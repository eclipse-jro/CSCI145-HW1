////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// AUTHOR   | Jon Garber && Jose Rene Ortega Jr.
// DATE     | February 12th, 2019
// PROJECT  | CSCI145 Homework One
// FILE     | For use in producing random values, such as: random monster type, gold amounts, damage amounts, etc.
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.lang.Math;

public class RandomGenerator {

    //get random integer from the inclusive range of a minimum and maximum value
    public int randInt(int min, int max) {

        return (int)((Math.random()*( max-(min-1)) ) + min);

    }
}