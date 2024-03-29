package com.cladup.hyperion.theme;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ThemeRepository extends CrudRepository<Theme, Long> {

}
