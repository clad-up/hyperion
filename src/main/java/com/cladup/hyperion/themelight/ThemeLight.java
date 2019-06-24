package com.cladup.hyperion.themelight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private boolean castShadow;
    @Column(nullable = false,
            precision = 5, scale = 3)
    private BigDecimal angle;
    @Column(nullable = false,
            precision = 5, scale = 3)
    private String color;
    @Column(nullable = false,
            precision = 5, scale = 3)
    private BigDecimal distance;
    @Column(nullable = false,
            precision = 5, scale = 3)
    private BigDecimal intensity;
    @Column(nullable = false,
            precision = 5, scale = 3)
    private BigDecimal spotPenumbra;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @CreationTimestamp
    private LocalDateTime createdAt;

}
