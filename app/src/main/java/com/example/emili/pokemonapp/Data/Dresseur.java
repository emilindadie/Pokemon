package com.example.emili.pokemonapp.Data;

import java.io.Serializable;

/**
 * Created by emili on 15/05/2017.
 */

public class Dresseur implements Serializable{

    String nom;

    public Dresseur(String nom){

        this.nom = nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return  this.nom;
    }
}
