package one.digitalinnovation.heroesapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.heroesapi.dto.request.HeroDTO;
import one.digitalinnovation.heroesapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.heroesapi.exception.HeroNotFoundException;
import one.digitalinnovation.heroesapi.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/hero")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HeroController {

    private HeroService heroService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createHero(@RequestBody @Valid HeroDTO heroDTO){
        return heroService.createHero(heroDTO);
    }

    @GetMapping
    public List<HeroDTO> listAll(){
        return heroService.listAll();
    }

    @GetMapping("/{id}")
    public HeroDTO findById(@PathVariable Long id) throws HeroNotFoundException {
        return heroService.findById(id);
    }

    @PutMapping("/{id}")
    public  MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid HeroDTO heroDTO) throws HeroNotFoundException {
        return heroService.updateById(id, heroDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deleteById(@PathVariable Long id) throws HeroNotFoundException {
        heroService.delete(id);
    }
}
