package com.cladup.hyperion.theme;

import com.cladup.hyperion.themelight.ThemeLight;
import com.cladup.hyperion.themeobject.ThemeObject;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "themes")
public class Theme {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "theme_id")
    private List<ThemeObject> themeObjects;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "theme_id")
    private List<ThemeLight> themeLights;
}
