package com.alvirg.ondefiyasiiko.festival.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "VALIDATION.FESTIVAL.SLOGAN.NOT_BLANK")
    private String slogan;

    @NotNull(message = "VALIDATION.FESTIVAL.START_DATE.NOT_NULL")
    @FutureOrPresent(message = "VALIDATION.FESTIVAL.START_DATE.FUTURE_OR_PRESENT")
    private LocalDate startDate;

    @NotNull(message = "VALIDATION.FESTIVAL.END_DATE.NOT_NULL")
    @FutureOrPresent(message = "VALIDATION.FESTIVAL.END_DATE.FUTURE_OR_PRESENT")
    private LocalDate endDate;

    @NotBlank(message = "VALIDATION.FESTIVAL.LOCATION.NOT_BLANK")
    private String location;

    @NotBlank(message = "VALIDATION.FESTIVAL.HISTORY.NOT_BLANK")
    private String history;

    @NotBlank(message = "VALIDATION.FESTIVAL.CULTURAL_SIGNIFICANCE.NOT_BLANK")
    private String culturalSignificance;

    @NotNull(message = "VALIDATION.FESTIVAL.YEAR.NOT_NULL")
    @Min(value = 1900, message = "VALIDATION.FESTIVAL.YEAR.MIN")
    @Max(value = 2100, message = "VALIDATION.FESTIVAL.YEAR.MAX")
    private int year;


}
