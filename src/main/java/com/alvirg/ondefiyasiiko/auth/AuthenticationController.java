package com.alvirg.ondefiyasiiko.auth;

import com.alvirg.ondefiyasiiko.auth.request.AuthenticationRequest;
import com.alvirg.ondefiyasiiko.auth.request.RefreshRequest;
import com.alvirg.ondefiyasiiko.auth.request.RegistrationRequest;
import com.alvirg.ondefiyasiiko.auth.response.AuthenticationResponse;
//import com.alvirg.ondefiyasiiko.handler.ErrorResponse;
import com.alvirg.ondefiyasiiko.handler.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication",description = "Authentication API")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @Valid
            @RequestBody
            final AuthenticationRequest request
    ){
        return ResponseEntity.ok(this.authenticationService.login(request));
    }

    @Operation(summary = "Register a new user", description = "Register a new user with email, password, and other required information")
    @ApiResponses(value = {
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
    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Valid
            @RequestBody
            final RegistrationRequest request
    ){
        this.authenticationService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthenticationResponse> refresh(
            @Valid
            @RequestBody
            final RefreshRequest request
    ){
        return ResponseEntity.ok(this.authenticationService.refreshToken(request));

    }
}
