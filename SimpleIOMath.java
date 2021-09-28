import java.util.Scanner;
import java.lang.Math;
/**
 * SimpleIOMath is next lab
 * @verson 09/21/2021
 * @author Lars Oehler
 */
public class SimpleIOMath {
    private String name;
    private int age;
    private int favNumber;

    private int smallestPrime(int num) {
        int smallest = 2;
        for (int i = 2; i <= (int) (Math.sqrt(num)) + 1; i++) {
            if (num % i == 0) {
                return i;
            }
        }
        return num;
    }
    /**
     *promptUser gets all the information from the user
     */
    public void promptUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("* Sit yourself down, take a seat *\n" +
                "* All you gotta do is repeat after me *");
        System.out.println("Question 1: What is your name? ");
        name = input.nextLine();
        System.out.println("Question 2: How old are you? ");
        age = input.nextInt();
        System.out.println("Question 3: What is your favorite number? ");
        favNumber = input.nextInt();
    }
    /**
     * printInfo is method to print the info which promptUser got
     */
    public void printInfo() {
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        System.out.println("Your next birthday you will be " + (age + 1) + ".");
        System.out.println("The first prime factor of " + age + " is: " + smallestPrime(age));
        System.out.println("Your favorite number is: " + favNumber);
        System.out.println("Your favorite number squared is: " + (favNumber * favNumber));
            }
    public static void main(String[] args) {
        SimpleIOMath obj = new SimpleIOMath();
        obj.promptUser();
        obj.printInfo();
    }
}



