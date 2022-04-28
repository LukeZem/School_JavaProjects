/**
 * @author luke
 * Class: CSS 143
 * HW: Recursion
 */

/**
 * Class that create custom exception if Item is not found
 */

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException()
    {
        super("Item not found");
    }

    public ItemNotFoundException(String msg)
    {
        System.out.println(msg);
    }
}