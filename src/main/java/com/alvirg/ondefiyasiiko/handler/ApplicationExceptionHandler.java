package com.alvirg.ondefiyasiiko.handler;

import com.alvirg.ondefiyasiiko.exception.BusinessException;
import com.alvirg.ondefiyasiiko.exception.ErrorCode;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ApplicationExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleException(final BusinessException ex){

        // return type is ResponseEntity because we are returning something to the user.

        final ErrorResponse body = ErrorResponse.builder()
                .message(ex.getMessage())
                .code(ex.getErrorCode().getCode())
                .build();
        log.info("Business exception: {}", ex.getMessage());
        log.debug(ex.getMessage(), ex);

        return ResponseEntity.status(ex.getErrorCode()
                .getHttpStatus() != null ? ex.getErrorCode().getHttpStatus(): HttpStatus.BAD_REQUEST)
                .body(body);
    }

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<ErrorResponse> handleException(final DisabledException ex){
        final ErrorResponse body = ErrorResponse.builder()
                .message(ErrorCode.ERR_USER_DISABLED.getDefaultMessage())
                .code(ErrorCode.ERR_USER_DISABLED.getCode())
                .build();

        return ResponseEntity.status(ErrorCode.ERR_USER_DISABLED.getHttpStatus())
                .body(body);

    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleException(final BadCredentialsException exp){
        log.debug(exp.getMessage(), exp);

        final ErrorResponse body = ErrorResponse.builder()
                .message(ErrorCode.BAD_CREDENTIALS.getDefaultMessage())
                .code(ErrorCode.BAD_CREDENTIALS.getCode())
                .build();

        return ResponseEntity.status(ErrorCode.BAD_CREDENTIALS.getHttpStatus())
                .body(body);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(final UsernameNotFoundException exp){
        final ErrorResponse response = ErrorResponse.builder()
                .message(ErrorCode.USERNAME_NOT_FOUND.getDefaultMessage())
                .code(ErrorCode.USERNAME_NOT_FOUND.getCode())
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(final EntityNotFoundException exp){
        log.debug(exp.getMessage(), exp);
        final ErrorResponse response = ErrorResponse.builder()
                .message(exp.getMessage())
                .code("to be defined")
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exp){
        final List<ErrorResponse.ValidationError> errors = new ArrayList<>();
        exp.getBindingResult()
                .getAllErrors()
                .forEach(error ->{
                    final String fieldName = ((FieldError) error).getField();
                    final String errorCode = error.getDefaultMessage();
                    errors.add(ErrorResponse.ValidationError.builder()
                                    .field(fieldName)
                                    .code(errorCode)
                                    .message(errorCode)
                                    .build());


                });
                final ErrorResponse errorResponse = ErrorResponse.builder()
                        .message(ErrorCode.VALIDATION_ERROR.getDefaultMessage())
                        .code(ErrorCode.VALIDATION_ERROR.getCode())
                        .validationErrors(errors)
                        .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);

    }




    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(final Exception exp){
        log.error(exp.getMessage(), exp);
        final ErrorResponse response = ErrorResponse.builder()
                .message(ErrorCode.INTERNAL_EXCEPTION.getDefaultMessage())
                .code(ErrorCode.INTERNAL_EXCEPTION.getCode())
                .build();

        return ResponseEntity.status(ErrorCode.INTERNAL_EXCEPTION.getHttpStatus())
                .body(response);
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<ErrorResponse> handleException(final AuthorizationDeniedException exp){
        log.debug(exp.getMessage(), exp);
        final ErrorResponse response = ErrorResponse.builder()
                .message("You are not authorized to perform this operation")
                .build();

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
