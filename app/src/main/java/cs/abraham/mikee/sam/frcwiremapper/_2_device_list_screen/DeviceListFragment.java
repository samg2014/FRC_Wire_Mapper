package cs.abraham.mikee.sam.frcwiremapper._2_device_list_screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cs.abraham.mikee.sam.frcwiremapper._3_device_view_screen.DeviceActivity;
import cs.abraham.mikee.sam.frcwiremapper._3_device_view_screen.DeviceFragment;
import cs.abraham.mikee.sam.frcwiremapper.R;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.Device;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.DeviceHolder;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.SaveUtilities;

public class DeviceListFragment extends ListFragment {

    public static DeviceListFragment newInstance() {
        DeviceListFragment fragment = new DeviceListFragment();
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DeviceListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new DeviceAdapter( DeviceHolder.get(this.getActivity().getApplicationContext()).getDevices()));
    }

    private class DeviceAdapter extends ArrayAdapter<Device> {
        public DeviceAdapter(ArrayList<Device> devices) {
            super(getActivity(), 0, devices);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //If we weren't given a view, inflate one
            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_device, null);
            }

            //Configure the view for this Crime
            Device d = getItem(position);

            TextView name = (TextView) convertView.findViewById(R.id.device_list_name);
            name.setText(d.getName());

            TextView shortDescription = (TextView) convertView.findViewById(R.id.device_list_short_description);
            shortDescription.setText(d.getShortDescription());

            return convertView;
        }
    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Device d =  DeviceHolder.get(this.getActivity()).getDevices().get(position);

        Intent i = new Intent(getActivity(), DeviceActivity.class);
        i.putExtra(DeviceFragment.EXTRA_DEVICE_ID, d.getId());
        startActivity(i);
    }

    @Override
    public void onPause(){
        super.onPause();
        SaveUtilities.save(this);
    }

    @Override
    public void onResume(){
        super.onResume();
        ((DeviceAdapter) this.getListAdapter()).notifyDataSetChanged();
    }
}