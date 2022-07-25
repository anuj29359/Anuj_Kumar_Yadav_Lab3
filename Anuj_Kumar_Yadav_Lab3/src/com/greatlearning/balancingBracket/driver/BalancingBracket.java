package com.greatlearning.balancingBracket.driver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.greatlearning.balancingBracket.service.Stack;

public class BalancingBracket {

	public static void main(String[] args) {
		
		
		// store the test string
		String testStr = "main(in[t] k)";
		
		
		
		int openingBracketCount=0;
		int closingBracketCount=0;
		
		// create a key-value pair of brackets
		Map<String,String> brackets = new HashMap<String,String>();
		brackets.put("{", "}");
		brackets.put("(", ")");
		brackets.put("[", "]");
		
		boolean flg = true;
		Stack OpeningBrackets = new Stack(testStr.length());
		int i = 0;
		while(i < testStr.length() && flg) {
			
			String testChar = testStr.charAt(i) + "";
			for(String s: brackets.keySet()) {
				if(testChar.equals(s)) {
					OpeningBrackets.push(s);
					//System.out.println("Pushed "+ s);
					openingBracketCount++;
					break;
				}
			}
			for(String s : brackets.values()) {
				if(testChar.equals(s)) {
					String s2 = brackets.get(OpeningBrackets.pop());
					if(s.equals(s2)) {
					//System.out.println("pop " + s +" "+ s2);
					closingBracketCount++;
					break;
					}
					else {
						flg = false;
						break;
					}
				}
				
			}
			i++;
		}
		
		if(openingBracketCount==0) {
			System.out.println("No brackets found");
		}
		else if(openingBracketCount == closingBracketCount && flg) {
			System.out.println("The entered string has balanced brackets");
		}
		else {
			System.out.println("The entered string DO NOT contain balanced brackets");
		}

	}

}
