/**
 * @author Luke
 * CSS 143 B
 * Grocery Manager HW
 */

/**
 * Class that inherits from GroceryItem to create specific grocery product
 */

import java.util.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Dairy extends GroceryItem{

    int refrigerationTemperature;

    /**
     * constructor takes all variables as arg
     * @param name
     * @param quantity
     * @param price
     * @param refrigerationTemperature
     */
    public Dairy(String name, int quantity, double price, int refrigerationTemperature)
    {
        super(name, quantity, price);
        setRefrigerationTemperature(refrigerationTemperature);
    }

    /**
     * constructor takes String input from txt file
     * @param lineInput
     */
    public Dairy(String lineInput)
    {
        Scanner in = new Scanner(lineInput);
        in.useDelimiter(" ");

        String type = in.next(); // just to get rid of the type sub string
        setName(in.next());
        setQuantity(parseInt(in.next()));
        setPrice(parseDouble(in.next()));
        setRefrigerationTemperature(parseInt(in.next()));
    }

    /**
     * returns temp value
     * @return
     */
    public int getRefrigerationTemperature()
    {
        return refrigerationTemperature;
    }

    /**
     * sets temp value
     * @param refrigerationTemperature
     */
    public void setRefrigerationTemperature(int refrigerationTemperature)
    {
        this.refrigerationTemperature = refrigerationTemperature;
    }

    /**
     * overrides the toString
     * @return
     */
    public String toString()
    {
        return super.toString() + "temperature: " + refrigerationTemperature;
    }
}
