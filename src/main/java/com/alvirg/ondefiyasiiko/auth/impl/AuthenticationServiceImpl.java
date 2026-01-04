package com.alvirg.ondefiyasiiko.auth.impl;

import com.alvirg.ondefiyasiiko.auth.AuthenticationService;
import com.alvirg.ondefiyasiiko.auth.request.AuthenticationRequest;
import com.alvirg.ondefiyasiiko.auth.request.RefreshRequest;
import com.alvirg.ondefiyasiiko.auth.request.RegistrationRequest;
import com.alvirg.ondefiyasiiko.auth.response.AuthenticationResponse;
//import com.alvirg.ondefiyasiiko.exception.BusinessException;
//import com.alvirg.ondefiyasiiko.exception.ErrorCode;
import com.alvirg.ondefiyasiiko.exception.BusinessException;
import com.alvirg.ondefiyasiiko.exception.ErrorCode;
import com.alvirg.ondefiyasiiko.role.Role;
import com.alvirg.ondefiyasiiko.role.RoleRepository;
import com.alvirg.ondefiyasiiko.security.JwtService;
import com.alvirg.ondefiyasiiko.user.User;
//import com.alvirg.ondefiyasiiko.user.UserMapper;
import com.alvirg.ondefiyasiiko.user.UserMapper;
import com.alvirg.ondefiyasiiko.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {

        // this part authenticates the user.
        final Authentication auth = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // this part extracts the authenticated user from the Authentication and cast to User object
        final User user = (User) auth.getPrincipal();
        final String token = this.jwtService.generateAccessToken(user.getEmail());
        final String refreshToken = this.jwtService.generateRefreshToken(user.getEmail());
        final String tokenType = "Bear";

        return AuthenticationResponse.builder()
                .accessToken(token)
                .refreshToken(refreshToken)
                .tokenType(tokenType)
                .build();
    }

    @Override
    @Transactional
    public void register(RegistrationRequest request) {

        checkUserEmail(request.getEmail());
        checkUserPhoneNumber(request.getPhoneNumber()); // check that another user with the same phone does not exist
        checkPasswords(request.getPassword(), request.getConfirmPassword());

        /** We need to fetch the ROLE.
         * because when we register a USER, by default, we need to assign a ROLE to the user
        */
        final Role userRole = this.roleRepository.findByName("ROLE_USER")
                .orElseThrow(()-> new EntityNotFoundException("Role user does not exist"));

        // because user and role is a many-to-many relationship, so create a list of roles
        final List<Role> roles = new ArrayList<>();
        roles.add(userRole);

        // We need to convert the RegistrationRequest to User entity to be able to save it in the database
        // after that set the roles
        final User user = this.userMapper.toUser(request);
        user.setRoles(roles);
        log.debug("Saving user {} ", user);
        this.userRepository.save(user);


    }
    @Override
    public AuthenticationResponse refreshToken(RefreshRequest request) {
        final String newAccessToken = this.jwtService.refreshAccessToken(request.getRefreshToken());
        final String tokenType = "Bearer";
        return AuthenticationResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(request.getRefreshToken())
                .tokenType(tokenType)
                .build();
    }

    private void checkUserEmail(String email) {
        final boolean emailExists = this.userRepository.existsByEmailIgnoreCase(email);

        if(emailExists){
            throw new BusinessException(ErrorCode.EMAIL_ALREADY_EXISTS);
        }

    }

    private void checkUserPhoneNumber(String phoneNumber) {

        final boolean phoneNumberExists = this.userRepository.existsByPhoneNumber(phoneNumber);
        if(phoneNumberExists){
            throw new BusinessException(ErrorCode.PHONE_NUMBER_ALREADY_EXISTS);
        }

    }

    private void checkPasswords(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)){
            throw new BusinessException(ErrorCode.PASSWORD_MISMATCH);
        }

    }




}
