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
 */
public class Exercise01 {
	
	public static void main(String args[]) throws IOException {
		
		InputStream inputStream = Exercise01.class.getResourceAsStream("/exercise01-1.txt");
		
		BufferedReader reader =  new BufferedReader(new InputStreamReader(inputStream));
		String text = reader.lines() .collect(Collectors.joining(System.lineSeparator()));
		
		System.out.println(text);
		
		Integer result = Stream.of(text.split("")).mapToInt(s -> ("(").equals(s)? 1: -1).sum();
		
		System.out.println(result);
		
	}

}
