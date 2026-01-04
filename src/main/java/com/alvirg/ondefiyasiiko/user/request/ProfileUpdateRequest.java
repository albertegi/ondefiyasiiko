package com.alvirg.ondefiyasiiko.user.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileUpdateRequest {

    @NotBlank(message = "VALIDATION.REGISTRATION.PROFILE_UPDATE.FIRSTNAME.NOT_BLANK")
    @Size(
            min = 5,
            max = 50,
            message = "VALIDATION.REGISTRATION.PROFILE_UPDATE.FIRSTNAME.SIZE"
    )
    @Pattern(
            regexp = "^[\\p{L} '-]+$",
            message = "VALIDATION.REGISTRATION.PROFILE_UPDATE.FIRSTNAME.PATTERN"
    )
    @Schema(example = "Albert")
    private String firstName;

    @NotBlank(message = "VALIDATION.REGISTRATION.PROFILE_UPDATE.LASTNAME.NOT_BLANK")
    @Size(
            min = 5,
            max = 50,
            message = "VALIDATION.REGISTRATION.PROFILE_UPDATE.LASTNAME.SIZE"
    )
    @Pattern(
            regexp = "^[\\p{L} '-]+$",
            message = "VALIDATION.REGISTRATION.PROFILE_UPDATE.LASTNAME.PATTERN"
    )
    @Schema(example = "Albert")
    private String lastName;


    private LocalDate dateOfBirth;
}
