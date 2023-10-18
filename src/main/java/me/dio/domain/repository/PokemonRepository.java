package me.dio.domain.repository;

import me.dio.domain.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository <Pokemon, Long> {

}
