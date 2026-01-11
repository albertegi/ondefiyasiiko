package com.alvirg.ondefiyasiiko.performer.request;

import com.alvirg.ondefiyasiiko.common.ApplicationStatus;
import com.alvirg.ondefiyasiiko.festival.Festival;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PerformerRequest {

    @NotBlank(message = "VALIDATION.PERFORMER.NAME.NOT_BLANK")
    private String name;
    @NotBlank(message = "VALIDATION.PERFORMER.EMAIL.NOT_BLANK")
    private String email;
    @NotBlank(message = "VALIDATION.PERFORMER.PHONE_NUMBER.NOT_BLANK")
    private String phoneNumber;
    @NotBlank(message = "VALIDATION.PERFORMER.PERFORMANCE_TYPE.NOT_BLANK")
    private String performanceType; // MUSIC, DANCE, POETRY, OTHER
    @NotBlank(message = "VALIDATION.PERFORMER.DESCRIPTION.NOT_BLANK")
    private String description;
    @NotBlank(message = "VALIDATION.PERFORMER.EQUIPMENT.NOT_BLANK")
    private String equipment;
    @NotBlank(message = "VALIDATION.PERFORMER.DURATION.NOT_BLANK")
    private Integer duration; // in minutes
    @NotBlank(message = "VALIDATION.PERFORMER.PREVIOUS_EXPERIENCE.NOT_BLANK")
    private String previousExperience;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus performerStatus = ApplicationStatus.PENDING; // PENDING, APPROVED, REJECTED
    private String festivalId;
}
