package com.alvirg.ondefiyasiiko.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    USER_NOT_FOUND("USER_NOT_FOUND", "User not found with id %s", HttpStatus.NOT_FOUND),

    CHANGE_PASSWORD_MISMATCH("CHANGE_PASSWORD_MISMATCH","Current Password and new password are not the same", HttpStatus.BAD_REQUEST),
    INVALID_CURRENT_PASSWORD("INVALID_CURRENT_PASSWORD","Current Password is invalid", HttpStatus.BAD_REQUEST ),
    ACCOUNT_ALREADY_DEACTIVATED("ACCOUNT_ALREADY_DEACTIVATED","Account is already deactivated", HttpStatus.BAD_REQUEST),
    ACCOUNT_ALREADY_ACTIVATED("ACCOUNT_ALREADY_ACTIVATED", "Account already activated", HttpStatus.BAD_REQUEST),
    EMAIL_ALREADY_EXISTS("EMAIL_ALREADY_EXISTS","email already exists" ,HttpStatus.BAD_REQUEST ),
    PHONE_NUMBER_ALREADY_EXISTS("PHONE_NUMBER_ALREADY_EXISTS", "Phone number already exists", HttpStatus.BAD_REQUEST),
    PASSWORD_MISMATCH("PASSWORD_MISMATCH", "Passwords do not match", HttpStatus.BAD_REQUEST),
    ERR_USER_DISABLED("ERR_USER_DISABLED", "User is disabled", HttpStatus.UNAUTHORIZED),
    BAD_CREDENTIALS("BAD_CREDENTIALS", "Username and / or password incorrect", HttpStatus.UNAUTHORIZED),
    USERNAME_NOT_FOUND("USERNAME_NOT_FOUND_EXCEPTION", "Username not found", HttpStatus.NOT_FOUND),
    INTERNAL_EXCEPTION("INTERNAL_EXCEPTION", "Internal server error", HttpStatus.INTERNAL_SERVER_ERROR),
    ENTITY_NOT_FOUND("ENTITY_NOT_FOUND", "Entity not found", HttpStatus.NOT_FOUND),
    VALIDATION_ERROR("VALIDATION_ERROR", "Validation failed", HttpStatus.BAD_REQUEST),
    CATEGORY_ALREADY_EXISTS_FOR_USER("CATEGORY_ALREADY_EXISTS_FOR_USER", "Category already exists for this user", HttpStatus.CONFLICT),
    EVENT_ALREADY_EXISTS("EVENT_ALREADY_EXISTS", "Event already exists", HttpStatus.BAD_REQUEST ),
    FESTIVAL_NOT_FOUND("FESTIVAL_NOT_FOUND","Festival not found", HttpStatus.NOT_FOUND ),
    ANNOUNCEMENT_NOT_FOUND("ANNOUNCEMENT_NOT_FOUND", "Announcement not found", HttpStatus.NOT_FOUND),
    ANNOUNCEMENT_ALREADY_EXISTS("ANNOUNCEMENT_ALREADY_EXISTS", "Announcement already exists", HttpStatus.BAD_REQUEST),
    EVENT_NOT_FOUND("EVENT_NOT_FOUND", "Event not found", HttpStatus.NOT_FOUND);
//    EVENT_ALREADY_EXISTS("EVENT_ALREADY_EXISTS","Event already exists", HttpStatus.BAD_REQUEST);



    private final  String code;
    private final String defaultMessage;
    private final HttpStatus httpStatus;

    ErrorCode(final String code,
              final String defaultMessage,
              final HttpStatus httpStatus) {
        this.code = code;
        this.defaultMessage = defaultMessage;
        this.httpStatus = httpStatus;
    }
}
