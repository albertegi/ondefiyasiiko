package com.alvirg.ondefiyasiiko.festival;

import com.alvirg.ondefiyasiiko.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "FESTIVAL")
public class Festival extends BaseEntity {

    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "THEME", nullable = false)
    private String theme;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;
    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;
    @Column(name = "LOCATION", nullable = false)
    private String location;
    @Column(name = "YEAR", nullable = false)
    private int year;


}
