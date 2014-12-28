package cs.abraham.mikee.sam.frcwiremapper._4_input_output_views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cs.abraham.mikee.sam.frcwiremapper.R;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.Device;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.DeviceHolder;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.Output;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.SaveUtilities;

public class OutputListFragment extends ListFragment {

    private ArrayList<Output> outputs;

    public void setOutputs(ArrayList<Output> outputs){
        this.outputs = outputs;
    }

    public static OutputListFragment newInstance(ArrayList<Output> outputs) {
        OutputListFragment fragment = new OutputListFragment();
        fragment.setOutputs(outputs);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public OutputListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new OutputAdapter(outputs));

    }

    public class OutputAdapter extends ArrayAdapter<Output> {
        public OutputAdapter(ArrayList<Output> outputs) {
            super(getActivity(), 0, outputs);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //If we weren't given a view, inflate one
            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_output, null);
            }

            //Configure the view for this Crime
            Output i = getItem(position);

            TextView name = (TextView) convertView.findViewById(R.id.output_list_view_name);
            name.setText(i.getName());

            TextView shortDescription = (TextView) convertView.findViewById(R.id.output_list_short_description);
            shortDescription.setText(i.getShortDescription());

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
        ((OutputAdapter) this.getListAdapter()).notifyDataSetChanged();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode != Activity.RESULT_OK){
            return;
        }
        Device device = ((OutputListActivity)this.getActivity()).device;
        Output output = new Output(device);
        output.setName(data.getStringExtra(AddOutputFragment.EXTRA_ADD_OUTPUT_OUTPUT_NAME));
        output.setShortDescription(data.getStringExtra(AddOutputFragment.EXTRA_ADD_OUTPUT_SHORT_DESCRIPTION));
        output.setLongDescription(data.getStringExtra(AddOutputFragment.EXTRA_ADD_OUTPUT_LONG_DESCRIPTION));


        List<Fragment> fragments = this.getActivity().getSupportFragmentManager().getFragments();
        for(Fragment fragment : fragments){
            if(fragment instanceof OutputListFragment){
                OutputListFragment ilf = (OutputListFragment) fragment;
                //outputs.add(new Output(((DeviceActivity) this.getParent()).getDevice(), null));
//                Output i = new Output(device);
                device.addOutput(output);
                DeviceHolder.get(this.getActivity()).getDevice(device.getId()).addOutput(output);
                ((OutputListFragment.OutputAdapter) ilf.getListAdapter()).add(output);
                ((OutputListFragment.OutputAdapter) ilf.getListAdapter()).notifyDataSetChanged();
            }
        }
    }
}