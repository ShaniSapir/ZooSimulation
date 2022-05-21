package animals;
import diet.Herbivor;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;

import java.util.Locale;

/**
 *
 * @author Shani Sapir
 *
 */
public class Giraffe extends Chew{

    //Attributes
    private double neckLength;

    /**
     * Ctor
     * @param name - Giraffe's name
     */
    public Giraffe(String name)
    {
        super(name, new Point(50, 0));
        MessageUtility.logConstractor("Giraffe", name);
        this.setWeight(450);
        this.setNeckLength(1.5);
        this.setIdiet(new Herbivor());
    }

    /**
     * Ctor
     * @param name - Giraffe's name
     * @param location - Giraffe's location
     */
    public Giraffe(String name, Point location)
    {
        super(name, location);
        //MessageUtility.logConstractor("Giraffe", name);
        this.setWeight(450);
        this.setNeckLength(1.5);
        this.setIdiet(new Herbivor());
    }


    public Giraffe(int size, String color, int horSpeed, int verSpeed, ZooPanel pan)
    {
        super("Giraffe", new Point(50, 0), size, size * 2.2, color, horSpeed, verSpeed, pan);
        this.setNeckLength(1.5);
        this.setIdiet(new Herbivor());
        this.loadImages("grf_" + color.toLowerCase(Locale.ROOT).charAt(0));

    }


    /**
     * Chew method - activates the giraffe sound
     */
    public void chew()
    {
        //MessageUtility.logSound(this.getName(), "Bleats and Stomps its legs, then chews");
    }


    /**
     * Set neck length method
     * @param neckLength - Neck length field
     * @return - Returns true if the Neck length entered is valid otherwise valid returns false
     */
    public boolean setNeckLength(double neckLength)
    {
        if (neckLength >= 1 && neckLength <= 2.5)
        {
            this.neckLength = neckLength;
            //MessageUtility.logSetter(this.getName(), "setNeckLength", this.neckLength, true);
            return true;
        }
        //MessageUtility.logSetter(this.getName(), "setNeckLength", this.neckLength, false);
        return false;
    }


    /**
     * Get neck length method
     * @return - Neck length field
     */
    public double getNeckLength()
    {
        //MessageUtility.logGetter(this.getName(), "getNeckLength", this.neckLength);
        return this.neckLength;
    }


    /**
     * To string method
     */
    public String toString()
    {
        return "[Giraffe]: " + this.getName();
    }

}