package com.alvirg.ondefiyasiiko.performer;

import com.alvirg.ondefiyasiiko.performer.request.PerformerRequest;
import com.alvirg.ondefiyasiiko.performer.request.StatusUpdateRequest;
import com.alvirg.ondefiyasiiko.performer.response.PerformerResponse;

import java.util.List;

public interface PerformerService {

    String registerPerformer(PerformerRequest request);
    List<PerformerResponse> getAllPerformers();
    List<PerformerResponse> getPerformersByStatus(String status);

    void updatePerformerStatus(StatusUpdateRequest request, String performerId);
}
