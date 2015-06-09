package co.birkhoff.haltrappenhuis;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.birkhoff.haltrappenhuis.R.*;


public class Route extends ActionBarActivity {
    private List<String> bevelen = new ArrayList<String>();


    public void addBevel(String bevel) {
        this.bevelen.add(bevel);
    }


    public void addToScreen(TextView data){
        StringBuilder sb = new StringBuilder();
        int x = 1;
        for(String bevel : this.bevelen){
            sb.append(x+". "+bevel);
            sb.append("\r\n");
            x++;
        }

        data.setText(sb.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_route);

        String van = getIntent().getExtras().getString("van");
        String naar = getIntent().getExtras().getString("naar");

        TextView title = (TextView) findViewById(id.title);
        TextView data = (TextView) findViewById(id.data);


        Lokaal lokaalNaar = null;
        Lokaal lokaalVan = null;
        try {
            lokaalNaar = new Lokaal(naar);
            lokaalVan = new Lokaal(van);

        } catch (Exception e) {
            Log.d("error", "Lokaal does not exist");
            data.setText("Het lokaal staat niet in de JSON, stuur aub een bug report");
        }

        try {
            if (lokaalNaar != null && lokaalVan != null) {
                if (lokaalNaar.etage == lokaalVan.etage) {
                    if (lokaalNaar.nummer == lokaalVan.nummer) {
                        addBevel("Eh, je bent er al!");
                    } else {
                        if (lokaalNaar.zijde.equals(lokaalVan.zijde)) {
                            if (lokaalNaar.nummer > lokaalVan.nummer) {
                                addBevel("Loop links de deur uit!");
                            } else {
                                addBevel("Loop rechts de deur uit!");
                            }
                        }else if(lokaalNaar.schooldeel == 4){

                        }else{
                            if(lokaalNaar.schooldeel == lokaalVan.schooldeel){
                                addBevel("Het lokaal bevindt zich aan de andere kant van de gang, in dit zelfde deel!");
                            }else{
                                if(lokaalNaar.schooldeel > lokaalVan.schooldeel){
                                    addBevel("Loop richting het oosten!");
                                }else{
                                    addBevel("Loop richting het westen!");
                                }
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            Log.d("Marius", e.getMessage());
        }



        addToScreen(data);
    }
}
