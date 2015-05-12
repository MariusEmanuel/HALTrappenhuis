package co.birkhoff.haltrappenhuis;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;


public class Route extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        String van = getIntent().getExtras().getString("van");
        String naar = getIntent().getExtras().getString("naar");

        TextView data = (TextView) findViewById(R.id.data);

        //data.setText("van: " + van + "\nnaar: " + naar);



        String json = "{\n" +
                "    lokalen: [\n" +
                "        {nummer: 1, naam: \"Lokaal 1\", \"etage\": 4, schooldeel: \"midden\", zijde: \"zuid\"},\n" +
                "        {nummer: 2, naam: \"Lokaal 2\", \"etage\": 4, schooldeel: \"midden\", zijde: \"zuid\"},\n" +
                "        {nummer: 3, naam: \"Lokaal 3\", \"etage\": 4, schooldeel: \"midden\", zijde: \"zuid\"},\n" +
                "        {nummer: 4, naam: \"Lokaal 4\", \"etage\": 4, schooldeel: \"midden\", zijde: \"noord\"},\n" +
                "        {nummer: 5, naam: \"Lokaal 5\", \"etage\": 4, schooldeel: \"midden\", zijde: \"noord\"},\n" +
                "        {nummer: 6, naam: \"Lokaal 6\", \"etage\": 4, schooldeel: \"midden\", zijde: \"noord\"}\n" +
                "    ]\n" +
                "}";

        data.setText(json);

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray lokalen = jsonObject.getJSONArray("lokalen");
            String lokalenString = lokalen.toString();

            String classroomOnezijde = lokalen.getJSONObject(0).getString("zijde");

            //data.setText(classroomOnezijde);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        Lokalen lokalen = new Lokalen();
        Lokalen test = lokalen.search("Lokaal 1");
        Log.d("tag", test.naam);
        data.setText(test.naam);
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
