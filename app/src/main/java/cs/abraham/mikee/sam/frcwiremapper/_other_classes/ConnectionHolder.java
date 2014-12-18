package cs.abraham.mikee.sam.frcwiremapper._other_classes;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Sam on 12/12/2014.
 */
public class ConnectionHolder implements Serializable{
    private static ConnectionHolder holder;
    transient private Context context;
    private ArrayList<Connection> connections;

    private ConnectionHolder(Context c){
        this.context = c;
        connections = new ArrayList<>();
    }

    public static ConnectionHolder get(Context c){
        if (holder == null){
            holder = new ConnectionHolder(c.getApplicationContext());
        }
        return holder;
    }

    public ArrayList<Connection> getConnections(){
        return connections;
    }

    public Connection getConnection(UUID id){
        for (Connection d : connections){
            if(d.getId().equals(id)){
                return d;
            }
        }
        return null;
    }

    public void addConnection(Connection d){
        this.connections.add(d);
    }

    public void setConnections(ArrayList<Connection> Connections){
        this.connections = Connections;
    }

    public static void setHolder(Context c, ConnectionHolder h){
        ConnectionHolder.holder = h;
        holder.context = c;
    }
}
