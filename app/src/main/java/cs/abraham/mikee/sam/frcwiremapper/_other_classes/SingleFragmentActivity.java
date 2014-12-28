package cs.abraham.mikee.sam.frcwiremapper._other_classes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import cs.abraham.mikee.sam.frcwiremapper.R;

public abstract class SingleFragmentActivity extends FragmentActivity {
	protected abstract Fragment createFragment();
	
	public SingleFragmentActivity(){
		Log.d("SingleFragmentActivity", "Constructed");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("SingFragmentActivity", "SingleFragmentActivity.onCreate()");
		setContentView(R.layout.activity_fragment);
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		if (fragment == null) {
			fragment = createFragment();
			fm.beginTransaction()
					.add(R.id.fragmentContainer, fragment)
					.commit();
		}
	}

    @Override
    public void onPause(){
        super.onPause();

        SaveUtilities.save(this);
    }
}
