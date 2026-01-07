package com.alvirg.ondefiyasiiko.event.request;

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
public class EventUpdateRequest {

    @NotBlank(message = "VALIDATION.EVENT.TITLE.NOT_BLANK")
    private String title;

    @NotBlank(message = "VALIDATION.EVENT.DESCRIPTION.NOT_BLANK")
    private String description;

    @NotNull(message = "VALIDATION.EVENT.START_TIME.NOT_NULL")
    @FutureOrPresent(message = "VALIDATION.EVENT.START_TIME.FUTURE_OR_PRESENT")
    private LocalDateTime startTime;

    @NotNull(message = "VALIDATION.EVENT.END_TIME.NOT_NULL")
    @FutureOrPresent(message = "VALIDATION.EVENT.END_TIME.FUTURE_OR_PRESENT")
    private LocalDateTime endTime;

    @NotBlank(message = "VALIDATION.EVENT.STAGE.NOT_BLANK")
    private String stage;

    @NotBlank(message = "VALIDATION.EVENT.EVENT_TYPE.NOT_BLANK")
    private String eventType;

    @NotBlank(message = "VALIDATION.EVENT.PERFORMER.NOT_BLANK")
    private String performer;

    @NotBlank(message = "VALIDATION.EVENT.VENUE.NOT_BLANK")
    private String venue;
}
