package com.cladup.hyperion.theme;

import com.cladup.hyperion.themelight.ThemeLight;
import com.cladup.hyperion.themeobject.ThemeObject;
import lombok.Builder;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Table(name = "themes")
public class Theme {
    @Id
    @GeneratedValue
    private final long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "theme_id")
    private final List<ThemeObject> themeObjects;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "theme_id")
    private final List<ThemeLight> themeLights;
}
