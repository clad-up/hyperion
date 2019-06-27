package com.cladup.hyperion.theme;

import com.cladup.hyperion.themelight.ThemeLightVOToThemeLightDTOConverter;
import com.cladup.hyperion.themeobject.ThemeObjectVOToThemeObjectDTOConverter;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ThemeVOToThemeDTOConverter implements Converter<ThemeVO, ThemeDTO> {
    private final ThemeLightVOToThemeLightDTOConverter themeLightVOToThemeLightDTOConverter;
    private final ThemeObjectVOToThemeObjectDTOConverter themeObjectVOToThemeObjectDTOConverter;

    @Override
    public @NotNull ThemeDTO convert(@NotNull ThemeVO source) {
        return ThemeDTO.builder()
                .id(source.getId())
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
                .themeLights(source.getThemeLights().stream()
                        .map(themeLightVOToThemeLightDTOConverter::convert)
                        .collect(Collectors.toList()))
                .themeObjects(source.getThemeObjects().stream()
                        .map(themeObjectVOToThemeObjectDTOConverter::convert)
                        .collect(Collectors.toList()))
                .build();
    }

}
