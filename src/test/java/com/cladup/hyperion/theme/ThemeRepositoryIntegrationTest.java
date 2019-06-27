package com.cladup.hyperion.theme;

import com.cladup.hyperion.themelight.ThemeLight;
import com.cladup.hyperion.themeobject.ThemeObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ThemeRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private ThemeRepository themeRepository;

    private Theme newTheme;
    private ThemeLight newLight;
    private ThemeObject newObject;

    @Before
    public void setup() {
        BigDecimal defaultDecimalValue = new BigDecimal("99.999");
        newTheme = Theme.builder()
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
                .build();
        newLight = ThemeLight.builder()
                .type("commerce")
                .name("Commerce Light")
                .castShadow(true)
                .angle(90)
                .color("FFFFFF")
                .distance(new BigDecimal("99.999"))
                .intensity(new BigDecimal("99.999"))
                .spotPenumbra(new BigDecimal("99.9"))
                .build();
        BigDecimal graphicValue = new BigDecimal("99.999");
        newObject = ThemeObject.builder()
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
    }

    /**
     * Theme Repository should return an empty optional if there's none
     * and an optional with a value when a value exists.
     */
    @Test
    public void testShouldFindById() {
        // Given
        Theme theme = testEntityManager
                .persistFlushFind(newTheme);
        // When
        Optional<Theme> createdTheme = themeRepository.findById(theme.getId());
        // Then
        Assert.assertEquals(theme.getId(), createdTheme.get().getId());
    }

    /**
     * Should find all themes in database.
     */
    @Test
    public void testShouldFindAll() {
        // Given
        Theme newTheme1 = testEntityManager
                .persistFlushFind(newTheme);
        BigDecimal defaultDecimalValue = new BigDecimal("98.888");
        Theme newTheme2 = testEntityManager
                .persistFlushFind(Theme.builder()
                        .name("Avengers Theme")
                        .description("A theme that shows Avengers stuff")
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
                        .build());
        List<Theme> newThemes = Arrays.asList(newTheme1, newTheme2);
        // When
        List<Theme> allThemes = (List<Theme>) themeRepository.findAll();
        // Then
        Assert.assertArrayEquals(allThemes.toArray(), newThemes.toArray());
    }

    /**
     * Should create when all properties have values
     */
    @Test
    public void testShouldCreate() {
        // Given
        // newTheme
        // When
        Theme savedTheme = testEntityManager.persistFlushFind(newTheme);
        // Then
        Assert.assertTrue(savedTheme.getId() > 0);
        Assert.assertEquals("Star Wars Theme", savedTheme.getName());
        Assert.assertEquals("A theme that shows Star Wars stuff", savedTheme.getDescription());
        Assert.assertEquals(newTheme.getCameraPositionX(), savedTheme.getCameraPositionX());
        Assert.assertEquals(newTheme.getCameraPositionY(), savedTheme.getCameraPositionY());
        Assert.assertEquals(newTheme.getCameraPositionZ(), savedTheme.getCameraPositionZ());
        Assert.assertEquals(newTheme.getCameraRotationX(), savedTheme.getCameraRotationX());
        Assert.assertEquals(newTheme.getCameraRotationY(), savedTheme.getCameraRotationY());
        Assert.assertEquals(newTheme.getCameraRotationZ(), savedTheme.getCameraRotationZ());
        Assert.assertEquals(newTheme.getPositionX(), savedTheme.getPositionX());
        Assert.assertEquals(newTheme.getPositionY(), savedTheme.getPositionY());
        Assert.assertEquals(newTheme.getPositionZ(), savedTheme.getPositionZ());
        Assert.assertEquals(newTheme.getRotationX(), savedTheme.getRotationX());
        Assert.assertEquals(newTheme.getRotationY(), savedTheme.getRotationY());
        Assert.assertEquals(newTheme.getRotationZ(), savedTheme.getRotationZ());
        Assert.assertEquals(newTheme.getScaleX(), savedTheme.getScaleX());
        Assert.assertEquals(newTheme.getScaleY(), savedTheme.getScaleY());
        Assert.assertEquals(newTheme.getScaleZ(), savedTheme.getScaleZ());
        Assert.assertNotNull(savedTheme.getUpdatedAt());
        Assert.assertNotNull(savedTheme.getCreatedAt());
    }

    /**
     * Should not persist when `name` is null
     */
    @Test(expected = PersistenceException.class)
    public void testShouldNotCreateWithNullName() {
        // Given
        // newTheme
        // When
        newTheme.setName(null);
        testEntityManager.persistAndFlush(newTheme);
        // Then
        // Throws ConstraintViolationException
    }

    /**
     * Should not persist when `description` is null
     */
    @Test(expected = PersistenceException.class)
    public void testShouldNotCreateWithNullDescription() {
        // Given
        // newTheme
        // When
        newTheme.setDescription(null);
        testEntityManager.persistAndFlush(newTheme);
        // Then
        // Throws ConstraintViolationException
    }

    /**
     * `cameraPosition*`, `cameraRotation*`, `position*`, `rotation*`, `scale*`
     * All graphic related fields must have a precision of 5 and scale of 3
     */
    @Test
    public void testShouldGraphicFieldsHaveFivePrecisionsAndThreeScales() {
        // Given
        // newTheme
        // When
        Theme savedTheme = testEntityManager.persistFlushFind(newTheme);
        // Then
        Assert.assertEquals(3, savedTheme.getCameraPositionX().scale());
        Assert.assertEquals(5, savedTheme.getCameraPositionX().precision());
        Assert.assertEquals(3, savedTheme.getCameraPositionY().scale());
        Assert.assertEquals(5, savedTheme.getCameraPositionY().precision());
        Assert.assertEquals(3, savedTheme.getCameraPositionZ().scale());
        Assert.assertEquals(5, savedTheme.getCameraPositionZ().precision());
        Assert.assertEquals(3, savedTheme.getCameraRotationX().scale());
        Assert.assertEquals(5, savedTheme.getCameraRotationX().precision());
        Assert.assertEquals(3, savedTheme.getCameraRotationY().scale());
        Assert.assertEquals(5, savedTheme.getCameraRotationY().precision());
        Assert.assertEquals(3, savedTheme.getCameraRotationZ().scale());
        Assert.assertEquals(5, savedTheme.getCameraRotationZ().precision());
        Assert.assertEquals(3, savedTheme.getPositionX().scale());
        Assert.assertEquals(5, savedTheme.getPositionX().precision());
        Assert.assertEquals(3, savedTheme.getPositionY().scale());
        Assert.assertEquals(5, savedTheme.getPositionY().precision());
        Assert.assertEquals(3, savedTheme.getPositionZ().scale());
        Assert.assertEquals(5, savedTheme.getPositionZ().precision());
        Assert.assertEquals(3, savedTheme.getRotationX().scale());
        Assert.assertEquals(5, savedTheme.getRotationX().precision());
        Assert.assertEquals(3, savedTheme.getRotationY().scale());
        Assert.assertEquals(5, savedTheme.getRotationY().precision());
        Assert.assertEquals(3, savedTheme.getRotationZ().scale());
        Assert.assertEquals(5, savedTheme.getRotationZ().precision());
        Assert.assertEquals(3, savedTheme.getScaleX().scale());
        Assert.assertEquals(5, savedTheme.getScaleX().precision());
        Assert.assertEquals(3, savedTheme.getScaleY().scale());
        Assert.assertEquals(5, savedTheme.getScaleY().precision());
        Assert.assertEquals(3, savedTheme.getScaleZ().scale());
        Assert.assertEquals(5, savedTheme.getScaleZ().precision());
    }

    /**
     * `cameraPosition*`, `cameraRotation*`, `position*`, `rotation*`, `scale*`
     * All graphic related fields should be not null
     */
    @Test(expected = PersistenceException.class)
    public void testShouldNotCreateWithNullGraphicFields() {
        // Given
        BigDecimal nullDecimalValue = null;
        newTheme = newTheme.toBuilder()
                .name("Star Wars Theme")
                .description("A theme that shows Star Wars stuff")
                .cameraPositionX(nullDecimalValue)
                .cameraPositionY(nullDecimalValue)
                .cameraPositionZ(nullDecimalValue)
                .cameraRotationX(nullDecimalValue)
                .cameraRotationY(nullDecimalValue)
                .cameraRotationZ(nullDecimalValue)
                .positionX(nullDecimalValue)
                .positionY(nullDecimalValue)
                .positionZ(nullDecimalValue)
                .rotationX(nullDecimalValue)
                .rotationY(nullDecimalValue)
                .rotationZ(nullDecimalValue)
                .scaleX(nullDecimalValue)
                .scaleY(nullDecimalValue)
                .scaleZ(nullDecimalValue)
                .build();
        // When
        testEntityManager.persistAndFlush(newTheme);
        // Then
        // Throws ConstraintViolationException
    }

    /**
     * All dates must not be null
     */
    @Test
    public void testShouldDatesNotNull() {
        // Given
        // newTheme
        // When
        Theme savedTheme = testEntityManager.persistFlushFind(newTheme);
        // Then
        Assert.assertNotNull(savedTheme.getUpdatedAt());
        Assert.assertNotNull(savedTheme.getCreatedAt());
    }

    /**
     * `updatedAt` should update when record is updated
     */
    @Test
    public void testShouldUpdatedAtUpdateWhenUpdate() {
        // Given
        // newTheme
        // When
        // Create theme
        Theme savedTheme = testEntityManager.persistFlushFind(newTheme);
        LocalDateTime lastUpdatedAt = savedTheme.getUpdatedAt();
        LocalDateTime lastCreatedAt = savedTheme.getCreatedAt();
        // Update theme
        Theme updatingTheme = testEntityManager.find(Theme.class, savedTheme.getId());
        updatingTheme.setName("Avengers! Assemble.");
        Theme updatedTheme = testEntityManager.persistFlushFind(updatingTheme);
        // Then
        Assert.assertNotEquals(updatedTheme.getUpdatedAt(), lastUpdatedAt);
        Assert.assertEquals(updatedTheme.getCreatedAt(), lastCreatedAt);
    }

    /**
     * Should create a ThemeLight entity with Theme association
     */
    @Test
    public void testShouldCreateThemeLight() {
        // Given
        // newLight
        // When
        newTheme.setThemeLights(List.of(newLight));
        Theme savedThemeWithLights = testEntityManager.persistFlushFind(newTheme);
        // Then
        ThemeLight newLight = savedThemeWithLights.getThemeLights().get(0);
        Assert.assertEquals("commerce", newLight.getType());
        Assert.assertEquals("Commerce Light", newLight.getName());
        Assert.assertTrue(newLight.isCastShadow());
        Assert.assertEquals(90, newLight.getAngle());
        Assert.assertEquals("FFFFFF", newLight.getColor());
        Assert.assertEquals(new BigDecimal("99.999"), newLight.getDistance());
        Assert.assertEquals(new BigDecimal("99.999"), newLight.getIntensity());
        Assert.assertEquals(new BigDecimal("99.9"), newLight.getSpotPenumbra());
    }

    /**
     * Should not persist light when type is null
     */
    @Test(expected = PersistenceException.class)
    public void testShouldLightTypeNotNull() {
        // Given
        // newLight
        // When
        newLight.setType(null);
        newTheme.setThemeLights(List.of(newLight));
        testEntityManager.persistAndFlush(newTheme);
        // Then
        // Throws PersistenceException
    }

    /**
     * Should not persist light when name is null
     */
    @Test(expected = PersistenceException.class)
    public void testShouldLightNameNotNull() {
        // Given
        // newLight
        // When
        newLight.setName(null);
        newTheme.setThemeLights(List.of(newLight));
        testEntityManager.persistAndFlush(newTheme);
        // Then
        // Throws PersistenceException
    }

    /**
     * Should not persist when angle value
     * is under 0
     */
    @Test(expected = ConstraintViolationException.class)
    public void testShouldNotCreateLightAngleUnder0() {
        // Given
        // newLight
        // When
        newLight.setAngle(-1);
        newTheme.setThemeLights(List.of(newLight));
        testEntityManager.persistAndFlush(newTheme);
        // Then
        // Throws ConstraintViolationException
    }

    /**
     * Should not persist when angle value
     * is over 360
     */
    @Test(expected = ConstraintViolationException.class)
    public void testShouldNotCreateLightAngleOver360() {
        // Given
        // newLight
        // When
        newLight.setAngle(361);
        newTheme.setThemeLights(List.of(newLight));
        testEntityManager.persistAndFlush(newTheme);
        // Then
        // Throws ConstraintViolationException
    }

    /**
     * Should not persist when
     * Light Fields: `distance`, `intensity`, `spotPenumbra`
     * are null (even one of them)
     */
    @Test(expected = PersistenceException.class)
    public void testShouldLightFieldsNotNull() {
        // Given
        // newLight
        // When
        newLight.setDistance(null);
        newLight.setIntensity(null);
        newLight.setSpotPenumbra(null);
        newTheme.setThemeLights(List.of(newLight));
        testEntityManager.persistAndFlush(newTheme);
        // Then
        // Throws PersistenceException
    }

    /**
     * Should persist with following precision and scale
     * `distance`, `intensity`: precision 5, scale 3
     * `spotPenumbra`: precision 3, scale 1
     */
    @Test
    public void testShouldLightFieldsPrecisionAndScaleSet() {
        // Given
        // newLight
        // When
        newTheme.setThemeLights(List.of(newLight));
        Theme savedTheme = testEntityManager.persistFlushFind(newTheme);
        ThemeLight savedLight = savedTheme.getThemeLights().get(0);
        // Then
        Assert.assertEquals(5, savedLight.getDistance().precision());
        Assert.assertEquals(3, savedLight.getDistance().scale());
        Assert.assertEquals(5, savedLight.getIntensity().precision());
        Assert.assertEquals(3, savedLight.getIntensity().scale());
        Assert.assertEquals(3, savedLight.getSpotPenumbra().precision());
        Assert.assertEquals(1, savedLight.getSpotPenumbra().scale());
    }

    /**
     * All dates must not be null
     */
    @Test
    public void testShouldLightDatesNotNull() {
        // Given
        // newLight
        // When
        newTheme.setThemeLights(List.of(newLight));
        Theme savedTheme = testEntityManager.persistFlushFind(newTheme);
        ThemeLight savedLight = savedTheme.getThemeLights().get(0);
        // Then
        Assert.assertNotNull(savedLight.getUpdatedAt());
        Assert.assertNotNull(savedLight.getCreatedAt());
    }

    /**
     * `updatedAt` should update when record is updated
     */
    @Test
    public void testShouldLightUpdateUpdatedAtWhenUpdate() {
        // Given
        // newLight
        // When
        // Create theme
        newTheme.setThemeLights(List.of(newLight));
        Theme savedTheme = testEntityManager.persistFlushFind(newTheme);
        ThemeLight savedLight = savedTheme.getThemeLights().get(0);
        LocalDateTime lastUpdatedAt = savedLight.getUpdatedAt();
        LocalDateTime lastCreatedAt = savedLight.getCreatedAt();
        // Update theme
        Theme updatingTheme = testEntityManager.find(Theme.class, savedTheme.getId());
        ThemeLight updatingLight = updatingTheme.getThemeLights().get(0);
        updatingLight.setAngle(7);
        updatingTheme.getThemeLights().clear();
        updatingTheme.getThemeLights().addAll(List.of(updatingLight));
        testEntityManager.persistAndFlush(updatingTheme);
        // Then
        Assert.assertNotEquals(updatingLight.getUpdatedAt(), lastUpdatedAt);
        Assert.assertEquals(updatingLight.getCreatedAt(), lastCreatedAt);
    }

    /**
     * Should create a ThemeObject entity with Theme association
     */
    @Test
    public void testShouldCreateThemeObject() {
        // Given
        // newObject
        // When
        newTheme.setThemeObjects(List.of(newObject));
        Theme savedThemeWithLights = testEntityManager.persistFlushFind(newTheme);
        // Then
        ThemeObject newThemeObject = savedThemeWithLights.getThemeObjects().get(0);
        Assert.assertEquals("Time Stone", newThemeObject.getName());
        Assert.assertEquals("product", newThemeObject.getType());
        Assert.assertEquals(new BigDecimal("99.999"), newThemeObject.getPositionX());
        Assert.assertEquals(new BigDecimal("99.999"), newThemeObject.getPositionY());
        Assert.assertEquals(new BigDecimal("99.999"), newThemeObject.getPositionZ());
        Assert.assertEquals(new BigDecimal("99.999"), newThemeObject.getRotationX());
        Assert.assertEquals(new BigDecimal("99.999"), newThemeObject.getRotationY());
        Assert.assertEquals(new BigDecimal("99.999"), newThemeObject.getRotationZ());
        Assert.assertEquals(new BigDecimal("99.999"), newThemeObject.getScaleX());
        Assert.assertEquals(new BigDecimal("99.999"), newThemeObject.getScaleY());
        Assert.assertEquals(new BigDecimal("99.999"), newThemeObject.getScaleZ());
        Assert.assertEquals("1", newThemeObject.getCompanyProductId());
        Assert.assertEquals("Endgame Infinity Stone", newThemeObject.getCompanyProductName());
        Assert.assertEquals("Image Url", newThemeObject.getCompanyProductImageUrl());
        Assert.assertEquals("Target Url", newThemeObject.getCompanyProductTargetUrl());
    }

    /**
     * Should not persist when ThemeObject type is null
     */
    @Test(expected = PersistenceException.class)
    public void testShouldObjectTypeNotNull() {
        // Given
        // newObject
        // When
        newObject.setType(null);
        newTheme.setThemeObjects(List.of(newObject));
        testEntityManager.persistAndFlush(newTheme);
        // Then
        // Throws PersistenceException
    }

    /**
     * Should not persist when ThemeObject name is null
     */
    @Test(expected = PersistenceException.class)
    public void testShouldObjectNameNotNull() {
        // Given
        // newObject
        // When
        newObject.setName(null);
        newTheme.setThemeObjects(List.of(newObject));
        testEntityManager.persistAndFlush(newTheme);
        // Then
        // Throws PersistenceException
    }

    /**
     * Should not persist when any of
     * `position{X,Y,Z}`, `rotation{X,Y,Z}`, `scale{X,Y,Z}` is null
     */
    @Test(expected = PersistenceException.class)
    public void testShouldObjectGraphicFieldsNotNull() {
        // Given
        // newObject
        // When
        newObject.setPositionX(null);
        newObject.setPositionY(null);
        newObject.setPositionZ(null);
        newObject.setRotationX(null);
        newObject.setRotationY(null);
        newObject.setRotationZ(null);
        newObject.setScaleX(null);
        newObject.setScaleY(null);
        newObject.setScaleZ(null);
        newTheme.setThemeObjects(List.of(newObject));
        testEntityManager.persistAndFlush(newTheme);
        // Then
        // Throws PersistenceException
    }

    /**
     * All graphic fields should have precision of 5 and scale of 3
     */
    @Test
    public void testShouldObjectGraphicFieldsPrecisionAndScaleSet() {
        // When
        // newObject
        // Given
        newTheme.setThemeObjects(List.of(newObject));
        Theme savedThemeWithObjects = testEntityManager.persistFlushFind(newTheme);
        // Then
        ThemeObject newThemeObject = savedThemeWithObjects.getThemeObjects().get(0);
        Assert.assertEquals(5, newThemeObject.getPositionX().precision());
        Assert.assertEquals(3, newThemeObject.getPositionX().scale());
        Assert.assertEquals(5, newThemeObject.getPositionY().precision());
        Assert.assertEquals(3, newThemeObject.getPositionY().scale());
        Assert.assertEquals(5, newThemeObject.getPositionZ().precision());
        Assert.assertEquals(3, newThemeObject.getPositionZ().scale());
        Assert.assertEquals(5, newThemeObject.getRotationX().precision());
        Assert.assertEquals(3, newThemeObject.getRotationX().scale());
        Assert.assertEquals(5, newThemeObject.getRotationY().precision());
        Assert.assertEquals(3, newThemeObject.getRotationY().scale());
        Assert.assertEquals(5, newThemeObject.getRotationZ().precision());
        Assert.assertEquals(3, newThemeObject.getRotationZ().scale());
        Assert.assertEquals(5, newThemeObject.getScaleX().precision());
        Assert.assertEquals(3, newThemeObject.getScaleX().scale());
        Assert.assertEquals(5, newThemeObject.getScaleY().precision());
        Assert.assertEquals(3, newThemeObject.getScaleY().scale());
        Assert.assertEquals(5, newThemeObject.getScaleZ().precision());
        Assert.assertEquals(3, newThemeObject.getScaleZ().scale());
    }

    /**
     * All dates must not be null
     */
    @Test
    public void testShouldObjectDatesNotNull() {
        // Given
        // newObject
        // When
        newTheme.setThemeObjects(List.of(newObject));
        Theme savedTheme = testEntityManager.persistFlushFind(newTheme);
        ThemeObject savedObject = savedTheme.getThemeObjects().get(0);
        // Then
        Assert.assertNotNull(savedObject.getUpdatedAt());
        Assert.assertNotNull(savedObject.getCreatedAt());
    }

    /**
     * `updatedAt` should update when record is updated
     */
    @Test
    public void testShouldObjectUpdateUpdatedAtWhenUpdate() {
        // Given
        // newObject
        // When
        // Create theme
        newTheme.setThemeObjects(List.of(newObject));
        Theme savedTheme = testEntityManager.persistFlushFind(newTheme);
        ThemeObject savedObject = savedTheme.getThemeObjects().get(0);
        LocalDateTime lastUpdatedAt = savedObject.getUpdatedAt();
        LocalDateTime lastCreatedAt = savedObject.getCreatedAt();
        // Update theme
        Theme updatingTheme = testEntityManager.find(Theme.class, savedTheme.getId());
        ThemeObject updatingObject = updatingTheme.getThemeObjects().get(0);
        updatingObject.setName("Reality Stone");
        updatingTheme.getThemeObjects().clear();
        updatingTheme.getThemeObjects().addAll(List.of(updatingObject));
        testEntityManager.persistAndFlush(updatingTheme);
        // Then
        Assert.assertNotEquals(updatingObject.getUpdatedAt(), lastUpdatedAt);
        Assert.assertEquals(updatingObject.getCreatedAt(), lastCreatedAt);
    }

}
