package diet;
import animals.*;
import food.EFoodType;
import food.IEdible;
import java.util.Random;

/**
 *
 * @author Theila Levi
 *
 */
public class Carnivore implements IDiet {

    /**
     * Checks whether the object can eat the type of food obtained in the method
     * food - EFood type
     */
    public boolean canEat(EFoodType food)
    {
        if(food == EFoodType.MEAT)
        {
            return true;
        }
        else
            return false;
    }


    /**
     * Activates the eating action and updates the weight field
     * animal - Animal object
     * food - A class type object that implements the IEdible interface
     */
    public double eat(Animal animal, IEdible food)
    {
        if (this.canEat(food.getFoodtype()) == false)
            return 0;
        double weight = animal.getWeight();
        double gain = weight * 0.1;
        animal.setWeight(weight + gain);
        if (animal instanceof Lion)
        {
            Random rand = new Random();
            int chance = rand.nextInt(2);
	        /* if chance value = 0 :: there is no scar addition
	           if chance value = 1 :: there is scar addition */
            if (chance == 1)
                ((Lion) animal).setScarCount(((Lion)animal).getScarCount() + 1);
        }
        return gain;
    }


    /**
     * To string method
     */
    public String toString()
    {
        return "[Carnivore]";
    }
}