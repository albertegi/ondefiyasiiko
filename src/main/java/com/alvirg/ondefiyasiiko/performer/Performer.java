package com.alvirg.ondefiyasiiko.performer;

import com.alvirg.ondefiyasiiko.common.ApplicationStatus;
import com.alvirg.ondefiyasiiko.common.BaseEntity;
import com.alvirg.ondefiyasiiko.festival.Festival;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "PERFORMER")
public class Performer extends BaseEntity {


    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Column(name = "PERFORMANCE_TYPE", nullable = false)
    private String performanceType; // MUSIC, DANCE, POETRY, OTHER

    @Column(name = "DESCRIPTION", length = 2000)
    private String description;

    @Column(name = "EQUIPMENT", length = 1000)
    private String equipment;

    @Column(name = "DURATION", nullable = false)
    private Integer duration; // in minutes

    @Column(name = "PREVIOUS_EXPERIENCE", length = 1000)
    private String previousExperience;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private String status = "PENDING"; // PENDING, APPROVED, REJECTED

    @Enumerated(EnumType.STRING)
    private ApplicationStatus performerStatus = ApplicationStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "festival_id", nullable = false)
    private Festival festival;
}
