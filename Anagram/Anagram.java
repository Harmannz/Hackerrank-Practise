import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
// import we need math library for calculating absolute. (We can also use ternary operator if do not want to use this)
import java.lang.Math;

public class Solution {
    private static final int ALPHABET_COUNT = 26; 
    
    
    public static int numberNeeded(String first, String second) {
        int index;
        // first handle edge cases
        // java characters are unicode (with numeric value)
        // create alphabet count for first
        int[] firstAlphabetCount = new int[ALPHABET_COUNT];
        int[] secondAlphabetCount = new int[ALPHABET_COUNT];
        // now read each character in first and update the alphabet count in first
        for(int i = 0; i < first.length(); i++) {
            index = first.charAt(i) - 'a';
            firstAlphabetCount[index]++;
        }
        for(int i = 0; i < second.length(); i++) {
            index = second.charAt(i) - 'a';
            secondAlphabetCount[index]++;
        }
        int difference = 0;
        // now calculate the difference in two alphabet counts
        for(int i = 0; i < ALPHABET_COUNT; i++){
            difference += Math.abs(firstAlphabetCount[i] - secondAlphabetCount[i]);
        }
        
        return difference;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
