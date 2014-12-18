package cs.abraham.mikee.sam.frcwiremapper._3_device_view_screen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.UUID;

import cs.abraham.mikee.sam.frcwiremapper.R;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.Device;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.DeviceHolder;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeviceFragment extends Fragment {

    TextView name, shortDescription, longDescription;
    MenuItem deleteMenu;
    Device device;

    public static String EXTRA_DEVICE_ID = "device id";

    public DeviceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_device, container, false);

        name = (TextView) v.findViewById(R.id.device_view_name);
        shortDescription = (TextView) v.findViewById(R.id.device_view_short_description);
        longDescription = (TextView) v.findViewById(R.id.device_view_long_description);

        device = ((DeviceActivity) this.getActivity()).getDevice();

        name.setText(device.getName());
        shortDescription.setText(device.getShortDescription());
        longDescription.setText(device.getLongDescription());


        return v;
    }
}
