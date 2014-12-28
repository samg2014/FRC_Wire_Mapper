package cs.abraham.mikee.sam.frcwiremapper._3_device_view_screen;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.UUID;

import cs.abraham.mikee.sam.frcwiremapper.R;
import cs.abraham.mikee.sam.frcwiremapper._2_device_list_screen.DeviceListActivity;
import cs.abraham.mikee.sam.frcwiremapper._4_input_output_views.InputListActivity;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.Device;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.DeviceHolder;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.SaveUtilities;


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
    public void onPause(){
        super.onPause();

        SaveUtilities.save(this);
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

        Button viewInputs = (Button) v.findViewById(R.id.device_view_inputs_button);
        viewInputs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), InputListActivity.class);
                Bundle b = new Bundle();

                b.putSerializable(InputListActivity.EXTRA_INPUT_LIST, device.getInputs());
                b.putSerializable(InputListActivity.EXTRA_DEVICE, device);
                i.putExtras(b);

                startActivity(i);
            }
        });


        return v;
    }
}
