package com.example.emili.pokemonapp.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by emili on 15/05/2017.
 */

public class GestionPokemon implements Serializable{

    public HashMap<String, Pokemon> pokedex;

    public GestionPokemon(){

        pokedex = new HashMap<String, Pokemon>();
    }

    public void ajouter_un_pokemon(String nomPokemon) throws DoublePokemonExeption {


        String cle = "code"+nomPokemon;
        Pokemon nouveau = new Pokemon(nomPokemon);

        if(pokedex.keySet().contains(cle)){

            throw new DoublePokemonExeption(nouveau);
        }
        else {

            pokedex.put(cle, nouveau);
            System.out.println("Le pokemon à bien été enregistré");
        }
    }

    public String afficher_les_pokemon(){

        String resultat ="";
        StringBuilder sb = new StringBuilder();
        if(pokedex.size() > 0){
            Collection<Pokemon> lesPokemon = pokedex.values();

            for(Pokemon liste : lesPokemon ){

                resultat  = liste.afficher_un_pokemon();
                sb.append(resultat + "\n") ;
            }
        }

        return sb.toString();
    }
}
