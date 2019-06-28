package com.cladup.hyperion.themelight;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * Converts `ThemeLight` entity to `ThemeLightVO` value object
 */
@Component
public class ThemeLightToThemeLightVOConverter implements Converter<ThemeLight, ThemeLightVO> {

    @Override
    public @NotNull ThemeLightVO convert(@NotNull ThemeLight source) {
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

    public @NotNull ThemeLight revert(@NotNull ThemeLightVO source) {
        return ThemeLight.builder()
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
