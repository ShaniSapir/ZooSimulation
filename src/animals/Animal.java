/*
 * Submissions:
 * Shani sapir 323060590
 * Tehila levi 322257213
 * */


package animals;
import mobility.*;
import food.*;
import diet.*;
import mobility.Point;
import utilities.MessageUtility;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;


/**
 *
 * @author Shani Sapir
 *
 */

public abstract class Animal extends Mobile implements IEdible, IAnimalBehavior, IDrawable, Runnable
{
    // Attributes
    private String name;
    private double weight;
    private IDiet diet;

    //new
    private final int EAT_DISTANCE = 10;
    private  int size;
    private String col;
    private  int horSpeed;
    private int verSpeed;
    private boolean coordChanged;
    private int x_dir;
    private int y_dir;
    private int eatCount;
    private ZooPanel pan;
    private BufferedImage img1, img2;
    private BufferedImage img = null;


    protected Thread thread;
    protected boolean threadSuspended;

    /**
     * Ctor
     * @param name - name of animal
     * @param location - location of the animal
     */
    public Animal(String name, Point location)
    {
        super(location);
        //MessageUtility.logConstractor("Animal", name);
        this.setName(name);
    }

    //Ctor
    public Animal(String name, Point location, int size, double weight, String color, int horSpeed,
                  int verSpeed, ZooPanel pan)
    {
        super(location);
        this.name = name;
        this.col = color;
        this.coordChanged = false;
        this.x_dir = 1;
        this.y_dir = 1;
        this.eatCount = 0;
        this.size = size;
        this.weight = weight;
        this.horSpeed = horSpeed;
        this.verSpeed = verSpeed;
        this.pan = pan;

        this.threadSuspended = false;
        this.thread = new Thread(this);
        this.thread.start();
    }


    /**
     * Set name method
     * @param name - name of animal
     * @return - true/ false
     */
    public boolean setName(String name)
    {
        this.name = name;
        //MessageUtility.logSetter(this.name, "setName", this.name, true);
        return true;
    }


    /**
     * Set weight method
     * @param weight - Weight of the animal
     * @return - Operation success or failed
     */
    public boolean setWeight(double weight)
    {
        this.weight = weight;
        //MessageUtility.logSetter(this.name, "setWeight", this.weight, true);
        return true;
    }


    /**
     * Set IDiet method
     * @param diet - kind of animal
     * @return - Operation success or failed
     */
    public boolean setIdiet(IDiet diet)
    {
        this.diet = diet;
        //MessageUtility.logSetter(this.name, "setIdiet", this.diet.toString(), true);
        return true;
    }


    /**
     * Get IDiet method
     * @return - diet field
     */
    public IDiet getIDiet()
    {
        //MessageUtility.logGetter(this.name, "getIDiet", this.diet);
        return this.diet;
    }


    /**
     *  Get name method
     * @return - name field
     */
    public String getName()
    {
        //MessageUtility.logGetter(this.name, "getName", this.name);
        return this.name;
    }


    /**
     * Get weight method
     * @return - weight field
     */
    public double getWeight()
    {
        //MessageUtility.logGetter(this.name, "getWeight", this.weight);
        return this.weight;
    }


    /**
     * Boolean eat method
     * @param food - Animal type object
     * @return - true if the eating was successful else returns false
     */
    public boolean eat(IEdible food)
    {
        if (this.diet.eat(this, food) != 0)
        {
            this.makeSound();
            //MessageUtility.logBooleanFunction(this.name, "eat", food, true);
            return true;
        }
        else
            //MessageUtility.logBooleanFunction(this.name, "eat", food, false);
        return false;
    }


    /**
     * Get food type method
     * return - What kind of food the animal is
     */
    public EFoodType getFoodtype()
    {
        //MessageUtility.logGetter(this.name, "getFoodtype", EFoodType.MEAT);
        return EFoodType.MEAT;
    }

    /**
     * Make sound of the animal
     */
    public abstract void makeSound();

    /**
     * To string method
     */
    public abstract String toString();



    //assignment2

    /**
     * load the image
     * @param nm name of picture
     */
    public void loadImages(String nm)
    {
        try {
            img1 = ImageIO.read(new File(PICTURE_PATH + "\\" + nm + "_1" + ".png"));
            img2 = ImageIO.read(new File(PICTURE_PATH + "\\" + nm + "_2" + ".png"));
        }
        catch (IOException e) { System.out.println("Cannot load image"); }
    }

    /**
     * drawes the object
     * @param g drawing object
     */
    public void drawObject(Graphics g)
    {
        if(this.x_dir == 1)
            g.drawImage(img1,this.getLocation().getX() - (this.size/2), this.getLocation().getY() - (this.size/10), this.size, this.size, this.pan);
        else
            g.drawImage(img2, this.getLocation().getX(), this.getLocation().getY() - (this.size/10), this.size, this.size, this.pan);
    }

    public String getAnimalName()
    {
        return this.name;
    }

