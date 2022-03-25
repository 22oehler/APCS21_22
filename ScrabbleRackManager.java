import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

/**
 * scrabble rack manager makes a tile rack and tells you the words you can play from it
 */
public class ScrabbleRackManager {
    ArrayList<ArrayList<String>> dictionary;
    ArrayList<String> tileRack;
    private final String alpha;


    /**
     * class constructor
     */
    public ScrabbleRackManager() {
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        dictionary = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            dictionary.add(new ArrayList<>());
        }
        buildDictionary();
        makeRack();

    }

    private boolean isBingo(String word) {
        return word.length() == 7;
    }

    private boolean isPlayable(String word) {
        ArrayList<String> rackCopy = new ArrayList<>(tileRack);
        for(int i = 0; i < word.length(); i++) {
            if(!(rackCopy.remove("" + word.charAt(i)))) {
                return false;
            }
        }
        return true;
        //make copy of tile rack
        //iterate through every letter in word
        //look at what .remove(object O) returns
        //for each letter in word, if you cant remove the letter from word return false
        //if the loop gets all the way through the word is playable
    }

    private void makeRack() {
        tileRack = new ArrayList<>();
        String[] rackLets = {"A", "A", "A", "A", "A", "A", "A", "A", "A", "B", "B", "C", "C", "D", "D", "D", "D", "E","E","E","E","E","E","E","E","E","E","E","E","F","F", "G","G","G", "H","H", "I","I","I","I","I","I","I","I","I","J", "K", "L","L","L","L","M", "M", "N","N","N","N","N","N","O","O","O","O","O","O","O","O","P", "P", "Q", "R","R","R","R","R","R","S","S","S","S","T","T","T","T","T","T","U","U","U","U","V","V","W","W","X","Y","Y","Z"," ", " "};
        ArrayList<String> tiles = new ArrayList<>();
        Collections.addAll(tiles, rackLets);
        Collections.shuffle(tiles);
        for(int i = 0; i < 7; i++)  {
            tileRack.add(tiles.remove((int)(Math.random()*tiles.size())));
        }
    }

    private void buildDictionary() {
        try {
            Scanner fileIn = new Scanner(new File("datafiles/ScrabbleWords.txt"));
            while(fileIn.hasNext()) {
                String temp = fileIn.nextLine();
                dictionary.get(alpha.indexOf(temp.charAt(0))).add(temp);
            }
            fileIn.close();
        }
        catch (Exception e) {
            System.out.println("BRUH");
        }
    }

    /**
     * displays the contents of the player's tile rack
     * */
    public void printRack() {
        System.out.println("Letters in the rack: " + tileRack);
    }
    /**
     * builds and returns an ArrayList of String objects that are values pulledfrom
     * the dictionary/database based on the available letters in the user's tile
     * rack
     * @return
     * */
    public ArrayList<String> getPlaylist() {
        ArrayList<String> plays = new ArrayList<>();
        for(ArrayList<String> bucket : dictionary) {
            for(String word : bucket) {
                if(isPlayable(word))
                    plays.add(word);
            }
        }
        return plays;
    }
    /**
     * print all of the playable words based on the letters in the tile rack
     * */
    public void printMatches() {
        ArrayList<String> plays = getPlaylist();
        boolean bingo = false;
        System.out.println("You can play the following words from the letters in your rack:");
        if(plays.size() == 0)
            System.out.println("Sorry, NO words can be played from those tiles");
        for(int i = 0; i < plays.size(); i++) {
            String word = plays.get(i);
            if(word.length() == 7) {
                word += "* ";
                bingo = true;
            }
            System.out.printf(String.format("%-10s", word));
            if((i+1) % 10 == 0) {
                System.out.println();
            }
        }
        if(bingo)
            System.out.println("* Denotes Bingo");
        /*
        System.out.println("You can play the following words from the letters in your rack: ");
        if(getPlaylist().size()>0) {
            for (String word : getPlaylist()) {
                System.out.print(word);
                if (isBingo(word))
                    System.out.print("*");
                System.out.print(" ");
            }
            System.out.println();
            System.out.print("* denotes Bingo");
        }
        else {
            System.out.println("Sorry, NO words can be played from those tiles.");
        }
         */
    }
    /**
     * main method for the class; use only 3 command lines in main
     * @param args command line of arguments if needed
     */
    public static void main(String[] args){
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();
    }
}
