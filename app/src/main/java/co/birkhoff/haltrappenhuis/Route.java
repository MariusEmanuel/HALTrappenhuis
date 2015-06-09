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
    private class Location {
        int x, y, z;
        int xyz;
        public Location (int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.xyz = this.x + 100 * this.y + 1000 * this.z; //altijd uniek
        }

        public Location (Lokaal lokaal) {
            this.x = lokaal.x;
            this.y = lokaal.y;
            this.z = lokaal.z;
            this.xyz = this.x + 100 * this.y + 1000 * this.z; //altijd uniek
        }

        public Location (Location location) {
            this.x = location.x;
            this.y = location.y;
            this.z = location.z;
            this.xyz = this.x + 100 * this.y + 1000 * this.z; //altijd uniek

        }
    }


    //Logic:
    private String turnLeftRight(Location currentLocation, Location nextDestination, String currentDirection) {
        String goToDirection;
        if(Math.abs(currentLocation.x - nextDestination.x) > 2) {
            if (currentLocation.y == 3 || currentLocation.y == 1) {

            }
        } else {

        }

        return "error in turnLeftRight";
    }


//    private String goFurther (Location currentLocation, Location nextDestination, String currentDirection) {
//        String goToDirection;
//        if (currentLocation.x - nextDestination.x > 2) {
//            //goWest
//            goToDirection = "west";
//        } else { // if (currentLocation.x - nextDestination.x < -2)
//            //goEast
//            goToDirection = "east";
//        }
//
//        if (currentDirection.equals(goToDirection)) {
//            //ga rechtdoor
//        } else if (currentDirection.equals("west") || currentDirection.equals("east")) {
//            //draai om
//        } else {
//            //ga links / rechts
//        }
//        return "";
//    }

    private ArrayList<String> calcRoute(Lokaal lokaalVan, Lokaal lokaalNaar) {
        ArrayList<String> stappen = new ArrayList<>();
        Location currentLocation = new Location(lokaalVan);
        Location destination = new Location(lokaalNaar);
        Location nextDesination;
        Location nextDestination = new Location(destination);
        String facingDirection; //e.g.: "west":
        if(lokaalVan.y == 1) {
            facingDirection = "north";
        } else if(lokaalVan.y == 3) {
            facingDirection = "south";
        } else {
//            if (lokaalVan.nummer == 24)
        }

        //x=1 :  west
        //x=12 :  oost
        //y=1 : zuid
        //y=2 : midden
        //y=3 : noord


        if (lokaalNaar.naam.equals(lokaalVan.naam)) {
            stappen.add("Je bent er al ;)");
            return stappen;
        }

        int i = 0;
        /*
        while (true) {
            if(currentLocation.xyz == destination.xyz) {
                break;
            } else if(currentLocation.z == destination.z) {
                //geen trappen

            }


            i++;
            if(i > 1000) {
                stappen.add("De while-loop is te lang. Route kon niet worden berekend.");
                Exception  e = new Exception("De while-loop is te lang. Route kon niet worden berekend.");
                e.printStackTrace();
                break;
            }
        }
        */

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
                        stappen.add("Ga naar links");
                        stappen.add(lokaalNaar.naam + " bevindt zich aan de linker kant"); //Ik ken de lokalen niet uit mijn hoofd
                        stappen.add(lokaalNaar.naam + " bevindt zich aan de linkerkant"); //Ik ken de lokalen niet uit mijn hoofd
                    } else if (lokaalNaar.nummer > lokaalVan.nummer) {
                        stappen.add("Ga naar rechts");
                        stappen.add(lokaalNaar.naam + " bevindt zich aan de rechter kant");
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

                int verschil = lokaalNaar.etage - lokaalVan.etage;
                String richting;
                if (verschil > 0) {
                    richting = "omhoog";
                } else {
                    richting = "omlaag";
                }
                verschil = Math.abs(verschil);
                stappen.add("Ga " + verschil + " trappen omlaag.");

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


        Lokaal lokaalNaar = null;
        Lokaal lokaalVan = null;
        try {
            lokaalNaar = new Lokaal(naar);
            lokaalVan = new Lokaal(van);

        } catch (Exception e) {
            Log.d("error", "Lokaal does not exist");
            e.printStackTrace();
            data.setText("Het lokaal staat niet in de JSON, stuur aub een bug report");
        }

        if(lokaalVan != null && lokaalNaar != null) {
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
