package com.cladup.hyperion.themeobject;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
public class ThemeObjectVO {
    private final long id;
    private final String name;
    private final String type;
    private final BigDecimal positionX;
    private final BigDecimal positionY;
    private final BigDecimal positionZ;
    private final BigDecimal rotationX;
    private final BigDecimal rotationY;
    private final BigDecimal rotationZ;
    private final BigDecimal scaleX;
    private final BigDecimal scaleY;
    private final BigDecimal scaleZ;
    private final String companyProductId;
    private final String companyProductName;
    private final String companyProductImageUrl;
    private final String companyProductTargetUrl;

}
