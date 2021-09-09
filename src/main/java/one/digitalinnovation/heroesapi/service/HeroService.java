package one.digitalinnovation.heroesapi.service;

import one.digitalinnovation.heroesapi.dto.MessageResponseDTO;
import one.digitalinnovation.heroesapi.entity.Hero;
import one.digitalinnovation.heroesapi.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class HeroService {
    private HeroRepository heroRepository;

    @Autowired
    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public MessageResponseDTO createHero(@RequestBody Hero hero){
        Hero saveHero = heroRepository.save(hero);
        return MessageResponseDTO
                .builder()
                .message("Created associated hero record " + saveHero.getId())
                .build();
    }
}
