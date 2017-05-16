package com.example.emili.pokemonapp.Data;

import android.content.Context;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by emili on 02/05/2017.
 */


public class Pokemon implements Serializable {

    String nom;
    Context context;


    public Pokemon(String nom){

        this.nom = nom;
    }

    public void setNom(String nom){

        this.nom = nom;
    }

    public String getNom(){

        return this.nom;
    }


    public String afficher_un_pokemon(){
        String nom_pokemon = nom;

        return nom;
    }

}
