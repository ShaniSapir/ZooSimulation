package mobility;

/**
 *
 * @author Shani Sapir
 *
 */
public class Point {

    // Static fields
    private static final int minX = 0;
    private static final int minY = 0;
    private static final int maxX = 800;
    private static final int maxY = 600;

    // Attributes
    private int x;
    private int y;


    /**
     * Static method thats checks the validity of inserted point values
     * @param pointToCheck - inserted point
     * @return - Returns true if the points values are valid otherwise return false
     */
    public static boolean cheackBounderies(Point pointToCheck)
    {
        if (pointToCheck.setX(pointToCheck.getX()) == true && pointToCheck.setY(pointToCheck.getY()) == true)
            return true;
        else
            return false;
    }


    /**
     * Ctor
     */
    public Point()
    {
        this.x = 0;
        this.y = 0;
    }



    /**
     * Ctor
     * @param x - X coordinate
     * @param y - Y coordinate
     */
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }


    /**
     * Set X method
     * @param x - X coordinate
     * @return - return true if the value of the X coordinate is valid otherwise return false
     */
    public boolean setX(int x)
    {
        if(x >= minX && x <= maxX)
        {
            this.x = x;
            return true;
        }

        else
            return false;
    }


    /**
     * Set Y method
     * @param y - Y coordinate
     * @return - return true if the value of the Y coordinate is valid otherwise return false
     */
    public boolean setY(int y)
    {
        if(y>= minY && y <= maxY)
        {
            this.y = y;
            return true;
        }

        else
            return false;
    }


    /**
     * Get x method
     * @return - X field
     */
    public int getX()
    {
        return this.x;
    }


    /**
     * Get Y method
     * @return - Y field
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * Copy Ctor
     * @param p - The point the copy Ctor duplicates
     */
    public Point(Point p)
    {
        this.x = p.getX();
        this.y = p.getY();
    }


    /**
     * To string method
     */
    public String toString()
    {
        return "(" + this.x + "," + this.y + ")";
    }
}