package com.cladup.hyperion.theme.input;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateThemeInput {
    @NotBlank
    private final String name;
    @NotNull
    private final String description;
    @DecimalMin("0.000")
    @DecimalMax("100.000")
    @NotNull
    private final BigDecimal cameraPositionX;
    @DecimalMin("0.000")
    @DecimalMax("100.000")
    @NotNull
    private final BigDecimal cameraPositionY;
    @DecimalMin("0.000")
    @DecimalMax("100.000")
    @NotNull
    private final BigDecimal cameraPositionZ;
    @DecimalMin("0.000")
    @DecimalMax("100.000")
    @NotNull
    private final BigDecimal cameraRotationX;
    @DecimalMin("0.000")
    @DecimalMax("100.000")
    @NotNull
    private final BigDecimal cameraRotationY;
    @DecimalMin("0.000")
    @DecimalMax("100.000")
    @NotNull
    private final BigDecimal cameraRotationZ;
    @DecimalMin("0.000")
    @DecimalMax("100.000")
    @NotNull
    private final BigDecimal positionX;
    @DecimalMin("0.000")
    @DecimalMax("100.000")
    @NotNull
    private final BigDecimal positionY;
    @DecimalMin("0.000")
    @DecimalMax("100.000")
    @NotNull
    private final BigDecimal positionZ;
    @DecimalMin("0.000")
    @DecimalMax("100.000")
    @NotNull
    private final BigDecimal rotationX;
    @DecimalMin("0.000")
    @DecimalMax("100.000")
    @NotNull
    private final BigDecimal rotationY;
    @DecimalMin("0.000")
    @DecimalMax("100.000")
    @NotNull
    private final BigDecimal rotationZ;
    @DecimalMin("0.000")
    @DecimalMax("100.000")
    @NotNull
    private final BigDecimal scaleX;
    @DecimalMin("0.000")
    @DecimalMax("100.000")
    @NotNull
    private final BigDecimal scaleY;
    @DecimalMin("0.000")
    @DecimalMax("100.000")
    @NotNull
    private final BigDecimal scaleZ;
    @NotNull
    private final List<CreateThemeObjectInput> themeObjects;
    @NotNull
    private final List<CreateThemeLightInput> themeLights;

}
