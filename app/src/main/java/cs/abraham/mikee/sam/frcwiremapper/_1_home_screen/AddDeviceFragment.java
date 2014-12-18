package cs.abraham.mikee.sam.frcwiremapper._1_home_screen;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cs.abraham.mikee.sam.frcwiremapper.R;

public class AddDeviceFragment extends DialogFragment {
	
	public static final String EXTRA_ADD_DEVICE_DEVICE_NAME = "EXTRA_ADD_DEVICE_DEVICE_NAME";
    public static final String EXTRA_ADD_DEVICE_SHORT_DESCRIPTION = "EXTRA_ADD_DEVICE_SHORT_DESCRIPTION";
    public static final String EXTRA_ADD_DEVICE_LONG_DESCRIPTION = "EXTRA_ADD_DEVICE_LONG_DESCRIPTION";

    EditText deviceName, sDescription, lDescription;
    Button submitButton;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState){
		View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_add_device, null);

        this.deviceName = (EditText) v.findViewById(R.id.add_device_device_name);
        this.sDescription = (EditText) v.findViewById(R.id.add_device_short_description);
        this.lDescription = (EditText) v.findViewById(R.id.add_device_long_description);
        this.submitButton = (Button) v.findViewById(R.id.add_device_submit);

        this.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendResult(Activity.RESULT_OK, deviceName.getText().toString(), sDescription.getText().toString(), lDescription.getText().toString());
            }
        });

		return new AlertDialog.Builder(getActivity()).setView(v)
				.setTitle("Add a device...")
				.create();
	}
	
	public static AddDeviceFragment newInstance(){
		Bundle args = new Bundle();
		
		AddDeviceFragment fragment = new AddDeviceFragment();
		fragment.setArguments(args);
		
		return fragment;
	}

	private void sendResult(int resultCode, String name, String sDes, String lDes){
		if (getTargetFragment() == null){
			return;
		}
		
		Intent i = new Intent();
		i.putExtra(AddDeviceFragment.EXTRA_ADD_DEVICE_DEVICE_NAME, name);
        i.putExtra(AddDeviceFragment.EXTRA_ADD_DEVICE_LONG_DESCRIPTION, lDes);
        i.putExtra(AddDeviceFragment.EXTRA_ADD_DEVICE_SHORT_DESCRIPTION, sDes);
		
		getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
        this.dismiss();
	}
}
