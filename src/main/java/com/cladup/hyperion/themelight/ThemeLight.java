package com.cladup.hyperion.themelight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
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
    private BigDecimal angle;
    private String color;
    private BigDecimal distance;
    private BigDecimal intensity;
    private BigDecimal spotPenumbra;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @CreationTimestamp
    private LocalDateTime createdAt;

}
