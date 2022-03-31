import java.lang.*;

/**
 * class coin is the object that is sorted
 */
public abstract class Coin {
    public abstract double getValue();
    public abstract String getName();

    /**
     * gets plural name
     * @return name pluralized
     */
    public String getPluralName() {
        if(getName().equals("penny"))
            return "pennies";
        else
            return getName() + "s";
    }
}
