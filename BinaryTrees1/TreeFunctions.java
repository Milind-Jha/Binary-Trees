package BinaryTrees1;

public class TreeFunctions {

    public static int Largest(BinaryNode<Integer> root){
        if(root==null){
            return -1;
        }
        int x = Largest(root.left);
        int y = root.data;
        int z = Largest(root.right);

        if(x>=y&&x>=z){
            return x;
        }
        else if(y>=z&&y>=x){
            return y;
        }
        else
            return z;
    }
    public static int countNodesGreaterThanX(BinaryNode<Integer> root, int x) {
        if(root==null){
            return 0;
        }
        int temp;
        if(root.data>x){
            temp=1;
        }
        else temp=0;
        int a = countNodesGreaterThanX(root.left,x);
        int b = countNodesGreaterThanX(root.right,x);
        return a+b+temp;
    }
    public static int height(BinaryNode<Integer> root) {
        if(root==null){
            return 0;
        }
        int x = height(root.left);
        int y = height(root.right);
        x = Math.max(x,y);
        return x+1;
    }
    public static int countLeaves(BinaryNode<Integer> root){
        if(root==null){
            return 0;
        }
        else if(root.left==null&&root.right==null){
            return 1;
        }
        int leftleaves= countLeaves(root.left);
        int rightleaves= countLeaves(root.right);
        return leftleaves+rightleaves;
    }
    public static void printNodesAtdepthK(BinaryNode<Integer> root, int k){
        if(root==null){
            return;
        }
        if(k==0){
            System.out.print(root.data+" ");
            return;
        }
            printNodesAtdepthK(root.left,k-1);
            printNodesAtdepthK(root.right,k-1);

    }
    public static void changeToDepthTree(BinaryNode<Integer> root) {
        if(root==null){
            return;
        }
        else
            root=changeNodeData(root,0);
    }

    private static BinaryNode<Integer> changeNodeData(BinaryNode<Integer> root, int i) {
        if(root==null){
            return null;
        }
        root.data=i;
        changeNodeData(root.left,i+1);
        changeNodeData(root.right,i+1);
        return root;
    }

    public static void main(String[] args){
        BinaryNode<Integer> root = Main.takeInputbetter(true,0,true);
        printNodesAtdepthK(root,2);
    }
    public static boolean isNodePresent(BinaryNode<Integer> root, int x) {
        if(root==null){
            return false;
        }
        if(root.data==x){
            return true;
        }
        boolean a = isNodePresent(root.left,x);
        boolean b = isNodePresent(root.right,x);

        if(a||b){
            return true;
        }
        else
            return false;
    }
    public static void printNodesWithoutSibling(BinaryNode<Integer> root) {
        if(root==null){
            return;
        }
        if(root.left==null&&root.right!=null){
            System.out.print(root.right.data+" ");
        }
        else if(root.left!=null&&root.right==null){
            System.out.print(root.left.data+" ");
        }
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }
}
