package com.alvirg.ondefiyasiiko.event.impl;

import com.alvirg.ondefiyasiiko.event.Event;
import com.alvirg.ondefiyasiiko.event.EventMapper;
import com.alvirg.ondefiyasiiko.event.EventRepository;
import com.alvirg.ondefiyasiiko.event.EventService;
import com.alvirg.ondefiyasiiko.event.request.EventRequest;
import com.alvirg.ondefiyasiiko.event.response.EventResponse;
import com.alvirg.ondefiyasiiko.exception.BusinessException;
import com.alvirg.ondefiyasiiko.exception.ErrorCode;
import com.alvirg.ondefiyasiiko.festival.FestivalService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;


    @Override
    public String createEvent(EventRequest request) {
        final Event event = this.eventMapper.toEvent(request);

        try{
            return this.eventRepository.save(event).getId();
        } catch (DataIntegrityViolationException exp) {
            throw new BusinessException(ErrorCode.EVENT_ALREADY_EXISTS);
        }
    }


//    private Event checkAndReturnEvent(String eventId) {
//        return this.eventRepository.findById(eventId)
//                .orElseThrow(()-> new EntityNotFoundException("No event found with the ID:"+ eventId));
//    }


    @Override
    public List<EventResponse> getAllEvents() {
        return this.eventRepository.findAllByOrderByStartTimeAsc()
                .stream()
                .map(this.eventMapper::toEventResponse)
                .toList();
    }

}
