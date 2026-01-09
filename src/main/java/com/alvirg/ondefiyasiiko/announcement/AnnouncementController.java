package com.alvirg.ondefiyasiiko.announcement;

import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementRequest;
import com.alvirg.ondefiyasiiko.common.RestResponse;
import com.alvirg.ondefiyasiiko.event.request.EventRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/announcement")
@RequiredArgsConstructor
@Tag(name = "Announcement", description = "Ondefiyasiiko Announcement API Management")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @PostMapping("/{festivalId}")
    public ResponseEntity<RestResponse> createAnnouncement(
            @Valid
            @RequestBody
            final AnnouncementRequest request,
            @PathVariable
            final String festivalId
            ){

        final String announcementId = this.announcementService.createAnnouncement(request, festivalId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RestResponse(announcementId));
    }
}
