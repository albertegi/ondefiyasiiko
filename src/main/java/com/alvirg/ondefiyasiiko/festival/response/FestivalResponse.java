package com.alvirg.ondefiyasiiko.festival.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FestivalResponse {

    private String id;
    private String name;
    private String theme;
    private String slogan;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private String history;
    private String culturalSignificance;
    private int year;
}
