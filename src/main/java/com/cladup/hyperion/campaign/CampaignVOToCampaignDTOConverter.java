package com.cladup.hyperion.campaign;

import com.cladup.hyperion.campaignlight.CampaignLightVOToCampaignLightDTOConverter;
import com.cladup.hyperion.campaignobject.CampaignObjectVOToCampaignObjectDTOConverter;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CampaignVOToCampaignDTOConverter implements Converter<CampaignVO, CampaignDTO> {
    private final CampaignLightVOToCampaignLightDTOConverter campaignLightVOToCampaignLightDTOConverter;
    private final CampaignObjectVOToCampaignObjectDTOConverter campaignObjectVOToCampaignObjectDTOConverter;

    @Override
    public CampaignDTO convert(CampaignVO source) {
        return CampaignDTO.builder()
                .id(source.getId())
                .themeId(source.getThemeId())
                .name(source.getName())
                .description(source.getDescription())
                .cameraPositionX(source.getCameraPositionX())
                .cameraPositionY(source.getCameraPositionY())
                .cameraPositionZ(source.getCameraPositionZ())
                .cameraRotationX(source.getCameraRotationX())
                .cameraRotationY(source.getCameraRotationY())
                .cameraRotationZ(source.getCameraRotationZ())
                .positionX(source.getPositionX())
                .positionY(source.getPositionY())
                .positionZ(source.getPositionZ())
                .rotationX(source.getRotationX())
                .rotationY(source.getRotationY())
                .rotationZ(source.getRotationZ())
                .scaleX(source.getScaleX())
                .scaleY(source.getScaleY())
                .scaleZ(source.getScaleZ())
                .campaignLights(source.getCampaignLights().stream()
                        .map(campaignLightVOToCampaignLightDTOConverter::convert)
                        .collect(Collectors.toList()))
                .campaignObjects(source.getCampaignObjects().stream()
                        .map(campaignObjectVOToCampaignObjectDTOConverter::convert)
                        .collect(Collectors.toList()))
                .build();
    }

}
