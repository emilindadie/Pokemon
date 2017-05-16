package com.example.emili.pokemonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.emili.pokemonapp.Data.Compte;
import com.example.emili.pokemonapp.Data.Dresseur;

public class Main2Activity extends AppCompatActivity {
    Button valider;
    EditText nom;
    String mon_nom;
    Dresseur dresseur;
    Compte compte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        valider = (Button) findViewById(R.id.valider);
        nom = (EditText) findViewById(R.id.nom);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mon_nom = nom.getText().toString();
                if(mon_nom != null){
                    dresseur = new Dresseur(mon_nom);
                    compte = new Compte(1000);

                    Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                    intent.putExtra("dresseur", dresseur);
                    intent.putExtra("compte", compte);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplication(), "Veuillez remplir le champs nom " ,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public String  getNom(){
        return mon_nom;
    }


}
