import java.text.DecimalFormat;
import java.util.Scanner;

/**this lab calculates the users bmi based on string and int input
 * @version 11/09/21
 * @author 22oehler (worked with jackson on code in main)
 */
public class BMICalculator {
    /**
     * this gets the inches out of the inches
     * @param value
     * @return
     */
    public static int extractInch(String value) {
        int qtPos = value.indexOf(("'"));
        int dblQtPos = value.indexOf("\"");
        if (qtPos == -1 || dblQtPos == -1) {
            return -1;
        }

        int feet = Integer.parseInt(value.substring(0, qtPos));
        int inches = Integer.parseInt(value.substring(qtPos + 1, dblQtPos));

        if(inches < 0 || inches > 11 || feet < 0)
            return -1;

        return feet * 12+ inches;
    }
    /** convert bmi
     *
     * @param inches
     * @param pounds
     * @return
     */
    public static double computeBMI(int inches, int pounds) {
        if(inches <= 0 || pounds <= 0)
            return 0;
        return pounds * 0.454 / Math.pow(inches * 0.0254, 2);
    }

    /**
     * main runs program and gets data
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        String height = " ";
        int weight = 0;
        while(true) {
            try {
                height = " ";
                while(extractInch(height) == -1) {
                    System.out.println("Please enter height in the ft'in\" format: ");
                    height = in.nextLine();
                }
                System.out.println("Enter weight in pounds: ");
                weight = in.nextInt();
                in.nextLine();
                //print bmi
                System.out.println("Your bmi is " + computeBMI(extractInch(height), weight));

                System.out.println("Continue (Y/N)");
                String cont = in.nextLine();
                if (cont.toUpperCase().equals("N"))
                    break;
            }
            catch(Exception e) {
                weight = 0;
                System.out.println("STOP ENTERING INVALID DATA");}
            }
        System.out.println("End of program");
    }
}
