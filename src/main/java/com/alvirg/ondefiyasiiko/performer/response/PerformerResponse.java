package com.alvirg.ondefiyasiiko.performer.response;

import com.alvirg.ondefiyasiiko.common.ApplicationStatus;
import com.alvirg.ondefiyasiiko.festival.Festival;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public class PerformerResponse {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String performanceType; // MUSIC, DANCE, POETRY, OTHER
    private String description;
    private String equipment;
    private Integer duration; // in minutes
    private String previousExperience;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus performerStatus = ApplicationStatus.PENDING; // PENDING, APPROVED, REJECTED
    private Festival festival;
}
