package com.alvirg.ondefiyasiiko.announcement;

import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementRequest;
import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementUpdateRequest;
import com.alvirg.ondefiyasiiko.announcement.response.AnnouncementResponse;
import com.alvirg.ondefiyasiiko.common.RestResponse;
import com.alvirg.ondefiyasiiko.event.response.EventResponse;
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
@RequestMapping("api/v1/announcement")
@RequiredArgsConstructor
@Tag(name = "Announcement", description = "Ondefiyasiiko Announcement API Management")
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RestResponse> createAnnouncement(
            @Valid
            @RequestBody
            final AnnouncementRequest request
            ){

        final String announcementId = this.announcementService.createAnnouncement(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RestResponse(announcementId));
    }

    @PutMapping("/{announcementId}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> updateAnnouncement(
            @Valid @RequestBody
            final AnnouncementUpdateRequest request,
            @PathVariable @P("announcementId")
            final String announcementId
    ) {
        this.announcementService.updateAnnouncement(
                request,
                announcementId
        );
        return ResponseEntity.accepted().build();
    }

    @GetMapping("{announcement-id}/{festival-id}/")
    public ResponseEntity<AnnouncementResponse> getAnnouncementById(
            @PathVariable("announcement-id") @P("announcementId")
            String announcementId,
            @PathVariable("festival-id") @P("festivalId")
            String festivalId){
        return ResponseEntity.ok(this.announcementService.getAnnouncementById(announcementId, festivalId));
    }

    @GetMapping("/{festival-id}")
    public ResponseEntity<List<AnnouncementResponse>> findAllAnnouncementsByFestival(
            @PathVariable("festival-id") @P("festivalId")
            String festivalId
    ){
        return ResponseEntity.ok(this.announcementService.getAllAnnouncementByFestival(festivalId));
    }

    @GetMapping
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<AnnouncementResponse>> getAllAnnouncements() {
        return ResponseEntity.ok(announcementService.getAllAnnouncement());
    }

    @DeleteMapping("/{festival-id}/{announcement-id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteAnnouncement(
            @PathVariable("festival-id") @P("festivalId")
            String festivalId,
            @PathVariable("announcement-id") @P("announcementId")
            String announcementId
    ) {
        announcementService.deleteAnnouncement(festivalId, announcementId);
        return ResponseEntity.ok().build();
    }


}
