package co.birkhoff.haltrappenhuis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class WifiTracking extends ActionBarActivity {
    final private String TAG = "WifiTracking";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_tracking);

        final TextView data = (TextView) findViewById(R.id.data);

        WifiManager myWifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        boolean wasEnabled = myWifiManager.isWifiEnabled();
        myWifiManager.setWifiEnabled(true);
        while(!myWifiManager.isWifiEnabled()){
            //Waiting until wifi is enabled;
        }

        Log.d(TAG, "Wifi enabled");

        if(myWifiManager.isWifiEnabled()){
            if(myWifiManager.startScan()){
                // List available APs
                List<ScanResult> scans = myWifiManager.getScanResults();
                if(scans != null && !scans.isEmpty()){
                    for (ScanResult scan : scans) {
                        int level = WifiManager.calculateSignalLevel(scan.level, 20);
                        Log.d(TAG, "Scan: " + scan.toString() + ";Level: " + level);
                    }
                }
            }
        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wifi_tracking, menu);
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
