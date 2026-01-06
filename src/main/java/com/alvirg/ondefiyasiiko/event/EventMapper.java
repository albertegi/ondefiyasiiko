package com.alvirg.ondefiyasiiko.event;

import com.alvirg.ondefiyasiiko.event.request.EventRequest;
import com.alvirg.ondefiyasiiko.event.response.EventResponse;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventMapper {
    public EventResponse toEventResponse(Event event) {
        return EventResponse.builder()
                .id(event.getId())
                .title(event.getTitle())
                .description(event.getDescription())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .eventType(event.getEventType())
                .performer(event.getPerformer())
                .venue(event.getVenue())
                .build();
    }

    public Event toEvent(EventRequest request) {
        return Event.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .eventType(request.getEventType())
                .performer(request.getPerformer())
                .venue(request.getVenue())
                .build();
    }

    public void applyUpdate(Event eventToUpdate, EventRequest request) {
        if(StringUtils.isNotBlank(request.getTitle()) &&
        !eventToUpdate.getTitle().equals(request.getTitle())){
            eventToUpdate.setTitle(request.getTitle());

        if(StringUtils.isNotBlank(request.getDescription()) &&
        !eventToUpdate.getDescription().equals(request.getDescription())){
            eventToUpdate.setDescription(request.getDescription());
        }

        if (request.getStartTime() != null
                && !request.getStartTime().equals(eventToUpdate.getStartTime())) {
            eventToUpdate.setStartTime(request.getStartTime());
        }

        if (request.getEndTime() != null
                && !request.getEndTime().equals(eventToUpdate.getEndTime())) {
            eventToUpdate.setEndTime(request.getEndTime());
        }

        }

        if(StringUtils.isNotBlank(request.getEventType()) &&
        !eventToUpdate.getEventType().equals(request.getEventType())){
            eventToUpdate.setEventType(request.getEventType());
        }

        if(StringUtils.isNotBlank(request.getPerformer()) &&
        !eventToUpdate.getPerformer().equals(request.getPerformer())){
            eventToUpdate.setPerformer(request.getPerformer());
        }

        if(StringUtils.isNotBlank(request.getVenue()) &&
        !eventToUpdate.getVenue().equals(request.getVenue())){
            eventToUpdate.setVenue(request.getVenue());
        }

    }
}
