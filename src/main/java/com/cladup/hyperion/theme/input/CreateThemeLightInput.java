package com.cladup.hyperion.theme.input;

import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class CreateThemeLightInput {
    @NotBlank
    private final String type;
    @NotBlank
    private final String name;
    private final boolean castShadow;
    @Min(0)
    @Max(360)
    private final int angle;
    @NotBlank
    private final String color;
    @NotNull
    private final BigDecimal distance;
    @NotNull
    private final BigDecimal intensity;
    @NotNull
    private final BigDecimal spotPenumbra;

}
