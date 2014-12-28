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
import cs.abraham.mikee.sam.frcwiremapper._other_classes.Input;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.SaveUtilities;


public class InputListActivity extends ActionBarActivity {
    private ArrayList<Input> inputs;

    public Device device;

    public static String EXTRA_INPUT_LIST = "Inputs";
    public static String EXTRA_DEVICE = "DeviceForInputs";
    private static final String DIALOG_DATE = "date";
    public static int REQUEST_SUCCESS = 0;

    protected Fragment createFragment(ArrayList<Input> inputs){
        this.inputs = inputs;
        return InputListFragment.newInstance(inputs);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            fragment = createFragment((ArrayList) getIntent().getSerializableExtra(EXTRA_INPUT_LIST));
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();

        }

        device = (Device) getIntent().getSerializableExtra(EXTRA_DEVICE);

        this.setTitle(device.getName() + " - Inputs");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_input_list, menu);

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

        if (id == R.id.add_input){
            FragmentManager fm = this.getSupportFragmentManager();
            AddInputFragment dialog = AddInputFragment.newInstance();
            dialog.setTargetFragment(fm.getFragments().get(0), InputListActivity.REQUEST_SUCCESS);
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
