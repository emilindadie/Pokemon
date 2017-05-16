package com.example.emili.pokemonapp;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.emili.pokemonapp.Data.Compte;
import com.example.emili.pokemonapp.Data.Dresseur;
import com.example.emili.pokemonapp.Data.GestionPokemon;
import com.example.emili.pokemonapp.Data.Pokemon;

import java.util.ArrayList;

public class PokemonActivity extends AppCompatActivity {
    Button afficher;
    Button acheter;
    GestionPokemon pokedex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        Intent intent = getIntent();
        final Dresseur dresseur = (Dresseur) intent.getSerializableExtra("dresseur");
        final GestionPokemon pokedex = (GestionPokemon) intent.getSerializableExtra("gestion_pokemon");

        afficher = (Button) findViewById(R.id.afficher_pokemon);
        acheter = (Button) findViewById(R.id.acheter_pokemon);

        acheter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(PokemonActivity.this, ListPokemonActivity.class);
                intent.putExtra("dresseur", dresseur);
                intent.putExtra("gestion_pokemon", pokedex);
                startActivity(intent);
            }
        });

        afficher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    public void run() {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(getApplicationContext(), pokedex.afficher_les_pokemon(), Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }).start();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_compte:

                Intent solde = getIntent();
                Intent intent = new Intent(PokemonActivity.this, CompteActivity.class);
                final Compte compte = (Compte) solde.getSerializableExtra("compte");
                intent.putExtra("compte", compte);
                startActivity(intent);

                // Comportement du bouton "A Propos"
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
