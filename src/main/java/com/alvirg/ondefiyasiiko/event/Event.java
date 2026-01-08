package com.alvirg.ondefiyasiiko.event;

import com.alvirg.ondefiyasiiko.common.BaseEntity;
import com.alvirg.ondefiyasiiko.festival.Festival;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "EVENT"
//        uniqueConstraints = @UniqueConstraint(
//                columnNames = {"TITLE", "START_TIME"}
//        )
)

public class Event extends BaseEntity {

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "START_TIME", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "END_TIME", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "STAGE", nullable = false)
    private String stage;

    @Column(name = "EVENT_TYPE", nullable = false)
    private String eventType;

    @Column(name = "PERFORMER", nullable = false)
    private String performer;

    @Column(name = "VENUE", nullable = false)
    private String venue;

    @ManyToOne
    @JoinColumn(name = "festival_id", nullable = false)
    private Festival festival;

}
