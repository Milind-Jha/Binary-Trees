package BinarySearchTrees;

public class BinarySearchNode<GEN> {

    GEN data;
    BinarySearchNode<GEN> left;
    BinarySearchNode<GEN> right;

    public BinarySearchNode(GEN data){
        this.data =data;
        this.left = null;
        this.right = null;
    }
    public BinarySearchNode(){

    }
}
