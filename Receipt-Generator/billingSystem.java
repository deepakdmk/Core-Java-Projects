import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class billingSystem {


    static Scanner in = new Scanner(System.in);

    //This HashMap links the serial number of the menu item to the key and the price of the item to the value, represented by integer and double respectively.
    private static HashMap<Integer, Double> menu = new HashMap<>();
    //These 3 ArrayList is to store and create one row of information in the receipt, for example -  Item QTY Price = Tea 2 $4.00
    private static ArrayList<Double> price = new ArrayList<>();
    private static ArrayList<Integer> quantity = new ArrayList<>();
    private static ArrayList<String> item = new ArrayList<>();
    //This is static variables that will be used to store the final values of my receipt
    private static double subtotal;
    private static double tax;
    private static double tip;
    private static double totalValue;

    //Initialize the menu into the HashMap
    static {
        menu.put(1, 1.00);// coffee
        menu.put(2, 2.00);//tea
        menu.put(3, 3.00);//milo
        menu.put(4, 4.00);//sandwich
        menu.put(5, 5.00);//burger
    }

    public static void main(String[] args) {
        printMenu();
        getOrder();
        calculateBill();
        printBill();
    }

    // A Simple method that prints out the contents on the menu
    private static void printMenu() {
        System.out.println("__________________________________");
        System.out.println("                       MENU                     ");
        System.out.println("__________________________________");
        System.out.println("SN               ITEM               PRICE");
        System.out.println("__________________________________");
        System.out.println("1                Coffee                    $1");
        System.out.println("2                Tea                        $2");
        System.out.println("3                Milo                        $3");
        System.out.println("4                Sandwich               $4");
        System.out.println("5                Burger                   $5");
        System.out.println("__________________________________");
    }

    /*
    This method will capture the user's order. One loop of this method captures one item order and the quantity.
    It will capture the serialnumber of the item order and the quantity the user wants, which then gives the value to
    the generateBill() method.  It will then proceed to ask if the users want to order anymore item until they are done.
    */
    private static void getOrder() {
        boolean done = true;
        while (done) {
            int serialNo = getSerialNo();
            int quantityItem = getQuantityItem();
            generateBill(serialNo, quantityItem);
            System.out.println("Anything else?");
            System.out.println("1. Yes");
            System.out.println("2.  No");
            try {
                int check = in.nextInt();
                if (check == 2) {
                    done = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please choose a number.\n 1 for Yes\n 2 for No");
            }
        }
    }

    // This method is here to keep the code cleaner, when the user enters their order, this method will check if the serial number that the user has selected is valid before returning it to getOrder();
    private static int getSerialNo() {
        boolean checkSerial = true;
        int serialNo = 0;
        while (checkSerial) {
            try {
                System.out.println("Please enter serial number (SN) of item you want to purchase");
                serialNo = in.nextInt();
                if (serialNo < 1 || serialNo > 5) {
                    System.out.println("Error: Number chosen is not on the menu");
                    continue;
                } else {
                    checkSerial = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: That is not a valid number");
            }
            in.nextLine();
        }
        return serialNo;
    }

    //This method will capture the amount of items(quantity) of their order and ensure that the quantity entered is a number before returning it to getOrder();
    private static int getQuantityItem() {
        boolean checkQuantity = true;
        int quantityItem = 0;
        while (checkQuantity) {
            System.out.println("Please enter the quantity you would like");
            try {
                quantityItem = in.nextInt();
                checkQuantity = false;
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid number");
            }
            in.nextLine();
        }
        return quantityItem;
    }


    // Within this method, it will generate the bill. Each loop of the getOrder() method will come here,
//    it will provide the serial number and quantity, this generates one order which will be saved to the arraylist
//    this will form one row of order within the bill
    private static void generateBill(int serialNo, int quantityItem) {
        switch (serialNo) {
            case 1:
                item.add("Coffee");
                quantity.add(quantityItem);
                price.add((menu.get(serialNo) * quantityItem));
                break;
            case 2:
                item.add("Tea");
                quantity.add(quantityItem);
                price.add((menu.get(serialNo) * quantityItem));
                break;
            case 3:
                item.add("Milo");
                quantity.add(quantityItem);
                price.add((menu.get(serialNo) * quantityItem));
                break;
            case 4:
                item.add("Sandwich");
                quantity.add(quantityItem);
                price.add((menu.get(serialNo) * quantityItem));
                break;
            case 5:
                item.add("Burger");
                quantity.add(quantityItem);
                price.add((menu.get(serialNo) * quantityItem));
                break;
            default:
                //It should never reach here since there are checkers in previous method
                System.out.println("Item you have chosen is not on the menu, please try again.");
                break;
        }
    }


//This part will do the maths and calculate the subtotal, tax and also ask the user how much they would like to tip and show them the minimum value
// It will not accept any value below the minimum.
    private static void calculateBill() {
        //Calculate subtotal
        subtotal = 0.00;
        for (int i = 0; i < price.size(); i++) {
            subtotal += price.get(i);
        }
        //Calculate tax
        double onePercent = (subtotal / 100);
        tax = (onePercent * 6.75);
        //calculate tip
        boolean check = true;
        double minimumTip = (((tax + subtotal) / 100) * 10);
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        while (check) {
            System.out.println("How much would you like to tip? Minimum being: $" + twoPlaces.format(minimumTip));
            try {
                tip = in.nextDouble();
                if (tip < minimumTip) {
                    System.out.println("You cant tip below $" + twoPlaces.format(minimumTip));
                    continue;
                } else {
                    check = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: That is not a valid number");
            }
            in.nextLine();
        }
        totalValue = subtotal + tax + tip;
    }


    //This method will generate the bill
    //The arraylist is iterated through to produce all the lines which shows the receipt
    private static void printBill() {
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        System.out.println("____________________________________");
        System.out.println("                       RECEIPT                 ");
        System.out.println("____________________________________");
        System.out.println("SN        ITEM        QTY         PRICE");
        System.out.println("____________________________________");
        for (int i = 0; i < item.size(); i++) {
            System.out.print((i + 1) + "          ");
            System.out.print(item.get(i) + "           ");
            System.out.print(quantity.get(i) + "              ");
            System.out.print("$" + twoPlaces.format(price.get(i)) + "\n");
        }
        System.out.println("____________________________________");
        System.out.println("Subtotal                                  " + "$" + twoPlaces.format(subtotal));
        System.out.println("Tax(6.75%)                              " + "$" + twoPlaces.format(tax));
        System.out.println("Tip(10%)                                 " + "$" + twoPlaces.format(tip));
        System.out.println("TOTAL:                                 " + "$" + twoPlaces.format(totalValue));
    }

}