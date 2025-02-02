//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.lang.reflect.Array;
import java.util.*;

//thrift store - creating all the items
//hard coded items and prices
//make exceptions for the code -
//more or less items - how many items are in the cart

public class Main {
    public static void main(String[] args) {
        Item item1 = null;//initializing items
        ArrayList <Item> cart = createCart(args, setupStore());
        printReceiptInOrder(cart);
    }
    //initializing items within the store and returning
    //want to use the arrayList
    public static ArrayList <Item> setupStore() {
        ArrayList <Item> defaultItems = new ArrayList <Item>();
        Item Shirt = new Item("Shirt", 5.00);
        defaultItems.add(Shirt);//item 0
        Item Shoes = new Item("Shoes", 10.00);
        defaultItems.add(Shoes);//item 1
        Item Pants = new Item("Pants", 8.00);
        defaultItems.add(Pants);//item 2
        Item Dress = new Item("Dress", 9.00);
        defaultItems.add(Dress);//item 3
        Item Hat = new Item("Hat", 3.00);
        defaultItems.add(Hat);//item 4
        return defaultItems;

    }
    //create cart method
    public static ArrayList<Item> createCart(String[] argInTerminal, ArrayList<Item>
                                             accessibleItems) {
        /*
        Use an ArrayList to create a cart based on the items available in the store.
        Inside this method:
        Check for exceptions and invalid input.
        Return an ArrayList containing the items in the cart.
         */

        //Read a token n from the command line.

        ArrayList <Item> itemsInCart = new ArrayList<Item>();
        ArrayList <Integer> numToConvertInList = new ArrayList<Integer>();

        for (int i = 0; i < argInTerminal.length; i++) {
            try{
                numToConvertInList.add(Integer.parseInt(argInTerminal[i]));
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid argument " + argInTerminal[i]);
                e.printStackTrace();
            }
        }
        //processing item numbers to items
        for (int currNumber: numToConvertInList) {
            try{
                if (currNumber >= 0 && currNumber < accessibleItems.size()) {
                    itemsInCart.add(accessibleItems.get(currNumber));
                }
                else{
                    System.out.println ("Invalid argument " + currNumber);
                }
            }
            catch (NumberFormatException e) {
                System.out.println ( e.getMessage()+ " Invalid argument " + currNumber);
            }

        }
        return itemsInCart;
    }

    //Create a method called printReceiptInOrder:
    public static void printReceiptInOrder(ArrayList<Item> itemsInCart) {
        //initializing subtotal outside
        double subtotal = 0;
        System.out.println("\nReceipt: ");
        for (Item item: itemsInCart) {
            System.out.println(item.getItemName() + " - $ " + item.getItemPrice());
            subtotal += item.getItemPrice();
        }
        double tax = subtotal * 0.05;
        double total = subtotal + tax;
        System.out.printf("Subtotal: $ %.2f%n", subtotal);
        System.out.printf("Tax: $ %.2f%n", tax);
        System.out.printf("Total: $ %.2f%n", total);
    }

    /*
    Print out:
The list of items with their prices in order.
Subtotal.
Sales tax (5%).
Total.
Create a method called emptyCartReverseOrder:

     */
    /*
    Instructions:
You are to simulate a shopping experience where all the input comes exclusively
from the command line. For each valid request, update the amount due
subtotal in the shopping basket. Once all the command-line requests are processed,
compute and display the sales tax and total due.




Print the last item on the list.
Remove that item from the list.
Repeat until the cart is empty.
Analyze Running Times:

Write (in a separate text file, to be committed to GitHub) your answers for the running times of the following methods:
printReceiptInOrder
emptyCartReverseOrder
Use Big-Oh notation based on the methods’ implementations.

     */
}
