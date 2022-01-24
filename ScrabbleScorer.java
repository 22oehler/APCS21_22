/**
 * ScrabbleScorer gets String input from the user and if it is a word in the Scrabble dictionary, returns the
 * point value of the word
 * @version 1/24/22
 * @author Lars Oehler
 */

import java.io.*;
import java.util.*;


public class ScrabbleScorer {
    private static ArrayList<String> dictionary;
    private int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    private String alpha;

    /**
     * constructor for class ScrabbleScorer
     * initializes dictionary and builds alpha string
     */
    public ScrabbleScorer() {
        dictionary = new ArrayList<>();
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        buildDictionary();
    }

    /**
     * this builds the file SCRABBLE_WORDS.txt into the ArrayList dictionary
     */
    public static void buildDictionary() {
        Scanner inDict = null;
        try {
            inDict = new Scanner(new File("SCRABBLE_WORDS.txt"));
            while(inDict.hasNext()) {
                dictionary.add(inDict.next());
            }
            Collections.sort(dictionary);
            //System.out.println(dictionary);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This determines if the user input is a word included in the ArrayList dictionary
     * @param word
     * @return
     */
    public boolean isValidWord(String word) {
        return Collections.binarySearch(dictionary, word) >= 0;
    }

    /**
     * This determines the score of the user input by comparing the index of the points array and index String
     * @param word
     * @return
     */
    public int getWordScore(String word) {
        int sum = 0;
        //parse word one letter at a time - for loop ""+charAt or substring
        //find the index of each letter
        // add the corresponding score/point value from points to sum value
        for(int i = 0; i <= word.length()-1; i++) {
            int point = points[alpha.indexOf("" + word.charAt(i))];
            sum += point;
        }
        return sum;
    }

    /**
     * main entry point for ScrabbleScorer, gets input from user and exits when user inputs 0
     * @param args
     */
    public static void main(String[] args) {
        ScrabbleScorer app = new ScrabbleScorer();
        System.out.println("* Welcome to the Scrabble Word Scorer app *");
        String userWord;
        Scanner userIn = new Scanner(System.in);
        try {
            //System.out.println(dictionary);
            while(true) {
                System.out.println("Enter a word to score or 0 to quit: ");
                userWord = userIn.nextLine();//.toUpperCase(Locale.ROOT);
                if(userWord.equals("0"))
                    break;
                else {
                    if(app.isValidWord(userWord.toUpperCase())) {
                        //System.out.println(userWord);
                        System.out.println(userWord + " = " + app.getWordScore(userWord.toUpperCase()));
                    }
                    else {
                        System.out.println(userWord + " is not a valid word in the dictionary");
                        //System.out.println(userWord);
                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Exiting the program thanks for playing");

    }
}
