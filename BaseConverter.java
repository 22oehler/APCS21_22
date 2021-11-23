import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
/**
 * BaseConverter gets an open data file, reads, converts numbers, prints
 * @version Thursday 11/10/21
 * @author 22oehler
 */
public class BaseConverter {
    //constructor for class
    public BaseConverter() {

    }

    /**
     * converts 2 strings into int and returns variable sum
     * @param num
     * @param fromBase
     * @return
     */
    public int strToInt(String num, String fromBase) {
        int base = Integer.parseInt(fromBase);
        String alpha = "0123456789ABCDEF";
        int sum = 0;
        int exp = 0;
        for(int i = num.length()-1; i >= 0; i--) {
            sum += alpha.indexOf(num.charAt(i))* Math.pow(base, exp);
            exp ++;
        }
        return sum;
    }

    /**
     * converts num to right base and returns as a string
     * @param num
     * @param toBase
     * @return
     */
    public String intToStr(int num, int toBase) {
        String alpha = "0123456789ABCDEF";
        String str = " ";
        while(num > 0) {
            str = alpha.charAt(num % toBase) + str;
            num /= toBase;
        }
        if(str.equals(""))
            return "0";
        else
            return str;
    }

    /**
     * reads file and prints final output
     */
    public void inputConvertPrintWrite() {
        //scanner that opens values10.dat
        //print each line to the screen
        Scanner sc = null;
        PrintWriter pw = null;
        try {
            sc = new Scanner(new File("datafiles/values30.dat"));
            pw = new PrintWriter(new File("datafiles/converted.dat"));
            while(sc.hasNext()) {
                String[] line = sc.nextLine().split("\t");
                // line = {"24A4B56"     "13"    "6"}
                //items to test: line [1] and line [2]
                int fromBase = Integer.parseInt(line[1]);
                int toBase = Integer.parseInt(line[2]);
                if(fromBase < 2 || fromBase > 16) {
                    System.out.println("invalid input base " + fromBase);
                }
                else if(toBase < 2 || toBase > 16) {
                    System.out.println("invalid output base " + toBase);
                }
                else {
                    //print statement to the console
                    System.out.println(line[0] + " base " + fromBase + " = " + intToStr(strToInt(line[0], line[1]), toBase) + "base " + toBase);
                    pw.println(line[0] + "\t" + fromBase + "\t" + intToStr(strToInt(line[0], line[1]), toBase) + "\t" + toBase);

                }
            }
            sc.close();
        }
        catch(Exception e) {
            System.out.println("bruh");
        }
        if(sc != null)
            sc.close();
        if(pw != null)
            pw.close();
        }

    /**
     * main entry point
     * @param args
     */
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();
    }
}
