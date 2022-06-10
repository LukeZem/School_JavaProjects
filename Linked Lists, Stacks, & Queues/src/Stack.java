/**
 * @author luke
 * Class CSS 143
 * HW: Linked Lists, Stacks, & Queues
 */

/**
 * class to create a Stack object using the inherited Linked list class "List"
 */
public class Stack extends List {

    /**
     * Adds an object to the top of the stack
     * @param toAdd
     * @throws LinkedListException
     */
    public void push(Object toAdd) throws LinkedListException
    {
        super.insert(toAdd, 0);
    }

    /**
     * Removes the first object off the top of the stack
     * @return
     * @throws LinkedListException
     */
    public Object pop() throws LinkedListException
    {
        return super.remove(0);
    }

    /**
     * Overrides the List insert method
     * @param toAdd
     * @param index
     * @throws LinkedListException
     */
    @Override
    public void insert(Object toAdd, int index) throws LinkedListException
    {
        push(toAdd);
    }

    /**
     * Overrides the List remove method
     * @param index
     * @return
     * @throws LinkedListException
     */
    @Override
    public Object remove(int index) throws LinkedListException
    {
        return pop();
    }

    /**
     * Main method for testing
     * @param args
     */
    public static void main(String[] args)
    {
        Stack S = new Stack();
        String str = "food";
        System.out.println("String to reverse: " + str);
        try //trying reversal of string using stack object
        {
            for (int i = 0; i < str.length(); i++)
                S.push(str.charAt(i));
            System.out.print("should be doof: ");
            while(!S.isEmpty())
                System.out.print(S.pop());
        } catch (LinkedListException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println();
        System.out.println("Should throw empty list exception");
        try
        {
            S.pop(); // should throw exception
        }catch (LinkedListException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
