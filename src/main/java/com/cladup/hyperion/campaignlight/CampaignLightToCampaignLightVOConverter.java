package com.cladup.hyperion.campaignlight;

import org.springframework.core.convert.converter.Converter;

public class CampaignLightToCampaignLightVOConverter implements Converter<CampaignLight, CampaignLightVO> {

    @Override
    public CampaignLightVO convert(CampaignLight source) {
        return CampaignLightVO.builder()
                .id(source.getId())
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
