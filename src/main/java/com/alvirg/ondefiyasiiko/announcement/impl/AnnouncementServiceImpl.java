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
    public String createAnnouncement(AnnouncementRequest request) {
        final Festival festival = this.festivalRepository.findById(request.getFestivalId())
                .orElseThrow(()-> new BusinessException(ErrorCode.USER_NOT_FOUND));

        final Announcement announcement = this.announcementMapper.toAnnouncement(request);
        announcement.setFestival(festival);
        return this.announcementRepository.save(announcement).getId();
    }

    @Override
    public void updateAnnouncement(
            final AnnouncementUpdateRequest request,
            final String announcementId) {

        Festival festival = festivalRepository.findById(request.getFestivalId())
                .orElseThrow(() -> new BusinessException(ErrorCode.FESTIVAL_NOT_FOUND));

        final Announcement announcementToUpdate = announcementRepository
                .findByIdAndFestival(announcementId, festival)
                .orElseThrow(() -> new BusinessException(ErrorCode.ANNOUNCEMENT_NOT_FOUND));

        boolean existsDuplicate = announcementRepository
                .existsByFestivalAndTitleAndContentAndIdNot(
                        festival,
                        request.getTitle(),
                        request.getContent(),
                        announcementId
                );
        if (existsDuplicate) {
            throw new BusinessException(ErrorCode.ANNOUNCEMENT_ALREADY_EXISTS);
        }
        this.announcementMapper.applyAnnouncementUpdate(announcementToUpdate, request);
        this.announcementRepository.save(announcementToUpdate);
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
