package com.alvirg.ondefiyasiiko.event.impl;

import com.alvirg.ondefiyasiiko.event.EventMapper;
import com.alvirg.ondefiyasiiko.event.EventRepository;
import com.alvirg.ondefiyasiiko.event.EventService;
import com.alvirg.ondefiyasiiko.event.response.EventResponse;
import com.alvirg.ondefiyasiiko.festival.FestivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;


    @Override
    public List<EventResponse> getAllEvents() {
        return this.eventRepository.findAllByOrderByStartTimeAsc()
                .stream()
                .map(this.eventMapper::toEvent)
                .toList();
    }

}
