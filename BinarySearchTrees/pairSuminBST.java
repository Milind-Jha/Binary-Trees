package BinarySearchTrees;

import java.util.ArrayList;
import java.util.Stack;

public class pairSuminBST {
    static ArrayList<Integer> elements = new ArrayList<>();
    static BinarySearchNode<Integer> root = new BinarySearchNode<>();

//    public static void printNodesSumToS(BinarySearchNode<Integer> root, int s) {
//        elements = createsortedArray(root);
//        int i = 0;
//        int j = elements.size() - 1;
//        while (i < j) {
//            if (elements.get(i) + elements.get(j) == s) {
//                System.out.println(elements.get(i) + " " + elements.get(j));
//                i++;
//                j--;
//            }
//            if (elements.get(i) + elements.get(j) < s) {
//                i++;
//            }
//            if (elements.get(i) + elements.get(j) > s) {
//                j--;
//            }
//
//        }
//    }

    public static int countNodes(BinarySearchNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void printNodesSumToS(BinarySearchNode<Integer> root, int s) {
        if (root == null) {
            return;
        }
        int totalCount = countNodes(root);
        int count = 0;
        Stack<BinarySearchNode<Integer>> inorder = new Stack<BinarySearchNode<Integer>>();
        Stack<BinarySearchNode<Integer>> revInorder = new Stack<BinarySearchNode<Integer>>();
        BinarySearchNode<Integer> temp = root;
        while (temp != null) {
            inorder.push(temp);
            temp = temp.left;
        }
        temp = root;
        while (temp != null) {

            revInorder.push(temp);
            temp = temp.right;
        }
        while (count < totalCount - 1) {
            BinarySearchNode<Integer> top1 = inorder.peek();
            BinarySearchNode<Integer> top2 = revInorder.peek();
            if (top1.data + top2.data == s) {
                System.out.println(top1.data + " " + top2.data);
                BinarySearchNode<Integer> top = top1;
                inorder.pop();
                count++;
                if (top.right != null) {
                    top = top.right;
                    while (top != null) {
                        inorder.push(top);
                        top = top.left;
                    }
                }
                top = top2;
                revInorder.pop();
                count++;
                if (top.left != null) {
                    top = top1.left;
                    while (top != null) {
                        revInorder.push(top);
                        top = top1.right;
                    }
                }
            } else if (top1.data + top2.data > s) {
                BinarySearchNode<Integer> top = top2;
                revInorder.pop();
                count++;
                if (top.left != null) {
                    top = top.left;
                    while (top != null) {
                        revInorder.push(top);
                        top = top.right;
                    }
                }

            } else {
                BinarySearchNode<Integer> top = top1;
                inorder.pop();
                count++;
                if (top.right != null) {
                    top = top.right;
                    while (top != null) {
                        inorder.push(top);
                        top = top.left;
                    }
                }
            }
        }
    }
}


//    private static ArrayList<Integer> createsortedArray(BinarySearchNode<Integer> root) {
//        if (root == null) {
//            return null;
//        }
//        if(root.left==null){
//            elements.add(root.data);
//        }
//        else if(root.left!=null&&root.right==null){
//            createsortedArray(root.left);
//            elements.add(root.data);
//        }
//        else if(root.left!=null&&root.right!=null){
//            createsortedArray(root.left);
//            elements.add(root.data);
//            createsortedArray(root.right);
//        }
//        else if(root.right==null){
//            elements.add(root.data);
//        }
//        return elements;
//    }
//
//    public static void insert(int insertion) {
//        root=helperinsert(root,insertion);
//    }
//    private static BinarySearchNode<Integer> helperinsert(BinarySearchNode<Integer> root, int insertion) {
//
//        if(root==null||root.data==null){
//            BinarySearchNode<Integer> temp = new BinarySearchNode<>(insertion);
//            return temp;
//
//        }
//        else if(root.data>insertion){
//            root.left= helperinsert(root.left,insertion);
//        }
//        else if(root.data<=insertion){
//            root.right=helperinsert(root.right,insertion);
//        }
//        return root;
//    }
//    public static void main(String[] args){
//        insert(5);
//        insert(3);
//        insert(1);
//        insert(9);
//        insert(4);
//        insert(7);
//        insert(6);
//        insert(8);
//       printNodesSumToS(root,10);
//            for(int x:elements){
//                System.out.println(x);
//            }
//
//    }
//}
