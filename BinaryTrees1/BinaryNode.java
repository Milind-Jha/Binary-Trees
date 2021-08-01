package BinaryTrees1;

import BinarySearchTrees.BinarySearchNode;

public class BinaryNode<T> {

    public T data;
    public BinaryNode<Integer> left;
    public BinaryNode<T> right;

    public BinaryNode(T data){
        this.data = data;
    }
}
