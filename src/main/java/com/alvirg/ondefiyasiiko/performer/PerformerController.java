package com.alvirg.ondefiyasiiko.performer;

import com.alvirg.ondefiyasiiko.common.RestResponse;
import com.alvirg.ondefiyasiiko.performer.request.PerformerRequest;
import com.alvirg.ondefiyasiiko.performer.request.StatusUpdateRequest;
import com.alvirg.ondefiyasiiko.performer.response.PerformerResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/performer")
@RequiredArgsConstructor
@Tag(name = "Performer", description = "Ondefiyasiiko Performer API Management")
public class PerformerController {

    private final PerformerService performerService;

    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RestResponse> registerPerformer(
            @Valid
            @RequestBody
            final PerformerRequest request
    ){
        final String performerId = this.performerService.registerPerformer(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RestResponse(performerId));
    }

    @GetMapping
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<PerformerResponse>> getAllPerformers() {
        return ResponseEntity.ok(this.performerService.getAllPerformers());
    }

    @GetMapping("/{status}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<PerformerResponse>> getPerformersByStatus(
            @PathVariable("status") @P("status")
            String status) {
        return ResponseEntity.ok(this.performerService.getPerformersByStatus(status));
    }

    @PatchMapping("/{performer-id}/status")
    public ResponseEntity<Void> updateStatus(
            @PathVariable("performer-id") @P("performerId")
            String performerId,
            @RequestBody StatusUpdateRequest request
    ) {
        performerService.updatePerformerStatus(request, performerId);
        return ResponseEntity.accepted().build();
    }


}
