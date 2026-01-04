package com.alvirg.ondefiyasiiko.auth;

import com.alvirg.ondefiyasiiko.auth.request.AuthenticationRequest;
import com.alvirg.ondefiyasiiko.auth.request.RefreshRequest;
import com.alvirg.ondefiyasiiko.auth.request.RegistrationRequest;
import com.alvirg.ondefiyasiiko.auth.response.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse login(AuthenticationRequest request);
    void register(RegistrationRequest request);
    AuthenticationResponse refreshToken(RefreshRequest request);
}
