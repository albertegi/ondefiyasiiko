package com.alvirg.ondefiyasiiko.festival;

import com.alvirg.ondefiyasiiko.festival.request.FestivalRequest;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FestivalMapper {
    public Festival toFestival(FestivalRequest request) {
        return Festival.builder()
                .name(request.getName())
                .theme(request.getTheme())
                .description(request.getDescription())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .location(request.getLocation())
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

        if(StringUtils.isNotBlank(request.getDescription())
                && !current.getDescription().equals(request.getDescription())
        ){
            current.setDescription(request.getDescription());
        }

        if(StringUtils.isNotBlank(request.getLocation())
                && !current.getLocation().equals(request.getLocation())
        ){
            current.setLocation(request.getLocation());
        }

        if (request.getLocation() != null
                && !request.getLocation().equals(current.getLocation())) {
            current.setLocation(request.getLocation());
        }

        if (request.getStartDate() != null
                && !request.getStartDate().equals(current.getStartDate())) {
            current.setStartDate(request.getStartDate());
        }

        if (request.getEndDate() != null
                && !request.getEndDate().equals(current.getEndDate())) {
            current.setEndDate(request.getEndDate());
        }




    }
}
