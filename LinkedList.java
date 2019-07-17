# LinkedList

public class LinkedList {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public LinkedList() {
        this.tail = null;
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(int data) {
        Node temp = new Node(data);
        if (isEmpty()) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }

    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public void pop() {
        if (isEmpty()) return;
        head = head.next;
    }

    public void popEnd() {
        if (isEmpty()) return;
        Node curr = head;
        Node prev = null;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        tail = prev;
        prev.next = null;
    }

    public boolean contains(int data) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) {
                return true;
            }
        }
        return false;
    }

    public LinkedList merge(LinkedList l2){
        return merge(head, l2.head);
    }

    private LinkedList merge(Node curr1, Node curr2){
        LinkedList merged = new LinkedList();
        while(curr1 != null && curr2 != null){
            if(curr1.data < curr2.data){
                merged.add(curr1.data);
                curr1 = curr1.next;
            } else {
                merged.add(curr2.data);
                curr2 = curr2.next;
            }
        }
        if(curr1 == null && curr2 != null){
            merged.add(curr2.data);
            curr2 = curr2.next;
        }
        if(curr1 != null && curr2 == null){
            merged.add(curr1.data);
            curr1 = curr1.next;
        }
        return merged;
    }
}
