package com.example.PokemonApi.controller;

import com.example.PokemonApi.model.Pokemon;
import com.example.PokemonApi.service.PokemonService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemones")
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    // Obtener todos los Pokémon
    @GetMapping
    public List<Pokemon> obtenerTodos() {
        return pokemonService.obtenerTodos();
    }

    // Obtener un Pokémon por ID
    @GetMapping("/{id}")
    public Pokemon obtenerPorId(@PathVariable Long id) {
        return pokemonService.obtenerPorId(id);
    }

    // Crear un Pokémon
    @PostMapping
    public Pokemon crearPokemon(@Valid @RequestBody Pokemon pokemon) {
        return pokemonService.crearPokemon(pokemon);
    }

    // Actualizar completamente un Pokémon
    @PutMapping("/{id}")
    public Pokemon actualizarCompleto(
            @PathVariable Long id,
            @Valid
            @RequestBody Pokemon pokemon) {

        return pokemonService.actualizarPokemonCompleto(id, pokemon);
    }

    // Actualizar parcialmente un Pokémon
    @PatchMapping("/{id}")
    public Pokemon actualizarParcial(
            @PathVariable Long id,
            @RequestBody Pokemon pokemon) {

        return pokemonService.actualizarPokemonParcial(id, pokemon);
    }

    // Eliminar un Pokémon
    @DeleteMapping("/{id}")
    public void eliminarPokemon(@PathVariable Long id) {
        pokemonService.eliminarPokemon(id);
    }
}