    public String getColor()
    {
        return this.col;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public int getSize()
    {
        return this.size;
    }

    public boolean getChanges()
    {
        return this.coordChanged;
    }

    public void setChanges(boolean state)
    {
        this.coordChanged = state;
    }

    public void eatInc()
    {
        this.eatCount += 1;
    }

    public int getEatCount()
    {
        return this.eatCount;
    }

    public int getVerSpeed()
    {
        return this.verSpeed;
    }

    public int getHorSpeed()
    {
        return this.horSpeed;
    }

    public void setX_dir(int new_X_dir)
    {
        this.x_dir = new_X_dir;
    }

    public int getX_dir()
    {
        return this.x_dir;
    }

    public int getY_dir()
    {
        return this.y_dir;
    }

    public void setY_dir(int new_Y_dir)
    {
        this.y_dir = new_Y_dir;
    }

    public Thread getThread()
    {
        return this.thread;
    }

    /**
     * Animal thread is sleep
     */
    public void setSuspended()
    {
        this.threadSuspended = true;
    }

    /**
     * Animal thread is alive and active
     */
    public void setResumed()
    {
        this.threadSuspended = false;
        synchronized (this)
        {
            this.notify();

        }
    }

    /**
     * Run method
     */
    @Override
    public void run()
    {
        while(true)
        {
            if (this.threadSuspended == true)
            {
                synchronized (this) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            else
            {
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (this.getLocation().getX() >= 940) {
                    this.setX_dir(-1);
                }
                if (this.getLocation().getX() <= 10) {
                    this.setX_dir(1);
                }
                if (this.getLocation().getY() >= 450) {
                    this.setY_dir(-1);
                }
                if (this.getLocation().getY() <= 0) {
                    this.setY_dir(1);
                }

                int new_x = this.getLocation().getX() + this.horSpeed * this.x_dir;
                int new_y = this.getLocation().getY() + this.verSpeed * this.y_dir;
                this.setLocation(new Point(new_x, new_y));
                this.pan.repaint();

                if (this.pan.getMeat_food() != null)
                {
                    if(this.getIDiet().canEat(this.pan.getMeat_food().getFoodtype()))
                    {
                        try {
                            Thread.sleep(40);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (this.getLocation().getX() <= 400)
                        {
                            this.setX_dir(1);
                        }
                        if (this.getLocation().getX() > 500)
                        {
                            this.setX_dir(-1);
                        }
                        if (this.getLocation().getY() >= 450) {
                            this.setY_dir(-1);
                        }
                        if (this.getLocation().getY() <= 0) {
                            this.setY_dir(1);
                        }

                        int newX = this.getLocation().getX() + this.getHorSpeed() * this.getX_dir();
                        int newY = this.getLocation().getY() + this.getVerSpeed() * this.getY_dir();
                        this.setLocation(new Point(newX, newY));
                        this.pan.repaint();

                        if (this.calcDistance(new Point(450, 200)) < 40)
                        {
                            this.eat(this.pan.getMeat_food());
                            this.pan.setMeat_food();
                            this.eatInc();
                            this.pan.repaint();
                        }

                    }
                }

                if (this.pan.getPlant_food() != null)
                {
                    if(this.getIDiet().canEat(this.pan.getPlant_food().getFoodtype()))
                    {
                        try
                        {
                            Thread.sleep(40);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (this.getLocation().getX() <= 400)
                        {
                            this.setX_dir(1);
                        }
                        if (this.getLocation().getX() > 500)
                        {
                            this.setX_dir(-1);
                        }
                        if (this.getLocation().getY() >= 450) {
                            this.setY_dir(-1);
                        }
                        if (this.getLocation().getY() <= 0) {
                            this.setY_dir(1);
                        }

                        int newX = this.getLocation().getX() + this.getHorSpeed() * this.getX_dir();
                        int newY = this.getLocation().getY() + this.getVerSpeed() * this.getY_dir();
                        this.setLocation(new Point(newX, newY));
                        this.pan.repaint();

                        if (this.calcDistance(new Point(450, 200)) < 30)
                        {
                            if (this.pan.getPlant_food() != null)
                            {
                                this.eat(this.pan.getPlant_food());
                                this.pan.setPlant_food();
                                this.eatInc();
                                this.pan.repaint();
                            }

                        }
                    }
                }
            }

            for (int i = 0; i < this.pan.getAnimalArr().size(); ++i)
            {
                if(this.getIDiet().canEat(this.pan.getAnimalArr().get(i).getFoodtype()) == true) {

                    if (this.getWeight() >= (2 * this.pan.getAnimalArr().get(i).getWeight())) {

                        if (this.calcDistance(this.pan.getAnimalArr().get(i).getLocation()) < (this.pan.getAnimalArr().get(i).getSize())) {
                            this.getIDiet().eat(this, this.pan.getAnimalArr().get(i));
                            this.eatInc();
                            this.pan.getAnimalArr().remove(i);
                            this.pan.repaint();
                        }
                    }
                }
            }
        }
    }
}