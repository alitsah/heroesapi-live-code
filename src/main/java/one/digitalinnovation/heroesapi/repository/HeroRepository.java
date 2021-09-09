package one.digitalinnovation.heroesapi.repository;

import one.digitalinnovation.heroesapi.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
}
