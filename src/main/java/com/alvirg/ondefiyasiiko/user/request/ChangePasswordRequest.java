package com.alvirg.ondefiyasiiko.user.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangePasswordRequest {

    @NotBlank(message = "VALIDATION.CHANGE_PASSWORD.PASSWORD.NOT_BLANK")
    @Size(
            min = 8,
            max = 72,
            message = "VALIDATION.CHANGE_PASSWORD.PASSWORD.SIZE"
    )
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*\\W).*$",
            message = "VALIDATION.CHANGE_PASSWORD.PASSWORD.WEAK"
    )
    @Schema(example = "<PASSWORD>")
    private String password;

    @NotBlank(message = "VALIDATION.CHANGE_PASSWORD.PASSWORD.NOT_BLANK")
    @Size(
            min = 8,
            max = 72,
            message = "VALIDATION.CHANGE_PASSWORD.PASSWORD.SIZE"
    )
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*\\W).*$",
            message = "VALIDATION.CHANGE_PASSWORD.PASSWORD.WEAK"
    )
    @Schema(example = "<PASSWORD>")
    private String currentPassword;

    @NotBlank(message = "VALIDATION.CHANGE_PASSWORD.PASSWORD.NOT_BLANK")
    @Size(
            min = 8,
            max = 72,
            message = "VALIDATION.CHANGE_PASSWORD.PASSWORD.SIZE"
    )
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*\\W).*$",
            message = "VALIDATION.CHANGE_PASSWORD.PASSWORD.WEAK"
    )
    @Schema(example = "<PASSWORD>")
    private String newPassword;

    @NotBlank(message = "VALIDATION.CHANGE_PASSWORD.CONFIRMED_PASSWORD.NOT_BLANK")
    @Size(
            min = 8,
            max = 72,
            message = "VALIDATION.CHANGE_PASSWORD.CONFIRMED_PASSWORD.SIZE"
    )
    private String confirmNewPassword;
}
