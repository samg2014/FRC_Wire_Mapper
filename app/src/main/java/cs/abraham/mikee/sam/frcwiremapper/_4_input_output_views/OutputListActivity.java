package cs.abraham.mikee.sam.frcwiremapper._4_input_output_views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import cs.abraham.mikee.sam.frcwiremapper.R;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.Device;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.Output;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.SaveUtilities;


public class OutputListActivity extends ActionBarActivity {
    private ArrayList<Output> outputs;

    public Device device;

    public static String EXTRA_OUTPUT_LIST = "Outputs";
    public static String EXTRA_DEVICE = "DeviceForOutputs";
    private static final String DIALOG_DATE = "date";
    public static int REQUEST_SUCCESS = 0;

    protected Fragment createFragment(ArrayList<Output> outputs){
        this.outputs = outputs;
        return OutputListFragment.newInstance(outputs);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            fragment = createFragment((ArrayList) getIntent().getSerializableExtra(EXTRA_OUTPUT_LIST));
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();

        }

        device = (Device) getIntent().getSerializableExtra(EXTRA_DEVICE);

        this.setTitle(device.getName() + " - Outputs");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_output_list, menu);

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

        if (id == R.id.add_output){
            FragmentManager fm = this.getSupportFragmentManager();
            AddOutputFragment dialog = AddOutputFragment.newInstance();
            dialog.setTargetFragment(fm.getFragments().get(0), OutputListActivity.REQUEST_SUCCESS);
            dialog.show(fm, DIALOG_DATE);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPause(){
        super.onPause();

        SaveUtilities.save(this);
    }
}
