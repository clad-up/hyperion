package com.cladup.hyperion.theme;

import com.cladup.hyperion.theme.input.CreateThemeInput;
import com.cladup.hyperion.themelight.ThemeLightVO;
import com.cladup.hyperion.themeobject.ThemeObjectVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * All `Theme` read operations
 */
@AllArgsConstructor
@Service
public class ThemeService {
    private final ThemeRepository themeRepository;
    private final ThemeToThemeVOConverter themeToThemeVOConverter;
    private final ThemeVOToThemeDTOConverter themeVOToThemeDTOConverter;

    /**
     * Get Theme by primary key
     * @param id Primary Key
     * @return Found Theme
     */
    public @NotNull ThemeDTO getById(long id) {
        return themeRepository.findById(id)
                .map(themeToThemeVOConverter::convert)
                .map(themeVOToThemeDTOConverter::convert)
                .orElseThrow();
    }

    /**
     * Return all available themes
     * TODO: Pagination will be needed
     * @return Available themes
     */
    public @NotNull List<ThemeDTO> getAll() {
        return StreamSupport
                .stream(themeRepository.findAll().spliterator(), false)
                .map(themeToThemeVOConverter::convert)
                .map(themeVOToThemeDTOConverter::convert)
                .collect(Collectors.toList());
    }

    /**
     * Create theme
     * @param createThemeInput Input with theme properties
     * @return Persisted theme
     */
    public @NotNull ThemeDTO create(@NotNull CreateThemeInput createThemeInput) {
        ThemeVO themeVO = ThemeVO.builder()
                .name(createThemeInput.getName())
                .description(createThemeInput.getDescription())
                .cameraPositionX(createThemeInput.getCameraPositionX())
                .cameraPositionY(createThemeInput.getCameraPositionY())
                .cameraPositionZ(createThemeInput.getCameraPositionZ())
                .cameraRotationX(createThemeInput.getCameraRotationX())
                .cameraRotationY(createThemeInput.getCameraRotationY())
                .cameraRotationZ(createThemeInput.getCameraRotationZ())
                .positionX(createThemeInput.getPositionX())
                .positionY(createThemeInput.getPositionY())
                .positionZ(createThemeInput.getPositionZ())
                .rotationX(createThemeInput.getRotationX())
                .rotationY(createThemeInput.getRotationY())
                .rotationZ(createThemeInput.getRotationZ())
                .scaleX(createThemeInput.getScaleX())
                .scaleY(createThemeInput.getScaleY())
                .scaleZ(createThemeInput.getScaleZ())
                .themeObjects(createThemeInput.getThemeObjects().stream()
                        .map(createThemeObjectInput -> ThemeObjectVO.builder()
                                .type(createThemeObjectInput.getType())
                                .name(createThemeObjectInput.getName())
                                .positionX(createThemeObjectInput.getPositionX())
                                .positionY(createThemeObjectInput.getPositionY())
                                .positionZ(createThemeObjectInput.getPositionZ())
                                .rotationX(createThemeObjectInput.getRotationX())
                                .rotationY(createThemeObjectInput.getRotationY())
                                .rotationZ(createThemeObjectInput.getRotationZ())
                                .scaleX(createThemeObjectInput.getScaleX())
                                .scaleY(createThemeObjectInput.getScaleY())
                                .scaleZ(createThemeObjectInput.getScaleZ())
                                .companyProductId(createThemeObjectInput.getCompanyProductId())
                                .companyProductName(createThemeObjectInput.getCompanyProductName())
                                .companyProductImageUrl(createThemeObjectInput.getCompanyProductImageUrl())
                                .companyProductTargetUrl(createThemeObjectInput.getCompanyProductTargetUrl())
                                .build())
                        .collect(Collectors.toList()))
                .themeLights(createThemeInput.getThemeLights().stream()
                        .map(createThemeLightInput -> ThemeLightVO.builder()
                                .type(createThemeLightInput.getType())
                                .name(createThemeLightInput.getName())
                                .castShadow(createThemeLightInput.isCastShadow())
                                .angle(createThemeLightInput.getAngle())
                                .color(createThemeLightInput.getColor())
                                .distance(createThemeLightInput.getDistance())
                                .intensity(createThemeLightInput.getIntensity())
                                .spotPenumbra(createThemeLightInput.getSpotPenumbra())
                                .build())
                        .collect(Collectors.toList()))
                .build();
        return Optional.of(themeVO)
                .map(themeToThemeVOConverter::revert)
                .map(themeRepository::save)
                .map(themeToThemeVOConverter::convert)
                .map(themeVOToThemeDTOConverter::convert)
                .orElseThrow();
    }

}
