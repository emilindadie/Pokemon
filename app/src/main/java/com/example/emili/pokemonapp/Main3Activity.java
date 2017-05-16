package com.example.emili.pokemonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emili.pokemonapp.Data.Compte;
import com.example.emili.pokemonapp.Data.Dresseur;
import com.example.emili.pokemonapp.Data.Pokemon;

public class Main3Activity extends AppCompatActivity {
    TextView nom;
    Button nouveau ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        nom = (TextView) findViewById(R.id.nom);
        nouveau = (Button) findViewById(R.id.nouveau);
        Intent intent = getIntent();

        final Dresseur dresseur = (Dresseur) intent.getSerializableExtra("dresseur");
        final Compte compte = (Compte) intent.getSerializableExtra("compte");

        if(intent.getExtras() != null){

            nom.setText("Bonjour " +dresseur.getNom().toString() +" bienvenue surPokemon app et maintenant " +
                    "cliqué sur nouveau pour choisir votre pokemon");
        }
        else {
            Toast.makeText(getApplicationContext(), "Le dresseur n'existe pas ", Toast.LENGTH_LONG).show();


        }
        nouveau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main3Activity.this, ListPokemonActivity.class);
                intent.putExtra("dresseur", dresseur);
                intent.putExtra("compte", compte);
                startActivity(intent);
            }
        });

    }
}
