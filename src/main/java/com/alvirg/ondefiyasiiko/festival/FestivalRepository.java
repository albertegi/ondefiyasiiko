package com.alvirg.ondefiyasiiko.festival;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FestivalRepository extends JpaRepository<Festival, String> {
    Optional<Festival> findFirstByOrderByCreatedDateDesc();
}
