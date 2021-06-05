import java.util.ArrayList;

public class Gate {

    private String name;
    private Node gateOutput;
    private ArrayList<Node> gateInputs;
    private String gateType;
    private boolean flipped;

    public Gate(String name, Node gateOutput, ArrayList<Node> gateInputs, String gateType) {
        this.name = name;
        this.gateOutput = gateOutput;
        this.gateInputs = gateInputs;
        this.gateType = gateType;
    }

    public String getName() {
        return name;
    }

    public Node getGateOutput() {
        return gateOutput;
    }

    public ArrayList<Node> getGateInputs() {
        return gateInputs;
    }

    public String getGateType() {
        return gateType;
    }

    public boolean isFlipped() {
        return flipped;
    }
}
