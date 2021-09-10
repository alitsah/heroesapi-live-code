package one.digitalinnovation.heroesapi.controller;

import one.digitalinnovation.heroesapi.dto.request.HeroDTO;
import one.digitalinnovation.heroesapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.heroesapi.exception.heroNotFoundException;
import one.digitalinnovation.heroesapi.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/hero")
public class HeroController {

    private HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createHero(@RequestBody  @Valid HeroDTO heroDTO){
        return heroService.createHero(heroDTO);
    }

    @GetMapping
    public List<HeroDTO> listAll(){
        return heroService.listAll();
    }

    @GetMapping("/{id}")
    public HeroDTO findById(@PathVariable Long id) throws heroNotFoundException {
        return heroService.findById(id);
    }
}
