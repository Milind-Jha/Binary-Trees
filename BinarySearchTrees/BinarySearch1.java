package BinarySearchTrees;

import java.util.ArrayList;

public class BinarySearch1 {
    public static boolean searchInBST(BinarySearchNode<Integer> root, int k) {
        boolean ans=false;
        if(root==null){
            return false;
        }
        if(root.data==k){
            return true;
        }
        else if(root.data>k){
            ans=searchInBST(root.left,k);
        }
        else if(root.data<k){
            ans=searchInBST(root.right,k);
        }
        return ans;
    }
    static ArrayList<Integer> elements = new ArrayList<>();
    public static void elementsInRangeK1K2(BinarySearchNode<Integer> root, int k1, int k2){
            printelements( root,k1,k2);
        for (int x:elements) {
            System.out.print(x+" ");
            }
        }

    private static void printelements(BinarySearchNode<Integer> root, int k1, int k2) {
        if(root==null){
            return;
        }
        if(k1< root.data&&root.data<k2){
            elementsInRangeK1K2(root.left,k1,k2); //All elements in left are smaller than root so they need to be printed first
            elements.add(root.data);
            elementsInRangeK1K2(root.right,k1,k2);
        }
        else if(root.data<k1){
            elementsInRangeK1K2(root.right,k1,k2);
        }
        else if(root.data>k2){
            elementsInRangeK1K2(root.left,k1,k2);
        }
    }


}
