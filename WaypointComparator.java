import java.util.Comparator;

/**
 * waypoint comparator compares waypoints
 * @version april 29
 * @author 22oehler
 */
public class WaypointComparator implements Comparator<Waypoint> {
    private int category;
    private boolean asc;

    /**
     * waypoint comparator constructor
     * @param c
     * @param a
     */
    public WaypointComparator(int c, boolean a) {
        category = c;
        asc = a;
    }

    /**
     * constructor
     * @param c
     */
    public WaypointComparator(int c) {
        c = category;
        asc = true;
    }

    /**
     * constructor
     * @param a
     */
    public WaypointComparator(boolean a) {
        category = 4;
        asc = a;
    }

    /**
     * compares one waypoint to another, returns int
     * @param one
     * @param two
     * @return
     */
    public int compare(Waypoint one, Waypoint two) {
        int diff = 0;
        if(category == 1) { //type
            diff = one.getType().compareTo(two.getType());
        }
        else if(category == 2){ //name
            diff = one.getName().compareTo(two.getName());
        }
        else if(category == 3){ //State
            diff = one.getState().compareTo(two.getState());
        }
        else if(category == 4){ //dtospringer
            Double d1 = one.getToSpringer();
            Double d2 = two.getToSpringer();
            diff = d1.compareTo(d2);
        }
        else if(category == 5){ //dtokatahdin
            Double d1 = one.getToKatahdin();
            Double d2 = two.getToKatahdin();
            diff = d1.compareTo(d2);
        }
        else if(category == 6) { //elevation
            diff = one.getElevation() - two.getElevation();
        }
        return (asc) ? diff : -diff;
    }
}
