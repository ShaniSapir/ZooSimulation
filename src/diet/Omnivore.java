package diet;
import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 *
 * @author Shani Sapir
 *
 */
public class Omnivore implements IDiet {

    Carnivore carnivore = new Carnivore();
    Herbivor herbivor = new Herbivor();

    /**
     * Checks whether the object can eat the type of food obtained in the method
     * food - EFood type
     */
    public boolean canEat(EFoodType food)
    {
        if(food == EFoodType.MEAT || food == EFoodType.VEGETABLE)
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
        if (food.getFoodtype() == EFoodType.MEAT)
        {
            //this.carnivore = (Carnivore)animal.getIDiet();
            return this.carnivore.eat(animal, food);
        }
        else
            return this.herbivor.eat(animal, food);
    }


    /**
     * To string method
     */
    public String toString()
    {
        return "[Omnivore]";
    }
}