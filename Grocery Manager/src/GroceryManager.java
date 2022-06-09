/**
 * @author Luke
 * CSS 143 B
 * Grocery Manager HW
 */

/**
 * Class that manages the grocery orders and inventory
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class GroceryManager {

    private ArrayList<GroceryItem> inventory = new ArrayList<>();
    private HashSet<String> restockingList = new HashSet<>();

    public GroceryManager()
    {

    }

    /**
     * scans inventory from file input and loads into ArrayList
     *
     * @param filename
     */
    public void loadInventory(String filename)
    {
        try {
            Scanner in = new Scanner(new FileInputStream(filename));
            String line = in.nextLine();
            for (int i = 0; i < 12; i++) {
                inventory.add(new Dairy(in.nextLine()));
            }
            for (int i = 0; i < 13; i++) {
                inventory.add(new Produce(in.nextLine()));
            }
            for (int i = 0; i < 4; i++) {
                inventory.add(new Meat(in.nextLine()));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    /**
     * subtracts the quantities of the orderItems from the inventory items
     *
     * @param order
     * @throws GroceryException
     */
    public void processOrder(GroceryOrder<GroceryItem> order) throws GroceryException
    {
        for (GroceryItem orderItem : order) {
            for (GroceryItem item : inventory) {
                try {
                    if (item.getName().compareTo(orderItem.getName()) == 0) {

                        if (orderItem.getQuantity() >= item.getQuantity()) {
                            item.setQuantity(0);
                            restockingList.add(item.getName());
                            throw new GroceryException("out of " + item.getName());
                        }
                        if (orderItem.getQuantity() < item.getQuantity()) {
                            item.setQuantity(item.getQuantity() - orderItem.getQuantity());
                        }
                    }
                } catch (GroceryException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    /**
     * finds and returns item if it exists
     *
     * @param name
     * @return
     */
    public GroceryItem findItemByName(String name)
    {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equals(name))
                return inventory.get(i);
        }
        return null;
    }

    /**
     * bubble sorts the items by name
     */
    public void sortInventoryByName()
    {
        int n = inventory.size();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (inventory.get(j - 1).compareTo(inventory.get(j)) == 1) {
                    GroceryItem temp = inventory.get(j - 1);
                    inventory.set(j - 1, inventory.get(j));
                    inventory.set(j, temp);
                }
            }
        }
    }

    /**
     * sorts the item by price using insertion sort algorithm
     */
    public void sortInventoryByPrice()
    {
        int n = inventory.size();
        for (int i = 0; i < n; ++i) {
            GroceryItem current = inventory.get(i);
            int prev = i;

            while (prev > 0 && inventory.get(prev - 1).getPrice() > current.getPrice()) {
                GroceryItem temp = inventory.get(prev - 1);
                inventory.set(prev - 1, current);
                inventory.set(prev, temp);
                prev--;
            }
        }
    }

    /**
     * Prints the list of items that need to get restocked
     */
    public void displayRestockingList()
    {
        Iterator<String> list = restockingList.iterator();
        while (list.hasNext()) {
            System.out.println(list.next());
        }
//        for (String item : restockingList)
//            System.out.println(item);
    }

    /**
     * Prints the inventory list
     */
    public void displayInventory()
    {
        for (int i = 0; i < inventory.size(); i++)
            System.out.println(inventory.get(i));
    }
}
