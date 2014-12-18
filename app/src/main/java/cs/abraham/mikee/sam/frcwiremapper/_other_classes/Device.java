package cs.abraham.mikee.sam.frcwiremapper._other_classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Sam on 12/12/2014.
 */
public class Device implements Serializable {

    //ID (long)
    //Name (String)
    //Inputs (ArrayList<Input>)
    //Outputs (ArrayList<Output>)
    //Short Description (String)
    //Description (String)
    //Subsystem (Subsystem)

    private UUID id;
    private String name;
    private ArrayList<Input> inputs;
    private ArrayList<Output> outputs;
    private String shortDescription;
    private String longDescription;
    private String subsystem;

    public Device(){
        id = UUID.randomUUID();
        name = "";
        inputs = new ArrayList<>();
        outputs = new ArrayList<>();
        shortDescription = "";
        longDescription = "";
        subsystem = "";
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public void setShortDescription(String sDescription) {
        this.shortDescription = sDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String lDescription) {
        this.longDescription = lDescription;
    }

    public String getSubsystem() {
        return subsystem;
    }

    public void setSubsystem(String subsystem) {
        this.subsystem = subsystem;
    }

    public ArrayList<Input> getInputs() {
        return inputs;
    }

    public void setInputs(ArrayList<Input> inputs) {
        this.inputs = inputs;
    }

    public ArrayList<Output> getOutputs() {
        return outputs;
    }

    public void setOutputs(ArrayList<Output> outputs) {
        this.outputs = outputs;
    }

    public void addInput(Input input){
        this.inputs.add(input);
    }

    public void addOutput(Output output){
        this.outputs.add(output);
    }
}
