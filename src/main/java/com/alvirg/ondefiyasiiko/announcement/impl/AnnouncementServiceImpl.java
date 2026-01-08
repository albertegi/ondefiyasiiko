package com.alvirg.ondefiyasiiko.announcement.impl;

import com.alvirg.ondefiyasiiko.announcement.AnnouncementService;
import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementRequest;
import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementUpdateRequest;
import com.alvirg.ondefiyasiiko.announcement.response.AnnouncementResponse;

import java.util.List;

public class AnnouncementServiceImpl implements AnnouncementService {
    @Override
    public String createAnnouncement(AnnouncementRequest request) {
        return "";
    }

    @Override
    public void updateAnnouncement(AnnouncementUpdateRequest request, String userId) {

    }

    @Override
    public AnnouncementResponse getAnnouncementById(String announcementId) {
        return null;
    }

    @Override
    public List<AnnouncementResponse> getAllAnnouncement() {
        return List.of();
    }

    @Override
    public void deleteAnnouncement(String AnnouncementId) {

    }
}
