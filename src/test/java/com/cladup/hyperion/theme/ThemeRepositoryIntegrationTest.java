package com.cladup.hyperion.theme;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

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

    /**
     * Theme Repository should return an empty optional if there's none
     * and an optional with a value when a value exists.
     */
    @Test
    public void testShouldFindById() {
        // Given
        Theme newTheme = testEntityManager
                .persistFlushFind(Theme.builder().build());
        // When
        Optional<Theme> createdTheme = themeRepository.findById(newTheme.getId());
        // Then
        Assert.assertEquals(newTheme.getId(), createdTheme.get().getId());
    }

    @Test
    public void testShouldFindAll() {
        // Given
        Theme newTheme1 = testEntityManager
                .persistFlushFind(Theme.builder().build());
        Theme newTheme2 = testEntityManager
                .persistFlushFind(Theme.builder().build());
        List<Theme> newThemes = Arrays.asList(newTheme1, newTheme2);
        // When
        List<Theme> allThemes = (List<Theme>) themeRepository.findAll();
        // Then
        Assert.assertArrayEquals(allThemes.toArray(), newThemes.toArray());
    }

}
