package animals;
import graphics.ZooPanel;
import mobility.*;
import diet.Carnivore;
import food.*;
import utilities.*;

import java.util.Locale;

/**
 *
 * @author Shani Sapir
 *
 */
public class Lion extends Roar {

    //Attributes
    private int scarCount;

    /**
     * Ctor
     * @param name - Lion's name
     */
    public Lion(String name)
    {
        super(name, new Point(20, 0));
        //MessageUtility.logConstractor("Lion", name);
        this.scarCount = 0;
        this.setIdiet(new Carnivore());
        this.setWeight(408.2);
    }


    /**
     * Ctor
     * @param name - Lion's name
     * @param location - Lion's location
     */
    public Lion(String name, Point location)
    {
        super(name, new Point(location));
        //MessageUtility.logConstractor("Lion", name);
        this.scarCount = 0;
        this.setIdiet(new Carnivore());
        this.setWeight(408.2);
    }


    public Lion(int size, String color, int horSpeed, int verSpeed, ZooPanel pan)
    {
        super("Lion", new Point(20, 0), size,size * 0.8, color, horSpeed, verSpeed, pan);
        this.scarCount = 0;
        this.setIdiet(new Carnivore());
        this.loadImages("lio_" + color.toLowerCase(Locale.ROOT).charAt(0));

    }


    /**
     * Roar method - activates the bear sound
     */
    public void roar()
    {
        //MessageUtility.logSound(this.getName(), "Roars, then stretches and shakes its mane");
    }


    /**
     * Get food type method
     * return - What kind of food the animal is
     */
    public EFoodType getFoodtype()
    {
        //MessageUtility.logGetter(this.getName(), "getFoodtype", EFoodType.NOTFOOD);
        return EFoodType.NOTFOOD;
    }


    /**
     * Set scar count method
     * @param count - Scar count field
     * @return - Returns true if the scar count entered is valid otherwise valid returns false
     */
    public boolean setScarCount(int count)
    {
        this.scarCount = count;
        //MessageUtility.logSetter(this.getName(), "setScarCount", this.scarCount, true);
        return true;
    }


    /**
     * Get scar count method
     * @return - Scar count field
     */
    public int getScarCount()
    {
        //MessageUtility.logGetter(this.getName(), "getNeckLength", this.scarCount);
        return this.scarCount;
    }


    /**
     * To string method
     */
    public String toString()
    {
        return "[Lion]: " + this.getName();
    }

}