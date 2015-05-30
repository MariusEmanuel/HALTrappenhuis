package co.birkhoff.haltrappenhuis;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static co.birkhoff.haltrappenhuis.R.*;


public class Route extends ActionBarActivity {

    //Logic:
    private static ArrayList<String> calcRoute(Lokaal lokaalVan, Lokaal lokaalNaar) {
        ArrayList<String> stappen = new ArrayList<>();

        if(lokaalVan.gebouw.equals("hoofdgebouw") && lokaalNaar.gebouw.equals("hoofdgebouw")) {
            //van het hoofdgebouw naar het hoofdgebouw
            if (lokaalNaar.naam.equals(lokaalVan.naam)) {
                stappen.add("Je bent er al ;)");
                return stappen;
            }

            if (lokaalVan.etage == lokaalNaar.etage) {
                // Geen trappen!
                if (lokaalVan.zijde.equals(lokaalNaar.zijde)) {
                    if (lokaalVan.nummer < lokaalNaar.nummer) {
                        stappen.add("Ga naar links/rechts");
                        stappen.add(lokaalNaar.naam + " bevindt zich aan de linker/rechter kant"); //Ik ken de lokalen niet uit mijn hoofd
                    } else if (lokaalNaar.nummer > lokaalVan.nummer) {
                        stappen.add("Ga naar links/rechts");
                        stappen.add(lokaalNaar.naam + " bevindt zich aan de linker/rechter kant");
                    }
                } else {
                    if (lokaalVan.nummer < lokaalNaar.nummer) {
                        stappen.add("Ga naar links/rechts");
                        stappen.add(lokaalNaar.naam + " bevindt zich aan de linker/rechter kant");
                    } else if (lokaalNaar.nummer > lokaalVan.nummer) {
                        stappen.add("Ga naar links/rechts");
                        stappen.add(lokaalNaar.naam + " bevindt zich aan de linker/rechter kant");
                    }
                }

            } else {
                //wel trappen

                int verschil = lokaalVan.etage - lokaalNaar.etage;
                if (verschil < 0) {
                    String richting = "omhoog";
                } else {
                    String richting = "omlaag";
                }

                verschil = Math.abs(verschil);
                Log.d("verschil", "" + verschil);
                while (verschil > 0) {
                    Log.d("Marius", "Hallo?");
                    verschil--;
                }
            }
        } else if (lokaalVan.equals("avio") && lokaalNaar.equals("avio")){
            //van de avio naar de avio
            stappen.add("Je wil van de avio naar de avio");
        }
        else if (lokaalVan.equals("avio")) {
            //van de avio naar het hoofdgebouw
            stappen.add("Je wil van de avio naar het hoofdgebouw");
        } else if (lokaalNaar.equals("avio")) {
            //van het hoofdgebouw naar de avio
            stappen.add("Je wilvan het hoofdgebouw naar de avio");
        }



        stappen.add("Einde Routebeschrijving");

        return stappen;
    }


    //UI:
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_route);

        String van = getIntent().getExtras().getString("van");
        String naar = getIntent().getExtras().getString("naar");

        TextView title = (TextView) findViewById(id.title);
        TextView data = (TextView) findViewById(id.data);


        Lokaal lokaalNaar;
        Lokaal lokaalVan;
        try {
            lokaalNaar = new Lokaal(van);
            lokaalVan = new Lokaal(naar);

            Log.d("calcroute:", calcRoute(lokaalVan, lokaalNaar).toString());

            ArrayList<String> stappen = calcRoute(lokaalVan, lokaalNaar);

            StringBuilder routeTekst = new StringBuilder();
            int i = 1;
            for (String stap : stappen) {
                routeTekst.append(i + ". " + stap + "\n");
                i++;
            }

            StringBuilder titleText = new StringBuilder();
            titleText.append("Route van " + lokaalVan.naam + " naar " + lokaalNaar.naam + ":");

            title.setText(titleText);
            data.setText(routeTekst.toString());

        } catch (Exception e) {
            Log.d("error", "Lokaal does not exist");
            e.printStackTrace();
            data.setText("Het lokaal staat niet in de JSON, stuur aub een bug report");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_route, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
