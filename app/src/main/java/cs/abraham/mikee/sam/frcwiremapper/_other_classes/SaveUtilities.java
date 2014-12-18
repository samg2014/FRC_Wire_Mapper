package cs.abraham.mikee.sam.frcwiremapper._other_classes;

import android.support.v4.app.Fragment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import cs.abraham.mikee.sam.frcwiremapper.R;

/**
 * Created by Sam on 12/16/2014.
 * Created on 12/16/2014.
 */
public class SaveUtilities {
    
    public static void save(Fragment fragment){

        File file = new File(fragment.getActivity().getFilesDir(), fragment.getString(R.string.device_save_location));
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(DeviceHolder.get(fragment.getActivity().getApplicationContext()));
            out.close();
            fileOut.close();
        }catch(IOException i)
        {
            Log.d("HomeFragment.java", "IO Exception thrown saving deviceHolder!", i);
        }

        file = new File(fragment.getActivity().getFilesDir(), fragment.getString(R.string.connection_save_location));
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(ConnectionHolder.get(fragment.getActivity().getApplicationContext()));
            out.close();
            fileOut.close();
        }catch(IOException i)
        {
            Log.d("HomeFragment.java", "IO Exception thrown saving connectionHolder!", i);
        }

        file = new File(fragment.getActivity().getFilesDir(), fragment.getString(R.string.wire_save_location));
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(WireHolder.get(fragment.getActivity().getApplicationContext()));
            out.close();
            fileOut.close();
        }catch(IOException i)
        {
            Log.d("HomeFragment.java", "IO Exception thrown saving wireHolder!", i);
        }
    }
    
}
