package mobility;

/**
 *
 * @author Shani Sapir
 *
 */
public interface ILocatable {

    /*
     * Get lication method
     */
    public Point getLocation();

    /**
     * Set location method
     * @param point - The values of the point to set
     * @return - returns true if the values are valid else return false
     */
    public boolean setLocation(Point point);
}