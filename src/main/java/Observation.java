import java.util.ArrayList;

public class Observation {
    private String name;
    private ArrayList<Boolean> inputsValue;
    private ArrayList<Boolean> outputsValue;



    public Observation(String name, ArrayList<Boolean> inputsValue, ArrayList<Boolean> outputsValue) {
        this.name = name;
        this.inputsValue = inputsValue;
        this.outputsValue = outputsValue;
    }


}
