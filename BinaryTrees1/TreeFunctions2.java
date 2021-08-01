package BinaryTrees1;

public class TreeFunctions2 {
    public static BinaryNode<Integer> removeLeaves(BinaryNode<Integer> root){
        if(root==null){
            return null;
        }
        if(root.left==null&&root.right==null){
            return null;
        }
       root.left= removeLeaves(root.left);
       root.right=removeLeaves(root.right);
        return root;
    }

    public static void mirrorBinaryTree(BinaryNode<Integer> root){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }
        else if(root.right==null&&root.left!=null){
            root.right=root.left;
            root.left=null;
        }
        else if(root.right!=null&&root.left==null){
            root.left=root.right;
            root.right=null;
        }
        else{
            BinaryNode<Integer> temp = root.left;
            root.left=root.right;
            root.right=temp;
        }
       mirrorBinaryTree(root.left);
       mirrorBinaryTree(root.right);
    }
    public static BalancedTreeReturns isBalancedBetter(BinaryNode<Integer> root){
        if(root==null){
            int h =0;
            boolean balanced = true;
            BalancedTreeReturns ans = new BalancedTreeReturns();
            ans.isBalanced = balanced;
            ans.height = h;
            return ans;
        }
        BalancedTreeReturns temp1 = isBalancedBetter(root.left);
        BalancedTreeReturns temp2 = isBalancedBetter(root.right);
        int h;
        boolean balanced = true;
        h = 1 + Math.max(temp1.height,temp2.height);

        if(Math.abs(temp1.height-temp2.height)>1){
            balanced = false;
        }
        if(!temp1.isBalanced||!temp2.isBalanced){
            balanced =false;
        }
        BalancedTreeReturns ans = new BalancedTreeReturns();
        ans.isBalanced = balanced;
        ans.height = h;
        return ans;
    }
    public static boolean isBalancedTREE(BinaryNode<Integer> root){
         if(root==null){               // Balanced Tree means for every node the diffrence of height in the...
             return true;             // left and the right sub-tree is <= 1
         }
        int x = height(root.left);
        int y = height(root.right);
        boolean temp1=false, temp2=false;
        if(x-y<=1&&x-y>=-1){
            temp1 = isBalancedTREE(root.left);
            temp2 = isBalancedTREE(root.right);
        }
        else
            return false;

        if(temp1==true&&temp2==true){
            return true;
        }
        else
            return false;

    }
    public static int height(BinaryNode<Integer> root){
        if(root==null){
            return 0;
        }
        int x = height(root.left);
        int y = height(root.right);
        return Math.max(x,y)+1;
    }
    public static int diameterOfBinaryTree(BinaryNode<Integer> root){
        if(root == null){
            return 0;
        }
        int leftheight = height(root.left);
        int rightheight = height(root.right);
        int leftdia = diameterOfBinaryTree(root.left);
        int rightdia = diameterOfBinaryTree(root.right);
        int x = leftheight+ rightheight+1;
        if(x>leftdia&&x>rightdia){
            return x;
        }
        else if(leftdia>x&&leftdia>rightdia){
            return leftdia;
        }
        else
            return rightdia;
    }

}
