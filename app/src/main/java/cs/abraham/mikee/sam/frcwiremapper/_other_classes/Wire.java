package cs.abraham.mikee.sam.frcwiremapper._other_classes;

import java.util.UUID;

/**
 * Created by Sam on 12/16/2014.
 * Created on 12/16/2014.
 */
public class Wire implements Connectible {
    public UUID id;
    public String name;
    public String type;
    public int gauge;
    public Connection connection_one, connection_two;

    public Wire(String name, String type, int gauge) {
        this.name = name;
        this.type = type;
        this.gauge = gauge;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGauge() {
        return gauge;
    }

    public void setGauge(int gauge) {
        this.gauge = gauge;
    }

    public Connection getConnection_one() {
        return connection_one;
    }

    public void setConnection_one(Connection connection_one) {
        this.connection_one = connection_one;
    }

    public Connection getConnection_two() {
        return connection_two;
    }

    public void setConnection_two(Connection connection_two) {
        this.connection_two = connection_two;
    }
}
