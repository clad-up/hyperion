package com.cladup.hyperion.theme;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
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
    }

    /**
     * Theme Repository should return an empty optional if there's none
     * and an optional with a value when a value exists.
     */
    @Test
    public void testShouldFindById() {
        // Given
        Theme newTheme = testEntityManager
                .persistFlushFind(this.newTheme);
        // When
        Optional<Theme> createdTheme = themeRepository.findById(newTheme.getId());
        // Then
        Assert.assertEquals(newTheme.getId(), createdTheme.get().getId());
    }

    /**
     * Should find all themes in database.
     */
    @Test
    public void testShouldFindAll() {
        // Given
        Theme newTheme1 = testEntityManager
                .persistFlushFind(this.newTheme);
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
        Theme savedTheme = testEntityManager.persistFlushFind(this.newTheme);
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
        testEntityManager.persistAndFlush(this.newTheme);
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
        testEntityManager.persistAndFlush(this.newTheme);
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
        Theme savedTheme = testEntityManager.persistFlushFind(this.newTheme);
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
        testEntityManager.persistAndFlush(this.newTheme);
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
        Theme savedTheme = testEntityManager.persistFlushFind(this.newTheme);
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
        Theme savedTheme = testEntityManager.persistFlushFind(this.newTheme);
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

}
