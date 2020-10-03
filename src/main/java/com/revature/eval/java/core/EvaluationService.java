package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class EvaluationService {

	//temp testing main class
	public static void main(String[] args)
	{
		//EvaluationService ev = new EvaluationService();
		//RotationalCipher rc = new RotationalCipher(4);
		//System.out.println("Testing 1 2 3 testing!");
		//System.out.println(rc.rotate("Testing 1 2 3 testing!"));
		
		//AtbashCipher ci = new AtbashCipher();
		//System.out.println(ci.encode("Testing,1 2 3, testing."));
		
		//boolean b = isValidIsbn("123123113123");
	}
	
	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String input) {
		if (input.charAt(0) == ' ')
		{
			return "ERROR: Cannot start with a space.";
		}
		else
		{
			//make the acronym start with the first letter of the phrase
			String acronym = "";
			acronym += input.charAt(0);
			
			int i = 1;
			while(i < input.length())
			{
				if(input.charAt(i) == ' ' || input.charAt(i) == '-')
				{
					if(i+1 >= input.length())
						break;
					else
						acronym += input.charAt(i+1);
				}
				i++;
			}
			
			return acronym.toUpperCase();
		}
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

		public boolean isEquilateral() {
			if (sideOne == sideTwo && sideTwo == sideThree)
				return true;
			else
				return false;
		}

		public boolean isIsosceles() {
			if (sideOne == sideTwo && sideOne != sideThree)
				return true;
			else if (sideTwo == sideThree && sideTwo != sideOne)
				return true;
			else if (sideOne == sideThree && sideOne != sideTwo)
				return true;
			else
				return false;
		}

		public boolean isScalene() {
			if (sideOne != sideTwo && sideOne != sideThree && sideTwo != sideThree)
				return true;
			else
				return false;
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
	public int getScrabbleScore(String word) {
		
		word = word.toLowerCase();
		int score = 0;
		
		for (int i =0; i < word.length(); i++)
		{
			if(word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' ||
					word.charAt(i) == 'l' || word.charAt(i) == 'n' || word.charAt(i) == 'o' ||
					word.charAt(i) == 'r' || word.charAt(i) == 's' || word.charAt(i) == 't' ||
					word.charAt(i) == 'u')
				score++;
			else if (word.charAt(i) == 'd' || word.charAt(i) == 'g')
				score+=2;
			else if (word.charAt(i) == 'b' || word.charAt(i) == 'c' || word.charAt(i) == 'm' ||
					word.charAt(i) == 'p')
				score+=3;
			else if (word.charAt(i) == 'f' || word.charAt(i) == 'v' || word.charAt(i) == 'w' ||
					word.charAt(i) == 'y' || word.charAt(i) == 'h')
				score+=4;
			else if (word.charAt(i) == 'k')
				score+=5;
			else if (word.charAt(i) == 'j' || word.charAt(i) == 'x')
				score+=8;
			else if (word.charAt(i) == 'q' || word.charAt(i) == 'z')
				score+=10;
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
	public String cleanPhoneNumber(String number) {
		
		String cleanNum = "";
		
		for(int i= 0; i < number.length(); i++)
		{
			if(number.charAt(i) != '0' && number.charAt(i) != '1' && number.charAt(i) != '2' &&
					number.charAt(i) != '3' && number.charAt(i) != '4' && number.charAt(i) != '5' &&
					number.charAt(i) != '6' && number.charAt(i) != '7' && number.charAt(i) != '8' &&
					number.charAt(i) != '9')
				cleanNum = cleanNum; //do nothing
			else
				cleanNum += number.charAt(i);
		}
		
		if (cleanNum.length() != 10)
			throw new IllegalArgumentException("ERROR: Number provided did not contain 10 digits.");
		
		return cleanNum;
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
		// Creates the map that will total up the keys being given
		Map<String, Integer> map = new HashMap<String, Integer> ();
		
		String[] words = string.split("[\\s,\n]+"); //this splits if it sees any white space char
		
		//for(String s: words)
		//{
			//System.out.println(s);
		//}
		
		int i = 0;
		while(i < words.length)
		{
			
			//Checks if the word is found in the map
			if(!map.containsKey(words[i])) //if the word isn't found...
			{
				map.put(words[i], 1);
			}
			else //if the word has been found
			{
				int count = map.get(words[i]); //returns the amount of times the word occurs in the map
				map.put(words[i], count +1);
			}
			
			i++;
		}
		
		//System.out.println(map.toString());
		return map;
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
			
			//int input = 0;
			//System.out.println(t instanceof String);
			
		
			int input = Integer.parseInt(t.toString());
			//input = (Integer)t;
				
			//System.out.println("input value: " + input);
			
			int left = 0, right = sortedList.size()-1;
			
			//System.out.println("right value: " + right);
			
			while(left <= right)
			{
				int middle = (left + right) / 2; //middle formula
				
				//System.out.println("middle value: " + middle);
				//System.out.println("middle List value: " + (Integer)sortedList.get(middle));
				
				if (Integer.parseInt(sortedList.get(middle).toString()) == input) //if found...
					return middle;
				else if (Integer.parseInt(sortedList.get(middle).toString()) < input) //if closer to the start...
					left = middle + 1;
				else //if closer to the end of the list...
					right = middle - 1;
			}
			
			return -1; //couldn't find the requested value
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
		
		String[] words = string.split("[\\s,\n]+"); //this splits if it sees any white space char
		
		String currentWord = "";
		String firstConsonant = "";
		String restOfWord = "";
		String pigLatin = "";
		
		//look through all of the words from the input and convert them
		int j = 0;
		for (String input : words)
		{
			input.toLowerCase();
			if (input.charAt(0) == 'a' || input.charAt(0) == 'e' || input.charAt(0) == 'i' ||
					input.charAt(0) == 'o' || input.charAt(0) == 'u')
			{
				return currentWord = input + "ay";
			}
			else if (input.charAt(0) == 'b' || input.charAt(0) == 'c' || input.charAt(0) == 'd' ||
						input.charAt(0) == 'f' || input.charAt(0) == 'g' || input.charAt(0) == 'h' || 
						input.charAt(0) == 'j' || input.charAt(0) == 'k' || input.charAt(0) == 'l' || 
						input.charAt(0) == 'm' || input.charAt(0) == 'n' || input.charAt(0) == 'p' || 
						input.charAt(0) == 'z' || input.charAt(0) == 'r' || input.charAt(0) == 'v' || 
						input.charAt(0) == 'w' || input.charAt(0) == 'x' || input.charAt(0) == 'y')
			{
					firstConsonant += input.charAt(0);
					
					for(int i = 1; i< input.length(); i++)
					{
						restOfWord += input.charAt(i);
					}
					
					currentWord = restOfWord + firstConsonant + "ay";
			}
			else if (input.charAt(0) == 'q')//if the word starts with q...
			{
				if (input.charAt(1) == 'u') //if the next letter is u...
				{
					firstConsonant += input.charAt(0);
					firstConsonant += input.charAt(1);
					
					for(int i = 2; i< input.length(); i++)
					{
						restOfWord += input.charAt(i);
					}
					
					currentWord = restOfWord + firstConsonant + "ay";
				}
				else
				{
					firstConsonant += input.charAt(0);
					
					for(int i = 1; i< input.length(); i++)
					{
						restOfWord += input.charAt(i);
					}
					
					currentWord = restOfWord + firstConsonant + "ay";
				}
			}
			else if (input.charAt(0) == 't') //if the word starts with an t...
			{
				if (input.charAt(1) == 'h')
				{
					firstConsonant += input.charAt(0);
					firstConsonant += input.charAt(1);
					
					for(int i = 2; i< input.length(); i++)
					{
						restOfWord += input.charAt(i);
					}
					
					currentWord = restOfWord + firstConsonant + "ay";
				}
				else
				{
					firstConsonant += input.charAt(0);
					
					for(int i = 1; i< input.length(); i++)
					{
						restOfWord += input.charAt(i);
					}
					
					currentWord = restOfWord + firstConsonant + "ay";
				}
			}
			else //if the word starts with an s...
			{
				if (input.charAt(1) == 'c')
				{
					firstConsonant += input.charAt(0);
					firstConsonant += input.charAt(1);
					firstConsonant += input.charAt(2);
					
					for(int i = 3; i< input.length(); i++)
					{
						restOfWord += input.charAt(i);
					}
					
					currentWord = restOfWord + firstConsonant + "ay";
				}
				else
				{
					firstConsonant += input.charAt(0);
					
					for(int i = 1; i< input.length(); i++)
					{
						restOfWord += input.charAt(i);
					}
					
					currentWord = restOfWord + firstConsonant + "ay";
				}
			}
			
			//have to reset these Strings after each word
			firstConsonant = "";
			restOfWord = "";
			
			j++; //needs to increment so I know how many words we've gone through
			
			if(j < words.length) //if not the last word in the phrase...
				pigLatin += currentWord + " ";
			else //if last word in the phrase...
				pigLatin += currentWord;
		}
			
		return pigLatin;
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9. 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2. 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153. 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		
		//could be done with an array but lists are easier to code
		List<Integer> numbersList = new ArrayList<Integer>();
		
		boolean isArmstrong = false;
		int originalInput = input;
		
		//placing the different digits in an array
		int count = 0;
		while (input > 0)
		{
			//System.out.println(input % 10);
		    numbersList.add(input % 10);
		    input /= 10;
		    count++;
		}
		
		//System.out.println("count is: " + count);
		
		for(int integ : numbersList)
		{
			//System.out.println(integ);
		}
		
		int total = 0;
		
		//calculate armstrong total
		for (int num : numbersList)
		{
			total += Math.pow(num, count);
		}
		
		if (total == originalInput)
			isArmstrong = true;
		else
			isArmstrong = false;
		
		//System.out.println("input: " + originalInput);
		//System.out.println("total: " + total);
		//System.out.println("is Armstrong: " + isArmstrong);
		
		return isArmstrong;
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
	public List<Long> calculatePrimeFactorsOf(long input) {
		
		//creates the list to import the factors into
		List<Long> longList = new ArrayList<Long>();
		
		long number = input;
		for(long i = 2L; i< number; i++)
		{
			while(number%i == 0)
			{	
				longList.add((long)i);
				number /= i;
			}
		}
		
		if (number >= 2L)
		{
			longList.add(number);
		}
		
		return longList;
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
			
			//alphabet array (not needed)
			//char[] alph = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
					//'o','p','q','r','s','t','u','v','w','x','y','z'};
			
			String alteredString = "";

			//for every letter in the word, the letter is shifted according 
			// to the given key amount
			for(int i = 0; i < string.length(); i++)
			{
				//if a capitol letter
				if(Character.isUpperCase(string.charAt(i)))
				{
					//formula is: ((current_letter + key - 65)%26 +65)
					alteredString += Character.toUpperCase((char)(((int)string.charAt(i) + key-65)%26 +65));
				}
				//if a lower case letter
				else if(Character.isLowerCase(string.charAt(i)))//if lowercase letter
				{
					alteredString += (char)(((int)string.charAt(i) + key-97)%26 +97);
				}
				//if any other character. Like a '-' , ' ' , '!' , etc...
				else
				{
					alteredString += string.charAt(i);
				}
			}
			
			return alteredString;
			
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
	public int calculateNthPrime(int input) {
		
		//check if the user inserts a number that is either
		// 0 or a negative number
		if(input <= 0)
		{
			throw new IllegalArgumentException();
		}
	
	    int number = 1;
	    int primesFound = 0;
	    
	    //this loop keeps testing and finding each prime number
	    // imaginable (starting from 1) until it has looped enough 
	    // times; based on the number given by the user
	    int i;
	    while (primesFound < input)
	    {
	      number = number+1;
	      for (i = 2; i <= number; i++)
	      {
	    	
	        if (number % i == 0)
	        {
	          break;
	        }
	      }
	      //When a prime number is found that matches the number given
	      // by the user
	      if (i == number)
	      {
	    	  primesFound++;
	      }
	    }
		
		return number;
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
			
			StringBuilder spaceless = new StringBuilder(); //Matthew's idea, turns out I could just use a string
			string = string.toLowerCase();
			String alteredString = "";
			
			final Map<Character, Character> alphMap = getMap();
			
			//removes punctuation from string
			for(int i = 0; i < string.length(); i++)
			{
				//System.out.println("Yo yo.");
				if(string.charAt(i) != ' ' && string.charAt(i) != '.' && string.charAt(i) != ',')
					spaceless.append(string.charAt(i));
			}
			
			//System.out.println(spaceless);
			
			//replacing alphabetical characters with their opposites
			for(int j = 0; j < spaceless.length(); j++)
			{
				if(j%5 == 0 && j != 0) //adds space into the string every 5 loops
				{
					alteredString += " " + alphMap.get(spaceless.charAt(j));
				}
				else
				{
					alteredString += alphMap.get(spaceless.charAt(j));
				}
			}
			
			//System.out.println(alteredString);
			
			return alteredString;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String alteredString = "";
			
			final Map<Character, Character> alphMap = getMap();
			
			//remove spaces and decodes babyyyy. Map's are wonderful
			for(int i =0; i< string.length(); i++)
			{
				if (string.charAt(i) != ' ')
				{
					alteredString += alphMap.get(string.charAt(i));
				}	
			}
			
			return alteredString;
		}
		
		private static Map<Character, Character> getMap()
		{
			Map<Character, Character> alphMap = new TreeMap<Character, Character>();
			
			//         Orig   New
			alphMap.put('a', 'z');
			alphMap.put('b', 'y');
			alphMap.put('c', 'x');
			alphMap.put('d', 'w');
			alphMap.put('e', 'v');
			alphMap.put('f', 'u');
			alphMap.put('g', 't');
			alphMap.put('h', 's');
			alphMap.put('i', 'r');
			alphMap.put('j', 'q');
			alphMap.put('k', 'p');
			alphMap.put('l', 'o');
			alphMap.put('m', 'n');
			alphMap.put('n', 'm');
			alphMap.put('o', 'l');
			alphMap.put('p', 'k');
			alphMap.put('q', 'j');
			alphMap.put('r', 'i');
			alphMap.put('s', 'h');
			alphMap.put('t', 'g');
			alphMap.put('u', 'f');
			alphMap.put('v', 'e');
			alphMap.put('w', 'd');
			alphMap.put('x', 'c');
			alphMap.put('y', 'b');
			alphMap.put('z', 'a');
			alphMap.put('0','0');
			alphMap.put('1','1');
			alphMap.put('2','2');
			alphMap.put('3','3');
			alphMap.put('4','4');
			alphMap.put('5','5');
			alphMap.put('6','6');
			alphMap.put('7','7');
			alphMap.put('8','8');
			alphMap.put('9','9');
			
			return alphMap;
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
		
		int runningTotal = 0;
		List<Integer> intList = new ArrayList<>();
		
		//TODO: convert string to int array without hyphens and converting X -> 10
		for(int i = 0; i < string.length(); i++)
		{
			if (string.charAt(i) != '-' && string.charAt(i) != 'K' && 
					string.charAt(i) != 'A' && string.charAt(i) != 'X')
			{
				intList.add(Character.getNumericValue(string.charAt(i)));
			}	
			else if(string.charAt(i) == 'X')
			{
				intList.add(10);
			}
		}
		
		if(intList.size() != 10)
			return false;
		
		//for(int j : intList)
		//{
			//System.out.print(j + " ");
		//}
		//System.out.print("\n");
		
		int j = 0;
		//loop that calculates the running total according to the formula
		for(int i = intList.size(); i > 0; i--)
		{
			//System.out.println("list val: " + intList.get(j) + " * " + i );
			//System.out.println("= " + intList.get(j) * i);
			runningTotal += intList.get(j) * i;
			//System.out.println("running total: " + runningTotal);
			j++;
		}
		
		//System.out.println("size of array list: " + intList.size());	
		//System.out.println("running total MOD 11: " + runningTotal%11);
		
		if ((runningTotal % 11) == 0)
			return true;
		else
			return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
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
		
		if (string.length() < 1)
		{
			return false;
		}
		
		//parallel arrays save the day yet again
		char[] alph = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n',
				'o','p','q','r','s','t','u','v','w','x','y','z'};
		int[] valid = new int[26];
		
		//fill valid array with zeros
		for(int k = 0; k < 26; k++)
		{
			valid[k] = 0;
		}
		
		//check every character of the given string to see if it's in the alphabet
		// if yes then a second array with 
		for(int i = 0; i < string.length(); i++)
		{
			for(int j = 0; j < 26; j++)
			{
				if(string.charAt(i) == alph[j])
				{
					valid[j] += 1;
				}
			}
		}
		
		//System.out.println();
		
		//if any of the numbers in this array are 0 then that letter never appeared
		for(int i : valid)
		{
			if (i == 0)
				return false;
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
		//plus seconds
		if(given instanceof LocalDate)
		{
			//change given to include time
			LocalDate localDate = (LocalDate) given;
			LocalDateTime resultDate = localDate.atTime(0,0,0); //.atTime(0,0,0) give it time
			
			resultDate = resultDate.plusSeconds((long)Math.pow(10, 9));
			
			return resultDate;
		}
		else
		{
			LocalDateTime startDate = LocalDateTime.from(given);
			LocalDateTime resultDate = startDate.plusSeconds((long)Math.pow(10, 9));
			
			return resultDate;
		}
		
		
		
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
	public int getSumOfMultiples(int limitNum, int[] set) {
		
		int runningTotal = 0;
		int result =0;
		boolean canAdd = true;
		List<Integer> intList = new ArrayList<>();
		
		for(int j = 0; j < set.length; j++)
		{
			for(int i = 1; i < limitNum; i++)
			{
				canAdd = true;
				//calcuate multipule of each member of the set
				result = set[j] * i;
				
				//so long as the result is less than the limiting value
				if(result < limitNum)
				{
					//checks for duplicate values in the list of multipules
					for(int num : intList)
					{
						if(num == result)
							canAdd = false;
					}
					
					if(canAdd)
						intList.add(result);
				}
				else
					break;
			}
		}
		
		for(int i : intList)
		{
			//System.out.print(i + " ");
			runningTotal += i;
		}
		//System.out.print("\n");
		//System.out.println("runningTotal = " + runningTotal);
		
		return runningTotal;
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
		
		string = string.replaceAll("[\\s()]", ""); //gets rid of spaces from string
		
		//System.out.println(string);
		
		List<Integer> intList = new ArrayList<>();
		int runningTotal = 0;
		
		for(int i = 0; i < string.length(); i++)
		{
			if(string.charAt(i) != 'a' && string.charAt(i) != 'b' && string.charAt(i) != 'c'
					&& string.charAt(i) != 'd' && string.charAt(i) != 'e' && string.charAt(i) != 'f'
					&& string.charAt(i) != '-')
			{
				intList.add(Character.getNumericValue(string.charAt(i)));
			}
			else
			{
				return false;
			}
		}
		
		//for(int k : intList)
		//{
			//System.out.print(k + " ");
		//}
		//System.out.print("\n");
		
		for(int j = 0; j < intList.size(); j++)
		{
			if(j%2 == 1)
			{
				int temp = intList.get(j);
				int tempDouble = temp * 2;
				if(tempDouble > 9)
					tempDouble -= 9;
				intList.set(j, tempDouble);
			}
		}
		
		//for(int k : intList)
		//{
			//System.out.print(k + " ");
		//}
		//System.out.print("\n");
		
		//calculate the running total of all the ints inside this list
		for(int k : intList)
		{
			runningTotal += k;
		}
		
		//System.out.println("running total: " + runningTotal);
		
		if(runningTotal%10 == 0)
			return true;
		else
			return false;
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
		
		string = string.toLowerCase();
		
		String[] words = string.split("[\\s,\n?]+"); //this splits if it sees any non letter char
		
		//determines the operation being applied to the two ints
		int oper =0;
		int firstInt = 0, secondInt = 0; //ints themselves
		
		//iterates through each extracted String value looking for the int and operator values
		for(String s : words)
		{
			//System.out.print(s + " ");
			
			if(isInt(s) && firstInt == 0)
				firstInt = Integer.parseInt(s);
			else if (isInt(s) && firstInt != 0 && secondInt == 0)
				secondInt = Integer.parseInt(s);
			
			
			
			if(s.equals("plus"))
				oper = 0;
			else if(s.equals("minus"))
				oper = 1;
			else if(s.equals("multiplied"))
				oper = 2;
			else if(s.equals("divided"))
				oper = 3;
		}
		//System.out.println("\nfirst int: " + firstInt);
		//System.out.println("operation: " + oper);
		//System.out.println("second int: " + secondInt);
		
		if(oper == 0)
			return firstInt + secondInt;
		if(oper == 1)
			return firstInt - secondInt;
		if(oper == 2)
			return firstInt * secondInt;
		if(oper == 3)
			return firstInt / secondInt;
		
		return 0;
	}
	
	private boolean isInt(String input)
	{
		try {
			Integer.parseInt(input);
			return true;
		} catch(NumberFormatException e)
		{
			return false;
		}
	}

}
