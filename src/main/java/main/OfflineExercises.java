package main;

import java.util.Arrays;

public class OfflineExercises {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") → "TTThhheee"
	// multChar("AAbb") → "AAAAAAbbbbbb"
	// multChar("Hi-There") → "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String ret = "";
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < 3; j++) {
				ret+=input.substring(i,i+1);
			}
		}
		return ret;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") → "evilc"
	// getBert("xxbertfridgebertyy") → "egdirf"
	// getBert("xxBertfridgebERtyy") → "egdirf"
	// getBert("xxbertyy") → ""
	// getBert("xxbeRTyy") → ""

	public String getBert(String input) {
		int bert1 = Integer.MAX_VALUE;
		int bert2 = Integer.MIN_VALUE;
		String ret = "";
		for (int i = 0; i < input.length()-7; i++) {
			if (input.substring(i,i+4).toLowerCase().equals("bert")) {
				bert1 = i+4;
			}
		}
		for (int i = input.length()-4; i>=3; i--) {
			if (input.substring(i,i+4).toLowerCase().equals("bert")) {
				bert2 = i;
			}
		}
		
		if (bert1 == Integer.MAX_VALUE || bert2 == Integer.MIN_VALUE) return "";
		
		for (int i = bert2-1; i >= bert1; i--) {
			ret += input.substring(i,i+1);
		}
//		System.out.println(ret);
		
		return ret;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false
	// evenlySpaced(4, 60, 9) → false

	public boolean evenlySpaced(int a, int b, int c) {
		int[] arr = {a,b,c};
		boolean ret = false;
		Arrays.parallelSort(arr);
		if (arr[1] - arr[0] == arr[2] - arr[1]) ret = true;  
		
		return ret;
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) → "Ho"
	// nMid("Chocolate", 3) → "Choate"
	// nMid("Chocolate", 1) → "Choclate"

	public String nMid(String input, int a) {
		int startMid = (int) (input.length()-a)/2;
		String ret = input.substring(0,startMid) + input.substring(startMid+a,input.length());
		return ret;
	}

	// Given a string, return true if it ends in "dev". Ignore Case

	// endsDev("ihatedev") → true
	// endsDev("wehateDev") → true
	// endsDev("everoyonehatesdevforreal") → false
	// endsDev("devisnotcool") → false

	public boolean endsDev(String input) {
		boolean ret = false;
		if (input.length() >= 3) {
			if (input.substring(input.length()-3,input.length()).toLowerCase().equals("dev")) ret = true;
		}
		return ret;
	}



	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") → 2
	// superBlock("abbCCCddDDDeeEEE") → 3
	// superBlock("") → 0

	public int superBlock(String input) {
		int max = 0;
		int maxCurrent = 0;
		for (int i = 1; i < input.length(); i++) {
			if (input.substring(i-1,i).equals(input.substring(i,i+1))) {   
				maxCurrent++;
			} else {
//				System.out.println(max);
//				System.out.println(maxCurrent);
				max = (maxCurrent+1 > max) ? maxCurrent+1 : max; //+1 to account for 1st occurrence of the letter
				maxCurrent = 0;
			}
		}
		return max;
		/* hoopplla:
		 * 1st check if h == o: false
		 * 2nd check if o == o: true, maxCurrent==1
		 * 3rd check if p
		 */
	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") → 1
	//amISearch("I am in Amsterdam am I?") → 2
	//amISearch("I have been in Amsterdam") → 0

	public int amISearch(String arg1) {
		int ret = 0;
		if (arg1.length() == 2) {
			if (arg1.toLowerCase().equals("am")) return 1;
			else return 0;
		}
//		System.out.println(arg1);
		for (int i = 0; i < arg1.length()-1; i++) {
			if (arg1.substring(i, i+2).toLowerCase().equals("am") ) {
				if (i==0) {
					if (arg1.charAt(2) == ' ') 	ret++;
				} else if (i==arg1.length()-2) {
					if (arg1.charAt(arg1.length()-3) == ' ') ret++;
				} else {
					if (arg1.charAt(i-1) == ' ' && arg1.charAt(i+2) == ' ') ret++;
				}
			}
			
		}
		
		
		return ret;
		
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) → "fizz"
	//fizzBuzz(10) → "buzz"
	//fizzBuzz(15) → "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		String ret = "";
		if (arg1%3 == 0) ret+="fizz";
		if (arg1%5 == 0) ret+="buzz";
		return ret;
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") → 14
	//largest("15 72 80 164") → 11
	//largest("555 72 86 45 10") → 15
	
	public int largest(String arg1) {
		int ret = 0;
		int adder = 0;
		String toAdd = "";
		arg1 += " "; //simple fix for last char being a number
		
		
		for (int i = 0; i < arg1.length(); i++) {
			
			if (arg1.charAt(i) == ' ') {
				for (int j = 0; j < toAdd.length(); j++) {
					adder += Integer.valueOf(toAdd.substring(j,j+1));
				}
//				System.out.println(toAdd+" "+adder);
				toAdd = "";
				ret = (adder > ret) ? adder : ret;
				adder = 0;
				
			} else {
				
				toAdd += (arg1.substring(i,i+1));
			}
			
		}
		
		
		return ret;
		
	}
	
	
}
