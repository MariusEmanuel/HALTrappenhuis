package co.birkhoff.haltrappenhuis;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import static co.birkhoff.haltrappenhuis.R.*;


public class Route extends ActionBarActivity {

    static String calcRoute(Lokaal lokaalVan, Lokaal lokaalNaar) {

//        if (lokaalNaar.naam.equals(lokaalVan.naam)) {
//            return "Je benr er al";
//        }


        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_route);

        String van = getIntent().getExtras().getString("van");
        String naar = getIntent().getExtras().getString("naar");

        TextView data = (TextView) findViewById(id.data);

        //TODO: use van instead of "Lokaal 1"
        Lokaal lokaalNaar = new Lokaal("Lokaal 7");
        Lokaal lokaalVan = new Lokaal("Lokaal 1");

        Log.d("hallo", "line 39");


        if(lokaalVan.etage != lokaalNaar.etage){
            // Geen trappen!

            int verschil = lokaalVan.etage - lokaalNaar.etage;
            if(verschil < 0){
                String richting = "omhoog";
            }else{
                String richting = "omlaag";
            }

            verschil = Math.abs(verschil);
            Log.d("verschil", ""+verschil);
            while(verschil > 0){
                Log.d("Marius", "Hallo?");
                verschil--;
            }

        }




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_route, menu);
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
