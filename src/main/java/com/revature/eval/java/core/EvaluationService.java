package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.*;
import java.lang.Math;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		int i;
		char temp;
		char[] charArray = string.toCharArray();
		
		//swapping the first and last letter and continuing with the other letters and their corresponding pairs
		for (i = 0; i < (charArray.length/2); i++) {
			temp = charArray[i];
			charArray[i] = charArray[(charArray.length - i - 1)];
			charArray[(charArray.length - i - 1)] = temp;
		}
		
		String reverseString = new String(charArray);
		return reverseString;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String firstLetterAcronym = "";
		
		//Separating the String into words
		String[] phraseArr = phrase.split(" ");
		
		//taking the first letter of each word
		for (int i = 0; i < phraseArr.length; i++) {
			firstLetterAcronym += (phraseArr[i].charAt(0));
		}
		
		return firstLetterAcronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		//checking if all sides are equal
		public boolean isEquilateral() {
			if (this.sideOne == this.sideTwo && this.sideOne == this.sideThree) {
				return true;
			}else {
				return false;
			}
			
		}

		//checking if at least two sides are equal
		public boolean isIsosceles() {
			if (this.sideOne == this.sideTwo || this.sideTwo == this.sideThree || this.sideOne == this.sideThree) {
				return true;
			}else {
				return false;
			}
			
		}

		//checking if no sides are equal
		public boolean isScalene() {
			if (this.sideOne == this.sideTwo || this.sideTwo == this.sideThree || this.sideOne == this.sideThree) {
				return false;
			}else {
				return true;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		string = string.toUpperCase();
		int score = 0;
		
		//cycling through the word to add the assigned values of the letters
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == 'A' || string.charAt(i) == 'E' || string.charAt(i) == 'I' || string.charAt(i) == 'O' || string.charAt(i) == 'U'
			|| string.charAt(i) == 'L' || string.charAt(i) == 'N' || string.charAt(i) == 'R' || string.charAt(i) == 'S' || string.charAt(i) == 'T') {
				score += 1;
			}else if (string.charAt(i) == 'D' || string.charAt(i) == 'G') {
				score += 2;
			}else if (string.charAt(i) == 'B' || string.charAt(i) == 'C' || string.charAt(i) == 'M' || string.charAt(i) == 'P') {
				score += 3;
			}else if (string.charAt(i) == 'F' || string.charAt(i) == 'H' || string.charAt(i) == 'V' || string.charAt(i) == 'W' || string.charAt(i) == 'Y') {
				score += 4;
			}else if (string.charAt(i) == 'K') {
				score += 5;
			}else if (string.charAt(i) == 'J' ||string.charAt(i) == 'X') {
				score += 8;
			}else if (string.charAt(i) == 'Q' ||string.charAt(i) == 'Z') {
				score +=10;
			}
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		char[] inputNum = string.toCharArray();
		String phoneNumber = "";
		
		//adding just the numbers input into a new string
		for (int i = 0; i < inputNum.length; i++) {
			if (inputNum[i] == '1' || inputNum[i] == '2' || inputNum[i] == '3' || inputNum[i] == '4' || inputNum[i] == '5'
			|| inputNum[i] == '6' || inputNum[i] == '7' || inputNum[i] == '8' || inputNum[i] == '9' || inputNum[i] == '0') {
				phoneNumber += inputNum[i];
			}
		}
		
		//removing country code if applicable
		if(phoneNumber.charAt(0) == 1) {
			phoneNumber = phoneNumber.substring(1);
		}
		
		//checking to see if we still have a valid phone number
		if(phoneNumber.length() != 10) {
			throw new IllegalArgumentException();
		}
		
		//checking that the numbers that can be from 2-9 are not 0 or 1
		if(phoneNumber.charAt(0) == 1 || phoneNumber.charAt(0) == 0 || phoneNumber.charAt(3) == 1 || phoneNumber.charAt(3) == 0) {
			throw new IllegalArgumentException();
		}
		
		return phoneNumber;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		Map<String, Integer> wordCount = new HashMap<>();
		
		//converting non-word characters to the same character for splitting
		string = string.replaceAll(","," ");
		string = string.replaceAll("\n", " ");
		string = string.replaceAll(" +", " ");
		
		//splitting the string into individual words
		String[] wordArr = string.split(" ");
		
		int counter;
		
		//counting the words
		for ( String s : wordArr) {
			if(wordCount.containsKey(s)) {
				counter = wordCount.get(s) + 1;
				wordCount.put(s, counter);
			}else if(!wordCount.containsKey(s)) {
				wordCount.put(s, 1);
			}
		}
		
		return wordCount;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String[] wordArr = string.split(" ");
		
		//converting to Pig Latin
		for(int i = 0; i < wordArr.length; i++) {
			if(wordArr[i].charAt(0) == 'a' || wordArr[i].charAt(0) == 'e' || wordArr[i].charAt(0) == 'i' || wordArr[i].charAt(0) == 'o' || wordArr[i].charAt(0) == 'u') {
				wordArr[i] += "ay";
				
			//finding the first vowel except for qu and moving all letters before to the end and adding ay 
			}else if(wordArr[i].charAt(0) != 'a' && wordArr[i].charAt(0) != 'e' && wordArr[i].charAt(0) != 'i' && wordArr[i].charAt(0) != 'o' && wordArr[i].charAt(0) != 'u') {
				for(int j = 1; j < wordArr[i].length(); j++) {
					if((wordArr[i].charAt(j) == 'a' || wordArr[i].charAt(j) == 'e' || wordArr[i].charAt(j) == 'i' || wordArr[i].charAt(j) == 'o' || wordArr[i].charAt(j) == 'u') && wordArr[i].charAt(j - 1) != 'q') {
						wordArr[i] = (wordArr[i].substring(j) + wordArr[i].substring(0,j) + "ay");
						j = wordArr[i].length();
					}
				}
			}
		}
		
		//putting back into a single string
		String wordString = "";
		for(String s : wordArr) {
			wordString += (s + " ");
		}
		wordString = wordString.trim();
		return wordString;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		//first we need to get the individual digits of the number
		List<Integer> digits = new ArrayList<>();
		Integer temp = new Integer(input);
		while(temp != 0) {
			digits.add(temp % 10);
			temp = ((temp - temp % 10)/10);
		}
		
		//now we do the math
		int newInt = 0;
		for(Integer i : digits) {
			newInt += (int) Math.pow(i, digits.size());
		}
		
		//now we equate
		if(newInt == input) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> primeFactors = new ArrayList<>();
		
		//go through until all factors are found
		while(l != 1) {
			
			//start at two and go up so you don't have to worry about getting factors that have factors
			long i = 2;
			
			//loop until you find a factor
			while(l % i != 0) {
			i = i + 1L;
			}
			
			//take the factor out and go again
			l = l/i;
			primeFactors.add(i);
		}
		
		return primeFactors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			//setting up String arrays to sort through our messages
			String[] alphabetLowercase = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
			String[] alphabetUppercase = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
			
			//Separating the input string into a string array with an index for each character
			String[] stringCharacters = string.split("");
			
			//identifying the letters and changing them
			int newIndex = 0;
			for (int i = 0; i < stringCharacters.length; i++) {
				for (int j = 0; j < alphabetLowercase.length; j++) {
					if(stringCharacters[i].equals(alphabetLowercase[j])) {
						newIndex = j + this.key;
						//looping back to the start of the alphabet
						if(newIndex > 25) {
							newIndex -= 26;
						}
						stringCharacters[i] = alphabetLowercase[newIndex];
						j = alphabetLowercase.length;
					}else if(stringCharacters[i].equals(alphabetUppercase[j])) {
						newIndex = j + this.key;
						//looping back to the start of the alphabet
						if(newIndex > 25) {
							newIndex -= 26;
						}
						stringCharacters[i] = alphabetUppercase[newIndex];
						j = alphabetUppercase.length;
					}
				}
			}
			
			//joining the array back into a single String
			String codedString = "";
			for (String s : stringCharacters) {
				codedString += s;
			}
			
			return codedString;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		
		if (i < 1) {
			throw new IllegalArgumentException();
		}
		
		//calculating primes, and stopping at the ith prime
		int primeCounter = 0;
		
		//set potentailPrime and j to 2 to avoid issues with 0 and 1
		int potentialPrime = 2;
		//declaring j here to broaden its scope
		int j;
		while(primeCounter != i) {
			
			//loop to increment k until j is divisible by it
			for( j = 2; potentialPrime % j != 0; j++);
			if( potentialPrime == j ) {
				primeCounter++;
			}
			potentialPrime++;
		}
		
		//reverting the increment from the loop by one
		potentialPrime--;
		
		return potentialPrime;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 *        zyxwvutsrqponmlkjihgfedcba
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			String[] alphabetLowercase = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
			string = string.toLowerCase();
			String[] stringArr = string.split("");
			
			int lettersCounter = 0;
			String encodedString = "";
			
			//separating the letters and coding them
			for(String s: stringArr) {
				for(int i = 0; i < alphabetLowercase.length; i++) {
					if(s.equals(alphabetLowercase[i])) {
						
						//separating into 5 letter groups
						if (lettersCounter % 5 == 0 && lettersCounter != 0) {
							encodedString += " ";
						}
						lettersCounter++;
						
						//reversing the letter and adding it to the code
						int j = (25 - i);
						encodedString += alphabetLowercase[j];
					}
				}
				
				//checking for numbers
				if(s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9") || s.equals("0")) {
					
					//separating into 5 letter groups
					if (lettersCounter % 5 == 0 && lettersCounter != 0) {
						encodedString += " ";
					}
					lettersCounter++;
					
					encodedString += s;
				}
				
			}
			return encodedString;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String[] alphabetLowercase = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
			String[] stringArr = string.split("");
			
			String decodedString = "";
			
			for(String s: stringArr) {
				for(int i = 0; i < alphabetLowercase.length; i++) {
					if(s.equals(alphabetLowercase[i])) {
						
						//reversing the letter and adding it to the phrase
						int j = (25 - i);
						decodedString += alphabetLowercase[j];
					}
				}
				
				//checking for numbers
				if(s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9") || s.equals("0")) {
					decodedString += s;
				}
				
			}
			
			return decodedString;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		String[] stringArr = string.split("");
		Integer checkNum = 0;
		
		//this j will keep track of what number we are on
		int j = 0;
		
		//checking the value of the Strings and doing some math based on what they are
		for(int i = 0; i < stringArr.length; i++) {
			if(stringArr[i].equals("1") || stringArr[i].equals("2") || stringArr[i].equals("3") || stringArr[i].equals("4") || stringArr[i].equals("5") ||
				stringArr[i].equals("6") || stringArr[i].equals("7") || stringArr[i].equals("8") || stringArr[i].equals("9") || stringArr[i].equals("0")) {
				checkNum += (Integer.valueOf(stringArr[i]) * (10 - j));
			}else if(stringArr[i].equals("-")) {
				j--;
			}else if(stringArr[i].equals("X") && (i + 1) == stringArr.length) {
				checkNum += 10;
			}else {
				return false;
			}
			j++;
		}
		if(checkNum % 11 == 0) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: Ï€Î±Î½ Î³Ï�Î¬Î¼Î¼Î±, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		String[] stringArr = string.split("");
		String[] alphabetLowercase = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		String[] alphabetUppercase = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

		//for each character cycle through the alphabet and check off the ones that we find
		for(String s: stringArr) {
			for(int i = 0; i < alphabetLowercase.length; i++) {
				if(s.equals(alphabetLowercase[i]) || s.equals(alphabetUppercase[i])) {
					alphabetLowercase[i] = null;
					i = alphabetLowercase.length;
				}
			}
		}
		
		//check if all letters have been checked off
		for(String s: alphabetLowercase) {
			if(s != null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		int sumNum = 0;
		
		//starting at 1 to avoid problems with 0 we cycle through the numbers and check if they have one of our set numbers as factors
		for (int j = 1; j < i; j++) {
			for (int k = 0; k < set.length; k++) {
				if(j % set[k] == 0) {
					sumNum += j;
					k = set.length;
				}
			}
		}
		return sumNum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		String[] stringArr = string.split("");
		List<Integer> processedNum = new ArrayList<>();
		int sumNum = 0;
		
		//make sure the string length is longer than one
		if (stringArr.length <= 1) {
			return false;
		}
		
		//separate the numbers into a new array
		for (String s: stringArr) {
			if(s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") ||
					s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9") || s.equals("0")) {
					processedNum.add(Integer.valueOf(s));
			}else if(s.equals(" ")) {
			}else {
				return false;
			}
		}
		
		//change the numbers that need to be changed and add them up
		for(int i = 0; i < processedNum.size(); i++) {
			if(i % 2 == 1) {
				processedNum.set(((processedNum.size() - 1) - i), (processedNum.get((processedNum.size() - 1) - i) * 2));
				if(processedNum.get((processedNum.size() - 1) - i) > 9) {
					processedNum.set(((processedNum.size() - 1) - i), (processedNum.get((processedNum.size() - 1) - i) - 9));
				}
			}
			sumNum += processedNum.get(processedNum.size() - 1 - i);
		}
		
		//final check
		if (sumNum % 10 == 0) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

}
