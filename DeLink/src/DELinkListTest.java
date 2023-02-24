import domain.DELinkList;
import exceptions.DELinkException;

public class DELinkListTest {
    public static void main(String[] args) throws DELinkException {
        DELinkList<Integer> list = new DELinkList<Integer>();

        list.insertOrdered(3, 'd');
        list.insertOrdered(2, 'd');
        list.insertOrdered(5, 'd');
        list.insertOrdered(7, 'd');
        list.insertOrdered(10, 'd');
        list.insertOrdered(1, 'd');

        list.displayList();

        System.out.println("Primer elemento: " + list.getFirst());
        System.out.println("último elemento: " + list.getLast());

        list.deleteAt(5);
        list.displayList();

        list.deleteDELink(5);
        list.displayList();
    }
}
