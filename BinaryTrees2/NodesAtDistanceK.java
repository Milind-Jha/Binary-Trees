package BinaryTrees2;

import BinaryTrees1.BinaryNode;
import BinaryTrees1.TreeIteration;

public class NodesAtDistanceK {
    public static void nodesAtDistanceK(BinaryNode<Integer> root, int node, int k) {

        if(root.data==node){
            printatDepthk(root,k);
        }
        else {
             findDistance(root,node,k);
        }


    }

    private static int findDistance(BinaryNode<Integer> root, int node, int k) {
        if(root==null){
            return -1;
        }
        if(root.data == node){
            return 0;
        }
        int left = findDistance(root.left,node,k);
        if(left!=-1){
            if(left+1==k){
                System.out.println(root.data);
            }
            else {
                printatDepthk(root.right,k-left-2);
            }
            return left+1;
        }
        int right= findDistance(root.right,node,k);
        if(right!=-1){
            if(right+1==k){
                System.out.println(root.data);
            }
            else{
                printatDepthk(root.left,k-right-2);
            }
            return right+1;
        }
        return -1;
    }

    private static BinaryNode<Integer> searchnode(BinaryNode<Integer> root, int node) {
        BinaryNode<Integer> temp = root;
        if(temp==null){
            return null;
        }
        else if(temp.data==node){
            return temp;
        }
        else if(temp.left!=null&&temp.left.data==node){
            return temp.left;
        }
        else if(temp.right!=null&&temp.right.data==node){
            return temp.right;
        }
        else {
            if(temp.left!=null){
                temp = searchnode(temp.left,node);
            }
            if(temp==null){
                temp = root;
                if(temp.right!=null){
                    temp = searchnode(temp.right,node);
                }
            }
        }
        return temp;
        }

    public static void main(String[] args){
        BinaryNode<Integer> root = TreeIteration.TakeInputLevelWise();
        root = searchnode(root,4);
        System.out.println(root.data);
    }

    public static void printatDepthk(BinaryNode<Integer> root,int k){
        if(root==null){
            return;
        }
        if(k==0){
            System.out.print(root.data+" ");
        }
        printatDepthk(root.left,k-1);
        printatDepthk(root.right,k-1);
    }
}
