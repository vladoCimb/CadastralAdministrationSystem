/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateNames;

import java.util.Random;

/**
 *
 * @author Vladko
 */
public class Digit16IDGenerator {

    private static Random rand = new Random();

    public static long createRandomInteger() {
        /*
        //get the range, casting to long to avoid overflow problems
        long range = 9999999999L - (long) 1000000000 + 1;
        // compute a fraction of the range, 0 <= frac < range
        long fraction = (long) (range * rand.nextDouble());
        long randomNumber = fraction + (long) 1000000000;
        return randomNumber;
         */
 /*
        long first14 = rand.nextInt() + 5000000000000000L;
        if(first14 < 0){
            first14 = first14 * (-1);
        }
        return first14;
         */

        Random rand = new Random();
        long x = (long) (rand.nextDouble() * 10000000000000000L);
        int length = String.valueOf(x).length();
        while (length < 16){
            x = (long) (rand.nextDouble() * 10000000000000000L);
            length = String.valueOf(x).length();
        }
        return x;
    }
}
