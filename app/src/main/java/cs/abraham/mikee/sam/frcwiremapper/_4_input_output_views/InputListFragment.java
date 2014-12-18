package cs.abraham.mikee.sam.frcwiremapper._4_input_output_views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import cs.abraham.mikee.sam.frcwiremapper.R;
import cs.abraham.mikee.sam.frcwiremapper._3_device_view_screen.DeviceActivity;
import cs.abraham.mikee.sam.frcwiremapper._3_device_view_screen.DeviceFragment;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.Device;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.DeviceHolder;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.Input;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.SaveUtilities;

public class InputListFragment extends ListFragment {

    public static InputListFragment newInstance(ArrayList<Input> inputs) {
        InputListFragment fragment = new InputListFragment();
        Bundle b = new Bundle();
        b.putSerializable("Input list", inputs);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public InputListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new InputAdapter((ArrayList) savedInstanceState.getSerializable("Input list")));
    }

    private class InputAdapter extends ArrayAdapter<Input> {
        public InputAdapter(ArrayList<Input> inputs) {
            super(getActivity(), 0, inputs);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //If we weren't given a view, inflate one
            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_input, null);
            }

            //Configure the view for this Crime
            Input i = getItem(position);


            return convertView;
        }
    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

//        Device d =  DeviceHolder.get(this.getActivity()).getDevices().get(position);
//
//        Intent i = new Intent(getActivity(), DeviceActivity.class);
//        i.putExtra(DeviceFragment.EXTRA_DEVICE_ID, d.getId());
//        startActivity(i);
    }

    @Override
    public void onPause(){
        super.onPause();
        SaveUtilities.save(this);
    }

    @Override
    public void onResume(){
        super.onResume();
        ((InputAdapter) this.getListAdapter()).notifyDataSetChanged();
    }
}