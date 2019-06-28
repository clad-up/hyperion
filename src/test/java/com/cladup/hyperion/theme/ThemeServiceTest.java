package com.cladup.hyperion.theme;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ThemeServiceTest {
    @MockBean
    private ThemeRepository themeRepository;
    @Autowired
    private ThemeService themeService;

    private Theme theme;

    @Before
    public void setUp() {
        BigDecimal defaultDecimalValue = new BigDecimal("99.999");
        theme = Theme.builder()
                .id(1L)
                .name("Star Wars Theme")
                .description("Darth Maul and Obi-wan")
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
                .themeLights(List.of())
                .themeObjects(List.of())
                .build();
        Mockito.when(themeRepository.findById(theme.getId()))
                .thenReturn(Optional.of(theme));
    }

    /**
     * Should found the only theme
     */
    @Test
    public void testShouldGetThemeById() {
        // Given
        long themeId = theme.getId();
        // When
        ThemeDTO themeDTO = themeService.getById(themeId);
        // Then
        Mockito.verify(themeRepository).findById(theme.getId());
        Assert.assertEquals(themeId, themeDTO.getId());
    }

    /**
     * Should find empty optional and throw NoSuchElementException
     */
    @Test(expected = NoSuchElementException.class)
    public void testShouldGetAndThrowExceptionWhenNone() {
        // Given
        long themeId = 0L;
        // When
        Mockito.when(themeRepository.findById(theme.getId()))
                .thenReturn(Optional.empty());
        themeService.getById(themeId);
        // Then
        Mockito.verify(themeRepository).findById(theme.getId());
        // Throw NoSuchElementException
    }

    /**
     * Should return empty list when there's no records
     */
    @Test
    public void testShouldReturnEmptyListWhenNoRecords() {
        // Given
        // When
        Mockito.when(themeRepository.findAll())
                .thenReturn(List.of());
        List<ThemeDTO> themeDTOS = themeService.getAll();
        // Then
        Mockito.verify(themeRepository).findAll();
        Assert.assertEquals(themeDTOS, List.of());
    }

    /**
     * Should return non empty list when records exist
     */
    @Test
    public void testShouldReturnNonEmptyListWhenRecordsExist() {
        // Given
        List<Theme> themes = List.of(theme);
        // When
        Mockito.when(themeRepository.findAll())
                .thenReturn(themes);
        List<ThemeDTO> themeDTOs = themeService.getAll();
        Mockito.verify(themeRepository).findAll();
        Assert.assertTrue(themeDTOs.size() > 0);
    }

}
