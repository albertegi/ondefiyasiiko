package com.alvirg.ondefiyasiiko.handler;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Schema(description = "Error response containing error message, code, and validation errors")
public class ErrorResponse {

    @Schema(description = "Error message", example = "An error occurred")
    private String message; // this will hold the error message
    
    @Schema(description = "Error code", example = "ERR_001")
    private String code; // the error code
    
    @Schema(description = "List of validation errors")
    private List<ValidationError> validationErrors;

    // Create a nested class for ValidationError

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    @Schema(description = "Validation error details")
    public static class ValidationError {
        @Schema(description = "Field name that failed validation", example = "email")
        private String field;
        
        @Schema(description = "Validation error code", example = "VALIDATION.REGISTRATION.EMAIL.NOT_BLANK")
        private String code;
        
        @Schema(description = "Validation error message", example = "Email cannot be blank")
        private String message;
    }
}
