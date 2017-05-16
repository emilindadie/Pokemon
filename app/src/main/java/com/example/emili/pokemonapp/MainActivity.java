package com.example.emili.pokemonapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button creer;
    Button pokemon;
    Button nouveau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creer = (Button) findViewById(R.id.creer);
        pokemon = (Button) findViewById(R.id.pokemon);
        nouveau = (Button) findViewById(R.id.nouveau);


        creer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra(Intent.EXTRA_TEXT, "This is for the main activity");
                startActivity(intent);
            }
        });

        pokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TestWidget.class);
                startActivity(intent);

            }
        });

        nouveau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra(Intent.EXTRA_TEXT, "This is for the main activity");
                startActivity(intent);
            }
        });


    }
}
