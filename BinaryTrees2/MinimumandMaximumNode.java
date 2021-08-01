package BinaryTrees2;

import BinaryTrees1.BinaryNode;

public class MinimumandMaximumNode {
    public static Pair<Integer,Integer> getMinAndMax(BinaryNode<Integer> root){

        if (root==null){
            return new Pair<>(Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Pair<Integer,Integer> left = getMinAndMax(root.left);
        Pair<Integer,Integer> right = getMinAndMax(root.right);
        int lm= Math.min(root.data,Math.min(left.minimum,right.minimum));
        int rm= Math.max(root.data,Math.max(left.maximum,right.maximum));
        return new Pair<>(lm,rm);
    }

}
