package com.alvirg.ondefiyasiiko.galleryimage;

import com.alvirg.ondefiyasiiko.common.BaseEntity;
import com.alvirg.ondefiyasiiko.festival.Festival;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "GALLERY_IMAGE")
public class GalleryImage extends BaseEntity {

        private String imageUrl;
        private String caption;

        private LocalDateTime uploadedAt = LocalDateTime.now();

        @ManyToOne
        @JoinColumn(name = "festival_id", nullable = false)
        private Festival festival;

}
