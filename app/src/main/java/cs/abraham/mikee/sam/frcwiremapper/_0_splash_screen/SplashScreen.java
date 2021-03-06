package cs.abraham.mikee.sam.frcwiremapper._0_splash_screen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import cs.abraham.mikee.sam.frcwiremapper.R;
import cs.abraham.mikee.sam.frcwiremapper._1_home_screen.HomeActivity;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.ConnectionHolder;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.DeviceHolder;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.WireHolder;


public class SplashScreen extends ActionBarActivity {

    private static final long SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.d("SplashScreen.java", "test");
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, HomeActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

        DeviceHolder dh = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(new File(this.getFilesDir(), getString(R.string.device_save_location)));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            dh = (DeviceHolder) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException | ClassNotFoundException i)
        {
            i.printStackTrace();
        }
        if(dh != null) {
            DeviceHolder.get(this.getApplicationContext()).setDevices(dh.getDevices());
        }

        ConnectionHolder ch = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(new File(this.getFilesDir(), getString(R.string.connection_save_location)));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ch = (ConnectionHolder) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException | ClassNotFoundException i)
        {
            i.printStackTrace();
        }
        if(ch != null) {
            ConnectionHolder.get(this.getApplicationContext()).setConnections(ch.getConnections());
        }

        WireHolder wh = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(new File(this.getFilesDir(), getString(R.string.wire_save_location)));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            wh = (WireHolder) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException | ClassNotFoundException i)
        {
            i.printStackTrace();
        }
        if(wh != null) {
            WireHolder.get(this.getApplicationContext()).setWires(wh.getWires());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
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
