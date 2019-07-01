package com.cladup.hyperion.campaignobject;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CampaignObjectVOToCampaignObjectDTOConverter implements Converter<CampaignObjectVO, CampaignObjectDTO> {

    @Override
    public CampaignObjectDTO convert(CampaignObjectVO source) {
        return CampaignObjectDTO.builder()
                .id(source.getId())
                .name(source.getName())
                .type(source.getType())
                .positionX(source.getPositionX())
                .positionY(source.getPositionY())
                .positionZ(source.getPositionZ())
                .rotationX(source.getRotationX())
                .rotationY(source.getRotationY())
                .rotationZ(source.getRotationZ())
                .scaleX(source.getScaleX())
                .scaleY(source.getScaleY())
                .scaleZ(source.getScaleZ())
                .companyProductId(source.getCompanyProductId())
                .companyProductName(source.getCompanyProductName())
                .companyProductImageUrl(source.getCompanyProductImageUrl())
                .companyProductTargetUrl(source.getCompanyProductTargetUrl())
                .build();
    }

}
