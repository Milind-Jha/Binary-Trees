package BinaryTrees2;

import BinaryTrees1.BinaryNode;
import BinaryTrees1.TreeFunctions;

public class Main {
    public static void main(String[] args){
        int[] preorder = {1,2,4,5,3};
        int[] inorder = {4,2,5,1,3};
        int[] postorder = {4,5,2,3,1};
        BinaryNode<Integer> root = TreeCreation.buildTreefromPreorderAndInorder(preorder,inorder);
        BinaryNode<Integer> root2 = TreeCreation.buildTree(postorder,inorder);
        BinaryTrees1.Main.print(root);
        BinaryTrees1.Main.print(root2);
    }
}
