/**
 * @author Lucas Z
 * Class: CSS 143
 * HW: Linked Lists, Stacks, & Queues
 */

/**
 * Class to create a singly linked list
 */
public class List {

    private Node head;

    /**
     * Inner class to create Nodes for list
     */
    public class Node {
        Object data;
        Node next;

        Node(Object data)
        {
            this.data = data;
        }
    }

    /**
     * Inserts object at given index, pushing any remaining objects in list forward
     *
     * @param toAdd
     * @param index
     * @throws LinkedListException
     */
    public void insert(Object toAdd, int index) throws LinkedListException
    {
        Node newNode = new Node(toAdd);
        Node current = head;
        Node prev = head;
        int count = 0;
        if (index > size() || index < 0)
            throw new LinkedListException("Index out of bounds");
        if (head == null) // empty list case
        {
            head = newNode;
            return;
        }
        if (head.next == null)// single list case
        {
            if (index == 1) // adding to tail
            {
                current.next = newNode;
                return;
            }
            newNode.next = head; // adding to head otherwise
            head = newNode;
            return;
        }
        if (index == 0)
        {
            newNode.next = head;
            head = newNode;
            return;
        }
        while (current.next != null && index != count)//multiple list case
        {
            count++;
            prev = current;
            current = current.next;
        }
        if (current.next == null && index == size())//appending to tail case
        {
            current.next = newNode;
        } else                    //inserting in middle case
        {
            prev.next = newNode;
            newNode.next = current;
        }
        return;
    }

    /**
     * Removes the object from the list at the given index
     *
     * @param index
     * @return
     * @throws LinkedListException
     */
    public Object remove(int index) throws LinkedListException
    {
        if (head == null)
            throw new LinkedListException("List is empty");
        if (index >= size() || index < 0)
            throw new LinkedListException("Index out of bounds");
        if (head.next == null) // single element case
        {
            Node temp = head;
            head = null;
            return temp.data;
        }
        //greater than one element
        if (index == 0)//if just removing head
        {
            Node temp = head;
            head = head.next;
            return temp.data;
        }
        //index given in beyond the head
        int count = 0;
        Node current = head;
        Node prev = head;
        while (index != count && current.next != null)
        {
            prev = current;
            current = current.next;
            count++;
        }
        Node temp = current;
        if (current.next == null)
        {
            prev.next = null;
        } else
        {
            prev.next = current.next;
        }
        return temp.data;
    }

    /**
     * Functions exactly like remove, deleting element at the given index
     *
     * @param index
     * @return
     * @throws LinkedListException
     */
    public Object delete(int index) throws LinkedListException
    {
        if (head == null)
            throw new LinkedListException("List is empty");
        if (index >= size() || index < 0)
            throw new LinkedListException("Index out of bounds");
        if (head.next == null) // single element case
        {
            Node temp = head;
            head = null;
            return temp.data;
        }
        //greater than one element
        if (index == 0)//if just removing head
        {
            Node temp = head;
            head = head.next;
            return temp.data;
        }
        //index given in beyond the head
        int count = 0;
        Node current = head;
        Node prev = head;
        while (index != count && current.next != null)
        {
            prev = current;
            current = current.next;
            count++;
        }
        Node temp = current;
        if (current.next == null)
        {
            prev.next = null;
        } else
        {
            prev.next = current.next;
        }
        return temp.data;
    }

    /**
     * appends an object to list (This functions as an append method)
     * wasn't sure what to name it as the assignment gives contradictory instruction
     *
     * @param toAdd
     * @throws LinkedListException
     */
    public void addToEnd(Object toAdd) throws LinkedListException
    {
        insert(toAdd, size());
    }

    /**
     * Returns the index of the given object within the list
     *
     * @param target
     * @return
     */
    public int indexOf(Object target) throws LinkedListException
    {
        int count = 0;
        Node current = head;
        while (current.next != null && current.data != target)
        {
            current = current.next;
            count++;
        }
        if (current.data == target)
            return count;
        throw new LinkedListException("Target not found");
    }

    /**
     * Calculates the size of the list
     *
     * @return
     */
    public int size()
    {
        int count = 0;
        Node current = head;
        while (current != null)
        {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Checks if list is empty
     *
     * @return
     */
    public boolean isEmpty()
    {
        if (head == null)
            return true;
        else return false;
    }

    public String toString()
    {
        String str = "( ";
        Node current = head;
        while (current != null)
        {
            str += current.data + " ";
            current = current.next;
        }
        str += ")";
        return str;
    }

    /**
     * clears the list (for testing purposes)
     */
    public void clear()
    {
        head = null;
    }

    /**
     * Main method for testing
     *
     * @param args
     */
    public static void main(String[] args)
    {
        List L = new List();
        List E = new List();
        List oneE = new List();
        try
        {
            L.insert(10, 0);
            System.out.println("Should be just 10: " + L);
            L.insert(20, 1);
            L.insert(30, 2);
            L.insert(40, 3);
            L.insert(50, 4);
            System.out.println("Should now have additional inputs: " + L);
            System.out.println("Testing indexOf, should be 0: " + L.indexOf(10));
            System.out.println("Testing indexOf, should be 4: " + L.indexOf(50));
            System.out.println("Testing size(), should be 5: " + L.size());
            L.remove(4);
            L.remove(0);
            L.delete(0);
            System.out.println("Should only have 30, 40: " + L);
            System.out.println("Should be false: " + L.isEmpty());
            System.out.println("Should be true: " + E.isEmpty());
            //boundary testing for insert, indexOf
//            L.indexOf(200);
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
            System.out.println("should be 1 2 3: " + L);
            //boundary testing for remove
//            L.remove(100);
            L.remove(-100);

        } catch (LinkedListException e)
        {
            System.out.println(e.getMessage());
        }

        try
        {
            oneE.insert(1, 0);
            oneE.remove(0); // testing remove method on single element case
            System.out.println("should be ( ): " + oneE);
        } catch (LinkedListException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
