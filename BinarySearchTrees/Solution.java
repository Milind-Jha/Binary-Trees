package BinarySearchTrees;

class pairofdata<a,b,c,d>            // DIFFICULTY-HARD
{
    int maximum;
    int minimum;
    boolean bst;
    int height;
}
class Solution {

    public static int largestBSTSubtree(BinarySearchNode<Integer> root) {
        // Write your code here
        if(root==null)
        {
            return 0;
        }
        pairofdata<Integer,Integer,Integer,Boolean> output=largestBSTSubtreehelper(root);
        return output.height;
    }

    public static pairofdata<Integer,Integer,Integer,Boolean> largestBSTSubtreehelper(BinarySearchNode<Integer> root)
    {
        if(root==null)
        {
            pairofdata<Integer,Integer,Integer,Boolean> output=new pairofdata<>();
            output.maximum=Integer.MIN_VALUE;
            output.minimum=Integer.MAX_VALUE;
            output.height=0;
            output.bst=true;
            return output;
        }
        pairofdata<Integer,Integer,Integer,Boolean> leftoutput=largestBSTSubtreehelper(root.left);
        pairofdata<Integer,Integer,Integer,Boolean> rightoutput=largestBSTSubtreehelper(root.right);
        int min=Math.min(root.data,Math.min(leftoutput.minimum,rightoutput.minimum));
        int max=Math.max(root.data,Math.max(leftoutput.maximum,rightoutput.maximum));
        boolean isbst=(root.data>leftoutput.maximum) && (root.data<rightoutput.minimum) &&(leftoutput.bst && rightoutput.bst);
        int height=Math.max(leftoutput.height,rightoutput.height);
        if(isbst==true){
            height++;
        }
        pairofdata<Integer,Integer,Integer,Boolean> output=new pairofdata<>();
        output.maximum=max;
        output.minimum=min;
        output.height=height;
        output.bst=isbst;
        return output;
    }
}
