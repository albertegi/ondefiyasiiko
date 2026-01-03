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


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "PERFORMER")
public class Performer extends BaseEntity {


    @Column(name = "STAGE_NAME", nullable = false)
    private String stageName;
    @Column(name = "CONTACT_PERSON", nullable = false)
    private String contactPerson;
    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;
    @Column(name = "PHONE_NUMBER", nullable = false, unique = true)
    private String phone;

    private String performanceType;

    @Column(length = 2000)
    private String notes;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status = ApplicationStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "festival_id", nullable = false)
    private Festival festival;
}
