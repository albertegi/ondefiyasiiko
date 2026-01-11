package com.alvirg.ondefiyasiiko.performer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeformerRepository extends JpaRepository<Performer, String> {

    List<Performer> findAllByOrderByCreatedAtDesc();

    List<Performer> findByStatusOrderByCreatedDateDesc(String status);
}
