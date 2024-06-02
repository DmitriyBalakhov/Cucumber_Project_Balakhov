package utils;

import java.util.Random;
 
public class EmailGenerator {

    private static final String ALPHABET = "qwertyuiopasdfghjklzxcvbnm";

    public static String generateRandomEmail (){

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 15; i++){
            int index = random.nextInt(ALPHABET.length());
            char randomChar = ALPHABET.charAt(index);
            stringBuilder.append(randomChar);

        }
        return stringBuilder + "@gmail.com";
    }
}


