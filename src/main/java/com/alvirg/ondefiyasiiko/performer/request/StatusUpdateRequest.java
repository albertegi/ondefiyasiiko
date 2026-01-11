package com.alvirg.ondefiyasiiko.performer.request;

import com.alvirg.ondefiyasiiko.common.ApplicationStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusUpdateRequest {

    @Enumerated(EnumType.STRING)
    private ApplicationStatus performerStatus = ApplicationStatus.PENDING; // PENDING, APPROVED, REJECTED
}
