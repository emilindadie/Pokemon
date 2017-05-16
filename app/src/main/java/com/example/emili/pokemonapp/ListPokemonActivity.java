package com.example.emili.pokemonapp;


import android.content.ClipData;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.emili.pokemonapp.Data.Compte;
import com.example.emili.pokemonapp.Data.Dresseur;
import com.example.emili.pokemonapp.Data.GestionPokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

public class ListPokemonActivity extends AppCompatActivity {


    ArrayList <String> liste_pokemon;
    ListView listView;
    ArrayAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pokemon);
        Intent intent = getIntent();


        makeHttpRequest("http://pokeapi.co/api/v2/pokemon");

    }

    private void makeHttpRequest(String URL)
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        //afficher le resultat d'une requete sous forme de chaine de caractères
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        handleResponse(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        queue.add(stringRequest);
    }

    private void handleResponse(String response) {

        listView = (ListView)findViewById(R.id.list_pokemon);


        liste_pokemon = new ArrayList<>();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,  liste_pokemon);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                Toast.makeText(getApplicationContext(), "Vous aver cliqué sur le pokemon "+listView.getItemIdAtPosition(position), Toast.LENGTH_LONG).show();
                String nom_pokemon = listView.getItemAtPosition(position).toString();
                long number = listView.getItemIdAtPosition(position) +1;

                Bundle bundle = new Bundle();
                Bundle bundle2 = new Bundle();
                bundle.putLong("position", number);
                bundle2.putString("nom_pokemon", nom_pokemon);
                Intent intent = new Intent(ListPokemonActivity.this, AchatPokemon.class);
                final Compte compte = (Compte) intent.getSerializableExtra("compte");
                final Dresseur dresseur = (Dresseur) intent.getSerializableExtra("dresseur");
                final GestionPokemon pokedex = (GestionPokemon) intent.getSerializableExtra("gestion_pokemon");
                intent.putExtras(bundle);
                intent.putExtras(bundle2);
                intent.putExtra("dresseur", dresseur);
                intent.putExtra("compte", compte);
                intent.putExtra("gestion_pokemon", pokedex);
                startActivity(intent);

            }

        });

        try {
            JSONObject mainObject = new JSONObject(response);
            JSONArray result = mainObject.getJSONArray("results");
            String nextURL = mainObject.getString("next");

            for(int i = 0; i < result.length(); i++)
            {
                JSONObject obj = result.getJSONObject(i);
                liste_pokemon.add(obj.getString("name"));

            }
            //mTextView.setText(urlList.get(0));
            //mTextView.setText(Integer.toString(urlList.size()));

            // mTextView.setText(urlList.get(i));
        } catch (JSONException e) {
            Log.e("MYAPP", "unexpected JSON exception", e);
            // Do something to recover ... or kill the app.
        }
    }

}