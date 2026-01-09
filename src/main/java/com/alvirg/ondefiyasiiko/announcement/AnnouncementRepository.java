package com.alvirg.ondefiyasiiko.announcement;

import com.alvirg.ondefiyasiiko.festival.Festival;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnnouncementRepository extends JpaRepository<Announcement, String> {

//    Optional<Announcement> findByTitleAndContent(String title, String content);

    List<Announcement> findAllByOrderByCreatedDateDesc();

    Optional<Announcement> findByIdAndFestival(String announcementId, Festival festival);

    boolean existsByFestivalAndTitleAndContentAndIdNot(
            Festival festival,
            String title,
            String content,
            String id
    );

}
