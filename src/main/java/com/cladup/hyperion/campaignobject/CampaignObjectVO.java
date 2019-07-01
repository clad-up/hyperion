package com.cladup.hyperion.campaignobject;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
public class CampaignObjectVO {
    private final long id;
    @Min(0)
    private final long themeObjectId;
    @NotBlank
    private final String name;
    @NotBlank
    private final String type;
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
    private final String companyProductId;
    @NotNull
    private final String companyProductName;
    @NotNull
    private final String companyProductImageUrl;
    @NotNull
    private final String companyProductTargetUrl;

}
