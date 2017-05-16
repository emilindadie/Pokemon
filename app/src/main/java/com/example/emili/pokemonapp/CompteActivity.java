package com.example.emili.pokemonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.emili.pokemonapp.Data.Compte;
import com.example.emili.pokemonapp.Data.Dresseur;

public class CompteActivity extends AppCompatActivity {
    Compte mon_compte;
    TextView solde;
    int solde_actuel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compte);

        Intent intent = getIntent();
        final Compte compte = (Compte) intent.getSerializableExtra("compte");
        final Dresseur dresseur = (Dresseur) intent.getSerializableExtra("dresseur");


        solde = (TextView) findViewById(R.id.solde);
        String argent = String.valueOf(compte.getArgent());
        solde.setText("Vous avez "+argent+ "euro");
    }
}
