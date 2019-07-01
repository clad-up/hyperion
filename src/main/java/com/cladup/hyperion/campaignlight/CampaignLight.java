package com.cladup.hyperion.campaignlight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "campaign_lights")
public class CampaignLight {
    @Id
    @GeneratedValue
    private long id;
    @Min(0)
    private long themeLightId;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private boolean castShadow;
    @Min(0)
    @Max(360)
    @Column(nullable = false)
    private int angle;
    @Column(nullable = false, length = 6)
    private String color;
    @Column(nullable = false,
            precision = 5, scale = 3)
    private BigDecimal distance;
    @Column(nullable = false,
            precision = 5, scale = 3)
    private BigDecimal intensity;
    @Column(nullable = false,
            precision = 3, scale = 1)
    private BigDecimal spotPenumbra;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @CreationTimestamp
    private LocalDateTime createdAt;

}
