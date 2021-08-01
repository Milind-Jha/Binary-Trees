package BinaryTrees1;

import java.util.ArrayList;

public class FindPathfromNodetoRoot {
    public static ArrayList<Integer> findPath(BinaryNode<Integer> root,int node){
        if(root==null){
            return null;
        }
        ArrayList<Integer> ans= new ArrayList<>();
        if(root.data==node){
            ans.add(root.data);
            return ans;
        }
        ArrayList<Integer> addleft = findPath(root.left,node);
        if(addleft!=null){
            addleft.add(root.data);
            return addleft;
        }
        ArrayList<Integer> addright = findPath(root.right,node);
        if(addright!=null){
            addright.add(root.data);
            return addright;
        }
        return null;
    }
}
