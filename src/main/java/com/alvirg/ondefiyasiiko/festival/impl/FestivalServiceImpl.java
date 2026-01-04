package com.alvirg.ondefiyasiiko.festival.impl;

import com.alvirg.ondefiyasiiko.festival.Festival;
import com.alvirg.ondefiyasiiko.festival.FestivalMapper;
import com.alvirg.ondefiyasiiko.festival.FestivalRepository;
import com.alvirg.ondefiyasiiko.festival.FestivalService;
import com.alvirg.ondefiyasiiko.festival.request.FestivalRequest;
import com.alvirg.ondefiyasiiko.festival.request.FestivalUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FestivalServiceImpl implements FestivalService {

    private final FestivalRepository festivalRepository;
    private final FestivalMapper festivalMapper;

    @Override
    public String createOrUpdateFestival(FestivalRequest request, String userId) {
        // check that the festival does not already exist

        Optional<Festival> existing = this.festivalRepository.findFirstByOrderByCreatedByDesc();

        if(existing.isPresent()){
            // perform update here
            Festival current = existing.get(); // get the current one from the db
            this.festivalMapper.mergeFestival(current, request);
            this.festivalRepository.save(current);
        }
        final Festival festival = this.festivalMapper.toFestival(request);
        return this.festivalRepository.save(festival).getId();
    }

    @Override
    public void updateFestival(FestivalUpdateRequest request, String userId) {

    }

    @Override
    public void deleteFestivalById(String todoId) {

    }

}
