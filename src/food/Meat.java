package food;

import graphics.IDrawable;
import mobility.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Meat implements IDrawable, IEdible {

    private BufferedImage img = null;
    private Point location;

    public Meat(String name)
    {
        this.location = new Point(450, 200);
        this.loadImages(name);
    }

    public void loadImages(String nm)
    {
        try { img = ImageIO.read(new File(PICTURE_PATH + "\\" + nm + ".gif")); }
        catch (IOException e) { System.out.println("Cannot load image"); }
    }


    public void drawObject(Graphics g)
    {
        int height = 50;
        int width = 50;
        g.drawImage(img, this.location.getX(), this.location.getY(), height, width, null);
    }


    public String getColor()
    {
        return " ";
    }


    public EFoodType getFoodtype()
    {
        return EFoodType.MEAT;
    }


    public Point getLocation()
    {
        return this.location;
    }
}
