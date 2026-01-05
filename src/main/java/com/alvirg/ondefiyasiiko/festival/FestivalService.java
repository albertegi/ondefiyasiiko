package com.alvirg.ondefiyasiiko.festival;

import com.alvirg.ondefiyasiiko.festival.request.FestivalRequest;
import com.alvirg.ondefiyasiiko.festival.response.FestivalResponse;

public interface FestivalService {

    String createOrUpdateFestival(FestivalRequest request, String userId);

    FestivalResponse findCurrentFestival();
}
