package one.digitalinnovation.heroesapi.service;

import one.digitalinnovation.heroesapi.dto.request.HeroDTO;
import one.digitalinnovation.heroesapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.heroesapi.entity.Hero;
import one.digitalinnovation.heroesapi.mapper.HeroMapper;
import one.digitalinnovation.heroesapi.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroService {

    private HeroRepository heroRepository;

    private final HeroMapper heroMapper = HeroMapper.INSTANCE;

    @Autowired
    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public MessageResponseDTO createHero(@RequestBody HeroDTO heroDTO){
        Hero herotoSave = heroMapper.toModel(heroDTO);

        Hero saveHero = heroRepository.save(herotoSave);
        return MessageResponseDTO
                .builder()
                .message("Created associated hero record " + saveHero.getId())
                .build();
    }

    public List<HeroDTO> listAll() {
        List<Hero> allHeroes =  heroRepository.findAll();
        return allHeroes.stream()
                .map(heroMapper::toDTO)
                .collect(Collectors.toList());
    }
}
