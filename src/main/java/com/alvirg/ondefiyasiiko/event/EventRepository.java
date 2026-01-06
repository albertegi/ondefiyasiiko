package com.alvirg.ondefiyasiiko.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, String> {
    List<Event> findAllByOrderByStartTimeAsc();


//    @Query("""
//            SELECT e
//            FROM Event e
//            WHERE e.id = :id
//            """)
//    Optional<Event> findEventById(@Param("id") String id);
}
