import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        //k = number of left rotations
        // n = size of a
        int currentIndex = 0;
        int[] leftRotatedArray = new int [n];
        for(int i = k; i < n; i++, currentIndex++){
            leftRotatedArray[currentIndex] = a[i];
        }
     
        //now we copied the values after k. We add the values before k only if k < n
        if(k < n){
            for(int i = 0; i < k; i++, currentIndex++){
                leftRotatedArray[currentIndex] = a[i];
            }
        }
        
        return leftRotatedArray;
        
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
      
    }
}
