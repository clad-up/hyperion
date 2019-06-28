package com.cladup.hyperion.theme;

import com.cladup.hyperion.themelight.ThemeLightToThemeLightVOConverter;
import com.cladup.hyperion.themeobject.ThemeObjectToThemeObjectVOConverter;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.stream.Collectors;

/**
 * Converts `Theme` entity to `ThemeVO` value object
 */
@AllArgsConstructor
@Component
public class ThemeToThemeVOConverter implements Converter<Theme, ThemeVO> {
    private final ThemeLightToThemeLightVOConverter themeLightToThemeLightVOConverter;
    private final ThemeObjectToThemeObjectVOConverter themeObjectToThemeObjectVOConverter;

    @Override
    public @NotNull ThemeVO convert(@NotNull Theme source) {
        return ThemeVO.builder()
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
                .themeObjects(source.getThemeObjects()
                        .stream()
                        .map(themeObjectToThemeObjectVOConverter::convert)
                        .collect(Collectors.toList()))
                .themeLights(source.getThemeLights()
                        .stream()
                        .map(themeLightToThemeLightVOConverter::convert)
                        .collect(Collectors.toList()))
                .build();
    }

    public @NotNull Theme revert(@NotNull ThemeVO source) {
        return Theme.builder()
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
                .themeObjects(source.getThemeObjects()
                        .stream()
                        .map(themeObjectToThemeObjectVOConverter::revert)
                        .collect(Collectors.toList()))
                .themeLights(source.getThemeLights()
                        .stream()
                        .map(themeLightToThemeLightVOConverter::revert)
                        .collect(Collectors.toList()))
                .build();
    }

}
