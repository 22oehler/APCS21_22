import java.io.File;
import java.util.*;

/**
 * this class sorts apptrail data and handles input
 * @verson april 29
 * @author 22oehler
 */
public class TrailDatabase {
    private ArrayList<Waypoint> database;
    private int searchTerm;
    private boolean asc;

    /**
     * class constructor for TrailDatabase
     */
    public TrailDatabase() {
        database = new ArrayList<>();
        populateDataBase();
    }

    /**
     * takes user input to determine how to sort data, returns search term
     */
    public int getSearchTerm() {
        System.out.println("+ Menu of search terms to use for sorting waypoints +\n" +
                "NA: by name\n" +
                "DS: by distance to Springer\n" +
                "DK: by distance to Katahdin\n" +
                "EL: by elevation");
        Scanner in = new Scanner(System.in);
    System.out.println("Enter your preferred sort by term of 'Q' to quit: ");
    String term = in.nextLine();
    if(term.equalsIgnoreCase("TY"))
        searchTerm = 1;
    else if(term.equalsIgnoreCase("NA"))
        searchTerm = 2;
    else if(term.equalsIgnoreCase("ST"))
        searchTerm = 3;
    else if(term.equalsIgnoreCase("DS"))
        searchTerm = 4;
    else if(term.equalsIgnoreCase("DK"))
        searchTerm = 5;
    else if(term.equalsIgnoreCase("EL"))
        searchTerm = 6;
    else
        searchTerm = 0;
    if(searchTerm != 0) {
        System.out.println("Enter 'A' to sort in ascending order of 'D' to sort in descending order: ");
        term = in.nextLine();
        asc = term.toLowerCase().equals("a") ? true : false;
        }
    return searchTerm;
    }

    /**
     * prints the data
     */
    public void printDB() {
        for(Waypoint w : database) {
            System.out.println(w);
        }
    }

    /**
     * sorts the data
     */
    public void sortDB() {
        Collections.sort(database, new WaypointComparator(searchTerm, asc));
    }

    /**
     * populates database with data from trailData.txt file
     */
    public void populateDataBase() {
        try {
            Scanner in = new Scanner(new File("trailData.txt"));
            while(in.hasNext()) {
                String[] line = in.nextLine().split("\t");
                //System.out.println("DEBUG " + Arrays.toString(line));
                database.add(new Waypoint(line[0], line[1], line[2], Double.parseDouble(line[5]),
						Double.parseDouble(line[6]), Integer.parseInt(line[7])));
            }
            in.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

	private void selectionSort() {
		WaypointComparator wc = new WaypointComparator(searchTerm, asc);
		Waypoint toSwap;
        int index;
        for(int out = 0; out < database.size(); out++) {
            index = out;
            toSwap = database.get(out);
            for(int in = out + 1; in < database.size(); in++) {
                Waypoint temp = database.get(in);
                if(wc.compare(temp, toSwap) < 0) {
                    toSwap = new Waypoint(temp);
                    index = in;
                }
            }
            database.set(index, database.get(out));
            database.set(out, toSwap);
        }
	}

    /**
     * main entry point for class TrailDatabase
     * @param args
     */
    public static void main(String[] args) {
        TrailDatabase db = new TrailDatabase();
        System.out.println("*** Welcome to the Appalachian Trail Database ***");
        while(true) {
            db.getSearchTerm();
            if(db.searchTerm == 0)
                break;
            db.selectionSort();
            db.printDB();
        }
        System.out.println("End of program");
    }
}
