package me.dio.service;

import me.dio.domain.model.Pokemon;

public interface PokemonService {

    Pokemon findById(Long id);

    Pokemon create(Pokemon pokemonToCreate);
}
