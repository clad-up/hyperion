package com.cladup.hyperion.themelight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "theme_lights")
public class ThemeLight {
    @Id
    @GeneratedValue
    private long id;
    private String type;
    private String name;
    private boolean castShadow;
    private float angle;
    private String color;
    private float distance;
    private float intensity;
    private float spotPenumbra;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

}
