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
public class Turtle extends Chew {

    //Attributes
    private int age;


    /**
     * Ctor
     * @param name - Turtle's name
     */
    public Turtle(String name)
    {
        super(name, new Point(80, 0));
        //MessageUtility.logConstractor("Turtle", name);
        this.setWeight(1);
        this.setAge(1);
        this.setIdiet(new Herbivor());
    }


    /**
     * Ctor
     * @param name - Turtle's name
     * @param location - Turtle's location
     */
    public Turtle(String name, Point location)
    {
        super(name, location);
        //MessageUtility.logConstractor("Turtle", name);
        this.setWeight(1);
        this.setAge(1);
        this.setIdiet(new Herbivor());
    }


    public Turtle(int size, String color, int horSpeed, int verSpeed, ZooPanel pan)
    {
        super("Turtle", new Point(80, 0), size,size * 0.5, color, horSpeed, verSpeed, pan);
        this.setAge(1);
        this.setIdiet(new Herbivor());
        this.loadImages("trt_" + color.toLowerCase(Locale.ROOT).charAt(0));
    }


    /**
     * Chew method - activates the giraffe sound
     */
    public void chew()
    {
        //MessageUtility.logSound(this.getName(), "Retracts its head in then eats quietly");
    }


    /**
     * Set age method
     * @param age - Age field
     * @return - Returns true if the age entered is valid otherwise valid returns false
     */
    public boolean setAge(int age)
    {
        if (age >= 0 && age <= 500)
        {
            this.age = age;
            //MessageUtility.logSetter(this.getName(), "setAge", this.age, true);
            return true;
        }
        //MessageUtility.logSetter(this.getName(), "setAge", this.age, false);
        return false;
    }


    /**
     * Get age method
     * @return - Age field
     */
    public int getAge()
    {
        //MessageUtility.logGetter(this.getName(), "getAge", this.age);
        return this.age;
    }


    /**
     * To string method
     */
    public String toString()
    {
        return "[Turtle]: " + this.getName();
    }

}