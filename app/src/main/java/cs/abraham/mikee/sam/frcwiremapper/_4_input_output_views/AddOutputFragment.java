package cs.abraham.mikee.sam.frcwiremapper._4_input_output_views;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cs.abraham.mikee.sam.frcwiremapper.R;
import cs.abraham.mikee.sam.frcwiremapper._other_classes.SaveUtilities;

public class AddOutputFragment extends DialogFragment {
	
	public static final String EXTRA_ADD_OUTPUT_OUTPUT_NAME = "EXTRA_ADD_OUTPUT_OUTPUT_NAME";
    public static final String EXTRA_ADD_OUTPUT_SHORT_DESCRIPTION = "EXTRA_ADD_OUTPUT_SHORT_DESCRIPTION";
    public static final String EXTRA_ADD_OUTPUT_LONG_DESCRIPTION = "EXTRA_ADD_OUTPUT_LONG_DESCRIPTION";

    EditText outputName, sDescription, lDescription;
    Button submitButton;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState){
		View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_add_output, null);

        this.outputName = (EditText) v.findViewById(R.id.add_output_output_name);
        this.sDescription = (EditText) v.findViewById(R.id.add_output_short_description);
        this.lDescription = (EditText) v.findViewById(R.id.add_output_long_description);
        this.submitButton = (Button) v.findViewById(R.id.add_output_submit);

        this.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendResult(Activity.RESULT_OK, outputName.getText().toString(), sDescription.getText().toString(), lDescription.getText().toString());
            }
        });

		return new AlertDialog.Builder(getActivity()).setView(v)
				.setTitle("Add an output...")
				.create();
	}
	
	public static AddOutputFragment newInstance(){
		Bundle args = new Bundle();
		
		AddOutputFragment fragment = new AddOutputFragment();
		fragment.setArguments(args);
		
		return fragment;
	}

	private void sendResult(int resultCode, String name, String sDes, String lDes){
		if (getTargetFragment() == null){
			return;
		}

        Log.d("AIF", "Name:" + name);
        Log.d("AIF", "sDes:" + sDes);
        Log.d("AIF", "lDes:" + lDes);

		Intent i = new Intent();

		i.putExtra(AddOutputFragment.EXTRA_ADD_OUTPUT_OUTPUT_NAME, name);
        i.putExtra(AddOutputFragment.EXTRA_ADD_OUTPUT_LONG_DESCRIPTION, lDes);
        i.putExtra(AddOutputFragment.EXTRA_ADD_OUTPUT_SHORT_DESCRIPTION, sDes);
		
		getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
        this.dismiss();
	}

    @Override
    public void onPause(){
        super.onPause();

        SaveUtilities.save(this);
    }
}
