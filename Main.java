package classes_objects;

public class Main {
    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addAtIndex(2,3);
        ll.print();


    }
}
