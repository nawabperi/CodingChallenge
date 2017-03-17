import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
    public Solution(){
    }

    /**
     * Takes in an array of strings, and returns an array of answers
     * @param s - string input array
     * @return - array of int answers of how many powers of five fit into each string in the array
     */
    public int[] getMin(String[] s){
    	int [] result=new int[s.length] ;
    	int k=0;
    	for (String binaryDigit : s) {
    		binaryDigit=binaryDigit.replaceFirst("^0+(?!$)", "");
    	    long [] f = new long [binaryDigit.length() + 1] ;
    		f[0] = 0;	
    		for (int i = 1 ; i <= binaryDigit.length() ;++i) {
    			f[i] = Integer.MAX_VALUE;
    		 for (int j = 1 ; j <= i ;++j) {
    			 if (binaryDigit.charAt(j - 1) == '0'){
    				 continue ;
    			 }
    			 long num = Long.parseLong(binaryDigit.substring(j - 1, i), 2);			 
    			 if (isPower(num)) {
    				 f[i] = Math.min(f[i], f[j - 1] + 1) ;				 
    			 }			 
    		 }
    		}		
    	result[k]=f[binaryDigit.length()] == Integer.MAX_VALUE ? -1 : (int)f[binaryDigit.length()];
    	k++;
    	}

		return result;
    }
    private boolean isPower (long val){
		if (val == 0) {
			return false ;
		}
		int n = (int)(Math.log(val) / Math.log(5));
		return Math.pow(5, n) == val;
	}
    public static void main(String[] args) {
    	Solution solution=new Solution();
    	String s []= {"101", "101101101", "1111101", "00000", "11111111111111111111111111111111111111111111111111",
              "10110001101000101011110000101110110001010", "10110001101000101011110000101110110001011", "111011100110101100101110111",
           "001000", "000001", "110111110101111000011", "10111", "1011", "1011000110100010101111000010111011000101"};
    	int [] res= solution.getMin(s);
    	for (int x : res)
    	{
    		System.out.println(x);
    	}
    }

}