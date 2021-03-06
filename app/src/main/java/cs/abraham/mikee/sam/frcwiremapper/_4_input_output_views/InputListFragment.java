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
import cs.abraham.mikee.sam.frcwiremapper._other_classes.Input;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.SaveUtilities;

public class InputListFragment extends ListFragment {

    private ArrayList<Input> inputs;

    public void setInputs(ArrayList<Input> inputs){
        this.inputs = inputs;
    }

    public static InputListFragment newInstance(ArrayList<Input> inputs) {
        InputListFragment fragment = new InputListFragment();
        fragment.setInputs(inputs);
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
        setListAdapter(new InputAdapter(inputs));

    }

    public class InputAdapter extends ArrayAdapter<Input> {
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

            TextView name = (TextView) convertView.findViewById(R.id.input_list_view_name);
            name.setText(i.getName());

            TextView shortDescription = (TextView) convertView.findViewById(R.id.input_list_short_description);
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
        ((InputAdapter) this.getListAdapter()).notifyDataSetChanged();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode != Activity.RESULT_OK){
            return;
        }
        Device device = ((InputListActivity)this.getActivity()).device;
        Input input = new Input(device);
        input.setName(data.getStringExtra(AddInputFragment.EXTRA_ADD_INPUT_INPUT_NAME));
        input.setShortDescription(data.getStringExtra(AddInputFragment.EXTRA_ADD_INPUT_SHORT_DESCRIPTION));
        input.setLongDescription(data.getStringExtra(AddInputFragment.EXTRA_ADD_INPUT_LONG_DESCRIPTION));


        List<Fragment> fragments = this.getActivity().getSupportFragmentManager().getFragments();
        for(Fragment fragment : fragments){
            if(fragment instanceof InputListFragment){
                InputListFragment ilf = (InputListFragment) fragment;
                //inputs.add(new Input(((DeviceActivity) this.getParent()).getDevice(), null));
//                Input i = new Input(device);
                device.addInput(input);
                DeviceHolder.get(this.getActivity()).getDevice(device.getId()).addInput(input);
                ((InputListFragment.InputAdapter) ilf.getListAdapter()).add(input);
                ((InputListFragment.InputAdapter) ilf.getListAdapter()).notifyDataSetChanged();
            }
        }
    }
}