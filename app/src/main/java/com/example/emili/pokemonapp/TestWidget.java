package com.example.emili.pokemonapp;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by emili on 12/05/2017.
 */

public class TestWidget extends AppWidgetProvider {

    public void onUpdate(Context context, AppWidgetManager mgr, int[] ids){

        for(int parcours : ids){

            Intent intent = new Intent(context, PokemonActivity.class);
            PendingIntent pi = PendingIntent.getActivity(context,0,intent,0);

            RemoteViews ri = new RemoteViews(context.getPackageName(), R.layout.appwidget);
            ri.setOnClickPendingIntent(R.id.button, pi);
            mgr.updateAppWidget(parcours, ri);
        }

    }
}
