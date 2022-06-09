/**
 * @author Luke
 * CSS 143 B
 * Grocery Manager HW
 */

/**
 * Abstract class to provide framework for an item
 */
public abstract class GroceryItem implements Comparable {

    String name;
    double price;
    int quantity;

    /**
     * no arg constructor
     */
    public GroceryItem()
    {
    }

    /**
     * constructor
     *
     * @param name
     * @param quantity
     * @param price
     */
    public GroceryItem(String name, int quantity, double price)
    {
        setName(name);
        setQuantity(quantity);
        setPrice(price);
    }

    /**
     * returns name
     *
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * sets the name
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * returns price
     *
     * @return
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * set the price
     *
     * @param price
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * returns the quantity
     *
     * @return
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * sets the quantity
     *
     * @param quantity
     */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    /**
     * overrides the toString method
     *
     * @return
     */
    @Override
    public String toString()
    {
        if (this.name.length() >= 10 && this.name.length() < 14)
            return "Name: " + this.name + "       " +
                    "Quantity: " + this.quantity + "      " +
                    "Price: $" + this.price + "      ";
        if (this.name.length() >= 14)
            return "Name: " + this.name + "    " +
                    "Quantity: " + this.quantity + "      " +
                    "Price: $" + this.price + "      ";
        if (this.name.length() < 10 && this.name.length() > 5)
            return "Name: " + this.name + "           " +
                    "Quantity: " + this.quantity + "      " +
                    "Price: $" + this.price + "      ";
        else {
            return "Name: " + this.name + "              " +
                    "Quantity: " + this.quantity + "      " +
                    "Price: $" + this.price + "      ";
        }

    }

    /**
     * Overrides the compareTo method for object
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o)
    {
        if (o instanceof GroceryItem) {
            GroceryItem other = (GroceryItem) o;
            if (this.name.compareTo(other.getName()) > 0) return 1;
            if (this.name.compareTo(other.getName()) < 0) return -1;
            else return 0;
        } else
            throw new ClassCastException();
    }
}
