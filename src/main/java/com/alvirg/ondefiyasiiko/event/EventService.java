package com.alvirg.ondefiyasiiko.event;

import com.alvirg.ondefiyasiiko.event.request.EventRequest;
import com.alvirg.ondefiyasiiko.event.response.EventResponse;

import java.util.List;

public interface EventService {
    String createEvent(EventRequest request);
    void updateEvent(EventRequest request, String userId);
    List<EventResponse> getAllEvents();
    void deleteEvent(String eventId);


}
