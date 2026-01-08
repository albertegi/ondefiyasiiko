package com.alvirg.ondefiyasiiko.announcement;

import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

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
}
