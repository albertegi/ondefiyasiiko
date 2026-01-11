package com.alvirg.ondefiyasiiko.performer;

import com.alvirg.ondefiyasiiko.common.ApplicationStatus;
import com.alvirg.ondefiyasiiko.festival.Festival;
import com.alvirg.ondefiyasiiko.performer.request.PerformerRequest;
import com.alvirg.ondefiyasiiko.performer.response.PerformerResponse;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.stereotype.Service;

@Service
public class PerformerMapper {
    public Performer toPerformer(PerformerRequest request) {
        return Performer.builder()
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .performanceType(request.getPerformanceType())
                .description(request.getDescription())
                .equipment(request.getEquipment())
                .duration(request.getDuration())
                .previousExperience(request.getPreviousExperience())
                .performerStatus(request.getPerformerStatus())
                .build();
    }

    public PerformerResponse toPerformerResponse(Performer performer) {
        return PerformerResponse.builder()
                .id(performer.getId())
                .email(performer.getEmail())
                .phoneNumber(performer.getPhoneNumber())
                .performanceType(performer.getPerformanceType())
                .description(performer.getDescription())
                .equipment(performer.getEquipment())
                .duration(performer.getDuration())
                .previousExperience(performer.getPreviousExperience())
                .performerStatus(performer.getPerformerStatus())
                .build();
    }
}
