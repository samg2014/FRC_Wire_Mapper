package cs.abraham.mikee.sam.frcwiremapper._other_classes;

import java.util.UUID;

/**
 * Created by Sam on 12/16/2014.
 */
public class Input implements Connectible {
    public UUID id;
    public Device device;
    public Connection connection;

    public Input(Device device, Connection connection) {
        this.device = device;
        this.connection = connection;
    }

    public UUID getId() {
        return id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
