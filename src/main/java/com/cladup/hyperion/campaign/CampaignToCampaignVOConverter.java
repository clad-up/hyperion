package com.cladup.hyperion.campaign;

import com.cladup.hyperion.campaignlight.CampaignLightToCampaignLightVOConverter;
import com.cladup.hyperion.campaignobject.CampaignObjectToCampaignObjectVOConverter;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CampaignToCampaignVOConverter implements Converter<Campaign, CampaignVO> {
    private final CampaignObjectToCampaignObjectVOConverter campaignObjectToCampaignObjectVOConverter;
    private final CampaignLightToCampaignLightVOConverter campaignLightToCampaignLightVOConverter;

    @Override
    public CampaignVO convert(Campaign source) {
        return CampaignVO.builder()
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
                .campaignObjects(source.getCampaignObjects()
                        .stream()
                        .map(campaignObjectToCampaignObjectVOConverter::convert)
                        .collect(Collectors.toList()))
                .campaignLights(source.getCampaignLights()
                        .stream()
                        .map(campaignLightToCampaignLightVOConverter::convert)
                        .collect(Collectors.toList()))
                .build();
    }

}
