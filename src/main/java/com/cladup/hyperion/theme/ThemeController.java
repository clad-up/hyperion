package com.cladup.hyperion.theme;

import com.cladup.hyperion.theme.input.CreateThemeInput;
import com.cladup.hyperion.theme.input.UpdateThemeInput;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/themes")
public class ThemeController {
    private final ThemeService themeService;

    /**
     * Get all themes created
     *
     * @return List of available themes
     */
    @GetMapping
    public @NotNull List<ThemeDTO> getAll() {
        return themeService.getAll();
    }

    /**
     * Get theme by primary key
     *
     * @param id primary key
     * @return Found theme
     */
    @GetMapping("/{id}")
    public @NotNull ThemeDTO getById(@PathVariable long id) {
        return themeService.getById(id);
    }

    /**
     * Create theme, objects, and lights
     *
     * @param createThemeInput Theme create input
     * @return Created theme
     */
    @PostMapping
    public @NotNull ThemeDTO create(@RequestBody @Validated CreateThemeInput createThemeInput) {
        return themeService.create(createThemeInput);
    }

    /**
     * Update theme, objects, and lights
     *
     * @param id               Theme primary key
     * @param updateThemeInput Theme update input
     * @return Updated theme
     */
    @PutMapping("/{id}")
    public @NotNull ThemeDTO update(@PathVariable long id,
                                    @RequestBody @Validated UpdateThemeInput updateThemeInput) {
        return themeService.update(id, updateThemeInput);
    }

    /**
     * Delete them, objects, and lights
     *
     * @param id Theme primary key
     * @return Deleted theme
     */
    @DeleteMapping("/{id}")
    public @NotNull ThemeDTO delete(@PathVariable long id) {
        return themeService.delete(id);
    }

}
