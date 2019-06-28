package com.cladup.hyperion.themeobject;

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
@Builder(toBuilder = true)
@Entity
@Table(name = "theme_objects")
public class ThemeObject {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;
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
    private String companyProductId;
    private String companyProductName;
    private String companyProductImageUrl;
    private String companyProductTargetUrl;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @CreationTimestamp
    private LocalDateTime createdAt;

}
