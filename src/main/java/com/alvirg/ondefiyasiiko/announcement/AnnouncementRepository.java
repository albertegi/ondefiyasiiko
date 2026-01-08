package com.alvirg.ondefiyasiiko.announcement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnnouncementRepository extends JpaRepository<Announcement, String> {

    boolean findByTitleAndContent(String title, String content);

    List<Announcement> findAllByOrderByCreatedDateDesc();
}
