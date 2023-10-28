package com.github.ikermarin.aoc.year2015.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Santa is trying to deliver presents in a large apartment building, but he can't find the right floor - the directions he got are a little confusing. He starts on the ground floor (floor 0) and then follows the instructions one character at a time.

An opening parenthesis, (, means he should go up one floor, and a closing parenthesis, ), means he should go down one floor.

The apartment building is very tall, and the basement is very deep; he will never find the top or bottom floors.

For example:

(()) and ()() both result in floor 0.
((( and (()(()( both result in floor 3.
))((((( also results in floor 3.
()) and ))( both result in floor -1 (the first basement level).
))) and )())()) both result in floor -3.
To what floor do the instructions take Santa?


--- Part Two ---
Now, given the same instructions, find the position of the first character that causes him to enter the basement (floor -1). The first character in the instructions has position 1, the second character has position 2, and so on.

For example:

) causes him to enter the basement at character position 1.
()()) causes him to enter the basement at character position 5.
What is the position of the character that causes Santa to first enter the basement?

*/
public class Exercise01 {
	
	public static void main(String args[]) throws IOException {
		
		InputStream inputStream = Exercise01.class.getResourceAsStream("/exercise01-1.txt");
		
		BufferedReader reader =  new BufferedReader(new InputStreamReader(inputStream));
		String text = reader.lines() .collect(Collectors.joining(System.lineSeparator()));
		
		System.out.println(text);
		
		//PART 1
		Integer result = Stream.of(text.split("")).mapToInt(s -> ("(").equals(s)? 1: -1).sum();
		System.out.println(result);
		
		//PART 2
		
		System.out.println(calculateFirstTimeInBasement(text));
		
	}

	private static int calculateFirstTimeInBasement(String text) {
		Integer floor = 0;
		for(Integer i = 0; i<text.length(); i++) {
			floor += Character.compare('(', text.charAt(i)) == 0 ? 1: -1;
			if(floor<0) {
				return i+1;
			}
		}
		return text.length();
	}

}
