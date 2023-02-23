import exceptions.DELinkException;

public class DELinkListTest {
    
    public static void main(String[] args) throws DELinkException {
        DELinkList<Integer> list = new DELinkList<Integer>(); 

        list.insertOrdered(1, 'a');
        list.insertOrdered(2, 'a');
        list.insertOrdered(5, 'a');
        list.insertOrdered(7, 'a');
        list.insertOrdered(10, 'a');
        list.insertOrdered(1, 'a');
        
        list.displayList();
        
        System.out.println("Primer elemento: " + list.getFirst());
        System.out.println("último elemento: " + list.getLast());

        list.deleteAt(5);    
        list.displayList(); 

        list.deleteDELink(5);    
        list.displayList(); 

        
    } 
}