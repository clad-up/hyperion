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
@Builder
@Entity
@Table(name = "theme_objects")
public class ThemeObject {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String type;
    @Column(name = "position_x")
    private BigDecimal positionX;
    @Column(name = "position_y")
    private BigDecimal positionY;
    @Column(name = "position_z")
    private BigDecimal positionZ;
    @Column(name = "rotation_x")
    private BigDecimal rotationX;
    @Column(name = "rotation_y")
    private BigDecimal rotationY;
    @Column(name = "rotation_z")
    private BigDecimal rotationZ;
    @Column(name = "scale_x")
    private BigDecimal scaleX;
    @Column(name = "scale_y")
    private BigDecimal scaleY;
    @Column(name = "scale_z")
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
