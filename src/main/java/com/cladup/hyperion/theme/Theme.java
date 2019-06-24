package com.cladup.hyperion.theme;

import com.cladup.hyperion.themelight.ThemeLight;
import com.cladup.hyperion.themeobject.ThemeObject;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
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
    private String name;
    private String description;
    @Column(name = "camera_position_x")
    private float cameraPositionX;
    @Column(name = "camera_position_y")
    private float cameraPositionY;
    @Column(name = "camera_position_z")
    private float cameraPositionZ;
    @Column(name = "camera_rotation_x")
    private float cameraRotationX;
    @Column(name = "camera_rotation_y")
    private float cameraRotationY;
    @Column(name = "camera_rotation_z")
    private float cameraRotationZ;
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
