package com.alvirg.ondefiyasiiko.festival;

import com.alvirg.ondefiyasiiko.festival.request.FestivalRequest;
import com.alvirg.ondefiyasiiko.festival.response.FestivalResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class FestivalMapper {
    public Festival toFestival(FestivalRequest request) {
        return Festival.builder()
                .name(request.getName())
                .theme(request.getTheme())
                .slogan(request.getSlogan())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .location(request.getLocation())
                .history(request.getHistory())
                .culturalSignificance(request.getCulturalSignificance())
                .year(request.getYear())
                .build();
    }

    public void mergeFestival(Festival current, FestivalRequest request) {
        if(StringUtils.isNotBlank(request.getName())
                && !current.getName().equals(request.getName())
        ){
            current.setName(request.getName());
        }

        if(StringUtils.isNotBlank(request.getTheme())
                && !current.getTheme().equals(request.getTheme())
        ){
            current.setTheme(request.getTheme());
        }

        if(StringUtils.isNotBlank(request.getSlogan())
                && !current.getSlogan().equals(request.getSlogan())
        ){
            current.setSlogan(request.getSlogan());
        }

        if (request.getStartDate() != null
                && !request.getStartDate().equals(current.getStartDate())) {
            current.setStartDate(request.getStartDate());
        }

        if (request.getEndDate() != null
                && !request.getEndDate().equals(current.getEndDate())) {
            current.setEndDate(request.getEndDate());
        }

        if(StringUtils.isNotBlank(request.getHistory())
                && !current.getHistory().equals(request.getHistory())
        ){
            current.setHistory(request.getHistory());
        }

        if(StringUtils.isNotBlank(request.getCulturalSignificance())
                && !current.getCulturalSignificance().equals(request.getCulturalSignificance())
        ){
            current.setCulturalSignificance(request.getCulturalSignificance());
        }


        if (request.getYear() != current.getYear()) {
            current.setYear(request.getYear());
        }

    }

    public FestivalResponse toFestivalResponse(final Festival festival)
    {
        return FestivalResponse.builder()
                .id(festival.getId())
                .name(festival.getName())
                .theme(festival.getTheme())
                .slogan(festival.getSlogan())
                .startDate(festival.getStartDate())
                .endDate(festival.getEndDate())
                .location(festival.getLocation())
                .history(festival.getHistory())
                .culturalSignificance(festival.getCulturalSignificance())
                .year(festival.getYear())
                .build();
    }
}
