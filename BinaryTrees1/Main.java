package BinaryTrees1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
//        BinaryNode<Integer> root = new BinaryNode<>(1);
//        BinaryNode<Integer> leftchildroot = new BinaryNode<>(2);
//        BinaryNode<Integer> rightchildroot = new BinaryNode<>(3);
//        BinaryNode<Integer> leftchildofleftchild = new BinaryNode<>(4);
//        BinaryNode<Integer> leftchildofrightchild = new BinaryNode<>(5);
//
//        root.left = leftchildroot;
//        root.right= rightchildroot;
//        leftchildroot.left= leftchildofleftchild;
//        rightchildroot.left = leftchildofrightchild;

        BinaryNode<Integer> root = takeInputbetter(true,0,true);
        System.out.println();
        preOrder(root);
        System.out.println(": PRE ORDER");
        postOrder(root);
        System.out.println(": POST ORDER");
        inOrder(root);
        System.out.println(": IN ORDER");
//        System.out.println("Number of nodes in the tree : "+length(root));
//        System.out.print("Largest Node: "+TreeFunctions.Largest(root));
//        System.out.println("Nodes Larger than 5 : "+TreeFunctions.countNodesGreaterThanX(root,5));
        System.out.println("Number of leaves : "+ TreeFunctions.countLeaves(root));
//        TreeFunctions.printNodesAtdepthK(root,3);
//        root = TreeFunctions2.removeLeaves(root);
//        System.out.println(TreeFunctions2.isBalancedTREE(root));
//        System.out.println(TreeFunctions2.isBalancedBetter(root).isBalanced);
    }

    public static int getSum(BinaryNode<Integer> root) {
        if(root==null){
            return 0;
        }
        int x = getSum(root.left);
        int y = getSum(root.right);
        return x+y+root.data;
    }
    public static int length(BinaryNode<Integer> root){
        if(root == null){
            return 0;
        }
        BinaryNode<Integer> left= root.left;
        BinaryNode<Integer> right =root.right;
        int x = length(left);
        int y = length(right);
        return x+y+1;
    }
    public static BinaryNode<Integer> takeInput(){
        int x;
        Scanner scanner = new Scanner(System.in);
        x= scanner.nextInt();

        if(x==-1){
            return null;
        }
        BinaryNode<Integer> root = new BinaryNode<>(x);
        BinaryNode<Integer> leftchild = takeInput();
        BinaryNode<Integer> rightchild = takeInput();

        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
    public static BinaryNode<Integer> takeInputbetter(boolean isroot, int parentdata, boolean isleftchild){

        if(isroot){
            System.out.print("Enter Root data: ");
            isroot = false;
        }
        else if(isleftchild){
            System.out.print("Enter the left child of "+ parentdata + " :");
        }
        else if(!isleftchild){
            System.out.print("Enter the right child of "+ parentdata + " :");
        }

        int x;
        Scanner scanner = new Scanner(System.in);
        x= scanner.nextInt();

        if(x==-1){
            return null;
        }
        BinaryNode<Integer> root = new BinaryNode<>(x);
        BinaryNode<Integer> leftchild = takeInputbetter(isroot,x,true);
        BinaryNode<Integer> rightchild = takeInputbetter(isroot,x,false);

        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
    public static void print(BinaryNode<Integer> root){

        if (root==null){
            return;
        }
        int x = root.data;
        int y =0;
        int z =0;
        if(root.left!=null){
            y = root.left.data;
        }
        if(root.right!=null){
            z = root.right.data;
        }
        if(root.left!=null&&root.right!=null){
            System.out.println(x+" : L:"+y+" R:"+z);
        }
        else if(root.left!=null&&root.right==null){
            System.out.println(x+" : L:"+y);
        }
        else if(root.left==null&&root.right!=null){
            System.out.println(x+" : R:"+z);
        }
        else {
            System.out.println(x);
        }

        BinaryNode<Integer> left = root.left;
        BinaryNode<Integer> right = root.right;
        print(left);
        print(right);
    }
    public static void preOrder(BinaryNode<Integer> root) {
        if (root==null){
            return;
        }
        int x = root.data;
        System.out.print(x+" ");
        BinaryNode<Integer> left = root.left;
        BinaryNode<Integer> right = root.right;
        preOrder(left);
        preOrder(right);

    }
    public static void postOrder(BinaryNode<Integer> root) {
        if (root==null){
            return;
        }
        int x = root.data;

        BinaryNode<Integer> left = root.left;
        BinaryNode<Integer> right = root.right;
        postOrder(left);
        postOrder(right);
        System.out.print(x+" ");
    }
    public static void inOrder(BinaryNode<Integer> root) {
        if (root==null){
            return;
        }
        int x = root.data;

        BinaryNode<Integer> left = root.left;
        BinaryNode<Integer> right = root.right;
        inOrder(left);
        System.out.print(x+" ");
        inOrder(right);

    }

}
