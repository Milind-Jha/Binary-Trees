package BinarySearchTrees;


public class BinarySearchTree {
    private BinarySearchNode<Integer> root;
    private static int size=0;

    public void insert(int insertion) {
        root=helperinsert(root,insertion);
    }
    private static BinarySearchNode<Integer> helperinsert(BinarySearchNode<Integer> root, int insertion) {

        if(root==null){
            BinarySearchNode<Integer> temp = new BinarySearchNode<>(insertion);
            size++;
            return temp;

        }
        if(root.data>insertion){
            root.left= helperinsert(root.left,insertion);
        }
        if(root.data<=insertion){
            root.right=helperinsert(root.right,insertion);
        }
        return root;
    }

    private static class Answer{
        BinarySearchNode newroot;
        boolean removed;
        private Answer(BinarySearchNode root, boolean removed){
            this.newroot=root;
            this.removed=removed;
        }
        private Answer(){
            this.newroot= null;
            this.removed=false;
        }
    }

    public boolean delete(int data) {
        Answer answer = helperdelete(root,data);
        root = answer.newroot;
        if(answer.removed){
            size--;
        }
        return answer.removed;
    }
    private static Answer helperdelete(BinarySearchNode<Integer> root, int data) {
        if(root==null){
            return new Answer(null,false);
        }
        if(root.data>data){
          Answer outputleft = helperdelete(root.left,data);
          root.left = outputleft.newroot;
          outputleft.newroot=root;
          return outputleft;
        }
        if(root.data<data){
          Answer outputright =  helperdelete(root.right,data);
          root.right=outputright.newroot;
          outputright.newroot=root;
          return outputright;
        }
        else {                      //root.data==data
            size--;
            if(root.right==null&&root.left==null){  //nochild
                Answer output = new Answer(null,true);
                return output;
            }
            else if(root.right==null&&root.left!=null) { //one child left
                   return new Answer(root.left,true);
            }
            else if(root.right!=null&&root.left==null) { //one child right
                    return new Answer(root.right,true);
            }
            else{                                   // two children
                    int rightmin=findMinimumNode(root.right);
                    root.data = rightmin;
                    Answer output = helperdelete(root.right, rightmin);
                    root.right=output.newroot;
                    return new Answer(root,true);
            }
        }
    }

    private static int findMinimumNode(BinarySearchNode<Integer> root) {
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int leftmin=findMinimumNode(root.left);
        int rightmin=findMinimumNode(root.right);
        return Math.min(root.data,Math.min(leftmin,rightmin));
    }

    public void printTree() {
        helperprintTree(root);
    }

    private static void helperprintTree(BinarySearchNode<Integer> root) {
        if(root==null){
            return;
        }
        else {
            if(root.left==null&&root.right==null){
                System.out.println(root.data);
            }
            if(root.right!=null&&root.left==null){
                System.out.println(root.data+":R:"+root.right.data);
            }
            if(root.right==null&&root.left!=null){
                System.out.println(root.data+":L:"+root.left.data);
            }
            else {
                System.out.println(root.data+":L:"+root.left.data+",R:"+root.right.data);
            }
        }
        helperprintTree(root.left);
        helperprintTree(root.right);
    }

    public boolean search(int data) {
        return helpersearch(root,data);
    }

    private static boolean helpersearch(BinarySearchNode<Integer> root, int data) {
        if(root==null){
            return false;
        }
        if(root.data==data){
            return true;
        }
        if(root.data>data){
           return helpersearch(root.left,data);
        }
        else {
            return helpersearch(root.right,data);
        }
    }
}
