package com.cladup.hyperion.themelight;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Entity
@Table(name = "theme_lights")
public class ThemeLight {
    @Id
    @GeneratedValue
    private final long id;

}
