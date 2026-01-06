package com.alvirg.ondefiyasiiko.event;

import com.alvirg.ondefiyasiiko.event.response.EventResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/event")
@RequiredArgsConstructor
@Tag(name = "Event", description = "Ondefiyasiiko Event API Management")
public class EventController {

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<EventResponse>> findAllEvents(){
        return ResponseEntity.ok(this.eventService.getAllEvents());

    }

}
