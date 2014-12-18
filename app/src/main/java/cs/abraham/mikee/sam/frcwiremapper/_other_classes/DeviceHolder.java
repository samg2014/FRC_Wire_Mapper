package cs.abraham.mikee.sam.frcwiremapper._other_classes;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Sam on 12/12/2014.
 */
public class DeviceHolder implements Serializable{
    private static DeviceHolder holder;
    transient private Context context;
    private ArrayList<Device> devices;

    private DeviceHolder(Context c){
        this.context = c;
        devices = new ArrayList<>();
    }

    public static DeviceHolder get(Context c){
        if (holder == null){
            holder = new DeviceHolder(c.getApplicationContext());
        }
        return holder;
    }

    public ArrayList<Device> getDevices(){
        return devices;
    }

    public Device getDevice(UUID id){
        for (Device d : devices){
            if(d.getId().equals(id)){
                return d;
            }
        }
        return null;
    }

    public void addDevice(Device d){
        this.devices.add(d);
    }

    public void setDevices(ArrayList<Device> devices){
        this.devices = devices;
    }

    public static void setHolder(Context c, DeviceHolder h){
        DeviceHolder.holder = h;
        holder.context = c;
    }
}
