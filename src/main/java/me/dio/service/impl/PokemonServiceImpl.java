package me.dio.service.impl;

import me.dio.domain.model.Pokemon;
import me.dio.domain.repository.PokemonRepository;
import me.dio.service.PokemonService;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public Pokemon findById(Long id) {

        return pokemonRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Pokemon create(Pokemon pokemonToCreate) {

        if (pokemonToCreate.getId() !=null && pokemonRepository.existsById(pokemonToCreate.getId())) {
            throw new IllegalArgumentException("This Pokemon ID already exists.");
         }
         return pokemonRepository.save(pokemonToCreate);
    }
}
