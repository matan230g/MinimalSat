import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Circuit {
    public String name;
    public ArrayList<Node> inputs=new ArrayList<Node>();
    public ArrayList<Node> outputs = new ArrayList<Node>();
    public ArrayList<Gate> gates= new ArrayList<Gate>();
    public ArrayList<Observation> observations = new ArrayList<Observation>();
    public Circuit(String pathName) {
        try {
            File file = new File(pathName);
            Scanner myReader = new Scanner(file);
            ArrayList<String> data=new ArrayList<String>();
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                data.add(line);
            }
            myReader.close();
            this.name = data.get(0).replace(".", "");
            String inputText=data.get(1);
            String[] inputsLine = cleanLine(inputText);
            for (String n:inputsLine) {
                inputs.add(new Node(n));
            }
            String outputsText=data.get(2);
            String[] outputsLine = cleanLine(outputsText);
            for (String n:outputsLine) {
                outputs.add(new Node(n));
            }

            addGates(data);


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }




    }

    private void addGates(ArrayList<String> data) {
        for (int i = 3; i <data.size() ; i++) {
            String[] gateLine = cleanLine(data.get(i));
            String type = gateLine[0];
            String gateName = gateLine[1];
            Node gateOutput = creatNode(gateLine[2]);
            for (int j = 3; j < gateLine.length; j++) {
                ArrayList<Node> gateInputs=new ArrayList<Node>();
                gateInputs.add(creatNode(gateLine[j]));
                this.gates.add(new Gate(gateName,gateOutput,gateInputs,type));
            }

        }
    }

    private String[] cleanLine(String inputText) {
        inputText=inputText.replace(".","");
        inputText=inputText.replaceAll("[\\[\\]\\(\\)]", "");
        return inputText.split(",");
    }
    private Node creatNode(String nodeName){
        ArrayList<Node> allNodes= new ArrayList<Node>();
        allNodes.addAll(this.inputs);
        allNodes.addAll(this.outputs);
        for (Node o:allNodes) {
            if(o.continasName(nodeName)){
                return o;
            }
        }
        return new Node(nodeName);
    }
    public void addObservationFromFile(String pathName){
        try {
            File file = new File(pathName);
            Scanner myReader = new Scanner(file);
            ArrayList<String> data=new ArrayList<String>();
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                data.add(line);
            }
            myReader.close();
            for (int i = 0; i <data.size() ; i++) {
               String[]arr=cleanLine(data.get(i));
               String nameObs = arr[1];
               ArrayList<Boolean> inputsObs =new ArrayList();
               ArrayList<Boolean> outputsObs =new ArrayList();
                for (int j = 0; j <arr.length ; j++) {
                    String temp = arr[j];
                    if(temp.contains("i")){
                        inputsObs.add(!temp.contains("-"));
                    }
                    else {
                        outputsObs.add(!temp.contains("-"));
                    }
                    this.observations.add(new Observation(nameObs,inputsObs,outputsObs));

                }



            }




        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }
}

