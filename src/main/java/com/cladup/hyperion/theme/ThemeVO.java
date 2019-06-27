package com.cladup.hyperion.theme;

import com.cladup.hyperion.themelight.ThemeLightVO;
import com.cladup.hyperion.themeobject.ThemeObjectVO;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class ThemeVO {
    private final long id;
    private final String name;
    private final String description;
    private final BigDecimal cameraPositionX;
    private final BigDecimal cameraPositionY;
    private final BigDecimal cameraPositionZ;
    private final BigDecimal cameraRotationX;
    private final BigDecimal cameraRotationY;
    private final BigDecimal cameraRotationZ;
    private final BigDecimal positionX;
    private final BigDecimal positionY;
    private final BigDecimal positionZ;
    private final BigDecimal rotationX;
    private final BigDecimal rotationY;
    private final BigDecimal rotationZ;
    private final BigDecimal scaleX;
    private final BigDecimal scaleY;
    private final BigDecimal scaleZ;
    private final List<ThemeObjectVO> themeObjects;
    private final List<ThemeLightVO> themeLights;

}
