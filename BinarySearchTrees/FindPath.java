package BinarySearchTrees;

import BinaryTrees1.BinaryNode;

import java.util.ArrayList;

public class FindPath {
    public static ArrayList<Integer> getPath(BinaryNode<Integer> root, int data){
        if(root==null){
            return null;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        if(root.data==data){
            ans.add(root.data);
            return ans;
        }
        if(root.data>data){
            ans = getPath(root.left,data);
            if(ans!=null){
                ans.add(root.data);
                return ans;
            }
        }
        if(root.data<data){
            ans = getPath(root.right,data);
            if(ans!=null){
                ans.add(root.data);
                return ans;
            }
        }
        return null;
    }
}
