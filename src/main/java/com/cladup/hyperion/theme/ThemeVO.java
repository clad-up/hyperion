package com.cladup.hyperion.theme;

import com.cladup.hyperion.themelight.ThemeLightVO;
import com.cladup.hyperion.themeobject.ThemeObjectVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class ThemeVO {
    private final long id;
    @NotBlank
    private final String name;
    @NotNull
    private final String description;
    @NotNull
    private final BigDecimal cameraPositionX;
    @NotNull
    private final BigDecimal cameraPositionY;
    @NotNull
    private final BigDecimal cameraPositionZ;
    @NotNull
    private final BigDecimal cameraRotationX;
    @NotNull
    private final BigDecimal cameraRotationY;
    @NotNull
    private final BigDecimal cameraRotationZ;
    @NotNull
    private final BigDecimal positionX;
    @NotNull
    private final BigDecimal positionY;
    @NotNull
    private final BigDecimal positionZ;
    @NotNull
    private final BigDecimal rotationX;
    @NotNull
    private final BigDecimal rotationY;
    @NotNull
    private final BigDecimal rotationZ;
    @NotNull
    private final BigDecimal scaleX;
    @NotNull
    private final BigDecimal scaleY;
    @NotNull
    private final BigDecimal scaleZ;
    @NotNull
    private final List<ThemeObjectVO> themeObjects;
    @NotNull
    private final List<ThemeLightVO> themeLights;

}
