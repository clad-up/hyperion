package com.cladup.hyperion.themelight;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class ThemeLightVOToThemeLightDTOConverter implements Converter<ThemeLightVO, ThemeLightDTO> {

    @Override
    public @NotNull ThemeLightDTO convert(@NotNull ThemeLightVO source) {
        return ThemeLightDTO.builder()
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
