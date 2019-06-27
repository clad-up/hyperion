package com.cladup.hyperion.theme;

import com.cladup.hyperion.themelight.ThemeLightDTO;
import com.cladup.hyperion.themeobject.ThemeObjectDTO;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class ThemeDTO {
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
    private final List<ThemeObjectDTO> themeObjects;
    @NotNull
    private final List<ThemeLightDTO> themeLights;

}
