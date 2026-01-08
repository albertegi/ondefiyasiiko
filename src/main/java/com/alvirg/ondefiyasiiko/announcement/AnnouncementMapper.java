package com.alvirg.ondefiyasiiko.announcement;

import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementRequest;
import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementUpdateRequest;
import com.alvirg.ondefiyasiiko.announcement.response.AnnouncementResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnnouncementMapper {


    public Announcement toAnnouncement(AnnouncementRequest request) {
        return Announcement.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .publishedAt(request.getPublishedAt())
                .build();
    }

    public void applyAnnouncementUpdate(Announcement announcementToUpdate, AnnouncementUpdateRequest request) {
        if(StringUtils.isNotBlank(request.getTitle())
        && !announcementToUpdate.getTitle().equals(request.getTitle())){
            announcementToUpdate.setTitle(request.getTitle());

        }if(StringUtils.isNotBlank(request.getContent())
        && !announcementToUpdate.getContent().equals(request.getContent())){
            announcementToUpdate.setContent(request.getContent());
        }

        if (request.getPublishedAt() != null
                && !request.getPublishedAt().equals(announcementToUpdate.getPublishedAt())) {
            announcementToUpdate.setPublishedAt(request.getPublishedAt());
        }
    }

    public AnnouncementResponse toAnnouncementResponse(Announcement announcement) {
        return AnnouncementResponse.builder()
                .id(announcement.getId())
                .title(announcement.getTitle())
                .content(announcement.getContent())
                .publishedAt(announcement.getPublishedAt())
                .build();
    }
}
