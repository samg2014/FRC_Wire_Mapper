package cs.abraham.mikee.sam.frcwiremapper._4_input_output_views;

import android.support.v4.app.Fragment;

import cs.abraham.mikee.sam.frcwiremapper._other_classes.SingleFragmentActivity;


public class DeviceListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new InputListFragment();
    }
}
