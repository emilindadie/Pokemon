package com.example.emili.pokemonapp.Data;

import java.io.Serializable;

/**
 * Created by emili on 05/05/2017.
 */

public class Compte implements Serializable{

    int argent;


    public Compte(int argent){

        this.argent = argent;
    }

    public int getArgent(){

        return argent;
    }

    public boolean acheter_pokemon(int prix_pokemon){

        boolean success = false;
        if(prix_pokemon <= this.argent){
            this.argent = this.argent - prix_pokemon;
            success = true;
        }

        return success;
    }

    public void vendre_pokemon(int prix_pokemon){

        this.argent = this.argent + prix_pokemon;

    }
    public int getPrix_pokemon(){

        return this.getPrix_pokemon();
    }
}
