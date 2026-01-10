package com.alvirg.ondefiyasiiko.event;

import com.alvirg.ondefiyasiiko.event.request.EventRequest;
import com.alvirg.ondefiyasiiko.event.request.EventUpdateRequest;
import com.alvirg.ondefiyasiiko.event.response.EventResponse;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface EventService {
    String createEvent(EventRequest request);
    void updateEvent(EventUpdateRequest request, String eventId);
    EventResponse getEventById(String eventId, String festivalId);
    List<EventResponse> getAllEvents();
    void deleteEvent(String eventId);
}
