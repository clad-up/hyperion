package com.cladup.hyperion.theme;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
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

}
