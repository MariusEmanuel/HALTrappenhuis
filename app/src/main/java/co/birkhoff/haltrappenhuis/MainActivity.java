package co.birkhoff.haltrappenhuis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MainActivity";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Widgets:
        final Spinner vanSpinner = (Spinner) findViewById(R.id.van_spinner);
        final Spinner naarSpinner = (Spinner) findViewById(R.id.naar_spinner);
        Button gaButton = (Button) findViewById(R.id.ga_button);


        gaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String van = vanSpinner.getSelectedItem().toString();
                String naar = naarSpinner.getSelectedItem().toString();
                Log.v(TAG, "van:" + van +"\n naar:" + naar);

                //Open activity Route

                Intent intent = new Intent(MainActivity.this, WifiTracking.class);
                intent.putExtra("van",van);
                intent.putExtra("naar", naar);


                startActivity(intent);


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
