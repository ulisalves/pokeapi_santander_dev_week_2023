package me.dio.contoller;

import me.dio.domain.model.Pokemon;
import me.dio.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> findById(@PathVariable Long id) {
        var pokemon = pokemonService.findById(id);
        return ResponseEntity.ok(pokemon);
    }

    @PostMapping
    public ResponseEntity<Pokemon> create(@RequestBody Pokemon pokemonToCreate) {
        var pokemonCreated = pokemonService.create(pokemonToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pokemonCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(pokemonCreated);
    }
}
