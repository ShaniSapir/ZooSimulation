package zoo;
import food.*;
import mobility.*;
import utilities.*;
import animals.*;
import java.util.Scanner;
import java.util.Random;
//import java.nio.ByteBuffer.*;
//import java.nio.LongBuffer;


/**
 *
 * @author Shani Sapir
 *
 */
public class ZooActions {

    /**
     * A static method that activates an eating action between two animals
     * @param animal - Animal object
     * @param food - Animal objects (implements IEdible interface)
     * @return - Returns true if the eating was done otherwise returns false
     */
    public static boolean eat(Object animal, IEdible food)
    {
        if (animal instanceof Animal && ((Animal) animal).eat(food) == true)
            return true;

        else
            return false;
    }


    /**
     * A static method that performs the movement of an animal
     * @param animal - Animal object
     * @param point - The point to which the animal is asked to move
     * @return - Returns true if the move was made successfully otherwise returns false
     */
    public static boolean move(Object animal, Point point)
    {
        if (animal instanceof Animal)
        {
            if (((Animal) animal).move(point) != 0)
            {
                MessageUtility.logBooleanFunction(((Animal) animal).getName(), "move", point, true);
                return true;
            }
        }
        MessageUtility.logBooleanFunction(((Animal) animal).getName(), "move", point, false);
        return false;
    }


}