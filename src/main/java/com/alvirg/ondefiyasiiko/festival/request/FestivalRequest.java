package com.alvirg.ondefiyasiiko.festival.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FestivalRequest {
    @NotBlank(message = "VALIDATION.FESTIVAL.NAME.NOT_BLANK")
    private String name;
    @NotBlank(message = "VALIDATION.FESTIVAL.THEME.NOT_BLANK")
    private String theme;
    @NotBlank(message = "VALIDATION.FESTIVAL.DESCRIPTION.NOT_BLANK")
    private String description;
    @FutureOrPresent(message = "VALIDATION.FESTIVAL.START_DATE.FUTURE_OR_PRESENT")
    private LocalDate startDate;
    @FutureOrPresent(message = "VALIDATION.FESTIVAL.END_DATE.FUTURE_OR_PRESENT")
    private LocalDate endDate;
    @NotBlank(message = "VALIDATION.FESTIVAL.LOCATION.NOT_BLANK")
    private String location;
    @NotBlank(message = "VALIDATION.FESTIVAL.YEAR.NOT_BLANK")
    private int year;
}
