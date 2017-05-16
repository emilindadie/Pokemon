package com.example.emili.pokemonapp.Data;

/**
 * Created by emili on 15/05/2017.
 */

public class DoublePokemonExeption extends Throwable {

    private Pokemon doublePokemon;

    public DoublePokemonExeption(Pokemon pokemon){

        doublePokemon = pokemon;

    }
}
