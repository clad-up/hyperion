package com.cladup.hyperion.themeobject;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * Converts `ThemeObject` entity to `ThemeObjectVO` value object
 */
@Component
public class ThemeObjectToThemeObjectVOConverter implements Converter<ThemeObject, ThemeObjectVO> {

    @Override
    public @NotNull ThemeObjectVO convert(@NotNull ThemeObject source) {
        return ThemeObjectVO.builder()
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

    public @NotNull ThemeObject revert(@NotNull ThemeObjectVO source) {
        return ThemeObject.builder()
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
