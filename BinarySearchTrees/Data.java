package BinarySearchTrees;

public class Data {
    public boolean isBSTNode;
    public int min;
    public int max;
    public Data(){

    }
    public Data(int min, int max, boolean isBSTNode){
        this.min=min;
        this.max=max;
        this.isBSTNode=isBSTNode;
    }
}
