package com.alvirg.ondefiyasiiko.announcement.impl;

import com.alvirg.ondefiyasiiko.announcement.Announcement;
import com.alvirg.ondefiyasiiko.announcement.AnnouncementMapper;
import com.alvirg.ondefiyasiiko.announcement.AnnouncementRepository;
import com.alvirg.ondefiyasiiko.announcement.AnnouncementService;
import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementRequest;
import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementUpdateRequest;
import com.alvirg.ondefiyasiiko.announcement.response.AnnouncementResponse;
import com.alvirg.ondefiyasiiko.exception.BusinessException;
import com.alvirg.ondefiyasiiko.exception.ErrorCode;
import com.alvirg.ondefiyasiiko.festival.Festival;
import com.alvirg.ondefiyasiiko.festival.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
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
    @Transactional(readOnly = true)
    public AnnouncementResponse getAnnouncementById(
            final String announcementId,
            final String festivalId) {

        Festival festival = festivalRepository.findById(festivalId)
                .orElseThrow(() -> new BusinessException(ErrorCode.FESTIVAL_NOT_FOUND));

        return this.announcementRepository
                .findByIdAndFestival(announcementId, festival)
                .map(this.announcementMapper::toAnnouncementResponse)
                .orElseThrow(()-> new BusinessException(ErrorCode.ANNOUNCEMENT_NOT_FOUND));
    }


    @Override
    @Transactional(readOnly = true)
    public List<AnnouncementResponse> getAllAnnouncement() {
        return announcementRepository.findAll(Sort.by("createdDate").descending())
                .stream()
                .map(announcementMapper::toAnnouncementResponse)
                .toList();
    }



    @Override
    @Transactional(readOnly = true)
    public List<AnnouncementResponse> getAllAnnouncementByFestival(
            String festivalId
    ) {
        Festival festival = festivalRepository.findById(festivalId)
                .orElseThrow(() -> new BusinessException(ErrorCode.FESTIVAL_NOT_FOUND));

        return this.announcementRepository.findAllByOrderByCreatedDateDesc(festival)
                .stream()
                .map(this.announcementMapper::toAnnouncementResponse)
                .toList();

    }

    @Override
    @Transactional(readOnly = true)
    public void deleteAnnouncement(
            final String festivalId,
            final String AnnouncementId) {

        Festival festival = festivalRepository.findById(festivalId)
                .orElseThrow(() -> new BusinessException(ErrorCode.FESTIVAL_NOT_FOUND));

        Announcement announcement = announcementRepository
                .findByIdAndFestival(AnnouncementId, festival)
                .orElseThrow(() -> new BusinessException(ErrorCode.ANNOUNCEMENT_NOT_FOUND));

        announcementRepository.delete(announcement);
    }

}
