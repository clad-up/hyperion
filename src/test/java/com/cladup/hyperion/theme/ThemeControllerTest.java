package com.cladup.hyperion.theme;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ThemeController.class)
public class ThemeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ThemeService themeService;

    private ThemeDTO theme;

    @Before
    public void setUp() {
        BigDecimal defaultDecimalValue = new BigDecimal("99.999");
        theme = ThemeDTO.builder()
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
                .themeObjects(List.of())
                .themeLights(List.of())
                .build();
    }

    /**
     * Should return empty list of themes when there's nothing
     */
    @Test
    public void testShouldReturnEmptyThemeList() throws Exception {
        // Given
        List<ThemeDTO> themes = List.of();
        // When
        Mockito.when(themeService.getAll())
                .thenReturn(themes);
        // Then
        mockMvc.perform(get("/api/v1/themes")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(0)));
    }

    /**
     * Should return list with more than one themes
     */
    @Test
    public void testShouldReturnThemeListMoreThanOne() throws Exception {
        // Given
        List<ThemeDTO> themes = List.of(theme);
        // When
        Mockito.when(themeService.getAll())
                .thenReturn(themes);
        // Then
        mockMvc.perform(get("/api/v1/themes")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(1)));
    }

    /**
     * Should return found theme if exists
     */
    @Test
    public void testShouldReturnFoundTheme() throws Exception {
        // Given
        // theme
        // When
        Mockito.when(themeService.getById(Mockito.anyLong()))
                .thenReturn(theme);
        // Then
        Double testGraphicValue = 99.999;
        mockMvc.perform(get("/api/v1/themes/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name",
                        Matchers.is("Star Wars Theme")))
                .andExpect(jsonPath("description",
                        Matchers.is("A theme that shows Star Wars stuff")))
                .andExpect(jsonPath("cameraPositionX",
                        Matchers.is(testGraphicValue)))
                .andExpect(jsonPath("cameraPositionY",
                        Matchers.is(testGraphicValue)))
                .andExpect(jsonPath("cameraPositionZ",
                        Matchers.is(testGraphicValue)))
                .andExpect(jsonPath("cameraRotationX",
                        Matchers.is(testGraphicValue)))
                .andExpect(jsonPath("cameraRotationY",
                        Matchers.is(testGraphicValue)))
                .andExpect(jsonPath("cameraRotationZ",
                        Matchers.is(testGraphicValue)))
                .andExpect(jsonPath("positionX",
                        Matchers.is(testGraphicValue)))
                .andExpect(jsonPath("positionY",
                        Matchers.is(testGraphicValue)))
                .andExpect(jsonPath("positionZ",
                        Matchers.is(testGraphicValue)))
                .andExpect(jsonPath("rotationX",
                        Matchers.is(testGraphicValue)))
                .andExpect(jsonPath("rotationY",
                        Matchers.is(testGraphicValue)))
                .andExpect(jsonPath("rotationZ",
                        Matchers.is(testGraphicValue)))
                .andExpect(jsonPath("scaleX",
                        Matchers.is(testGraphicValue)))
                .andExpect(jsonPath("scaleY",
                        Matchers.is(testGraphicValue)))
                .andExpect(jsonPath("scaleZ",
                        Matchers.is(testGraphicValue)))
                .andExpect(jsonPath("themeLights",
                        Matchers.is(List.of())))
                .andExpect(jsonPath("themeObjects",
                        Matchers.is(List.of())));
    }

    /**
     * Should return 404 when theme not found
     * TODO: Need to throw 404 exception and handle it in all controllers
     * TODO: Implement ControllerAdvice and exception trees
     */
    @Test
    public void testShouldReturn404StatusWhenThemeNotFound() throws Exception {
        // Given
        // theme
        // When
        Mockito.when(themeService.getById(0))
                .thenReturn(null);
        // Then
        mockMvc.perform(get("/api/v1/themes/0")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Should return 400 when id isn't an integer
     */
    @Test
    public void testShouldReturn400WhenIdIsNotAnInteger() throws Exception {
        // Given
        // theme
        // When
        Mockito.when(themeService.getById(Mockito.anyLong()))
                .thenReturn(theme);
        // Then
        mockMvc.perform(get("/api/v1/themes/not_integer")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
