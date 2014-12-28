package cs.abraham.mikee.sam.frcwiremapper._other_classes;

import java.util.UUID;

/**
 * Created by Sam on 12/16/2014.
 */
public class Output implements Connectible {
    public UUID id;
    public Device device;
    public Connection connection;
    String name;
    public String shortDescription;
    public String longDescription;

    public Output(Device device) {
        this.device = device;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
