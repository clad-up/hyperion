package com.cladup.hyperion.campaign;

import com.cladup.hyperion.campaign.input.CreateCampaignInput;
import com.cladup.hyperion.campaign.input.UpdateCampaignInput;
import com.cladup.hyperion.campaign.input.UpdateCampaignLightInput;
import com.cladup.hyperion.campaign.input.UpdateCampaignObjectInput;
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

    /**
     * Create campaign
     *
     * @param createCampaignInput Input data for campaign creation
     * @return Created campaign
     */
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

    /**
     * Update campaign
     *
     * @param updateCampaignInput Input for campaign update
     * @return Updated campaign
     */
    public @NotNull CampaignDTO update(long id, @NotNull UpdateCampaignInput updateCampaignInput) {
        return campaignRepository.findById(id)
                .filter(campaign -> campaign.getId() == updateCampaignInput.getId())
                .map(campaign -> campaign.toBuilder()
                        .themeId(updateCampaignInput.getThemeId())
                        .name(updateCampaignInput.getName())
                        .description(updateCampaignInput.getDescription())
                        .cameraPositionX(updateCampaignInput.getCameraPositionX())
                        .cameraPositionY(updateCampaignInput.getCameraPositionY())
                        .cameraPositionZ(updateCampaignInput.getCameraPositionZ())
                        .cameraRotationX(updateCampaignInput.getCameraRotationX())
                        .cameraRotationY(updateCampaignInput.getCameraRotationY())
                        .cameraRotationZ(updateCampaignInput.getCameraRotationZ())
                        .positionX(updateCampaignInput.getPositionX())
                        .positionY(updateCampaignInput.getPositionY())
                        .positionZ(updateCampaignInput.getPositionZ())
                        .rotationX(updateCampaignInput.getRotationX())
                        .rotationY(updateCampaignInput.getRotationY())
                        .rotationZ(updateCampaignInput.getRotationZ())
                        .scaleX(updateCampaignInput.getScaleX())
                        .scaleY(updateCampaignInput.getScaleY())
                        .scaleZ(updateCampaignInput.getScaleZ())
                        .campaignObjects(campaign.getCampaignObjects().stream()
                                .map(campaignObject -> {
                                    UpdateCampaignObjectInput updatingObject = updateCampaignInput
                                            .getCampaignObjects()
                                            .stream()
                                            .filter(updateThemeObjectInput -> updateThemeObjectInput.getId() ==
                                                    campaignObject.getId())
                                            .findFirst()
                                            .orElseThrow();
                                    return campaignObject.toBuilder()
                                            .themeObjectId(updatingObject.getThemeObjectId())
                                            .name(updatingObject.getName())
                                            .type(updatingObject.getType())
                                            .positionX(updatingObject.getPositionX())
                                            .positionY(updatingObject.getPositionY())
                                            .positionZ(updatingObject.getPositionZ())
                                            .rotationX(updatingObject.getPositionX())
                                            .rotationY(updatingObject.getPositionY())
                                            .rotationZ(updatingObject.getPositionZ())
                                            .scaleX(updatingObject.getScaleX())
                                            .scaleY(updatingObject.getScaleY())
                                            .scaleZ(updatingObject.getScaleZ())
                                            .companyProductId(updatingObject.getCompanyProductId())
                                            .companyProductName(updatingObject.getCompanyProductName())
                                            .companyProductImageUrl(updatingObject.getCompanyProductImageUrl())
                                            .companyProductTargetUrl(updatingObject.getCompanyProductTargetUrl())
                                            .build();
                                })
                                .collect(Collectors.toList()))
                        .campaignLights(campaign.getCampaignLights().stream()
                                .map(campaignLight -> {
                                    UpdateCampaignLightInput updatingLight = updateCampaignInput
                                            .getCampaignLights()
                                            .stream()
                                            .filter(updateThemeLightInput -> updateThemeLightInput.getId() ==
                                                    campaignLight.getId())
                                            .findFirst()
                                            .orElseThrow();
                                    return campaignLight.toBuilder()
                                            .themeLightId(updatingLight.getThemeLightId())
                                            .type(updatingLight.getType())
                                            .name(updatingLight.getName())
                                            .castShadow(updatingLight.isCastShadow())
                                            .angle(updatingLight.getAngle())
                                            .color(updatingLight.getColor())
                                            .distance(updatingLight.getDistance())
                                            .intensity(updatingLight.getIntensity())
                                            .spotPenumbra(updatingLight.getSpotPenumbra())
                                            .build();
                                })
                                .collect(Collectors.toList()))
                        .build())
                .map(campaignToCampaignVOConverter::convert)
                .map(campaignVOToCampaignDTOConverter::convert)
                .orElseThrow();
    }

    /**
     * Delete campaign
     *
     * @param id Primary key
     * @return Deleted campaign
     */
    public CampaignDTO delete(long id) {
        return campaignRepository.findById(id)
                .map(theme -> {
                    campaignRepository.deleteById(id);
                    return theme;
                })
                .map(campaignToCampaignVOConverter::convert)
                .map(campaignVOToCampaignDTOConverter::convert)
                .orElseThrow();
    }

}
