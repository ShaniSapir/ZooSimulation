package animals;
import diet.Herbivor;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;

import java.util.Locale;

/**
 *
 * @author Tehila Levi
 *
 */
public class Elephant extends Chew{

    //Attributes
    private double trunkLength;


    /**
     * Ctor
     * @param name - Elephant's name
     */
    public Elephant(String name)
    {
        super(name, new Point(50, 90));
        MessageUtility.logConstractor("Elephant", name);
        this.setWeight(500);
        this.setTrunkLength(1);
        this.setIdiet(new Herbivor());
    }


    /**
     * Ctor
     * @param name - Elephant's name
     * @param location - Elephant's location
     */
    public Elephant(String name, Point location)
    {
        super(name, location);
        //MessageUtility.logConstractor("Elephant", name);
        this.setWeight(500);
        this.setTrunkLength(1);
        this.setIdiet(new Herbivor());
    }


    public Elephant(int size, String color, int horSpeed, int verSpeed, ZooPanel pan)
    {
        super("Elephant", new Point(50, 90), size,size * 10, color, horSpeed, verSpeed, pan);
        this.setTrunkLength(1);
        this.setIdiet(new Herbivor());
        this.loadImages("elf_" + color.toLowerCase(Locale.ROOT).charAt(0));

    }


    /**
     * Chew method - activates the elephant sound
     */
    public void chew()
    {
        //MessageUtility.logSound(this.getName(), "Trumpets with joy while flapping its ears, then chews");
    }


    /**
     * Set trunk method
     * @param trunkLength - Trunk length field
     * @return - Returns true if the trunk length entered is valid otherwise valid returns false
     */
    public boolean setTrunkLength(double trunkLength)
    {
        if (trunkLength >= 0.5 && trunkLength <= 3)
        {
            this.trunkLength = trunkLength;
            //MessageUtility.logSetter(this.getName(), "setTrunkLength", this.trunkLength, true);
            return true;
        }
        //MessageUtility.logSetter(this.getName(), "setTrunkLength", this.trunkLength, false);
        return false;
    }


    /**
     * Get trunk length method
     * @return Trunk length field
     */
    public double getTrunkLength()
    {
        //MessageUtility.logGetter(this.getName(), "getTrunkLength", this.trunkLength);
        return this.trunkLength;
    }


    /**
     * To string method
     */
    public String toString()
    {
        return "[Elephant]: " + this.getName();
    }
}