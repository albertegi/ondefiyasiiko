package com.alvirg.ondefiyasiiko.event;

import com.alvirg.ondefiyasiiko.event.response.EventResponse;
import com.sun.jdi.request.EventRequest;

import java.util.List;

public interface EventService {
    String createEvent(EventRequest request, String userId);
    List<EventResponse> getAllEvents();


}
