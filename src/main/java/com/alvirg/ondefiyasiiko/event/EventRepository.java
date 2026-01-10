package com.alvirg.ondefiyasiiko.event;

import com.alvirg.ondefiyasiiko.festival.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, String> {
    List<Event> findAllByOrderByStartTimeAsc();

    boolean existsByTitleAndStartTime(String title, LocalDateTime startTime);

    Optional<Event> findByIdAndFestival(String eventId, Festival festivalId);


//    @Query("""
//            SELECT e
//            FROM Event e
//            WHERE e.id = :id
//            """)
//    Optional<Event> findEventById(@Param("id") String id);
}
