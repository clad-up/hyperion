package com.cladup.hyperion.themelight;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
public class ThemeLightVO {
    private final long id;
    @NotBlank
    private final String type;
    @NotBlank
    private final String name;
    private final boolean castShadow;
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
