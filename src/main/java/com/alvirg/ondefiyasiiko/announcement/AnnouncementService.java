package com.alvirg.ondefiyasiiko.announcement;

import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementRequest;
import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementUpdateRequest;
import com.alvirg.ondefiyasiiko.announcement.response.AnnouncementResponse;

import java.util.List;

public interface AnnouncementService {
    String createAnnouncement(AnnouncementRequest request);
    void updateAnnouncement(AnnouncementUpdateRequest request, String announcementId,String festivalId);
    AnnouncementResponse getAnnouncementById(String announcementId);
    List<AnnouncementResponse> getAllAnnouncement();
    void deleteAnnouncement(String AnnouncementId);
}
