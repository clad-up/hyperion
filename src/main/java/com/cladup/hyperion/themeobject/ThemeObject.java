package com.cladup.hyperion.themeobject;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Entity
@Table(name = "theme_objects")
public class ThemeObject {
    @Id
    @GeneratedValue
    private final long id;

}
