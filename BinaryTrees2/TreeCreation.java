package BinaryTrees2;

import BinaryTrees1.BinaryNode;

public class TreeCreation {
    public static BinaryNode<Integer> buildTreefromPreorderAndInorder(int[] preOrder, int[] inOrder) {
        if(preOrder.length==0){
            return null;
        }
        int root = preOrder[0];
        int leftlength=0;
        for(int i:inOrder) {
            if (i == root) {
                break;
            } else {
                leftlength++;
            }
        }
            int[] leftinorder = new int[leftlength];
            int[] leftpreorder = new int[leftlength];
            int[] rightpreorder = new int[preOrder.length-leftlength-1];
            int[] rightinorder = new int[preOrder.length-leftlength-1];

            boolean rootfound = false;

        for(int i=0;i<inOrder.length;i++) {
            if(inOrder[i] == root){
                rootfound=true;
                continue;
            }
            if (!rootfound) {
                leftinorder[i]=inOrder[i];
            }
            else if(rootfound){
                rightinorder[i-leftlength-1]=inOrder[i];
            }
        }

        for(int i=1;i< preOrder.length;i++){
            if(i-1<leftlength){
                leftpreorder[i-1]=preOrder[i];
            }
            else {
                rightpreorder[i-leftlength-1]=preOrder[i];
            }
        }
        BinaryNode<Integer> letfsubtree= buildTreefromPreorderAndInorder(leftpreorder,leftinorder);
        BinaryNode<Integer> rightsubtree= buildTreefromPreorderAndInorder(rightpreorder,rightinorder);
        BinaryNode<Integer> start = new BinaryNode<>(root);
        start.left=letfsubtree;
        start.right=rightsubtree;
        return start;
    }
    public static BinaryNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
        if(postOrder.length==0){
            return null;
        }
        int root = postOrder[postOrder.length-1];
        int leftlength=0;
        for(int i:inOrder){
            if(i==root){
                break;
            }
            else{
                leftlength++;
            }
        }
        int[] leftpostorder = new int[leftlength];
        int[] rightpostorder= new int[postOrder.length-leftlength-1];
        int[] leftinorder = new int[leftlength];
        int[] rightinorder= new int[postOrder.length-leftlength-1];

        boolean rootfound = false;

        for(int i=0;i<inOrder.length;i++){
            if(inOrder[i]==root){
                rootfound=true;
                continue;
            }
            if(!rootfound){
                leftinorder[i]=inOrder[i];
            }
            else if(rootfound){
                rightinorder[i-leftlength-1]=inOrder[i];
            }
        }

        for (int i=0;i< postOrder.length-1;i++){
            if(i<leftlength){
                leftpostorder[i]=postOrder[i];
            }
            else {
                rightpostorder[i-leftlength]=postOrder[i];
            }
        }
        BinaryNode<Integer> leftsubtree = buildTree(leftpostorder,leftinorder);
        BinaryNode<Integer> rightsubtree = buildTree(rightpostorder,rightinorder);
        BinaryNode<Integer> head = new BinaryNode<>(root);
        head.left=leftsubtree;
        head.right=rightsubtree;
        return head;
    }
}
