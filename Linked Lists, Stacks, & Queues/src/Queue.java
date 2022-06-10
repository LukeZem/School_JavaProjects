/**
 * @author luke
 * Class CSS 143
 * HW: Linked Lists, Stacks, & Queues
 */

/**
 * A class to create a queue using the inherited linked list class "List"
 */
public class Queue extends List{

    /**
     * Adds objects into the back of the queue start FIFO
     * @param toAdd
     * @throws LinkedListException
     */
    public void enqueue(Object toAdd) throws LinkedListException
    {
        if(isEmpty())
            super.insert(toAdd, 0);
        else
            super.insert(toAdd, size());
    }

    /**
     * removes object from the front of the queue FIFO
     * @return
     * @throws LinkedListException
     */
    public Object dequeue() throws LinkedListException
    {
        if(isEmpty())
            throw new LinkedListException("Queue is empty");
        else
            return super.remove(0);
    }

    @Override
    public void insert(Object toAdd, int index) throws LinkedListException
    {
        enqueue(toAdd);
    }

    @Override
    public Object remove(int index) throws LinkedListException
    {
        return dequeue();
    }

    /**
     * Main method for testing
     * @param args
     */
    public static void main(String [] args)
    {
        Queue q = new Queue();
        try
        {
            for (int i = 1; i <= 10; i++)
                q.enqueue(i);
            System.out.println("Should be 1 - 10");
            while(!q.isEmpty())
                System.out.print(q.dequeue() + " ");
        }catch (LinkedListException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println();
        try
        {
            System.out.println("should throw empty queue exception");
            q.dequeue(); // should throw exception
        } catch (LinkedListException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
