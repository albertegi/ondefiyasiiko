package com.alvirg.ondefiyasiiko.event;

import com.alvirg.ondefiyasiiko.announcement.response.AnnouncementResponse;
import com.alvirg.ondefiyasiiko.common.RestResponse;
import com.alvirg.ondefiyasiiko.event.request.EventRequest;
import com.alvirg.ondefiyasiiko.event.request.EventUpdateRequest;
import com.alvirg.ondefiyasiiko.event.response.EventResponse;
import com.alvirg.ondefiyasiiko.user.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/event")
@RequiredArgsConstructor
@Tag(name = "Event", description = "Ondefiyasiiko Event API Management")
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<RestResponse>createEvent(
            @Valid
            @RequestBody
            final EventRequest request){

        final String eventId = this.eventService.createEvent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new RestResponse(eventId));
    }

    @PutMapping("/{event-id}")
    public ResponseEntity<Void> updateEvent(
            @Valid
            @RequestBody
            final EventUpdateRequest request,
            @PathVariable("event-id") @P("eventId")
            final String eventId){
        this.eventService.updateEvent(
                request,
                eventId
        );
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    //    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<EventResponse>> findAllEvents(){
        return ResponseEntity.ok(this.eventService.getAllEvents());
    }

    @GetMapping("/{festival-id}")
    public ResponseEntity<List<EventResponse>> findAllEventsByFestival(
            @PathVariable("festival-id") @P("festivalId")
            String festivalId
    ){
        return ResponseEntity.ok(this.eventService.getAllEventsByFestival(festivalId));
    }

    @GetMapping("/{festival-id}/{event-id}")
    public ResponseEntity<EventResponse> findEventById(
            @PathVariable("event-id") @P("eventId")
            String eventId,
            @PathVariable("festival-id") @P("festivalId")
            String festivalId){
        return ResponseEntity.ok(this.eventService.getEventById(eventId, festivalId));
    }


    @DeleteMapping("/{festival-id}/{event-id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteEvent(
            @PathVariable("festival-id") @P("festivalId")
            String festivalId,
            @PathVariable("event-id") @P("eventId")
            String eventId
    ) {
        eventService.deleteEvent(festivalId, eventId);
        return ResponseEntity.ok().build();
    }

}
