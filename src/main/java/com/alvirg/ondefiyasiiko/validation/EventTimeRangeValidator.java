package com.alvirg.ondefiyasiiko.validation;

import com.alvirg.ondefiyasiiko.event.request.EventRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EventTimeRangeValidator implements ConstraintValidator<ValidEventTimeRange, EventRequest> {
    @Override
    public boolean isValid(EventRequest request, ConstraintValidatorContext context) {
        if(request.getStartTime() == null || request.getEndTime() == null){
            return true;
        }
        return request.getEndTime().isAfter(request.getStartTime());
    }
}
