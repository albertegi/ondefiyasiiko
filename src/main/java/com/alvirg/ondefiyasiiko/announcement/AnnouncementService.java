package com.alvirg.ondefiyasiiko.announcement;

import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementRequest;
import com.alvirg.ondefiyasiiko.announcement.request.AnnouncementUpdateRequest;
import com.alvirg.ondefiyasiiko.announcement.response.AnnouncementResponse;
import com.alvirg.ondefiyasiiko.festival.Festival;

import java.util.List;

public interface AnnouncementService {
    String createAnnouncement(AnnouncementRequest request);
    void updateAnnouncement(AnnouncementUpdateRequest request, String announcementId);
    AnnouncementResponse getAnnouncementById(String announcementId, String festivalId);
    List<AnnouncementResponse> getAllAnnouncementByFestival(String festivalId);
    List<AnnouncementResponse> getAllAnnouncement();
    void deleteAnnouncement(String festivalId, String AnnouncementId);

}
