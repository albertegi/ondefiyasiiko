package com.alvirg.ondefiyasiiko.event;

import com.alvirg.ondefiyasiiko.event.response.EventResponse;

import java.util.List;

public interface EventService {
    List<EventResponse> getAllEvents();
}
