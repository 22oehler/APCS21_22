/**
 * SubWordFinder finds words that are made up of subwords in the words_all_os.txt
 * @version 2/1/22
 * @author Lars Oehler
 */

import java.util.*;
import java.io.*;

/**
 * subWordFinder uses 2d jagged arraylist and string alpha to sort this list
 */
public class SubWordFinder implements WordFinder {
    private ArrayList<ArrayList<String>> dictionary;    //jagged list
    private String alpha = "abcdefghijklmnopqrstuvwxyz";

    /**
     *populates and initializes ArrayList<ArrayList<String>> dictionary
     */
    public SubWordFinder() {
        dictionary = new ArrayList<>();
        // 26 empty bucket
        for(int i = 0; i < alpha.length(); i++) {
            dictionary.add(new ArrayList<>());
        }
        populateDictionary();
    }

    /**
     * builds dictionary with words from file words_all_os.txt
     */
    public void populateDictionary() {
        try{
            Scanner in = new Scanner(new File("words_all_os.txt"));
            while(in.hasNext()) {
                String word = in.nextLine();
                dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
            }
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Look through the entire dictionary object to see if word exists in dictionary
     * @param word The item to be searched for in dictionary
     * @return
     */
    public boolean inDictionary(String word) {
        int index = alpha.indexOf(word.charAt(0));
        ArrayList<String> bucket = dictionary.get(index);
        return indexOf(bucket, word) >= 0;
        //return Collections.binarySearch(bucket, word) >= 0;
    }

    //binary search
    private int indexOf(ArrayList<String> bucket, String word) {
        int min = 0, max = bucket.size()-1, mid;
        while(min <= max) {
            mid = (min + max) / 2;
            if (bucket.get(mid).compareTo(word) < 0) {
                 min = mid + 1;
            }
            else if(bucket.get(mid).compareTo(word) > 0) {
                max = mid -1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    /*
    public String findShortestWord() {
        String shortestWord = dictionary.get(0).get(0);
        for(ArrayList<String> bucket : dictionary) {
            for(String word : bucket) {
                if(word.length() < shortestWord.length())
                    shortestWord = word;
            }
        }
        return shortestWord;
    }
     */

    /**
     * finds all subWords in the text file and adds them to the ArrayList subwords
     * @return
     */
    public ArrayList<SubWord> getSubWords() {
        ArrayList<SubWord> subwords = new ArrayList<>();
        String root1 = "";
        String root2 = "";
        //string word = "baseball"
        //if indexOf("base" != -1 && indexOf("ball") != -1;
            //subwords.add(new subWord("baseball", "base", "ball")
        for(ArrayList<String> bucket : dictionary) {
            for(String word : bucket) {
                for(int i = 3; i < word.length() - 2; i++) {
                    root1 = word.substring(0, i);
                    root2 = word.substring(i);
                    if(inDictionary(root1) && inDictionary(root2)) {
                        subwords.add(new SubWord(word, root1, root2));
                        //System.out.println(word + " = " + root1 + root2);
                    }
                }
            }
        }
        return subwords;
    }

    /*
    public void printDictionary() {
        //for(ArrayList<String> bucket : dictionary){
            //for(String word : bucket) {
                //System.out.println(inDictionary(word));
            //}
        //}
        for(ArrayList<String> bucket : dictionary) {
            System.out.println(bucket);
        }
    }
     */

    /**
     * main entry point for SubWordFinder.java
     * @param args
     */
    public static void main(String[] args) {
        SubWordFinder app = new SubWordFinder();
        //app.populateDictionary();
        //app.printDictionary();
        //System.out.println(app.findShortestWord());

        ArrayList<SubWord> temp = app.getSubWords();
        for(SubWord item : temp)
            System.out.println(item);
        System.out.println(temp.size());
    }
}
