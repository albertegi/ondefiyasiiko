package com.alvirg.ondefiyasiiko.announcement;

import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementRequest;
import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementUpdateRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AnnouncementMapper {

    @NotBlank(message = "VALIDATION.ANNOUNCEMENT.TITLE.NOT_BLANK")
    private String title;

    @NotBlank(message = "VALIDATION.ANNOUNCEMENT.CONTENT.NOT_BLANK")
    private String content;

    @NotNull(message = "VALIDATION.ANNOUNCEMENT.PUBLISHED_AT.NOT_NULL")
    @FutureOrPresent(message = "VALIDATION.ANNOUNCEMENT.PUBLISHED_AT.FUTURE_OR_PRESENT")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime publishedAt;


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
}
