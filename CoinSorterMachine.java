import javax.swing.*;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * coin sorter machine takes a list of coins and sorts them and adds up their values
 */
public class CoinSorterMachine {
    private ArrayList<Coin> coins;
    public int coinVal;
    public int numP, numDi, numN, numQ, numHD, numD;
    //private ArrayList<String> beforeCoin;
    // initializes coins ArrayList

    /**
     * initializes coins array list
     */
    public CoinSorterMachine() {
        coins = new ArrayList<>();
        //beforeCoin = new ArrayList<>();
    }
    // use one or two Scanner objects, prompting user for the appropriate file
    // name and importing the data from filename – MUST handle diabolic values!

    /**
     * this deposits the coins using scanner
     */
    public void depositCoins() {
        try{
            Scanner userIn = new Scanner(System.in);
            System.out.print("Enter the name of the data file for coin deposit: ");
            String file = userIn.nextLine();
            Scanner in = new Scanner(new File("datafiles/" + file));
            System.out.println("Depositing coins...");
            while(in.hasNext()) {
                int coinVal = in.nextInt();
                if(coinVal == 1) {
                    coins.add(new Penny());
                    numP ++;
                }
                else if(coinVal == 5) {
                    coins.add(new Nickel());
                    numN ++;
                }
                else if(coinVal == 10) {
                    coins.add(new Dime());
                    numDi ++;
                }
                else if(coinVal == 25) {
                    coins.add(new Quarter());
                    numQ ++;
                }
                else if(coinVal == 50) {
                    coins.add(new HalfDollar());
                    numHD ++;
                }
                else if(coinVal == 100) {
                    coins.add(new Dollar());
                    numD ++;
                }
                else {
                    System.out.println("Coin value " + coinVal + " not recognized");
                }
            }
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Prints deposit summary using a DecimalFormat object (see output section)

    /**
     * prints out numbers of coins and their values, I hardcoded
     */
    public void printDepositSummary() {
        DecimalFormat df = new DecimalFormat("$0.00");
        System.out.println("Summary of deposit:");
        if (numP == 1)
            System.out.println(numP + " penny " + df.format(numP * 0.01));
        else
            System.out.println(numP + " pennies " + df.format(numP * 0.01));
        if (numN == 1)
            System.out.println(numN + " nickel " + df.format(numN * .05));
        else
            System.out.println(numN + " nickels " + df.format(numN * .05));
        if (numDi == 1)
            System.out.println(numDi + " dime " + df.format(numDi * 0.10));
        else
            System.out.println(numDi + " dimes " + df.format(numDi * 0.10));
        if (numQ == 1)
            System.out.println(numQ + " quarter " + df.format(numQ * 0.25));
        else
            System.out.println(numQ + " quarters " + df.format(numQ * 0.25));
        if (numHD == 1)
            System.out.println(numHD + "half dollar" + df.format(numHD * 0.50));
        else
            System.out.println(numHD + " half dollars " + df.format(numHD * 0.50));
        if (numD == 1)
            System.out.println(numD + " dollar " + df.format(numD));
        else
            System.out.println(numD + " dollars " + df.format(numD));
        System.out.println("TOTAL DEPOSIT: " + df.format(getTotalValue()));
    }
    // return the total value of all Coin objects stored in coins as a double

    /**
     * gets total value of all coins
     * @return total
     */
    public double getTotalValue() {
        double total = 0;
        for(Coin c : coins)
            total += c.getValue();
        return total;
        //return (numP + (numN*5) + (numDi*10) + (numQ*25) + (numHD*50) + (numD*100));
    }
    // main method for the class should use these exact three lines of code

    /**
     * main method, runs machine
     * @param args
     */
    public static void main(String[] args){
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
}
