package diet;
import food.*;
import animals.*;

/**
 *
 * @author Tehila Levi
 *
 */
public interface IDiet {

    public boolean canEat(EFoodType food);
    public double eat(Animal animal, IEdible food);
}