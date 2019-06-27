package com.cladup.hyperion.theme;

import com.cladup.hyperion.themelight.*;
import com.cladup.hyperion.themeobject.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThemeConverterTest {
    @Autowired
    private ThemeToThemeVOConverter themeToThemeVOConverter;
    @Autowired
    private ThemeVOToThemeDTOConverter themeVOToThemeDTOConverter;
    @Autowired
    private ThemeLightToThemeLightVOConverter themeLightToThemeLightVOConverter;
    @Autowired
    private ThemeLightVOToThemeLightDTOConverter themeLightVOToThemeLightDTOConverter;
    @Autowired
    private ThemeObjectToThemeObjectVOConverter themeObjectToThemeObjectVOConverter;
    @Autowired
    private ThemeObjectVOToThemeObjectDTOConverter themeObjectVOToThemeObjectDTOConverter;

    private Theme theme;
    private ThemeVO themeVO;
    private ThemeObject themeObject;
    private ThemeObjectVO themeObjectVO;
    private ThemeLight themeLight;
    private ThemeLightVO themeLightVO;

    @Before
    public void setUp() {
        themeLight = ThemeLight.builder()
                .type("commerce")
                .name("Commerce Light")
                .castShadow(true)
                .angle(90)
                .color("FFFFFF")
                .distance(new BigDecimal("99.999"))
                .intensity(new BigDecimal("99.999"))
                .spotPenumbra(new BigDecimal("99.9"))
                .build();
        themeLightVO = ThemeLightVO.builder()
                .type("commerce_vo")
                .name("Commerce Light VO")
                .castShadow(true)
                .angle(90)
                .color("DDDDDD")
                .distance(new BigDecimal("77.777"))
                .intensity(new BigDecimal("77.777"))
                .spotPenumbra(new BigDecimal("77.7"))
                .build();
        BigDecimal graphicValue = new BigDecimal("99.999");
        themeObject = ThemeObject.builder()
                .name("Time Stone")
                .type("product")
                .positionX(graphicValue)
                .positionY(graphicValue)
                .positionZ(graphicValue)
                .rotationX(graphicValue)
                .rotationY(graphicValue)
                .rotationZ(graphicValue)
                .scaleX(graphicValue)
                .scaleY(graphicValue)
                .scaleZ(graphicValue)
                .companyProductId("1")
                .companyProductName("Endgame Infinity Stone")
                .companyProductImageUrl("Image Url")
                .companyProductTargetUrl("Target Url")
                .build();
        BigDecimal graphicValueVO = new BigDecimal("77.777");
        themeObjectVO = ThemeObjectVO.builder()
                .name("Time Stone")
                .type("product")
                .positionX(graphicValueVO)
                .positionY(graphicValueVO)
                .positionZ(graphicValueVO)
                .rotationX(graphicValueVO)
                .rotationY(graphicValueVO)
                .rotationZ(graphicValueVO)
                .scaleX(graphicValueVO)
                .scaleY(graphicValueVO)
                .scaleZ(graphicValueVO)
                .companyProductId("2")
                .companyProductName("Endgame Infinity Stone VO")
                .companyProductImageUrl("Image Url VO")
                .companyProductTargetUrl("Target Url VO")
                .build();
        BigDecimal defaultDecimalValue = new BigDecimal("99.999");
        theme = Theme.builder()
                .name("Star Wars Theme")
                .description("A theme that shows Star Wars stuff")
                .cameraPositionX(defaultDecimalValue)
                .cameraPositionY(defaultDecimalValue)
                .cameraPositionZ(defaultDecimalValue)
                .cameraRotationX(defaultDecimalValue)
                .cameraRotationY(defaultDecimalValue)
                .cameraRotationZ(defaultDecimalValue)
                .positionX(defaultDecimalValue)
                .positionY(defaultDecimalValue)
                .positionZ(defaultDecimalValue)
                .rotationX(defaultDecimalValue)
                .rotationY(defaultDecimalValue)
                .rotationZ(defaultDecimalValue)
                .scaleX(defaultDecimalValue)
                .scaleY(defaultDecimalValue)
                .scaleZ(defaultDecimalValue)
                .themeLights(List.of(themeLight))
                .themeObjects(List.of(themeObject))
                .build();
        BigDecimal defaultDecimalValueVO = new BigDecimal("77.777");
        themeVO = ThemeVO.builder()
                .name("Star Wars Theme VO")
                .description("A theme that shows Star Wars stuff VO")
                .cameraPositionX(defaultDecimalValueVO)
                .cameraPositionY(defaultDecimalValueVO)
                .cameraPositionZ(defaultDecimalValueVO)
                .cameraRotationX(defaultDecimalValueVO)
                .cameraRotationY(defaultDecimalValueVO)
                .cameraRotationZ(defaultDecimalValueVO)
                .positionX(defaultDecimalValueVO)
                .positionY(defaultDecimalValueVO)
                .positionZ(defaultDecimalValueVO)
                .rotationX(defaultDecimalValueVO)
                .rotationY(defaultDecimalValueVO)
                .rotationZ(defaultDecimalValueVO)
                .scaleX(defaultDecimalValueVO)
                .scaleY(defaultDecimalValueVO)
                .scaleZ(defaultDecimalValueVO)
                .themeLights(List.of(themeLightVO))
                .themeObjects(List.of(themeObjectVO))
                .build();
    }

    /**
     * Should convert `Theme` to `ThemeVO` type
     */
    @Test
    public void shouldConvertThemeToThemeVOType() {
        // Given
        // theme
        // When
        ThemeVO themeVO = themeToThemeVOConverter.convert(theme);
        // Then
        Assert.assertTrue(themeVO instanceof ThemeVO);
    }

    /**
     * Should convert `Theme` to `ThemeVO` properties
     */
    @Test
    public void shouldConvertThemeToThemeVOProperties() {
        // Given
        // theme
        // When
        ThemeVO themeVO = themeToThemeVOConverter.convert(theme);
        // Then
        Assert.assertEquals(themeVO.getId(), theme.getId());
        Assert.assertEquals(themeVO.getName(), theme.getName());
        Assert.assertEquals(themeVO.getDescription(), theme.getDescription());
        Assert.assertEquals(themeVO.getCameraPositionX(), theme.getCameraRotationX());
        Assert.assertEquals(themeVO.getCameraPositionY(), theme.getCameraRotationY());
        Assert.assertEquals(themeVO.getCameraPositionZ(), theme.getCameraRotationZ());
        Assert.assertEquals(themeVO.getCameraRotationX(), theme.getCameraRotationX());
        Assert.assertEquals(themeVO.getCameraRotationY(), theme.getCameraRotationY());
        Assert.assertEquals(themeVO.getCameraRotationZ(), theme.getCameraRotationZ());
        Assert.assertEquals(themeVO.getPositionX(), theme.getPositionX());
        Assert.assertEquals(themeVO.getPositionY(), theme.getPositionY());
        Assert.assertEquals(themeVO.getPositionZ(), theme.getPositionZ());
        Assert.assertEquals(themeVO.getRotationX(), theme.getRotationX());
        Assert.assertEquals(themeVO.getRotationY(), theme.getRotationY());
        Assert.assertEquals(themeVO.getRotationZ(), theme.getRotationZ());
        Assert.assertEquals(themeVO.getScaleX(), theme.getScaleX());
        Assert.assertEquals(themeVO.getScaleY(), theme.getScaleY());
        Assert.assertEquals(themeVO.getScaleZ(), theme.getScaleZ());
    }

    /**
     * Should convert `ThemeVO` to `ThemeDTO` type
     */
    @Test
    public void shouldConvertThemeVOtoThemeDTOType() {
        // Given
        // themeVO
        // When
        ThemeDTO themeDTO = themeVOToThemeDTOConverter.convert(themeVO);
        // Then
        Assert.assertTrue(themeDTO instanceof ThemeDTO);
    }

    /**
     * Should convert `ThemeVO` to `ThemeDTO` properties
     */
    @Test
    public void shouldConvertThemeVOToThemeDTOProperties() {
        // Given
        // themeVO
        // When
        ThemeDTO themeDTO = themeVOToThemeDTOConverter.convert(themeVO);
        // Then
        Assert.assertEquals(themeDTO.getId(), themeVO.getId());
        Assert.assertEquals(themeDTO.getName(), themeVO.getName());
        Assert.assertEquals(themeDTO.getDescription(), themeVO.getDescription());
        Assert.assertEquals(themeDTO.getCameraPositionX(), themeVO.getCameraRotationX());
        Assert.assertEquals(themeDTO.getCameraPositionY(), themeVO.getCameraRotationY());
        Assert.assertEquals(themeDTO.getCameraPositionZ(), themeVO.getCameraRotationZ());
        Assert.assertEquals(themeDTO.getCameraRotationX(), themeVO.getCameraRotationX());
        Assert.assertEquals(themeDTO.getCameraRotationY(), themeVO.getCameraRotationY());
        Assert.assertEquals(themeDTO.getCameraRotationZ(), themeVO.getCameraRotationZ());
        Assert.assertEquals(themeDTO.getPositionX(), themeVO.getPositionX());
        Assert.assertEquals(themeDTO.getPositionY(), themeVO.getPositionY());
        Assert.assertEquals(themeDTO.getPositionZ(), themeVO.getPositionZ());
        Assert.assertEquals(themeDTO.getRotationX(), themeVO.getRotationX());
        Assert.assertEquals(themeDTO.getRotationY(), themeVO.getRotationY());
        Assert.assertEquals(themeDTO.getRotationZ(), themeVO.getRotationZ());
        Assert.assertEquals(themeDTO.getScaleX(), themeVO.getScaleX());
        Assert.assertEquals(themeDTO.getScaleY(), themeVO.getScaleY());
        Assert.assertEquals(themeDTO.getScaleZ(), themeVO.getScaleZ());
    }

    /**
     * Should convert `ThemeLight` to `ThemeLightVO` type
     */
    @Test
    public void testShouldConvertThemeLightToThemeLightVOType() {
        // Given
        // themeLight
        // When
        ThemeLightVO themeLightVO = themeLightToThemeLightVOConverter.convert(themeLight);
        // Then
        Assert.assertTrue(themeLightVO instanceof ThemeLightVO);
    }

    /**
     * Should convert `ThemeLight` to `ThemeLightVO` properties
     */
    @Test
    public void testShouldConvertThemeLightToThemeLightVOProperties() {
        // Given
        // themeLight
        // When
        ThemeLightVO themeLightVO = themeLightToThemeLightVOConverter.convert(themeLight);
        // Then
        Assert.assertEquals(themeLightVO.getId(), themeLight.getId());
        Assert.assertEquals(themeLightVO.getType(), themeLight.getType());
        Assert.assertEquals(themeLightVO.getName(), themeLight.getName());
        Assert.assertEquals(themeLightVO.isCastShadow(), themeLight.isCastShadow());
        Assert.assertEquals(themeLightVO.getAngle(), themeLight.getAngle());
        Assert.assertEquals(themeLightVO.getColor(), themeLight.getColor());
        Assert.assertEquals(themeLightVO.getDistance(), themeLight.getDistance());
        Assert.assertEquals(themeLightVO.getIntensity(), themeLight.getIntensity());
        Assert.assertEquals(themeLightVO.getSpotPenumbra(), themeLight.getSpotPenumbra());
    }

    /**
     * Should convert `ThemeLightVO` to `ThemeLightDTO` type
     */
    @Test
    public void testShouldConvertThemeLightVOToThemeLightDTOType() {
        // Given
        // themeLightVO
        // When
        ThemeLightDTO themeLightDTO = themeLightVOToThemeLightDTOConverter.convert(themeLightVO);
        // Then
        Assert.assertTrue(themeLightDTO instanceof ThemeLightDTO);
    }

    /**
     * Should convert `ThemeLightVO` to `ThemeLightDTO` properties
     */
    @Test
    public void testShouldConvertThemeLightVOToThemeLightDTOProperties() {
        // Given
        // themeLightVO
        // When
        ThemeLightDTO themeLightDTO = themeLightVOToThemeLightDTOConverter.convert(themeLightVO);
        // Then
        Assert.assertEquals(themeLightDTO.getId(), themeLightVO.getId());
        Assert.assertEquals(themeLightDTO.getType(), themeLightVO.getType());
        Assert.assertEquals(themeLightDTO.getName(), themeLightVO.getName());
        Assert.assertEquals(themeLightDTO.isCastShadow(), themeLightVO.isCastShadow());
        Assert.assertEquals(themeLightDTO.getAngle(), themeLightVO.getAngle());
        Assert.assertEquals(themeLightDTO.getColor(), themeLightVO.getColor());
        Assert.assertEquals(themeLightDTO.getDistance(), themeLightVO.getDistance());
        Assert.assertEquals(themeLightDTO.getIntensity(), themeLightVO.getIntensity());
        Assert.assertEquals(themeLightDTO.getSpotPenumbra(), themeLightVO.getSpotPenumbra());
    }

    /**
     * Should convert `ThemeObject` to `ThemeObjectVO` type
     */
    @Test
    public void testShouldConvertThemeObjectToThemeObjectVOType() {
        // Given
        // themeObject
        // When
        ThemeObjectVO themeObjectVO = themeObjectToThemeObjectVOConverter.convert(themeObject);
        // Then
        Assert.assertTrue(themeObjectVO instanceof ThemeObjectVO);
    }

    /**
     * Should convert `ThemeObject` to `ThemeObjectVO` properties
     */
    @Test
    public void testShouldConvertThemeObjectToThemeObjectVOProperties() {
        // Given
        // themeObject
        // When
        ThemeObjectVO themeObjectVO = themeObjectToThemeObjectVOConverter.convert(themeObject);
        // Then
        Assert.assertEquals(themeObjectVO.getId(), themeObject.getId());
        Assert.assertEquals(themeObjectVO.getName(), themeObject.getName());
        Assert.assertEquals(themeObjectVO.getType(), themeObject.getType());
        Assert.assertEquals(themeObjectVO.getPositionX(), themeObject.getPositionX());
        Assert.assertEquals(themeObjectVO.getPositionY(), themeObject.getPositionY());
        Assert.assertEquals(themeObjectVO.getPositionZ(), themeObject.getPositionZ());
        Assert.assertEquals(themeObjectVO.getRotationX(), themeObject.getRotationX());
        Assert.assertEquals(themeObjectVO.getRotationY(), themeObject.getRotationY());
        Assert.assertEquals(themeObjectVO.getRotationZ(), themeObject.getRotationZ());
        Assert.assertEquals(themeObjectVO.getScaleX(), themeObject.getScaleX());
        Assert.assertEquals(themeObjectVO.getScaleY(), themeObject.getScaleY());
        Assert.assertEquals(themeObjectVO.getScaleZ(), themeObject.getScaleZ());
        Assert.assertEquals(themeObjectVO.getCompanyProductId(), themeObject.getCompanyProductId());
        Assert.assertEquals(themeObjectVO.getCompanyProductName(), themeObject.getCompanyProductName());
        Assert.assertEquals(themeObjectVO.getCompanyProductImageUrl(), themeObject.getCompanyProductImageUrl());
        Assert.assertEquals(themeObjectVO.getCompanyProductTargetUrl(), themeObject.getCompanyProductTargetUrl());
    }

    /**
     * Should convert `ThemeObjectVO` to `ThemeObjectDTO` type
     */
    @Test
    public void testShouldConvertThemeObjectVOToThemeObjectDTOType() {
        // Given
        // themeObjectVO
        // When
        ThemeObjectDTO themeObjectDTO = themeObjectVOToThemeObjectDTOConverter.convert(themeObjectVO);
        // Then
        Assert.assertTrue(themeObjectDTO instanceof ThemeObjectDTO);
    }

    /**
     * Should convert `ThemeObjectVO` to `ThemeObjectDTO` properties
     */
    @Test
    public void testShouldConvertThemeObjectVOToThemeObjectDTOProperties() {
        // Given
        // themeObjectVO
        // When
        ThemeObjectDTO themeObjectDTO = themeObjectVOToThemeObjectDTOConverter.convert(themeObjectVO);
        // Then
        Assert.assertEquals(themeObjectDTO.getId(), themeObjectVO.getId());
        Assert.assertEquals(themeObjectDTO.getName(), themeObjectVO.getName());
        Assert.assertEquals(themeObjectDTO.getType(), themeObjectVO.getType());
        Assert.assertEquals(themeObjectDTO.getPositionX(), themeObjectVO.getPositionX());
        Assert.assertEquals(themeObjectDTO.getPositionY(), themeObjectVO.getPositionY());
        Assert.assertEquals(themeObjectDTO.getPositionZ(), themeObjectVO.getPositionZ());
        Assert.assertEquals(themeObjectDTO.getRotationX(), themeObjectVO.getRotationX());
        Assert.assertEquals(themeObjectDTO.getRotationY(), themeObjectVO.getRotationY());
        Assert.assertEquals(themeObjectDTO.getRotationZ(), themeObjectVO.getRotationZ());
        Assert.assertEquals(themeObjectDTO.getScaleX(), themeObjectVO.getScaleX());
        Assert.assertEquals(themeObjectDTO.getScaleY(), themeObjectVO.getScaleY());
        Assert.assertEquals(themeObjectDTO.getScaleZ(), themeObjectVO.getScaleZ());
        Assert.assertEquals(themeObjectDTO.getCompanyProductId(), themeObjectVO.getCompanyProductId());
        Assert.assertEquals(themeObjectDTO.getCompanyProductName(), themeObjectVO.getCompanyProductName());
        Assert.assertEquals(themeObjectDTO.getCompanyProductImageUrl(), themeObjectVO.getCompanyProductImageUrl());
        Assert.assertEquals(themeObjectDTO.getCompanyProductTargetUrl(), themeObjectVO.getCompanyProductTargetUrl());
    }

}
