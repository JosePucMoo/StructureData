package test;
import domain.LinkList;
import exceptions.ErrorDeleteItem;

public class App {
    public static void main(String[] args) throws ErrorDeleteItem {
        

        LinkList<Integer> list = new LinkList<Integer>();

        list.insertOrdered(3, 'd');
        list.insertOrdered(2, 'd');
        list.insertOrdered(5, 'd');
        list.insertOrdered(7, 'd');
        list.insertOrdered(1, 'd');
        list.insertOrdered(10, 'd');
        list.showList();

    }
}
