package com.cladup.hyperion.theme;

import com.cladup.hyperion.theme.input.CreateThemeInput;
import com.cladup.hyperion.theme.input.UpdateThemeInput;
import com.cladup.hyperion.themelight.ThemeLight;
import com.cladup.hyperion.themelight.ThemeLightVO;
import com.cladup.hyperion.themeobject.ThemeObject;
import com.cladup.hyperion.themeobject.ThemeObjectVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
     *
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
     *
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
     *
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

    /**
     * Update theme
     *
     * @param id               primary key
     * @param updateThemeInput Input with updated theme properties
     * @return Updated theme
     */
    public @NotNull ThemeDTO update(long id, @NotNull UpdateThemeInput updateThemeInput) {
        return themeRepository.findById(id)
                .filter(theme -> theme.getId() == updateThemeInput.getId())
                .map(theme -> theme.toBuilder()
                        .name(updateThemeInput.getName())
                        .description(updateThemeInput.getDescription())
                        .cameraPositionX(updateThemeInput.getCameraPositionX())
                        .cameraPositionY(updateThemeInput.getCameraPositionY())
                        .cameraPositionZ(updateThemeInput.getCameraPositionZ())
                        .cameraRotationX(updateThemeInput.getCameraRotationX())
                        .cameraRotationY(updateThemeInput.getCameraRotationY())
                        .cameraRotationZ(updateThemeInput.getCameraRotationZ())
                        .positionX(updateThemeInput.getPositionX())
                        .positionY(updateThemeInput.getPositionY())
                        .positionZ(updateThemeInput.getPositionZ())
                        .rotationX(updateThemeInput.getRotationX())
                        .rotationY(updateThemeInput.getRotationY())
                        .rotationZ(updateThemeInput.getRotationZ())
                        .scaleX(updateThemeInput.getScaleX())
                        .scaleY(updateThemeInput.getScaleY())
                        .scaleZ(updateThemeInput.getScaleZ())
                        .themeObjects(updateThemeInput.getThemeObjects().stream()
                                .map(updateThemeObjectInput -> ThemeObject.builder()
                                        .type(updateThemeObjectInput.getType())
                                        .name(updateThemeObjectInput.getName())
                                        .positionX(updateThemeObjectInput.getPositionX())
                                        .positionY(updateThemeObjectInput.getPositionY())
                                        .positionZ(updateThemeObjectInput.getPositionZ())
                                        .rotationX(updateThemeObjectInput.getRotationX())
                                        .rotationY(updateThemeObjectInput.getRotationY())
                                        .rotationZ(updateThemeObjectInput.getRotationZ())
                                        .scaleX(updateThemeObjectInput.getScaleX())
                                        .scaleY(updateThemeObjectInput.getScaleY())
                                        .scaleZ(updateThemeObjectInput.getScaleZ())
                                        .companyProductId(updateThemeObjectInput.getCompanyProductId())
                                        .companyProductName(updateThemeObjectInput.getCompanyProductName())
                                        .companyProductImageUrl(updateThemeObjectInput.getCompanyProductImageUrl())
                                        .companyProductTargetUrl(updateThemeObjectInput.getCompanyProductTargetUrl())
                                        .build())
                                .collect(Collectors.toList()))
                        .themeLights(updateThemeInput.getThemeLights().stream()
                                .map(updateThemeLightInput -> ThemeLight.builder()
                                        .type(updateThemeLightInput.getType())
                                        .name(updateThemeLightInput.getName())
                                        .castShadow(updateThemeLightInput.isCastShadow())
                                        .angle(updateThemeLightInput.getAngle())
                                        .color(updateThemeLightInput.getColor())
                                        .distance(updateThemeLightInput.getDistance())
                                        .intensity(updateThemeLightInput.getIntensity())
                                        .spotPenumbra(updateThemeLightInput.getSpotPenumbra())
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .map(themeRepository::save)
                .map(themeToThemeVOConverter::convert)
                .map(themeVOToThemeDTOConverter::convert)
                .orElseThrow();
    }

    /**
     * Delete theme
     *
     * @param id primary key
     * @return Deleted theme
     */
    public ThemeDTO delete(long id) {
        return themeRepository.findById(id)
                .map(theme -> {
                    themeRepository.deleteById(id);
                    return theme;
                })
                .map(themeToThemeVOConverter::convert)
                .map(themeVOToThemeDTOConverter::convert)
                .orElseThrow();
    }

}
