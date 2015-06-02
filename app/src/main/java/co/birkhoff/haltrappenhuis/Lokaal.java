package co.birkhoff.haltrappenhuis;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by emanuelkuhn en mariusbirkhoff on 12-05-15.
 */
public class Lokaal {

    public Lokaal(String lokaalNaam) throws NullPointerException {
        final String TAG = "public Lokaal(String lokaalNaam)";
        this.lokaalNaam = lokaalNaam;

        JSONObject lokaal = Lokaal.search(lokaalNaam);

        try {
            Log.d(TAG, "lokaalNaam: " + lokaalNaam + "lokaal.getString(\"naam\")" + lokaal.getString("naam"));
            if (lokaal.getString("naam").equals(lokaalNaam)) {

                this.naam = lokaal.getString("naam");
                //TODO: nummer as String instead of int because of e.g. "Aula"
                this.nummer = lokaal.getInt("nummer");
                this.schooldeel = lokaal.getString("schooldeel");
                this.zijde = lokaal.getString("zijde");
                this.etage = lokaal.getInt("etage");

                if(this.nummer < 100) {
                    this.gebouw = "hoofdgebouw";
                } else if (this.nummer > 100) {
                    this.gebouw = "avio";
                }

            } else {
                // TODO: remove one of the following:
                Exception e = new Exception("error: lokaal.naam != naam");
                e.printStackTrace();
                Log.d(TAG, "error: lokaal.naam != naam");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String naam,
            schooldeel,
            zijde, gebouw;

    public int nummer,
            etage;


    private final String lokaalNaam;

    private static String lokalenJson = "{\n" +
            "    lokalen: [\n" +
            "        {nummer: 1, naam: \"Lokaal 1\", \"etage\": 4, schooldeel: \"midden\", zijde: \"zuid\"},\n" +
            "        {nummer: 2, naam: \"Lokaal 2\", \"etage\": 4, schooldeel: \"midden\", zijde: \"zuid\"},\n" +
            "        {nummer: 3, naam: \"Lokaal 3\", \"etage\": 4, schooldeel: \"midden\", zijde: \"zuid\"},\n" +
            "        {nummer: 4, naam: \"Lokaal 4\", \"etage\": 4, schooldeel: \"midden\", zijde: \"noord\"},\n" +
            "        {nummer: 5, naam: \"Lokaal 5\", \"etage\": 4, schooldeel: \"midden\", zijde: \"noord\"},\n" +
            "        {nummer: 6, naam: \"Lokaal 6\", \"etage\": 4, schooldeel: \"midden\", zijde: \"noord\"},\n" +
            "        {nummer: 7, naam: \"Lokaal 7\", \"etage\": 3, schooldeel: \"oost\", zijde: \"noord\"},\n" +
            "        {nummer: 108, naam: \"Lokaal A8\", \"etage\": 3, schooldeel: \"oost\", zijde: \"noord\"}\n" + //nummer hoger dan 100 is in de avio bijv. 101 is A1

            "    ]\n" +
            "}";


    private static JSONObject lokalenObject;
    private static JSONArray lokalenArray;

    {

        try {
            lokalenObject = new JSONObject(lokalenJson);
            lokalenArray = lokalenObject.getJSONArray("lokalen");
        } catch (JSONException e) {
            Log.d("JSON", "Fout in de json "+e.getMessage());

            e.printStackTrace();
        }
    }



    private static JSONObject search (String lokaalNaam) {
        String TAG = "private static JSONObject search (String lokaalNaam)";
        try {
            for (int i = 0; i < lokalenArray.length(); i++) {
                JSONObject lokaal = lokalenArray.getJSONObject(i);
                Log.d("Lokalen", lokaal.toString());

                Log.d("LokaalNaam", lokaal.getString("naam"));

                if(lokaal.getString("naam").equals(lokaalNaam)) {
                    return lokaal;
                }
            }

            Log.d(TAG, "lokaalNaam" + lokaalNaam + "not found in lokalenArray");
            return null;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
