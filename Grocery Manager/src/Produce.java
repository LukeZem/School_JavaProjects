/**
 * @author Luke
 * CSS 143 B
 * Grocery Manager HW
 */

/**
 * Class that inherits from GroceryItem to create specific grocery item
 */

import java.util.Scanner;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Produce extends GroceryItem{


    boolean isOrganic;

    /**
     * constructor takes all variables as arg
     * @param name
     * @param quantity
     * @param price
     * @param isOrganic
     */
    public Produce(String name, int quantity, double price, boolean isOrganic)
    {
        super(name, quantity, price);
        setIsOrganic(isOrganic);
    }

    /**
     * constructor takes String input from txt file
     * @param lineInput
     */
    public Produce(String lineInput)
    {
        Scanner in = new Scanner(lineInput);
        in.useDelimiter(" ");

        String type = in.next(); // just to get rid of the type sub string
        setName(in.next());
        setQuantity(parseInt(in.next()));
        setPrice(parseDouble(in.next()));
        setIsOrganic(parseBoolean(in.next()));
    }

    /**
     * returns isOrganic value
     * @return
     */
    public boolean getIsOrganic()
    {
        return isOrganic;
    }

    /**
     * sets isOrganic value
     * @param organic
     */
    public void setIsOrganic(boolean organic)
    {
        isOrganic = organic;
    }

    /**
     * overrides toString method
     * @return
     */
    public String toString()
    {
        return super.toString() + "isOrganic: " + isOrganic;
    }
}
