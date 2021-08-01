package BinarySearchTrees;

import BinaryTrees1.BinaryNode;

public class LowestCommonAncestorod2nodes {

    public static int getLCA(BinaryNode<Integer> root, int a, int b) {
        if(root==null){
            return -1;
        }
        if(root.data==a||root.data==b){
            return root.data;
        }
        int left = getLCA(root.left,a,b);
        int right = getLCA(root.right,a,b);

        if(left==-1&&right==-1){
            return -1;
        }
        else if(left!=-1&&right==-1){
            return left;
        }
        else if(left==-1&&right!=-1){
            return right;
        }
        else {
            return root.data;
        }
    }
    static int sum=0;
    public static void replaceWithlargerNodesSum(BinaryNode<Integer> root){
        if(root==null){
            return;
        }
        replaceWithlargerNodesSum(root.right);
        sum=sum+root.data;
        root.data =sum;
        replaceWithlargerNodesSum(root.left);
    }
    public static void replaceWithlargerNodesSum2(BinaryNode<Integer> root) {
            helperreplaceWithlargerNodesSum2(root,0);
    }

    private static int helperreplaceWithlargerNodesSum2(BinaryNode<Integer> root, int sum) {
        if(root==null){
            return sum;
        }
        sum = helperreplaceWithlargerNodesSum2(root.right,sum);
        sum = sum + root.data;
        root.data = sum;
        sum = helperreplaceWithlargerNodesSum2(root.left,sum);
        return sum;
    }
}
