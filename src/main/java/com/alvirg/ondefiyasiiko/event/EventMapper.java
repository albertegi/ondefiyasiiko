package com.alvirg.ondefiyasiiko.event;

import com.alvirg.ondefiyasiiko.event.response.EventResponse;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventMapper {
    public EventResponse toEvent(Event event) {
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
}
