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

                this.zijde = lokaal.getString("zijde");

                this.etage = lokaal.getInt("etage");

                if(lokaal.has("schooldeel")) {
                    this.schooldeel = lokaal.getInt("schooldeel");
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

    public int schooldeel;

    public int nummer,
            etage, x, y, z;

    private static String lokalenJson = "{lokalen: [\n" +
            "  {\n" +
            "    \"nummer\":1,\n" +
            "    \"naam\":\"Lokaal 1\",\n" +
            "    \"etage\":4,\n" +
            "    \"schooldeel\":\"midden\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":2,\n" +
            "    \"naam\":\"Lokaal 2\",\n" +
            "    \"etage\":4,\n" +
            "    \"schooldeel\":\"midden\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":3,\n" +
            "    \"naam\":\"Lokaal 3\",\n" +
            "    \"etage\":4,\n" +
            "    \"schooldeel\":\"midden\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":4,\n" +
            "    \"naam\":\"Lokaal 4\",\n" +
            "    \"etage\":4,\n" +
            "    \"schooldeel\":\"midden\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":5,\n" +
            "    \"naam\":\"Lokaal 5\",\n" +
            "    \"etage\":4,\n" +
            "    \"schooldeel\":\"midden\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":6,\n" +
            "    \"naam\":\"Lokaal 6\",\n" +
            "    \"etage\":4,\n" +
            "    \"schooldeel\":\"midden\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":7,\n" +
            "    \"naam\":\"Lokaal 7\",\n" +
            "    \"etage\":3,\n" +
            "    \"schooldeel\":\"oost\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":8,\n" +
            "    \"naam\":\"Lokaal 8\",\n" +
            "    \"etage\":3,\n" +
            "    \"schooldeel\":\"midden\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":9,\n" +
            "    \"naam\":\"Lokaal 9\",\n" +
            "    \"etage\":3,\n" +
            "    \"schooldeel\":\"midden\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":10,\n" +
            "    \"naam\":\"Lokaal 10\",\n" +
            "    \"etage\":3,\n" +
            "    \"schooldeel\":\"midden\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":11,\n" +
            "    \"naam\":\"Lokaal 11\",\n" +
            "    \"etage\":3,\n" +
            "    \"schooldeel\":\"west\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":12,\n" +
            "    \"naam\":\"Lokaal 12\",\n" +
            "    \"etage\":3,\n" +
            "    \"schooldeel\":\"west\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":13,\n" +
            "    \"naam\":\"Lokaal 13\",\n" +
            "    \"etage\":3,\n" +
            "    \"schooldeel\":\"west\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":14,\n" +
            "    \"naam\":\"Lokaal 14\",\n" +
            "    \"etage\":3,\n" +
            "    \"schooldeel\":\"west\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":15,\n" +
            "    \"naam\":\"Lokaal 15\",\n" +
            "    \"etage\":3,\n" +
            "    \"schooldeel\":\"midden\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":16,\n" +
            "    \"naam\":\"Lokaal 16\",\n" +
            "    \"etage\":3,\n" +
            "    \"schooldeel\":\"midden\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":17,\n" +
            "    \"naam\":\"Lokaal 17\",\n" +
            "    \"etage\":3,\n" +
            "    \"schooldeel\":\"oost\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":18,\n" +
            "    \"naam\":\"Lokaal 18\",\n" +
            "    \"etage\":2,\n" +
            "    \"schooldeel\":\"west\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":19,\n" +
            "    \"naam\":\"Lokaal 19\",\n" +
            "    \"etage\":2,\n" +
            "    \"schooldeel\":\"west\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":20,\n" +
            "    \"naam\":\"Lokaal 20\",\n" +
            "    \"etage\":2,\n" +
            "    \"schooldeel\":\"west\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":21,\n" +
            "    \"naam\":\"Lokaal 21\",\n" +
            "    \"etage\":2,\n" +
            "    \"schooldeel\":\"west\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":22,\n" +
            "    \"naam\":\"Lokaal 22\",\n" +
            "    \"etage\":2,\n" +
            "    \"schooldeel\":\"oost\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":23,\n" +
            "    \"naam\":\"Lokaal 23\",\n" +
            "    \"etage\":2,\n" +
            "    \"schooldeel\":\"oost\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":24,\n" +
            "    \"naam\":\"Lokaal 24\",\n" +
            "    \"etage\":2,\n" +
            "    \"schooldeel\":\"oost\",\n" +
            "    \"zijde\":\"midden\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":25,\n" +
            "    \"naam\":\"Lokaal 25\",\n" +
            "    \"etage\":2,\n" +
            "    \"schooldeel\":\"oost\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":26,\n" +
            "    \"naam\":\"Lokaal 26\",\n" +
            "    \"etage\":2,\n" +
            "    \"schooldeel\":\"oost\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":27,\n" +
            "    \"naam\":\"Lokaal 27\",\n" +
            "    \"etage\":1,\n" +
            "    \"schooldeel\":\"west\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":28,\n" +
            "    \"naam\":\"Lokaal 28\",\n" +
            "    \"etage\":1,\n" +
            "    \"schooldeel\":\"west\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":29,\n" +
            "    \"naam\":\"Lokaal 29\",\n" +
            "    \"etage\":1,\n" +
            "    \"schooldeel\":\"west\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":30,\n" +
            "    \"naam\":\"Lokaal 30\",\n" +
            "    \"etage\":1,\n" +
            "    \"schooldeel\":\"west\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":31,\n" +
            "    \"naam\":\"Lokaal 31\",\n" +
            "    \"etage\":1,\n" +
            "    \"schooldeel\":\"oost\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":32,\n" +
            "    \"naam\":\"Lokaal 32\",\n" +
            "    \"etage\":1,\n" +
            "    \"schooldeel\":\"oost\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":33,\n" +
            "    \"naam\":\"Lokaal 33\",\n" +
            "    \"etage\":1,\n" +
            "    \"schooldeel\":\"oost\",\n" +
            "    \"zijde\":\"noord\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":34,\n" +
            "    \"naam\":\"Lokaal 34\",\n" +
            "    \"etage\":1,\n" +
            "    \"schooldeel\":\"oost\",\n" +
            "    \"zijde\":\"midden\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":35,\n" +
            "    \"naam\":\"Lokaal 35\",\n" +
            "    \"etage\":1,\n" +
            "    \"schooldeel\":\"oost\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":36,\n" +
            "    \"naam\":\"Lokaal 36\",\n" +
            "    \"etage\":1,\n" +
            "    \"schooldeel\":\"oost\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"nummer\":37,\n" +
            "    \"naam\":\"Lokaal 37\",\n" +
            "    \"etage\":1,\n" +
            "    \"schooldeel\":\"oost\",\n" +
            "    \"zijde\":\"zuid\"\n" +
            "  }\n" +
            "]\n" +
            "}";



    private static String lokalenJsonCoords = "{lokalen: [  {    \"nummer\":1,    \"x\":7,    \"y\":1,    \"z\":4,    \"naam\":\"Lokaal 1\",    \"etage\":4  },  {    \"nummer\":2,    \"x\":6,    \"y\":1,    \"z\":4,    \"naam\":\"Lokaal 2\",    \"etage\":4  },  {    \"nummer\":3,    \"x\":5,    \"y\":1,    \"z\":4,    \"naam\":\"Lokaal 3\",    \"etage\":4  },  {    \"nummer\":4,    \"x\":5,    \"y\":3,    \"z\":4,    \"naam\":\"Lokaal 4\",    \"etage\":4  },  {    \"nummer\":5,    \"x\":6,    \"y\":3,    \"z\":4,    \"naam\":\"Lokaal 5\",    \"etage\":4  },  {    \"nummer\":6,    \"x\":7,    \"y\":3,    \"z\":4,    \"naam\":\"Lokaal 6\",    \"etage\":4  },  {    \"nummer\":7,    \"x\":9,    \"y\":1,    \"z\":3,    \"naam\":\"Lokaal 7\",    \"etage\":3  },  {    \"nummer\":8,    \"x\":7,    \"y\":1,    \"z\":3,    \"naam\":\"Lokaal 8\",    \"etage\":3  },  {    \"nummer\":9,    \"x\":6,    \"y\":1,    \"z\":3,    \"naam\":\"Lokaal 9\",    \"etage\":3  },  {    \"nummer\":10,    \"x\":5,    \"y\":1,    \"z\":3,    \"naam\":\"Lokaal 10\",    \"etage\":3  },  {    \"nummer\":11,    \"x\":3,    \"y\":1,    \"z\":3,    \"naam\":\"Lokaal 11\",    \"etage\":3  },  {    \"nummer\":12,    \"x\":1,    \"y\":1,    \"z\":3,    \"naam\":\"Lokaal 12\",    \"etage\":3  },  {    \"nummer\":13,    \"x\":1,    \"y\":3,    \"z\":3,    \"naam\":\"Lokaal 13\",    \"etage\":3  },  {    \"nummer\":14,    \"x\":3,    \"y\":3,    \"z\":3,    \"naam\":\"Lokaal 14\",    \"etage\":3  },  {    \"nummer\":15,    \"x\":5,    \"y\":3,    \"z\":3,    \"naam\":\"Lokaal 15\",    \"etage\":3  },  {    \"nummer\":16,    \"x\":6,    \"y\":3,    \"z\":3,    \"naam\":\"Lokaal 16\",    \"etage\":3  },  {    \"nummer\":17,    \"x\":9,    \"y\":3,    \"z\":3,    \"naam\":\"Lokaal 17\",    \"etage\":3  },  {    \"nummer\":18,    \"x\":3,    \"y\":1,    \"z\":2,    \"naam\":\"Lokaal 18\",    \"etage\":2  },  {    \"nummer\":19,    \"x\":1,    \"y\":1,    \"z\":2,    \"naam\":\"Lokaal 19\",    \"etage\":2  },  {    \"nummer\":20,    \"x\":1,    \"y\":3,    \"z\":2,    \"naam\":\"Lokaal 20\",    \"etage\":2  },  {    \"nummer\":21,    \"x\":3,    \"y\":3,    \"z\":2,    \"naam\":\"Lokaal 21\",    \"etage\":2  },  {    \"nummer\":22,    \"x\":9,    \"y\":3,    \"z\":2,    \"naam\":\"Lokaal 22\",    \"etage\":2  },  {    \"nummer\":23,    \"x\":11,    \"y\":3,    \"z\":2,    \"naam\":\"Lokaal 23\",    \"etage\":2  },  {    \"nummer\":24,    \"x\":12,    \"y\":2,    \"z\":2,    \"naam\":\"Lokaal 24\",    \"etage\":2  },  {    \"nummer\":25,    \"x\":11,    \"y\":1,    \"z\":2,    \"naam\":\"Lokaal 25\",    \"etage\":2  },  {    \"nummer\":26,    \"x\":9,    \"y\":1,    \"z\":2,    \"naam\":\"Lokaal 26\",    \"etage\":2  },  {    \"nummer\":27,    \"x\":1,    \"y\":1,    \"z\":1,    \"naam\":\"Lokaal 27\",    \"etage\":1  },  {    \"nummer\":28,    \"x\":1,    \"y\":3,    \"z\":1,    \"naam\":\"Lokaal 28\",    \"etage\":1  },  {    \"nummer\":29,    \"x\":2,    \"y\":3,    \"z\":1,    \"naam\":\"Lokaal 29\",    \"etage\":1  },  {    \"nummer\":30,    \"x\":3,    \"y\":3,    \"z\":1,    \"naam\":\"Lokaal 30\",    \"etage\":1  },  {    \"nummer\":31,    \"x\":9,    \"y\":3,    \"z\":1,    \"naam\":\"Lokaal 31\",    \"etage\":1  },  {    \"nummer\":32,    \"x\":10,    \"y\":3,    \"z\":1,    \"naam\":\"Lokaal 32\",    \"etage\":1  },  {    \"nummer\":33,    \"x\":11,    \"y\":3,    \"z\":1,    \"naam\":\"Lokaal 33\",    \"etage\":1  },  {    \"nummer\":34,    \"x\":12,    \"y\":2,    \"z\":1,    \"naam\":\"Lokaal 34\",    \"etage\":1  },  {    \"nummer\":35,    \"x\":11,    \"y\":1,    \"z\":1,    \"naam\":\"Lokaal 35\",    \"etage\":1  },  {    \"nummer\":36,    \"x\":10,    \"y\":1,    \"z\":1,    \"naam\":\"Lokaal 36\",    \"etage\":1  },  {    \"nummer\":37,    \"x\":9,    \"y\":1,    \"z\":1,    \"naam\":\"Lokaal 37\",    \"etage\":1  }]}";
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
