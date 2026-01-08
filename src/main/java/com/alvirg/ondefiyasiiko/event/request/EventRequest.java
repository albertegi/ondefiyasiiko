package com.alvirg.ondefiyasiiko.event.request;

import com.alvirg.ondefiyasiiko.validation.ValidEventTimeRange;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ValidEventTimeRange
public class EventRequest {

    @NotBlank(message = "VALIDATION.EVENT.TITLE.NOT_BLANK")
    private String title;

    @NotBlank(message = "VALIDATION.EVENT.DESCRIPTION.NOT_BLANK")
    private String description;

    @NotNull(message = "VALIDATION.EVENT.START_TIME.NOT_NULL")
    @FutureOrPresent(message = "VALIDATION.EVENT.START_TIME.FUTURE_OR_PRESENT")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTime;

    @NotNull(message = "VALIDATION.EVENT.END_TIME.NOT_NULL")
    @FutureOrPresent(message = "VALIDATION.EVENT.END_TIME.FUTURE_OR_PRESENT")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endTime;

    @NotBlank(message = "VALIDATION.EVENT.STAGE.NOT_BLANK")
    private String stage;

    @NotBlank(message = "VALIDATION.EVENT.EVENT_TYPE.NOT_BLANK")
    private String eventType;

    @NotBlank(message = "VALIDATION.EVENT.PERFORMER.NOT_BLANK")
    private String performer;

    @NotBlank(message = "VALIDATION.EVENT.VENUE.NOT_BLANK")
    private String venue;

//    private String festivalId; // since an event belongs to a festival
}
