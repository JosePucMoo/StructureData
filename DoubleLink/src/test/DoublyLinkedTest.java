package test;

import domain.DoublyLinkedList;
import exception.ErrorDoubleLinkedList;

public class DoublyLinkedTest {
    public static void main(String[] args) throws ErrorDoubleLinkedList {
    DoublyLinkedList<Integer> theList = new DoublyLinkedList<>();
    theList.inserDataOrder(10, 'a');
    theList.inserDataOrder(0, 'a');
    theList.inserDataOrder(3, 'a');
    theList.inserDataOrder(4, 'a');
    theList.inserDataOrder(9, 'a');
    theList.inserDataOrder(5, 'a');
    theList.inserDataOrder(7, 'a');
    theList.inserDataOrder(6, 'a');

    System.out.println("Primer elemento: " + theList.getFirstDoublyLink().getdData());
    System.out.println("Ãšltimo elemento: " + theList.getLastDoublyLink().getdData());
    System.out.println("Size: " + theList.size());

    theList.displayForward(); 
    theList.displayBackward(); 

    theList.deleteDoublyLinkPosition(7);

    theList.displayForward(); 
    theList.displayBackward();

    } 
}