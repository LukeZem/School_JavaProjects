/**
 * @author Luke
 * CSS 143 B
 * Grocery Manager HW
 */

public class GroceryException extends Exception{

    /**
     * default constructor
     */
    public GroceryException()
    {
        super();
    }

    /**
     * constructor
     * @param message
     */
    public GroceryException(String message)
    {
        super(message);
    }
}
