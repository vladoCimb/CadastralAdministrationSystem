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
public class RandomStringGenerator {
    
    public static String generateString() {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        String randomString = "";
        
        int length = 6;
        
        Random rand = new Random();
        char[]text = new char[length];
        
        for(int i = 0; i < length; i++){
            text[i] = characters.charAt(rand.nextInt(characters.length()));
        }
        for(int i = 0; i < text.length; i++){
            randomString += text[i];
        }
        
        return randomString;
        
   }
    
}
