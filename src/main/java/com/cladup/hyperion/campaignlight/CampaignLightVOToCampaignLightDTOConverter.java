package com.cladup.hyperion.campaignlight;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CampaignLightVOToCampaignLightDTOConverter implements Converter<CampaignLightVO, CampaignLightDTO> {

    @Override
    public CampaignLightDTO convert(CampaignLightVO source) {
        return CampaignLightDTO.builder()
                .id(source.getId())
                .themeLightId(source.getThemeLightId())
                .type(source.getType())
                .name(source.getName())
                .castShadow(source.isCastShadow())
                .angle(source.getAngle())
                .color(source.getColor())
                .distance(source.getDistance())
                .intensity(source.getIntensity())
                .spotPenumbra(source.getSpotPenumbra())
                .build();
    }

}
