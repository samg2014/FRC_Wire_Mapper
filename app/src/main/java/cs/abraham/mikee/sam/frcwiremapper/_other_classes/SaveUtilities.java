package cs.abraham.mikee.sam.frcwiremapper._other_classes;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cs.abraham.mikee.sam.frcwiremapper.R;

/**
 * Created by Sam on 12/16/2014.
 * Created on 12/16/2014.
 */
public class SaveUtilities {
    
    //Save all data using a fragment
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

    public static void save(Activity activity){

        File file = new File(activity.getFilesDir(), activity.getString(R.string.device_save_location));
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(DeviceHolder.get(activity.getApplicationContext()));
            out.close();
            fileOut.close();
        }catch(IOException i)
        {
            Log.d("HomeFragment.java", "IO Exception thrown saving deviceHolder!", i);
        }

        file = new File(activity.getFilesDir(), activity.getString(R.string.connection_save_location));
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(ConnectionHolder.get(activity.getApplicationContext()));
            out.close();
            fileOut.close();
        }catch(IOException i)
        {
            Log.d("HomeFragment.java", "IO Exception thrown saving connectionHolder!", i);
        }

        file = new File(activity.getFilesDir(), activity.getString(R.string.wire_save_location));
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(WireHolder.get(activity.getApplicationContext()));
            out.close();
            fileOut.close();
        }catch(IOException i)
        {
            Log.d("HomeFragment.java", "IO Exception thrown saving wireHolder!", i);
        }
    }
    
    public static void readData(Fragment fragment){
        DeviceHolder dh = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(new File(fragment.getActivity().getFilesDir(), fragment.getString(R.string.device_save_location)));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            dh = (DeviceHolder) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException | ClassNotFoundException i)
        {
            i.printStackTrace();
        }
        if(dh != null) {
            DeviceHolder.get(fragment.getActivity().getApplicationContext()).setDevices(dh.getDevices());
        }

        ConnectionHolder ch = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(new File(fragment.getActivity().getFilesDir(), fragment.getString(R.string.connection_save_location)));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ch = (ConnectionHolder) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException | ClassNotFoundException i)
        {
            i.printStackTrace();
        }
        if(ch != null) {
            ConnectionHolder.get(fragment.getActivity().getApplicationContext()).setConnections(ch.getConnections());
        }

        WireHolder wh = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(new File(fragment.getActivity().getFilesDir(), fragment.getString(R.string.wire_save_location)));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            wh = (WireHolder) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException | ClassNotFoundException i)
        {
            i.printStackTrace();
        }
        if(wh != null) {
            WireHolder.get(fragment.getActivity().getApplicationContext()).setWires(wh.getWires());
        }
    }

    public static void readData(Activity activity){
        DeviceHolder dh = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(new File(activity.getFilesDir(), activity.getString(R.string.device_save_location)));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            dh = (DeviceHolder) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException | ClassNotFoundException i)
        {
            i.printStackTrace();
        }
        if(dh != null) {
            DeviceHolder.get(activity.getApplicationContext()).setDevices(dh.getDevices());
        }

        ConnectionHolder ch = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(new File(activity.getFilesDir(), activity.getString(R.string.connection_save_location)));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ch = (ConnectionHolder) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException | ClassNotFoundException i)
        {
            i.printStackTrace();
        }
        if(ch != null) {
            ConnectionHolder.get(activity.getApplicationContext()).setConnections(ch.getConnections());
        }

        WireHolder wh = null;
        try
        {
            FileInputStream fileIn = new FileInputStream(new File(activity.getFilesDir(), activity.getString(R.string.wire_save_location)));
            ObjectInputStream in = new ObjectInputStream(fileIn);
            wh = (WireHolder) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException | ClassNotFoundException i)
        {
            i.printStackTrace();
        }
        if(wh != null) {
            WireHolder.get(activity.getApplicationContext()).setWires(wh.getWires());
        }
    }
}
