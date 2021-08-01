package BinarySearchTrees;

import BinaryTrees1.BinaryNode;
import BinaryTrees1.TreeIteration;

public class CheckOrConstructBinarySearchTree {

    public static Data isBinarySearchTreeefficient(BinaryNode<Integer> root){
        if(root==null){
            Data ans = new Data(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
            return ans;
        }
        Data leftans = isBinarySearchTreeefficient(root.left);
        Data rightans = isBinarySearchTreeefficient(root.right);

        int min = Math.min(root.data,Math.min(leftans.min, rightans.min));
        int max = Math.max(root.data,Math.max(leftans.max, rightans.max));
        boolean isBST =true;
        if(leftans.max>root.data){
            isBST=false;
        }
        if(rightans.min< root.data){
            isBST=false;
        }
        if(!(leftans.isBSTNode)||!(rightans.isBSTNode)){
            isBST=false;
        }
        Data data = new Data(min,max,isBST);
        return data;
    }
    private static Data isBinarySearchTreeefficient2(BinaryNode<Integer> root){
        if(root==null){
            Data ans = new Data();
            ans.isBSTNode=true;
            ans.min=Integer.MAX_VALUE;
            ans.max=Integer.MIN_VALUE;
            return ans;
        }
        boolean isBSTNode = true;
        Data ansleft = isBinarySearchTreeefficient2(root.left);
        Data ansright = isBinarySearchTreeefficient2(root.right);


        if(ansleft.isBSTNode==false||ansright.isBSTNode==false){
            isBSTNode=false;
        }
        if(ansleft.max>root.data){
            isBSTNode=false;
        }
        if(ansright.min< root.data){
            isBSTNode=false;
        }
        int max=Math.max(root.data, Math.max(ansleft.max,ansright.max));
        int min=Math.min(root.data, Math.min(ansleft.min,ansright.min));
        Data d = new Data(min,max, isBSTNode);
        return d;
    }
    public static boolean isBSTBest(BinaryNode<Integer> root){
        return isBSTBesthelper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private static boolean isBSTBesthelper(BinaryNode<Integer> root, int minrange, int maxrange) {
        if(root==null){
            return true;
        }
        if(root.data>maxrange){
            return false;
        }
        if(root.data<minrange){
            return false;
        }
        boolean isleftBST = isBSTBesthelper(root.left,minrange,root.data-1);
        boolean isrightBST = isBSTBesthelper(root.right,root.data,maxrange);

        return isleftBST&&isrightBST;
    }

    public static boolean isBinarySearchTree(BinaryNode<Integer> root){
        if(root==null){
            return true;
        }
        int rootdata = root.data;
        int leftmax = maximum(root.left);
        int rightmin = minimum(root.right);
        if(rootdata>rightmin){
            return false;
        }
        if(rootdata<leftmax){
            return false;
        }
        boolean leftans = isBinarySearchTree(root.left);
        boolean rightans = isBinarySearchTree(root.right);
        return leftans&&rightans;
    }

    private static int minimum(BinaryNode<Integer> root) {
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int leftmin=minimum(root.left);
        int rightmin = minimum(root.right);
        return Math.min(root.data,Math.min(leftmin,rightmin));
    }

    private static int maximum(BinaryNode<Integer> root) {
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int leftmax=maximum(root.left);
        int rightmax=maximum(root.right);
        return Math.max(root.data,Math.max(leftmax,rightmax));
    }

    public static void main(String[] args){
        BinaryNode<Integer> root = TreeIteration.TakeInputLevelWise();
        System.out.println(isBSTBest(root));

    }
    public static BinaryNode<Integer> SortedArrayToBinarySearchTree(int[] arr, int n){
        BinaryNode<Integer> root = helperSortedArrayToBinarySearchTree(arr,0,n-1);
        return root;
    }

    private static BinaryNode<Integer> helperSortedArrayToBinarySearchTree(int[] arr, int start, int end) {
        if (start>end){
            return null;
        }
        int mid = (start+ end)/2;
        BinaryNode<Integer> root = new BinaryNode<>(arr[mid]);
        root.left= helperSortedArrayToBinarySearchTree(arr,start,mid-1);
        root.right= helperSortedArrayToBinarySearchTree(arr, mid+1, end);
        return root;
    }

}

