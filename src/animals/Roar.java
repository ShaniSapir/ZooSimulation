package animals;
import graphics.ZooPanel;
import mobility.Point;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 *
 * @author Theils Levi
 *
 */
public abstract class Roar extends Animal {

    /**
     * Ctor
     * @param name - 	Name of the animal
     * @param location - Location of the animal
     */
    public Roar(String name, Point location)
    {
        super(name, new Point(location));
    }


    //Ctor all
    public Roar(String name, Point location, int size, double weight, String color, int horSpeed, int verSpeed, ZooPanel pan)
    {
        super(name, location, size, weight, color, horSpeed, verSpeed, pan);
    }


    /**
     * Make sound method - activates the roar sound
     */
    public void makeSound()
    {
        this.roar();
    }


    /**
     * Roar method
     */
    public abstract void roar();


    /**
     * To string method
     */
    public abstract String toString();
}