package com.amit.myself;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        head.next.next.next.next.next.next.next.next.next = new Node(10);
        printList(head);
        head = reverseList(head);
        System.out.println("linked list in reverse order");
        printList(head);
        System.out.println("linked list with pair wise reversal");
        head = pairWiseReversal(head);
        printList(head);
    }

    public static Node pairWiseReversal(Node head) {
        Node temp1 = null, temp2 = null;
        while (head != null && head.next != null) {
            if(temp1 != null) {
                temp1.next.next = head.next;
            }
            temp1 = head.next;
            head.next = temp1.next;
            temp1.next = head;
            head = head.next;
            if(temp2 == null) {
                temp2 = temp1;
            }
        }
        return temp2;
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printList(Node head) {
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
class Node {
    int data;
    Node next;
    public Node(int data) {
            this.data = data;
    }
    public void setNext(Node node) {
        this.next = node;
    }
}
