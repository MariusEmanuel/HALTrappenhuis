package co.birkhoff.haltrappenhuis;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by emanuelkuhn en mariusbirkhoff on 12-05-15.
 */

public class Lokaal {
    private final String lokaalNaam;

    public Lokaal(String lokaalNaam) throws NullPointerException {
        final String TAG = "public Lokaal(String lokaalNaam)";
        this.lokaalNaam = lokaalNaam;

        JSONObject lokaal = Lokaal.search(lokaalNaam);

        try {
            Log.d(TAG, "lokaalNaam: " + lokaalNaam + "lokaal.getString(\"naam\")" + lokaal.getString("naam"));
            if (lokaal.getString("naam").equals(lokaalNaam)) {

                this.naam = lokaal.getString("naam");
                this.nummer = lokaal.getInt("nummer");

                this.x = lokaal.getInt("x");
                this.y = lokaal.getInt("y");
                this.z = lokaal.getInt("z");

                if(lokaal.has("zijde")) {
                    this.zijde = lokaal.getString("zijde");
                } else {
                    if(this.y == 1)
                        this.zijde = "zuid";
                    else if(this.y == 2)
                        this.zijde = "midden";
                    else if (this.y == 3)
                        this.zijde = "noord";
                }

                this.etage = lokaal.getInt("etage");

                if(lokaal.has("schooldeel")) {
                    this.schooldeel = lokaal.getString("schooldeel");
                }

                if(this.nummer < 100) {
                    this.gebouw = "hoofdgebouw";
                } else if (this.nummer > 100) {
                    this.gebouw = "avio";
                }

            } else {
                // TODO: remove one of the following:
                Exception e = new Exception("error: lokaal.naam != naam");
                e.printStackTrace();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String naam,
            zijde, gebouw;

    @Deprecated public String schooldeel;

    public int nummer,
            etage, x, y, z;

    @Deprecated
    private static String lokalenJsonDeprecated = "{\n" +
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

    private static String lokalenJson = "{lokalen: [  {    \"nummer\":1,    \"x\":7,    \"y\":1,    \"z\":4,    \"naam\":\"Lokaal 1\",    \"etage\":4  },  {    \"nummer\":2,    \"x\":6,    \"y\":1,    \"z\":4,    \"naam\":\"Lokaal 2\",    \"etage\":4  },  {    \"nummer\":3,    \"x\":5,    \"y\":1,    \"z\":4,    \"naam\":\"Lokaal 3\",    \"etage\":4  },  {    \"nummer\":4,    \"x\":5,    \"y\":3,    \"z\":4,    \"naam\":\"Lokaal 4\",    \"etage\":4  },  {    \"nummer\":5,    \"x\":6,    \"y\":3,    \"z\":4,    \"naam\":\"Lokaal 5\",    \"etage\":4  },  {    \"nummer\":6,    \"x\":7,    \"y\":3,    \"z\":4,    \"naam\":\"Lokaal 6\",    \"etage\":4  },  {    \"nummer\":7,    \"x\":9,    \"y\":1,    \"z\":3,    \"naam\":\"Lokaal 7\",    \"etage\":3  },  {    \"nummer\":8,    \"x\":7,    \"y\":1,    \"z\":3,    \"naam\":\"Lokaal 8\",    \"etage\":3  },  {    \"nummer\":9,    \"x\":6,    \"y\":1,    \"z\":3,    \"naam\":\"Lokaal 9\",    \"etage\":3  },  {    \"nummer\":10,    \"x\":5,    \"y\":1,    \"z\":3,    \"naam\":\"Lokaal 10\",    \"etage\":3  },  {    \"nummer\":11,    \"x\":3,    \"y\":1,    \"z\":3,    \"naam\":\"Lokaal 11\",    \"etage\":3  },  {    \"nummer\":12,    \"x\":1,    \"y\":1,    \"z\":3,    \"naam\":\"Lokaal 12\",    \"etage\":3  },  {    \"nummer\":13,    \"x\":1,    \"y\":3,    \"z\":3,    \"naam\":\"Lokaal 13\",    \"etage\":3  },  {    \"nummer\":14,    \"x\":3,    \"y\":3,    \"z\":3,    \"naam\":\"Lokaal 14\",    \"etage\":3  },  {    \"nummer\":15,    \"x\":5,    \"y\":3,    \"z\":3,    \"naam\":\"Lokaal 15\",    \"etage\":3  },  {    \"nummer\":16,    \"x\":6,    \"y\":3,    \"z\":3,    \"naam\":\"Lokaal 16\",    \"etage\":3  },  {    \"nummer\":17,    \"x\":9,    \"y\":3,    \"z\":3,    \"naam\":\"Lokaal 17\",    \"etage\":3  },  {    \"nummer\":18,    \"x\":3,    \"y\":1,    \"z\":2,    \"naam\":\"Lokaal 18\",    \"etage\":2  },  {    \"nummer\":19,    \"x\":1,    \"y\":1,    \"z\":2,    \"naam\":\"Lokaal 19\",    \"etage\":2  },  {    \"nummer\":20,    \"x\":1,    \"y\":3,    \"z\":2,    \"naam\":\"Lokaal 20\",    \"etage\":2  },  {    \"nummer\":21,    \"x\":3,    \"y\":3,    \"z\":2,    \"naam\":\"Lokaal 21\",    \"etage\":2  },  {    \"nummer\":22,    \"x\":9,    \"y\":3,    \"z\":2,    \"naam\":\"Lokaal 22\",    \"etage\":2  },  {    \"nummer\":23,    \"x\":11,    \"y\":3,    \"z\":2,    \"naam\":\"Lokaal 23\",    \"etage\":2  },  {    \"nummer\":24,    \"x\":12,    \"y\":2,    \"z\":2,    \"naam\":\"Lokaal 24\",    \"etage\":2  },  {    \"nummer\":25,    \"x\":11,    \"y\":1,    \"z\":2,    \"naam\":\"Lokaal 25\",    \"etage\":2  },  {    \"nummer\":26,    \"x\":9,    \"y\":1,    \"z\":2,    \"naam\":\"Lokaal 26\",    \"etage\":2  },  {    \"nummer\":27,    \"x\":1,    \"y\":1,    \"z\":1,    \"naam\":\"Lokaal 27\",    \"etage\":1  },  {    \"nummer\":28,    \"x\":1,    \"y\":3,    \"z\":1,    \"naam\":\"Lokaal 28\",    \"etage\":1  },  {    \"nummer\":29,    \"x\":2,    \"y\":3,    \"z\":1,    \"naam\":\"Lokaal 29\",    \"etage\":1  },  {    \"nummer\":30,    \"x\":3,    \"y\":3,    \"z\":1,    \"naam\":\"Lokaal 30\",    \"etage\":1  },  {    \"nummer\":31,    \"x\":9,    \"y\":3,    \"z\":1,    \"naam\":\"Lokaal 31\",    \"etage\":1  },  {    \"nummer\":32,    \"x\":10,    \"y\":3,    \"z\":1,    \"naam\":\"Lokaal 32\",    \"etage\":1  },  {    \"nummer\":33,    \"x\":11,    \"y\":3,    \"z\":1,    \"naam\":\"Lokaal 33\",    \"etage\":1  },  {    \"nummer\":34,    \"x\":12,    \"y\":2,    \"z\":1,    \"naam\":\"Lokaal 34\",    \"etage\":1  },  {    \"nummer\":35,    \"x\":11,    \"y\":1,    \"z\":1,    \"naam\":\"Lokaal 35\",    \"etage\":1  },  {    \"nummer\":36,    \"x\":10,    \"y\":1,    \"z\":1,    \"naam\":\"Lokaal 36\",    \"etage\":1  },  {    \"nummer\":37,    \"x\":9,    \"y\":1,    \"z\":1,    \"naam\":\"Lokaal 37\",    \"etage\":1  }]}";
    //Voorbeeld:
    /*
      {
        "nummer":1,
        "x":7,
        "y":1,
        "z":4,
        "naam":"Lokaal 1",
        "etage":4
      },
     */


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
