package diet;
import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 *
 * @author Shani Sapir
 *
 */
public class Herbivor implements IDiet {

    /**
     * Checks whether the object can eat the type of food obtained in the method
     * food - EFood type
     */
    public boolean canEat(EFoodType food)
    {
        if(food == EFoodType.VEGETABLE)
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
        double gain = weight * 0.7;
        animal.setWeight(weight + gain);
        return gain;
    }


    /**
     * To string method
     */
    public String toString()
    {
        return "[Herbivor]";
    }
}