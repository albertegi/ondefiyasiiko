package com.alvirg.ondefiyasiiko.performer.impl;

import com.alvirg.ondefiyasiiko.announcement.Announcement;
import com.alvirg.ondefiyasiiko.exception.BusinessException;
import com.alvirg.ondefiyasiiko.exception.ErrorCode;
import com.alvirg.ondefiyasiiko.festival.Festival;
import com.alvirg.ondefiyasiiko.festival.FestivalRepository;
import com.alvirg.ondefiyasiiko.performer.PeformerRepository;
import com.alvirg.ondefiyasiiko.performer.Performer;
import com.alvirg.ondefiyasiiko.performer.PerformerMapper;
import com.alvirg.ondefiyasiiko.performer.PerformerService;
import com.alvirg.ondefiyasiiko.performer.request.PerformerRequest;
import com.alvirg.ondefiyasiiko.performer.response.PerformerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PerformerServiceImpl implements PerformerService {
    private final FestivalRepository festivalRepository;
    private final PeformerRepository peformerRepository;
    private final PerformerMapper performerMapper;

    @Override
    public String registerPerformer(PerformerRequest request) {

        final Festival festival = this.festivalRepository.findById(request.getFestivalId())
                .orElseThrow(()-> new BusinessException(ErrorCode.FESTIVAL_NOT_FOUND));

        final Performer performer = this.performerMapper.toPerformer(request);
        performer.setFestival(festival);
        return this.peformerRepository.save(performer).getId();
    }

    @Override
    public List<PerformerResponse> getAllPerformers() {
        return this.peformerRepository.findAll(Sort.by("createdDate").descending())
                .stream()
                .map(this.performerMapper::toPerformerResponse)
                .toList();

    }

    @Override
    public List<PerformerResponse> getPerformersByStatus(String status) {
        return this.peformerRepository.findByStatusOrderByCreatedDateDesc(status)
                .stream()
                .map(this.performerMapper::toPerformerResponse)
                .toList();
    }
}
