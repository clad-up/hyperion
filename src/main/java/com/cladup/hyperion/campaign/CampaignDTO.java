package com.cladup.hyperion.campaign;

import com.cladup.hyperion.campaignlight.CampaignLightDTO;
import com.cladup.hyperion.campaignobject.CampaignObjectDTO;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class CampaignDTO {
    private final long id;
    @Min(0)
    private final long themeId;
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
    private final List<CampaignObjectDTO> campaignObjects;
    @NotNull
    private final List<CampaignLightDTO> campaignLights;

}
