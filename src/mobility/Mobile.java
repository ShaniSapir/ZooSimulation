package mobility;
import java.lang.Math;

/**
 *
 * @author Theila levi
 *
 */
public abstract class Mobile implements ILocatable{

    // Attributes
    private Point location;
    private double totalDistance; // in the set distance > 0


    /**
     * Ctor
     * @param location - Point object field
     */
    public Mobile(Point location)
    {
        this.location = new Point(location);
        this.totalDistance = 0;
    }

    /**
     * Ctor
     */
    public Mobile()
    {
        this.location = new Point();
        this.totalDistance = 0;
    }


    /**
     * Get location method
     */
    public Point getLocation()
    {
        return this.location;
    }


    /**
     * Set location method
     * @param point - The value of the point we want to initialize
     */
    public boolean setLocation(Point point)
    {
        this.location = new Point(point);
        return true;
    }


    /**
     * Calculates the overall distance
     * @param distance - The distance traveled
     */
    public void addTotalDistance(double distance)
    {
        this.totalDistance = this.getTotalDistance() + Math.abs(distance);
    }


    /**
     * Get total distance method
     * @return - Total distance field
     */
    public double getTotalDistance()
    {
        return this.totalDistance;
    }


    /**
     * Calculates the distance between two points
     * @param location - The point we want to get to
     * @return - The distance between the two points
     */
    public double calcDistance(Point location)
    {
        return Math.sqrt((location.getY()-this.location.getY()) * (location.getY()-this.location.getY()) +
                (location.getX()- this.location.getX()) * (location.getX()- this.location.getX()));
    }


    /**
     * Makes the animal move from one position to another
     * @param location - The point we want to get to
     * @return - The total distance traveled
     */
    public double move(Point location)
    {
        if (Point.cheackBounderies(location) == false)
            return 0;
        double distance = this.calcDistance(location);
        this.addTotalDistance(distance);
        this.setLocation(location);
        return distance;
    }
}





