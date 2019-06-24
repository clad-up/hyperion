package com.cladup.hyperion.theme;

import com.cladup.hyperion.themelight.ThemeLight;
import com.cladup.hyperion.themeobject.ThemeObject;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "themes")
public class Theme {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;
    @Lob
    @Column(nullable = false)
    private String description = "";
    @Column(name = "camera_position_x", nullable = false,
            precision = 5, scale = 3)
    private BigDecimal cameraPositionX;
    @Column(name = "camera_position_y", nullable = false,
            precision = 5, scale = 3)
    private BigDecimal cameraPositionY;
    @Column(name = "camera_position_z", nullable = false,
            precision = 5, scale = 3)
    private BigDecimal cameraPositionZ;
    @Column(name = "camera_rotation_x", nullable = false,
            precision = 5, scale = 3)
    private BigDecimal cameraRotationX;
    @Column(name = "camera_rotation_y", nullable = false,
            precision = 5, scale = 3)
    private BigDecimal cameraRotationY;
    @Column(name = "camera_rotation_z", nullable = false,
            precision = 5, scale = 3)
    private BigDecimal cameraRotationZ;
    @Column(name = "position_x", nullable = false,
            precision = 5, scale = 3)
    private BigDecimal positionX;
    @Column(name = "position_y", nullable = false,
            precision = 5, scale = 3)
    private BigDecimal positionY;
    @Column(name = "position_z", nullable = false,
            precision = 5, scale = 3)
    private BigDecimal positionZ;
    @Column(name = "rotation_x", nullable = false,
            precision = 5, scale = 3)
    private BigDecimal rotationX;
    @Column(name = "rotation_y", nullable = false,
            precision = 5, scale = 3)
    private BigDecimal rotationY;
    @Column(name = "rotation_z", nullable = false,
            precision = 5, scale = 3)
    private BigDecimal rotationZ;
    @Column(name = "scale_x", nullable = false,
            precision = 5, scale = 3)
    private BigDecimal scaleX;
    @Column(name = "scale_y", nullable = false,
            precision = 5, scale = 3)
    private BigDecimal scaleY;
    @Column(name = "scale_z", nullable = false,
            precision = 5, scale = 3)
    private BigDecimal scaleZ;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "theme_id")
    private List<ThemeObject> themeObjects;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "theme_id")
    private List<ThemeLight> themeLights;

}
