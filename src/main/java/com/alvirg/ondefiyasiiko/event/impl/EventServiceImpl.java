package com.alvirg.ondefiyasiiko.event.impl;

import com.alvirg.ondefiyasiiko.event.Event;
import com.alvirg.ondefiyasiiko.event.EventMapper;
import com.alvirg.ondefiyasiiko.event.EventRepository;
import com.alvirg.ondefiyasiiko.event.EventService;
import com.alvirg.ondefiyasiiko.event.request.EventRequest;
import com.alvirg.ondefiyasiiko.event.request.EventUpdateRequest;
import com.alvirg.ondefiyasiiko.event.response.EventResponse;
import com.alvirg.ondefiyasiiko.exception.BusinessException;
import com.alvirg.ondefiyasiiko.exception.ErrorCode;
import com.alvirg.ondefiyasiiko.festival.Festival;
import com.alvirg.ondefiyasiiko.festival.FestivalRepository;
import com.alvirg.ondefiyasiiko.festival.FestivalService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final FestivalRepository festivalRepository;
    private final EventMapper eventMapper;


    @Override
    @Transactional
    public String createEvent(EventRequest request) {
        if(this.eventRepository.existsByTitleAndStartTime(
                request.getTitle(), request.getStartTime()
        )){
            throw new BusinessException(ErrorCode.EVENT_ALREADY_EXISTS);
        }

        final Festival festival = this.festivalRepository.findFirstByOrderByCreatedDateDesc()
                .orElseThrow(()-> new BusinessException(ErrorCode.FESTIVAL_NOT_FOUND));

        final Event event = this.eventMapper.toEvent(request);

        event.setFestival(festival);
        return this.eventRepository.save(event).getId();
    }

    @Override
    public void updateEvent(EventUpdateRequest request, String userId) {
        final Event eventToUpdate = this.eventRepository.findById(userId)
                .orElseThrow(()-> new EntityNotFoundException("No Event found with Id: " +userId));

        this.eventMapper.applyEventUpdate(eventToUpdate, request);
        this.eventRepository.save(eventToUpdate);
    }

    @Override
    public EventResponse getEventById(final String eventId) {
        return this.eventRepository.findById(eventId)
                .map(this.eventMapper::toEventResponse)
                .orElseThrow(()-> new EntityNotFoundException("No event found with the ID " + eventId
                ));
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

    @Override
    public void deleteEvent(String eventId) {
        this.eventRepository.deleteById(eventId);
    }

}
