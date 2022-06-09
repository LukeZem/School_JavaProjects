import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
/**
 * @author Luke
 * CSS 143 B
 * Grocery Manager HW
 */

/**
 * Class inherits from GroceryItem to create specific grocery item
 */
public class Meat extends GroceryItem{

    boolean isGround;

    /**
     * constructor takes all variables as arg
     * @param name
     * @param quantity
     * @param price
     * @param isGround
     */
    public Meat(String name, int quantity, double price, boolean isGround)
    {
        super(name, quantity, price);
        setIsGround(isGround);
    }

    /**
     * constructor takes String input from txt file
     * @param lineInput
     */
    public Meat(String lineInput)
    {
        Scanner in = new Scanner(lineInput);
        in.useDelimiter(" ");

        String type = in.next(); // just to get rid of the type sub string
        setName(in.next());
        setQuantity(parseInt(in.next()));
        setPrice(parseDouble(in.next()));
        setIsGround(parseBoolean(in.next()));
    }

    /**
     * returns isGround value
     * @return
     */
    public boolean getIsGround()
    {
        return isGround;
    }

    /**
     * sets isGround value
     * @param ground
     */
    public void setIsGround(boolean ground)
    {
        isGround = ground;
    }

    /**
     * overrides toString method
     * @return
     */
    public String toString()
    {
        return super.toString() + "isGround: " + isGround;
    }
}
