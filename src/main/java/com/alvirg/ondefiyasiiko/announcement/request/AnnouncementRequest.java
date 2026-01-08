package com.alvirg.ondefiyasiiko.announcement.request;

import com.alvirg.ondefiyasiiko.festival.Festival;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnnouncementRequest {

    @NotBlank(message = "VALIDATION.ANNOUNCEMENT.TITLE.NOT_BLANK")
    private String title;

    @NotBlank(message = "VALIDATION.ANNOUNCEMENT.CONTENT.NOT_BLANK")
    private String content;

    @NotNull(message = "VALIDATION.ANNOUNCEMENT.PUBLISHED_AT.NOT_NULL")
    @FutureOrPresent(message = "VALIDATION.ANNOUNCEMENT.PUBLISHED_AT.FUTURE_OR_PRESENT")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime publishedAt;

    private Festival festival;
}
