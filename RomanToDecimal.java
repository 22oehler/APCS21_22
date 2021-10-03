import java.util.Locale;

/**
 * Roman to decimal will convert roman numerals to numbers
 * @author 22oehler
 */
public class RomanToDecimal {
    public static int romanToDecimal(String roman){
        int decimal = 0;
        roman = roman.toUpperCase();
        for(int i = 0; i < roman.length();  i++){
            if(roman.substring(i, i+1).toUpperCase().equals("I")){
                decimal += 1;}
            else if(roman.substring(i, i+1).toUpperCase().equals(("V"))) {
                decimal += 5;}
            else if(roman.substring(i, i+1).toUpperCase().equals(("X"))) {
                decimal += 10;}
            else if(roman.substring(i, i+1).toUpperCase().equals(("L"))) {
                decimal += 50;}
            else if(roman.substring(i, i+1).toUpperCase().equals(("C"))) {
                decimal += 100;}
            else if(roman.substring(i, i+1).toUpperCase().equals(("D"))) {
                decimal += 500;}
            else if(roman.substring(i, i+1).toUpperCase().equals(("M"))) {
                decimal += 1000;}
            else {
                return -1;
            }
        }
        //at this point raw point value is accurate
        if(roman.indexOf("IV") != -1)
            decimal -= 2;
        if(roman.indexOf("IX") != -1)
            decimal -= 2;
        if(roman.indexOf("XL") != -1)
            decimal -= 20;
        if(roman.indexOf("XC") != -1)
            decimal -= 20;
        if(roman.indexOf("CD") != -1)
            decimal -= 200;
        if(roman.indexOf("CM") != -1)
            decimal -= 200;
        return decimal;
    }
    public static void main(String[] args){
        for(String temp : args) {
            int val = romanToDecimal(temp);
            if(val == -1) {
                System.out.println("Input: " + temp + " => output: invalid" );
            }
            else {
                System.out.println("Input: " + temp + " => output: " + romanToDecimal(temp));
            }
        }
    }
}
