package cs.abraham.mikee.sam.frcwiremapper._other_classes;

import java.util.UUID;

/**
 * Created by Sam on 12/16/2014.
 */
public class Connection implements Connectible{
    public UUID id;
    public Connectible input;
    public Connectible output;
    public String physical;

    public Connection(Connectible input, Connectible output, String physical) {
        this.id = UUID.randomUUID();
        this.input = input;
        this.output = output;
        this.physical = physical;
    }

    public Connection() {
        this.id = UUID.randomUUID();
    }

    public Connectible getInput() {
        return input;
    }

    public void setInput(Connectible input) {
        this.input = input;
    }

    public Connectible getOutput() {
        return output;
    }

    public void setOutput(Connectible output) {
        this.output = output;
    }

    public String getPhysical() {
        return physical;
    }

    public void setPhysical(String physical) {
        this.physical = physical;
    }

    public UUID getId() {
        return id;
    }
}
