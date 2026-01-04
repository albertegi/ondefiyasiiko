package com.alvirg.ondefiyasiiko.festival;

import com.alvirg.ondefiyasiiko.festival.request.FestivalRequest;
import com.alvirg.ondefiyasiiko.festival.request.FestivalUpdateRequest;

import java.util.List;

public interface FestivalService {

    String createOrUpdateFestival(FestivalRequest request, String userId);
    void updateFestival(FestivalUpdateRequest request, String userId);
    void deleteFestivalById(String todoId);
}
