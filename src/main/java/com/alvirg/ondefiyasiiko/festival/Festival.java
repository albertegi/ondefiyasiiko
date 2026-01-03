package com.alvirg.ondefiyasiiko.festival;

import com.alvirg.ondefiyasiiko.announcement.Announcement;
import com.alvirg.ondefiyasiiko.common.BaseEntity;
import com.alvirg.ondefiyasiiko.event.Event;
import com.alvirg.ondefiyasiiko.galleryimage.GalleryImage;
import com.alvirg.ondefiyasiiko.performer.Performer;
import com.alvirg.ondefiyasiiko.vendor.Vendor;
import com.alvirg.ondefiyasiiko.volunteer.Volunteer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "FESTIVAL")
public class Festival extends BaseEntity {

    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "THEME", nullable = false)
    private String theme;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;
    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;
    @Column(name = "LOCATION", nullable = false)
    private String location;
    @Column(name = "YEAR", nullable = false)
    private int year;

    @OneToMany(mappedBy = "festival", cascade = CascadeType.ALL)
    private List<Event> events;

    @OneToMany(mappedBy = "festival", cascade = CascadeType.ALL)
    private List<Performer> performers;

    @OneToMany(mappedBy = "festival", cascade = CascadeType.ALL)
    private List<Vendor> vendors;

    @OneToMany(mappedBy = "festival", cascade = CascadeType.ALL)
    private List<Volunteer> volunteers;

    @OneToMany(mappedBy = "festival", cascade = CascadeType.ALL)
    private List<GalleryImage> galleryImages;

    @OneToMany(mappedBy = "festival", cascade = CascadeType.ALL)
    private List<Announcement> announcements;

}
