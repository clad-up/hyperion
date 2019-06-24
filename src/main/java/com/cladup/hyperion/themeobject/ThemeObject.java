package com.cladup.hyperion.themeobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
    private float positionX;
    @Column(name = "position_y")
    private float positionY;
    @Column(name = "position_z")
    private float positionZ;
    @Column(name = "rotation_x")
    private float rotationX;
    @Column(name = "rotation_y")
    private float rotationY;
    @Column(name = "rotation_z")
    private float rotationZ;
    @Column(name = "scale_x")
    private float scaleX;
    @Column(name = "scale_y")
    private float scaleY;
    @Column(name = "scale_z")
    private float scaleZ;
    private String companyProductId;
    private String companyProductName;
    private String companyProductImageUrl;
    private String companyProductTargetUrl;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @CreationTimestamp
    private LocalDateTime createdAt;

}
