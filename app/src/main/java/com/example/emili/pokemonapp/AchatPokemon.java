package com.example.emili.pokemonapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.emili.pokemonapp.Data.Compte;
import com.example.emili.pokemonapp.Data.DoublePokemonExeption;
import com.example.emili.pokemonapp.Data.Dresseur;
import com.example.emili.pokemonapp.Data.GestionPokemon;
import com.example.emili.pokemonapp.Data.Pokemon;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class AchatPokemon extends AppCompatActivity {
    Button choix;
    GestionPokemon gestionPokemon;
    Bundle bundle;
    Bundle bundle2;
    static final int prix_pokemon = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achat_pokemon);
        bundle = getIntent().getExtras();
        bundle2 = getIntent().getExtras();
        Intent intent = getIntent();
        final String pokemon_choix = bundle2.get("nom_pokemon").toString();

        final Dresseur dresseur = (Dresseur) intent.getSerializableExtra("dresseur");
        final Compte compte = (Compte) intent.getSerializableExtra("compte");
        choix = (Button) findViewById(R.id.choix_pokemon);


        if(bundle != null){
            MakeHttpPhotoRequest("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/"+bundle.get("position") +".png");
        }
        else {
            Toast.makeText(getApplication(), "Le bundle ne recois aucune valeurs " ,Toast.LENGTH_SHORT).show();
        }


        choix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = getIntent();
                if(intent1.getSerializableExtra("gestion_pokemon") != null){
                    GestionPokemon gestionPokemon = (GestionPokemon) intent1.getSerializableExtra("gestion_pokemon");
                    try {
                        gestionPokemon.ajouter_un_pokemon(pokemon_choix);
                        Toast.makeText(getApplication(), "Le pokemon a été choisit "  ,Toast.LENGTH_SHORT).show();
                    } catch (DoublePokemonExeption doublePokemonExeption) {
                        doublePokemonExeption.printStackTrace();
                        Toast.makeText(getApplicationContext(), "L'exeption a eu lieu", Toast.LENGTH_LONG).show();
                    }
                }
                else {

                    gestionPokemon = new GestionPokemon();
                    try {
                        gestionPokemon.ajouter_un_pokemon(pokemon_choix);
                        Toast.makeText(getApplication(), "Le pokemon a été choisit "  ,Toast.LENGTH_SHORT).show();
                    } catch (DoublePokemonExeption doublePokemonExeption) {
                        doublePokemonExeption.printStackTrace();
                        Toast.makeText(getApplicationContext(), "L'exeption a eu lieu", Toast.LENGTH_LONG).show();
                    }
                }

          //  boolean succes = compte.acheter_pokemon(prix_pokemon);

           // if(succes == true){

          //  }
           /* else {
                Toast.makeText(getApplication(), "Vous n'avez pas assez d'argent "  ,Toast.LENGTH_SHORT).show();
            }*/
            Intent intent2 = new Intent(AchatPokemon.this, PokemonActivity.class);
            intent2.putExtra("compte", compte);
                intent2.putExtra("gestion_pokemon", gestionPokemon);
                intent2.putExtra("compte", compte);
            startActivity(intent2);
            }
        });
    }

    private void MakeHttpPhotoRequest(final String url){

        RequestQueue queue = Volley.newRequestQueue(this);

        final ImageView imageView = (ImageView) findViewById(R.id.image1);

        //final String url  = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/1.png";

        StringRequest resultat = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                new AchatPokemon.DownLoadImageTask(imageView).execute(url);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Ca ne marche pas", Toast.LENGTH_LONG).show();
            }
        });
        queue.add(resultat);

    }

    private class DownLoadImageTask extends AsyncTask<String,Void,Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        /*
            doInBackground(Params... params)
                Override this method to perform a computation on a background thread.
         */
        protected Bitmap doInBackground(String...urls){
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
                logo = BitmapFactory.decodeStream(is);
            }catch(Exception e){ // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        /*
            onPostExecute(Result result)
                Runs on the UI thread after doInBackground(Params...).
         */
        protected void onPostExecute(Bitmap result){

            imageView.setImageBitmap(result);
        }
    }


}
