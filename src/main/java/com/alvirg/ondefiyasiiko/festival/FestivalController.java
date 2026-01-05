package com.alvirg.ondefiyasiiko.festival;

import com.alvirg.ondefiyasiiko.common.RestResponse;
import com.alvirg.ondefiyasiiko.festival.request.FestivalRequest;
import com.alvirg.ondefiyasiiko.user.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/festival")
@RequiredArgsConstructor
@Tag(name = "Festival", description = "Ondefiyasiiko Festival API Management")
public class FestivalController {

    private final FestivalService festivalService;

    public ResponseEntity<RestResponse> createOrUpdateFestival(
            @Valid
            @RequestBody
            final FestivalRequest request,
            final Authentication authentication
            ){
        String userId = ((User) authentication.getPrincipal()).getId();
        final String festivalId = this.festivalService.createOrUpdateFestival(request,userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new RestResponse(festivalId));
    }
}
