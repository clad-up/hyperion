package com.cladup.hyperion.themelight;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
public class ThemeLightVO {
    private final long id;
    private final String type;
    private final String name;
    private final boolean castShadow;
    private final int angle;
    private final String color;
    private final BigDecimal distance;
    private final BigDecimal intensity;
    private final BigDecimal spotPenumbra;

}
