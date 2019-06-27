package com.cladup.hyperion.themeobject;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class ThemeObjectVOToThemeObjectDTOConverter implements Converter<ThemeObjectVO, ThemeObjectDTO> {

    @Override
    public @NotNull ThemeObjectDTO convert(@NotNull ThemeObjectVO source) {
        return ThemeObjectDTO.builder()
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
