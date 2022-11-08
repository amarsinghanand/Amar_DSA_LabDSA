package com.gl.dsa.lab.balancedbracket;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBracketMain {

	private static boolean isBalancedParentheses(String str) {
		int n = str.length();
		Stack<Character> bracketsString = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
				bracketsString.push(str.charAt(i));
			} else {
				if (bracketsString.empty()) {
					return false;
				}
				if (str.charAt(i) == ')') {
					char last = bracketsString.peek();
					bracketsString.pop();
					if (last != '(') {
						return false;
					}
				}
				if (str.charAt(i) == '}') {
					char last = bracketsString.peek();
					bracketsString.pop();
					if (last != '{') {
						return false;
					}
				}
				if (str.charAt(i) == ']') {
					char last = bracketsString.peek();
					bracketsString.pop();
					if (last != '[') {
						return false;
					}
				}
			}
		}
		return bracketsString.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println("******************************************************");
		System.out.println("Welcome to the balanced bracket assignment solution");
		System.out.println("******************************************************");
		System.out.println("Please enter brackets string to validate if it has the balanced brackets or not");
		Scanner in = new Scanner(System.in);
		String s = in.next();
		if (isBalancedParentheses(s)) {
			System.out.println("Entered string has the balanced brackets");
		} else {
			System.out.println("Entered string does not have the balanced brackets");
		}
		in.close();
	}

}
