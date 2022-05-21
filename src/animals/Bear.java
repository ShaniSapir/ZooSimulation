package animals;
import diet.Omnivore;
import graphics.ZooPanel;
import mobility.*;
import mobility.Point;
import utilities.MessageUtility;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Locale;

/**
 *
 * @author Tehila Levi
 *
 */
public class Bear extends Roar {

    // Attributes
    String furColor;

    /**
     * Ctor
     * @param name - Bear's name
     */
    public Bear(String name)
    {
        super(name, new Point(100, 5));
        //MessageUtility.logConstractor("Bear", name);
        this.setWeight(308.2);
        this.setFurColor("GRAY");
        this.setIdiet(new Omnivore());
    }


    /**
     * Ctor
     * @param name - Bear's name
     * @param location - Bear's location
     */
    public Bear(String name, Point location)
    {
        super(name, location);
        //MessageUtility.logConstractor("Bear", name);
        this.setWeight(308.2);
        this.setFurColor("GRAY");
        this.setIdiet(new Omnivore());
    }


    //Ctor all
    public Bear(int size, String color, int horSpeed, int verSpeed, ZooPanel pan)
    {
        super("Bear", new Point(100, 5), size, size * 1.5, color, horSpeed, verSpeed, pan);
        this.setFurColor("GRAY");
        this.setIdiet(new Omnivore());
        this.loadImages("bea_" + color.toLowerCase(Locale.ROOT).charAt(0));
    }


    /**
     * Roar method - activates the bear sound
     */
    public void roar()
    {
        //MessageUtility.logSound(this.getName(), "Stands on its hind legs, roars and scratches its belly");
    }


    /**
     * Set fur color method
     * @param furColor - fur color field
     * @return - Returns true if the fur color entered is valid otherwise valid returns false
     */
    public Boolean setFurColor(String furColor)
    {
        if(furColor.compareToIgnoreCase("GRAY") == 0 || furColor.compareToIgnoreCase("BLACK") == 0 || furColor.compareToIgnoreCase("WHITE")== 0)
        {
            this.furColor = furColor;
            //MessageUtility.logSetter(this.getName(), "setFurColor", this.furColor, true);
            return true;
        }
        else
            //MessageUtility.logSetter(this.getName(), "setFurColor", this.furColor, false);
        return false;
    }


    /**
     * Get fur color method
     * @return - fur color field
     */
    public String getFurColor()
    {
        //MessageUtility.logGetter(this.getName(), "getFurColor", this.furColor);
        return this.furColor;
    }


    /**
     * To string method
     */
    public String toString()
    {
        return "[Bear]: " + this.getName();
    }
}