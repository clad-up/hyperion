package com.cladup.hyperion.campaign;

import com.cladup.hyperion.campaignlight.CampaignLight;
import com.cladup.hyperion.campaignobject.CampaignObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Table(name = "campaigns")
public class Campaign {
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
    @JoinColumn(name = "campaign_id")
    private List<CampaignObject> campaignObjects;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "campaign_id")
    private List<CampaignLight> campaignLights;

}
