package BinaryTrees1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeIteration {

    public static BinaryNode<Integer> TakeInputLevelWise(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the root of the tree : ");
        int x = scanner.nextInt();
        if(x==-1){
            return null;
        }
        BinaryNode<Integer> root = new BinaryNode<>(x);
        Queue<BinaryNode<Integer>> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            BinaryNode<Integer> temp = nodes.remove();
            System.out.print("Enter the left child of "+ temp.data+" : ");
            int leftchild= scanner.nextInt();
            if(leftchild!=-1){
                BinaryNode<Integer> left = new BinaryNode<>(leftchild);
                temp.left=left;
                nodes.add(left);
            }
            System.out.print("Enter the right child of "+ temp.data+ " : ");
            int rightchild = scanner.nextInt();
            if(rightchild!=-1){
                BinaryNode<Integer> right = new BinaryNode<>(rightchild);
                temp.right=right;
                nodes.add(right);
            }
        }
        return root;
    }
    public static void printLevelWise(BinaryNode<Integer> root) {
        if(root==null){
            return;
        }
        Queue<BinaryNode<Integer>> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            BinaryNode<Integer> temp = nodes.remove();
            System.out.print(temp.data+":");
            if(temp.left!=null&&temp.right!=null){
                BinaryNode<Integer> leftchild = temp.left;
                BinaryNode<Integer> rightchild = temp.right;
                nodes.add(leftchild);
                nodes.add(rightchild);
                System.out.println("L:"+leftchild.data+",R:"+rightchild.data);
            }
            else if(temp.left==null&&temp.right!=null){
                BinaryNode<Integer> rightchild = temp.right;
                nodes.add(rightchild);
                System.out.println("L:-1"+",R:"+rightchild.data);
            }
            else if(temp.left!=null&&temp.right==null){
                BinaryNode<Integer> leftchild = temp.left;
                nodes.add(leftchild);
                System.out.println("L:"+leftchild.data+",R:-1");
            }
            else
                System.out.println("L:-1,R:-1");
        }
    }
    public static void printLevelWiseimproved(BinaryNode<Integer>root){
        if(root==null){
            return;
        }
        Queue<BinaryNode<Integer>> nodes = new LinkedList<>();
        nodes.add(root);
        System.out.println("The Root of the tree is "+root.data);
        while (!nodes.isEmpty()){
           boolean nochild = true;
           BinaryNode<Integer> temp = nodes.remove();
           if(temp.left!=null){
               BinaryNode<Integer> leftchild = temp.left;
               System.out.println("The Left Child of "+ temp.data+" : "+leftchild.data);
               nodes.add(leftchild);
               nochild=false;
           }
           else if(temp.left==null&&temp.right!=null){
               System.out.println(temp.data+" does not have a left child ");
               nochild=false;
           }

            if(temp.right!=null){
                BinaryNode<Integer> rightchild = temp.right;
                System.out.println("The Right Child of "+ temp.data+" : "+rightchild.data);
                nodes.add(rightchild);
                nochild=false;
            }
            else if (temp.right==null&&temp.left!=null){
                System.out.println(temp.data+" does not have a right child ");
                nochild=false;
            }
            if(nochild){
                System.out.println(temp.data+" does not have any child ");
            }
        }
    }
    public static void printLevelWise2(BinaryNode<Integer> root) {

        Queue<BinaryNode<Integer>> elements = new LinkedList<>();
        elements.add(root);
        elements.add(null);
        while (!elements.isEmpty()) {
            BinaryNode<Integer> temp = elements.remove();
            if (temp != null) {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    elements.add(temp.left);
                }
                if (temp.right != null) {
                    elements.add(temp.right);
                }
            }
            if (temp == null) {
                System.out.println();
                if (!elements.isEmpty()) {
                    elements.add(null);
                }
            }
        }
    }
    public static void main(String [] args){
        BinaryNode<Integer> root = TakeInputLevelWise();
        System.out.println();
        printLevelWise2(root);
    }
}
