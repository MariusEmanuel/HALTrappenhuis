package co.birkhoff.haltrappenhuis;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by emanuelkuhn on 12-05-15.
 */
public class Lokalen {

    private final String TAG = "Lokalen";

    public String naam,
            schooldeel,
            zijde;

    public int nummer,
               etage;

    public Lokalen search (String naam) {

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray lokalen = jsonObject.getJSONArray("lokalen");
            String lokalenString = lokalen.toString();

            String classroomOnezijde = lokalen.getJSONObject(0).getString("zijde");


            for (int i = 0; i < lokalen.length(); i++) {
                Log.d("Lokalen", lokalen.getJSONObject(i).toString());
                JSONObject lokaal = lokalen.getJSONObject(i);

                Log.d("LokaalNaam", lokaal.getString("naam"));

                if (lokaal.getString("naam") == "Lokaal 1") {
                    this.naam = lokaal.getString("naam");
                    return this;
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return this;
    }

    private String json = "{\n" +
            "    lokalen: [\n" +
            "        {nummer: 1, naam: \"Lokaal 1\", \"etage\": 4, schooldeel: \"midden\", zijde: \"zuid\"},\n" +
            "        {nummer: 2, naam: \"Lokaal 2\", \"etage\": 4, schooldeel: \"midden\", zijde: \"zuid\"},\n" +
            "        {nummer: 3, naam: \"Lokaal 3\", \"etage\": 4, schooldeel: \"midden\", zijde: \"zuid\"},\n" +
            "        {nummer: 4, naam: \"Lokaal 4\", \"etage\": 4, schooldeel: \"midden\", zijde: \"noord\"},\n" +
            "        {nummer: 5, naam: \"Lokaal 5\", \"etage\": 4, schooldeel: \"midden\", zijde: \"noord\"},\n" +
            "        {nummer: 6, naam: \"Lokaal 6\", \"etage\": 4, schooldeel: \"midden\", zijde: \"noord\"}\n" +
            "    ]\n" +
            "}";



}
