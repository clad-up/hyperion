package com.cladup.hyperion.theme;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ThemeService {
    private final ThemeRepository themeRepository;

    /**
     * Get Theme by primary key
     * @param id Primary Key
     * @return Found Theme
     */
    public Theme getById(long id) {
        return themeRepository.findById(id)
                .orElseThrow();
    }

    /**
     * Return all available themes
     * TODO: Pagination will be needed
     * @return Available themes
     */
    public Iterable<Theme> getAll() {
        return themeRepository.findAll();
    }

}
