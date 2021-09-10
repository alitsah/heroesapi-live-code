package one.digitalinnovation.heroesapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.heroesapi.dto.request.HeroDTO;
import one.digitalinnovation.heroesapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.heroesapi.entity.Hero;
import one.digitalinnovation.heroesapi.exception.HeroNotFoundException;
import one.digitalinnovation.heroesapi.mapper.HeroMapper;
import one.digitalinnovation.heroesapi.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HeroService {

    private HeroRepository heroRepository;

    private final HeroMapper heroMapper = HeroMapper.INSTANCE;

    public MessageResponseDTO createHero(@RequestBody HeroDTO heroDTO){
        Hero herotoSave = heroMapper.toModel(heroDTO);

        Hero saveHero = heroRepository.save(herotoSave);
        return createMessageResponse(saveHero.getId(), "Created Hero!");
    }

    public List<HeroDTO> listAll() {
        List<Hero> allHeroes =  heroRepository.findAll();
        return allHeroes.stream()
                .map(heroMapper::toDTO)
                .collect(Collectors.toList());
    }

    public HeroDTO findById(Long id) throws HeroNotFoundException {
        Hero hero = verifyIfExistsRegister(id);

        return heroMapper.toDTO(hero);
    }

    public void delete(Long id) throws HeroNotFoundException {
        verifyIfExistsRegister(id);
        heroRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, HeroDTO heroDTO) throws HeroNotFoundException {
        verifyIfExistsRegister(id);

        Hero herotoUpdate = heroMapper.toModel(heroDTO);

        Hero updateHero = heroRepository.save(herotoUpdate);
        return createMessageResponse(updateHero.getId(), "Update Hero!");
    }

    private Hero verifyIfExistsRegister(Long id) throws HeroNotFoundException {
        return  heroRepository.findById(id)
                .orElseThrow(()-> new HeroNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
