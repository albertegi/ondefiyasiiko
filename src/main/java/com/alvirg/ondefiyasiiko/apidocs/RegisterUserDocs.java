package com.alvirg.ondefiyasiiko.apidocs;



import com.alvirg.ondefiyasiiko.handler.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Operation(
        summary = "Register a new user",
        description = "Register a new user with email, password, and other required information"
)
@ApiResponses({
        @ApiResponse(
                responseCode = "201",
                description = "User successfully registered"
        ),
        @ApiResponse(
                responseCode = "400",
                description = "Validation error - Invalid input data",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = ErrorResponse.class)
                )
        )
})
public @interface RegisterUserDocs {
}
