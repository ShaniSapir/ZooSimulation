package graphics;

import java.awt.*;

public interface IDrawable {
    public final static String PICTURE_PATH = "C:\\Users\\Shani Sapir\\OneDrive\\Documents\\'שנה ב\\'סמסטר ב\\מונחה עצמים מתקדם\\מטלה 2\\assignment2_pictures\\assignment2_pictures";
    public void loadImages(String nm);
    public void drawObject(Graphics g);
    public String getColor();
}
