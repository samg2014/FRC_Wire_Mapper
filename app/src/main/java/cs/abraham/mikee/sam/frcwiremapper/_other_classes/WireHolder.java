package cs.abraham.mikee.sam.frcwiremapper._other_classes;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Sam on 12/12/2014.
 */
public class WireHolder implements Serializable{
    private static WireHolder holder;
    transient private Context context;
    private ArrayList<Wire> wires;

    private WireHolder(Context c){
        this.context = c;
        wires = new ArrayList<>();
    }

    public static WireHolder get(Context c){
        if (holder == null){
            holder = new WireHolder(c.getApplicationContext());
        }
        return holder;
    }

    public ArrayList<Wire> getWires(){
        return wires;
    }

    public Wire getWire(UUID id){
        for (Wire d : wires){
            if(d.getId().equals(id)){
                return d;
            }
        }
        return null;
    }

    public void addWire(Wire d){
        this.wires.add(d);
    }

    public void setWires(ArrayList<Wire> Wires){
        this.wires = Wires;
    }

    public static void setHolder(Context c, WireHolder h){
        WireHolder.holder = h;
        holder.context = c;
    }
}
