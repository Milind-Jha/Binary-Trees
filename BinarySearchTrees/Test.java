package BinarySearchTrees;

import java.util.Stack;

public class Test {
    private static int count(BinarySearchNode<Integer> root) {
        if(root==null){
            return 0;
        }
        int x = count(root.left)+count(root.right) + 1;
        return x;
    }
    public static void printNodesSumToS(BinarySearchNode<Integer> root, int s) {
        int totalnodes = count(root);
        int count=0;
        Stack<BinarySearchNode<Integer>> inorder = new Stack<>();
        Stack<BinarySearchNode<Integer>> revinorder = new Stack<>();
        BinarySearchNode<Integer> temp = root;

        while (temp!=null){
            inorder.push(temp);
            temp=temp.left;
        }
        temp=root;
        while (temp!=null){
            revinorder.push(temp);
            temp=temp.right;
        }


        while (count<totalnodes-1){
            BinarySearchNode<Integer> top1 = inorder.peek();
            BinarySearchNode<Integer> top2 = revinorder.peek();
            if(top1.data + top2.data == s){
                System.out.println(top1.data + " " + top2.data);
                BinarySearchNode<Integer> top = top1;
                inorder.pop();
                count++;

                if(top.right!=null){
                    top=top.right;
                    while (top!=null){
                        inorder.push(top);
                        top=top.left;
                    }
                }

                top = top2;
                revinorder.pop();
                count++;
                if(top.left!=null){
                    top=top.left;
                    while (top!=null){
                        revinorder.push(top);
                        top = top.right;
                    }
                }
            }
            else if(top1.data+top2.data>s){
                BinarySearchNode<Integer> top = top2;
                revinorder.pop();
                count++;
                if(top.left!=null) {
                    top=top.left;
                    while (top!=null){
                        revinorder.push(top);
                        top =top.right;
                    }
                }
            }
            else {
                BinarySearchNode<Integer> top = top1;
                inorder.pop();
                count++;
                if(top1.right!=null){
                    top1 = top1.right;
                    inorder.push(top1);
                    while (top1!=null){
                        inorder.push(top1);
                        top1=top1.left;
                    }
                }
            }
        }
    }
}
