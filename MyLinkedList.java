package classes_objects;
public class MyLinkedList {

    //create node of linked list
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //add at first of classes_objects.LinkedList
    public void addFirst(int data) {
        size++;
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    //add at the end of classes_objects.LinkedList
    public void addLast(int data) {
        size++;
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    //add at the given index of linked list
    public void addAtIndex(int index, int data) {
        size++;
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;

        while(i < index - 1) {
            temp = temp.next;
            i++;
        }

        newNode = temp.next;
        temp.next = newNode;
    }

    //print the elements of the classes_objects.LinkedList
    public void print() {
        if(head == null) {
            System.out.println("classes_objects.LinkedList is Empty!!!");
            return;
        }

        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    //remove the first element of linked list
    public int removeFirst() {
        if(size == 0) {
            System.out.println("Linked list is Empty!!!");
            return -1;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    //remove last element of classes_objects.LinkedList
    public int removeLast() {
        if(size == 0) {
            System.out.println("classes_objects.LinkedList is Empty!!!");
            return -1;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        Node prev = head;
        for(int i = 1; i < size - 1; i++) {
            prev = prev.next;
        }

        int val = prev.next.data;
        tail = prev;
        size--;
        return val;
    }

    //remove given index element from linked list
    public int removeIndex(int index) {
        Node prev = head;
        for(int i = 1; i < index-2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    //search iteratively in linked list
    public int itrSearch(int key) {
        Node temp = head;
        int i = 1;
        while(temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        return -1;
    }

    //helper function for recursive search
    public int helper(Node head, int key) {
        if(head == null) {
            return -1;
        }
        if(head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);
        if(idx == -1) {
            return -1;
        }
        return idx+1;
    }

    //recursive search
    public int recSearch(int key) {
        return helper(head, key);
    }

    //reverse Linked List
    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    //delete Nth node from end if the linked list
    public void deleteNthFromEnd(int n) {
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }
        if(n == sz) {
            head = head.next;
        }

        int i = 1;
        Node prev = head;
        while(i < n-sz) {
            prev = prev.next;
            i++;
        }
        prev = prev.next.next;
        return;
    }

    //find mid of the linked list
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
