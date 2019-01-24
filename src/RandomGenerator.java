/*  For use in producing random values,
    such as: random monster type, gold amounts,
    damage amounts, etc.
    Might end up being moved into a different class as a method. */

import java.lang.Math;

public class RandomGenerator {

    //get random integer from the inclusive range of a minimum and maximum value
    public int randInt(int min, int max) {
        int random = (int)((Math.random()*( max-(min-1)) ) + min);
        return random;
    }
}