package com.cladup.hyperion.themeobject;

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
@Table(name = "theme_objects")
public class ThemeObject {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String type;
    private float positionX;
    private float positionY;
    private float positionZ;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float scaleZ;
    private String companyProductId;
    private String companyProductName;
    private String companyProductImageUrl;
    private String companyProductTargetUrl;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

}
