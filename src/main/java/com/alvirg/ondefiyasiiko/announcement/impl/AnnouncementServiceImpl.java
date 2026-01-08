package com.alvirg.ondefiyasiiko.announcement.impl;

import com.alvirg.ondefiyasiiko.announcement.Announcement;
import com.alvirg.ondefiyasiiko.announcement.AnnouncementMapper;
import com.alvirg.ondefiyasiiko.announcement.AnnouncementRepository;
import com.alvirg.ondefiyasiiko.announcement.AnnouncementService;
import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementRequest;
import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementUpdateRequest;
import com.alvirg.ondefiyasiiko.announcement.response.AnnouncementResponse;
import com.alvirg.ondefiyasiiko.event.Event;
import com.alvirg.ondefiyasiiko.exception.BusinessException;
import com.alvirg.ondefiyasiiko.exception.ErrorCode;
import com.alvirg.ondefiyasiiko.festival.Festival;
import com.alvirg.ondefiyasiiko.festival.FestivalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final FestivalRepository festivalRepository;
    private final AnnouncementMapper announcementMapper;

    @Override
    @Transactional
    public String createAnnouncement(AnnouncementRequest request, String festivalId) {

        if(this.announcementRepository.findByTitleAndContent(
                request.getTitle(),
                request.getContent()
        )){
            throw new BusinessException(ErrorCode.EVENT_ALREADY_EXISTS);
        }
        final Festival festival = this.festivalRepository.findById(festivalId)
                .orElseThrow(()-> new BusinessException(ErrorCode.USER_NOT_FOUND));

        final Announcement announcement = this.announcementMapper.toAnnouncement(request);
        announcement.setFestival(festival);
        return this.announcementRepository.save(announcement).getId();
    }


    @Override
    public void updateAnnouncement(AnnouncementUpdateRequest request, String userId) {

        final Announcement AnnouncementToUpdate = this.announcementRepository.findById(userId)
                .orElseThrow(()-> new BusinessException(ErrorCode.ANNOUNCEMENT_NOT_FOUND));

        this.announcementMapper.applyAnnouncementUpdate(AnnouncementToUpdate, request);
        this.announcementRepository.save(AnnouncementToUpdate);

    }

    @Override
    public AnnouncementResponse getAnnouncementById(String announcementId) {
        return this.announcementRepository.findById(announcementId)
                .map(this.announcementMapper::toAnnouncementResponse)
                .orElseThrow(()-> new BusinessException(ErrorCode.ANNOUNCEMENT_NOT_FOUND));
    }

    @Override
    public List<AnnouncementResponse> getAllAnnouncement() {
        return this.announcementRepository.findAllByOrderByCreatedDateDesc()
                .stream()
                .map(this.announcementMapper::toAnnouncementResponse)
                .toList();
    }

    @Override
    public void deleteAnnouncement(String AnnouncementId) {
        this.announcementRepository.deleteById(AnnouncementId);

    }
}
