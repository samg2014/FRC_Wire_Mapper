package cs.abraham.mikee.sam.frcwiremapper._1_home_screen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cs.abraham.mikee.sam.frcwiremapper._other_classes.Device;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.DeviceHolder;
import cs.abraham.mikee.sam.frcwiremapper._2_device_list_screen.DeviceListActivity;
import cs.abraham.mikee.sam.frcwiremapper.R;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.SaveUtilities;

public class HomeFragment extends Fragment {
    Button mDevicesButton, mAddDeviceButton;
    private static final String DIALOG_DATE = "date";

    public static int REQUEST_SUCCESS = 0;
    public static int REQUEST_FAILURE = 1;


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode != Activity.RESULT_OK){
            return;
        }
        Log.d("Activity Result:", "Name: " + data.getStringExtra(AddDeviceFragment.EXTRA_ADD_DEVICE_DEVICE_NAME) + "; S-DES: " + data.getStringExtra(AddDeviceFragment.EXTRA_ADD_DEVICE_SHORT_DESCRIPTION) + "; L-DES: " + data.getStringExtra(AddDeviceFragment.EXTRA_ADD_DEVICE_LONG_DESCRIPTION));
        Device d = new Device();
        d.setName(data.getStringExtra(AddDeviceFragment.EXTRA_ADD_DEVICE_DEVICE_NAME));
        d.setShortDescription(data.getStringExtra(AddDeviceFragment.EXTRA_ADD_DEVICE_SHORT_DESCRIPTION));
        d.setLongDescription(data.getStringExtra(AddDeviceFragment.EXTRA_ADD_DEVICE_LONG_DESCRIPTION));
        DeviceHolder.get(this.getActivity().getApplicationContext()).addDevice(d);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        Log.d("HomeActivity.java", "Moment1");
        mDevicesButton = (Button) rootView.findViewById(R.id.view_devices_button);
        mDevicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeFragment.this.getActivity(), DeviceListActivity.class);
                startActivity(i);
            }
        });
        mAddDeviceButton = (Button) rootView.findViewById(R.id.add_device_button);
        mAddDeviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = HomeFragment.this.getActivity().getSupportFragmentManager();
                AddDeviceFragment dialog = AddDeviceFragment.newInstance();
                dialog.setTargetFragment(HomeFragment.this, HomeFragment.REQUEST_SUCCESS);
                dialog.show(fm, DIALOG_DATE);
            }
        });
        DeviceHolder.get(this.getActivity());
        return rootView;
    }

    @Override
    public void onPause(){
        super.onPause();

        SaveUtilities.save(this);
    }
}
