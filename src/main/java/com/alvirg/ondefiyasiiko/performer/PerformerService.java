package com.alvirg.ondefiyasiiko.performer;

import java.util.List;

public interface PerformerService {

    String registerPerformer(Performer performer);
    List<Performer> getAllPerformers();
    List<Performer> getPerformersByStatus(String status);
}
