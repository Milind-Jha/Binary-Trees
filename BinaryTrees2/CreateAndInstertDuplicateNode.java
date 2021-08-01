package BinaryTrees2;

import BinaryTrees1.BinaryNode;

public class CreateAndInstertDuplicateNode {
    public static void insertDuplicateNode(BinaryNode<Integer> root) {
        if(root==null){
            return;
        }
        BinaryNode<Integer> temp = new BinaryNode<>(root.data);
        if(root.left==null){
            root.left = temp;
        }
        else {
            temp.left=root.left;
            root.left=temp;
        }
        insertDuplicateNode(root.left.left);
        insertDuplicateNode(root.right);
    }
}
