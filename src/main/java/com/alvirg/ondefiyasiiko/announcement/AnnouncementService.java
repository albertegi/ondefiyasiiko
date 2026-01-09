package com.alvirg.ondefiyasiiko.announcement;

import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementRequest;
import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementUpdateRequest;
import com.alvirg.ondefiyasiiko.announcement.response.AnnouncementResponse;

import java.util.List;

public interface AnnouncementService {
    String createAnnouncement(AnnouncementRequest request, String festivalId);
    void updateAnnouncement(AnnouncementUpdateRequest request, String userId);
    AnnouncementResponse getAnnouncementById(String announcementId);
    List<AnnouncementResponse> getAllAnnouncement();
    void deleteAnnouncement(String AnnouncementId);
}
