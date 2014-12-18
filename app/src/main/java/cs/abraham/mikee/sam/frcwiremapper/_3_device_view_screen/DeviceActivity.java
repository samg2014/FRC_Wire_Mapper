package cs.abraham.mikee.sam.frcwiremapper._3_device_view_screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.UUID;

import cs.abraham.mikee.sam.frcwiremapper.R;
import cs.abraham.mikee.sam.frcwiremapper._2_device_list_screen.DeviceListActivity;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.Device;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.DeviceHolder;


public class DeviceActivity extends ActionBarActivity {

    private Device device;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new DeviceFragment())
                    .commit();
        }

        device = DeviceHolder.get(this).getDevice((UUID) getIntent().getSerializableExtra(DeviceFragment.EXTRA_DEVICE_ID));
    }

    public Device getDevice(){
        return device;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_device, menu);

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

        if(id == R.id.delete_device){
            DeviceHolder dh = DeviceHolder.get(DeviceActivity.this);
            ArrayList<Device> devices = dh.getDevices();
            devices.remove(device);

//            Intent i = new Intent(this, DeviceListActivity.class);
//            startActivity(i);

            this.finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
