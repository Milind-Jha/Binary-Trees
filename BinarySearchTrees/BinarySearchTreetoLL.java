package BinarySearchTrees;

import BinaryTrees1.BinaryNode;

public class BinarySearchTreetoLL {
    public static LinkedListNode<Integer> constructLinkedList(BinarySearchNode<Integer> root) {
        if(root==null){
            return null;
        }
        LinkedListNode<Integer> head = constructLinkedList(root.left);
        int x = root.data;
        LinkedListNode<Integer> body = new LinkedListNode<>(x);
        LinkedListNode<Integer> tail = constructLinkedList(root.right);
        if(head==null){
            body.next=tail;
            return body;
        }
        LinkedListNode<Integer> temp = head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=body;
        body.next=tail;
        return head;
    }
}
