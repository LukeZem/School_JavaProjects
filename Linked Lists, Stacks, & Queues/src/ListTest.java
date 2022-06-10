/**
 * @author luke
 * Class CSS 143
 * HW: Linked Lists, Stacks, & Queues
 */

public class ListTest {

    public static void main(String[] args)
    {
        List L = new List();
        List E = new List();
        try
        {
            L.insert(1, 0);
            L.insert(2, 1);
            L.insert(3, 2);
            L.insert(4, 3);
            L.insert(5, 4);
            System.out.println(L);
            System.out.println(L.size());
            L.remove(1);
            System.out.println(L);
            System.out.println("Should be false: " + L.isEmpty());
            System.out.println("Should be true: " + E.isEmpty());
            System.out.println("Should be 0: " + L.indexOf(1));
//            L.insert(20, 20);
            L.insert(20, -20);
        } catch (LinkedListException e)
        {
            System.out.println(e.getMessage());
        }
        L.clear();
        try
        {
            L.insert(1, 0);
            L.insert(2, 1);
            L.addToEnd(3);
            System.out.println(L);
//            L.remove(100);
            L.remove(-100);

        } catch (LinkedListException e)
        {
            System.out.println(e.getMessage());
        }

    }


}


//        try
//        {
//
//        }catch (LinkedListException e)
//        {
//            System.out.println(e.getMessage());
//        }