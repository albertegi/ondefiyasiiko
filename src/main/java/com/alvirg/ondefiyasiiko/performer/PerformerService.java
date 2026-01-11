package com.alvirg.ondefiyasiiko.performer;

import com.alvirg.ondefiyasiiko.performer.request.PerformerRequest;

import java.util.List;

public interface PerformerService {

    String registerPerformer(PerformerRequest request);
    List<Performer> getAllPerformers();
    List<Performer> getPerformersByStatus(String status);
}
