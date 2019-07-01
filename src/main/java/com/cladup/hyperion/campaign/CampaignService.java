package com.cladup.hyperion.campaign;

import com.cladup.hyperion.campaign.input.CreateCampaignInput;
import com.cladup.hyperion.campaignlight.CampaignLight;
import com.cladup.hyperion.campaignobject.CampaignObject;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class CampaignService {
    private final CampaignRepository campaignRepository;
    private final CampaignToCampaignVOConverter campaignToCampaignVOConverter;
    private final CampaignVOToCampaignDTOConverter campaignVOToCampaignDTOConverter;

    /**
     * Get all available campaigns
     *
     * @return List of campaigns
     */
    public @NotNull List<CampaignDTO> getAll() {
        return StreamSupport
                .stream(campaignRepository.findAll().spliterator(), false)
                .map(campaignToCampaignVOConverter::convert)
                .map(campaignVOToCampaignDTOConverter::convert)
                .collect(Collectors.toList());
    }

    /**
     * Get campaign by primary key
     *
     * @param id Primary key
     * @return Found campaign
     */
    public @NotNull CampaignDTO getById(long id) {
        return campaignRepository.findById(id)
                .map(campaignToCampaignVOConverter::convert)
                .map(campaignVOToCampaignDTOConverter::convert)
                .orElseThrow();
    }

    public @NotNull CampaignDTO create(@NotNull CreateCampaignInput createCampaignInput) {
        Campaign newCampaign = Campaign.builder()
                .themeId(createCampaignInput.getThemeId())
                .name(createCampaignInput.getName())
                .description(createCampaignInput.getDescription())
                .cameraPositionX(createCampaignInput.getCameraPositionX())
                .cameraPositionY(createCampaignInput.getCameraPositionY())
                .cameraPositionZ(createCampaignInput.getCameraPositionZ())
                .cameraRotationX(createCampaignInput.getCameraRotationX())
                .cameraRotationY(createCampaignInput.getCameraRotationY())
                .cameraRotationZ(createCampaignInput.getCameraRotationZ())
                .positionX(createCampaignInput.getPositionX())
                .positionY(createCampaignInput.getPositionY())
                .positionZ(createCampaignInput.getPositionZ())
                .rotationX(createCampaignInput.getRotationX())
                .rotationY(createCampaignInput.getRotationY())
                .rotationZ(createCampaignInput.getRotationZ())
                .scaleX(createCampaignInput.getScaleX())
                .scaleY(createCampaignInput.getScaleY())
                .scaleZ(createCampaignInput.getScaleZ())
                .campaignObjects(createCampaignInput.getCampaignObjects().stream()
                        .map(createCampaignObjectInput -> CampaignObject.builder()
                                .themeObjectId(createCampaignObjectInput.getThemeObjectId())
                                .type(createCampaignObjectInput.getType())
                                .name(createCampaignObjectInput.getName())
                                .positionX(createCampaignObjectInput.getPositionX())
                                .positionY(createCampaignObjectInput.getPositionY())
                                .positionZ(createCampaignObjectInput.getPositionZ())
                                .rotationX(createCampaignObjectInput.getRotationX())
                                .rotationY(createCampaignObjectInput.getRotationY())
                                .rotationZ(createCampaignObjectInput.getRotationZ())
                                .scaleX(createCampaignObjectInput.getScaleX())
                                .scaleY(createCampaignObjectInput.getScaleY())
                                .scaleZ(createCampaignObjectInput.getScaleZ())
                                .companyProductId(createCampaignObjectInput.getCompanyProductId())
                                .companyProductName(createCampaignObjectInput.getCompanyProductName())
                                .companyProductImageUrl(createCampaignObjectInput.getCompanyProductImageUrl())
                                .companyProductTargetUrl(createCampaignObjectInput.getCompanyProductTargetUrl())
                                .build())
                        .collect(Collectors.toList()))
                .campaignLights(createCampaignInput.getCampaignLights().stream()
                        .map(createCampaignLightInput -> CampaignLight.builder()
                                .themeLightId(createCampaignLightInput.getThemeLightId())
                                .type(createCampaignLightInput.getType())
                                .name(createCampaignLightInput.getName())
                                .castShadow(createCampaignLightInput.isCastShadow())
                                .angle(createCampaignLightInput.getAngle())
                                .color(createCampaignLightInput.getColor())
                                .distance(createCampaignLightInput.getDistance())
                                .intensity(createCampaignLightInput.getIntensity())
                                .spotPenumbra(createCampaignLightInput.getSpotPenumbra())
                                .build())
                        .collect(Collectors.toList()))
                .build();
        return Optional.of(newCampaign)
                .map(campaignRepository::save)
                .map(campaignToCampaignVOConverter::convert)
                .map(campaignVOToCampaignDTOConverter::convert)
                .orElseThrow();
    }

}
