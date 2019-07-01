package com.cladup.hyperion.campaign.input;

import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class CreateCampaignObjectInput {
    @Min(0)
    private final long themeObjectId;
    @NotBlank
    private final String name;
    @NotBlank
    private final String type;
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
    private final String companyProductId;
    @NotNull
    private final String companyProductName;
    @NotNull
    private final String companyProductImageUrl;
    @NotNull
    private final String companyProductTargetUrl;

}
