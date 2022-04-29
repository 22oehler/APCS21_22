/**
 * waypoint is comparable class
 * object which TrailDatabase sorts
 * @version april 29
 * @author 22oehler
 */
public class Waypoint implements Comparable<Waypoint> {
    private String type, name, state;
    private double toSpringer, toKatahdin;
    private int elevation;

    /**
     * constructor for waypoint
     * @param t
     * @param n
     * @param s
     * @param ts
     * @param tk
     * @param e
     */
    public Waypoint(String t, String n, String s, double ts, double tk, int e) {
        type = t;
        name = n;
        state = s;
        toSpringer = ts;
        toKatahdin = tk;
        elevation = e;
    }

    /**
     * copy constructor? allows one waypoint to be declared with other waypoint as parameter
     * @param other
     */
    public Waypoint(Waypoint other) {
        this(other.type, other.name, other.state, other.toSpringer, other.toKatahdin, other.elevation);
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getState() {return state;}

    public double getToSpringer() {
        return toSpringer;
    }

    public double getToKatahdin() {
        return toKatahdin;
    }

    public int getElevation() {
        return elevation;
    }

    /**
     * converts waypoint parameters to string
     * @return
     */
    @Override
    public String toString() {
        return "Waypoint{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", toSpringer=" + toSpringer +
                ", toKatahdin=" + toKatahdin +
                ", elevation=" + elevation +
                '}';
    }

    /**
     * compares this waypoint to other waypoint
     * @param other
     * @return
     */
    public int compareTo(Waypoint other) {
        //return other.elevation - this.elevation;
        return (this.name.substring(0, 1).compareTo(other.name.substring(0,1)))*-1;
    }
}
