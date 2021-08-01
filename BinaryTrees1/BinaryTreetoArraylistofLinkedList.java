package BinaryTrees1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreetoArraylistofLinkedList {
    public static ArrayList<LinkedListNode<Integer>> constructLinkedListofeachlevel(BinaryNode<Integer> root){
        Queue<BinaryNode<Integer>> elements = new LinkedList<>();
        elements.add(root);
        elements.add(null);
        LinkedListNode<Integer> head=new LinkedListNode<>();
        LinkedListNode<Integer> tail=new LinkedListNode<>();
        LinkedListNode<Integer> current=new LinkedListNode<>();
        ArrayList<LinkedListNode<Integer>> output = new ArrayList<>();

        while (!elements.isEmpty()){
            BinaryNode<Integer> temp = elements.remove();
            if(temp!=null){
                current.data=temp.data;
            }
            if(temp==null){
                if(!elements.isEmpty()){
                    elements.add(null);
                }
            }
            else if(temp.left!=null&&temp.right!=null){
                elements.add(temp.left);
                elements.add(temp.right);
            }
            else if(temp.left==null&&temp.right!=null){
                elements.add(temp.right);
            }
            else if(temp.right==null&&temp.left!=null){
                elements.add(temp.left);
            }

            else {
                current=null;
            }
            if(current==null){
                output.add(head);
                head=null;
                tail=null;
            }
            if(current.data!=null){
                LinkedListNode<Integer> n = current;
                if (head==null&&tail==null){
                    head=n;
                    tail=head;
                }
                if(head!=null&&n!=null){
                    while (tail.next!=null){
                        tail=tail.next;
                    }
                    tail.next=n;
                    tail=n;
                }
                if(n==null){
                    output.add(head);
                    head = null;
                    tail = null;
                }
            }

            elements.remove();
        }
        return output;
    }
}
