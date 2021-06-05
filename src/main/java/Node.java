public class Node {
    private String name;
    private boolean value;
    public Node(String name) {
            this.name=name;
            this.value=!name.contains("-");
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
    public boolean continasName(String Name){
        return this.name.equals(name);
    }

    @Override
    public String toString() {
        return "node: "+this.name+" value:"+this.value;
    }
}
