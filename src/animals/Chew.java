package animals;
import graphics.ZooPanel;
import mobility.Point;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author Shani Sapir
 *
 */
public abstract class Chew extends Animal {

    /**
     * Ctor
     * @param name - 	Name of the animal
     * @param location - Location of the animal
     */
    public Chew(String name, Point location)
    {
        super(name, new Point(location));
    }


    //Ctor all
    public Chew(String name, Point location, int size, double weight, String color, int horSpeed, int verSpeed, ZooPanel pan)
    {
        super(name, location, size, weight, color, horSpeed, verSpeed, pan);
    }

    /**
     * Make sound method - activates the chew sound
     */
    public void makeSound()
    {
        this.chew();
    }

    /**
     * Chew method
     */
    public abstract void chew();

    /**
     * To string method
     */
    public abstract String toString();
}