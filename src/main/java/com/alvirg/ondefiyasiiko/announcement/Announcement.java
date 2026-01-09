package com.alvirg.ondefiyasiiko.announcement;

import com.alvirg.ondefiyasiiko.common.BaseEntity;
import com.alvirg.ondefiyasiiko.festival.Festival;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "ANNOUNCEMENT")
public class Announcement extends BaseEntity {

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "CONTENT", length = 2000, nullable = false)
    private String content;

    @Column(name = "PUBLISHED_AT", nullable = false)
    private LocalDateTime publishedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "festival_id", nullable = false)
    private Festival festival;
}
