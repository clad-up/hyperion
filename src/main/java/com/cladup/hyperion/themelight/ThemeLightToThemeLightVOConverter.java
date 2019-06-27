package com.cladup.hyperion.themelight;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Converts `ThemeLight` entity to `ThemeLightVO` value object
 */
@Component
public class ThemeLightToThemeLightVOConverter implements Converter<ThemeLight, ThemeLightVO> {

    @Override
    public ThemeLightVO convert(ThemeLight source) {
        return ThemeLightVO.builder()
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
