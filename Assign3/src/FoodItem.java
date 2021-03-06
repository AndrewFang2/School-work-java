import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * declare all the values and set them into a value
 * Student Name: Andrew Fang
 * Student Number: 040974861
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @Professor James Mwangi PhD.
 * @version 2020-08-05
 */
public class FoodItem {
    protected int itemCode, itemQuantityInStock;
    protected String itemName;
    protected float itemPrice, itemCost;
    DecimalFormat df = new DecimalFormat("#.00");
    /**Initialize value*/
    public FoodItem() {
        itemCost = 0;
        itemQuantityInStock = 0;
        itemName = "";
        itemPrice = 0;
        itemCost = 0;
    }
    /**Create a string to document the item*/
    public String toString() {
        System.out.println("Inventory: ");
        String str = "\n";
        return str;
    }
    /**
     * Updates the item quantity
     * @param amount the amount you enter to the buy or sell
     * @return false when less then 0 and return true else
     */
    public boolean updateItem(int amount) {
        int total = amount + itemQuantityInStock;
        if(total<0){
            return false;
        }else{
            itemQuantityInStock = total;
            return true;
        }

    }
    /**
     * check if any value equal each other
     * @param foodItem check if the item itemCode exist
     * @return if it is true or false
     */
    public boolean isEqual(FoodItem foodItem) {
        return foodItem.itemCode == itemCode;
    }
    /**
     * ask for value to enter and add them to the items
     * @param scanner Take in variables
     * @return always return true
     */
    public boolean addItem(Scanner scanner){
        scanner = new Scanner(System.in);
        System.out.print("Enter the name for the item: ");
        itemName = scanner.nextLine();
        boolean invalid = false;
        do {
            try {
                System.out.print("Enter the cost of the item: ");
                itemPrice = scanner.nextFloat();
                if (itemPrice > 0)
                    invalid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry");
                scanner.next();
            }
        } while (!invalid);
        invalid = false;
        do {
            try {
                System.out.print("Enter the sales price of the item: ");
                itemCost = scanner.nextFloat();
                scanner.nextLine();
                if (itemCost > 0)
                    invalid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid entry");
                scanner.next();
            }
        } while (!invalid);
        return true;
        }
    /**
     * ask you to input only the code
     * @param scanner Take in variables
     * @return always return true
     */
    public boolean inputCode(Scanner scanner) {
        boolean valid = false;
        do {
            System.out.print("Enter the code for the item: ");
            if (scanner.hasNextInt()) {
                itemCode = scanner.nextInt();
                valid = true;
            } else {
                System.out.println("Invalid entry");
                scanner.next();
            }
        }while(!valid);
        return true;
    }
    /**
     * gives itemCode
     * @return itemCode
     */
    public int getItemCode(){
        return itemCode;
    }
    /**
     * format for the file
     * @param writer the format
     */
    public void outputItem(Formatter writer){
        writer.format("\n%d", itemCode);
        writer.format("\n%s", itemName);
        writer.format("\n%d", itemQuantityInStock);
        writer.format("\n%.2f", itemPrice);
        writer.format("\n%.2f", itemCost);
    }
}
