package com.spell.number;

import java.text.NumberFormat;
import java.util.Scanner;

public class SpellNumberMain {
	public static void main(final String[] args) {

		int n;
		
		// Scanner scanner = new Scanner(System.in);
		// scanner.nextLine();
		
		n = 8;
		System.out.println(NumberFormat.getInstance().format(n) + "='" + SpellNumber.convert(n) + "'");

		n = 16;
		System.out.println(NumberFormat.getInstance().format(n) + "='" + SpellNumber.convert(n) + "'");

		n = 758;
		System.out.println(NumberFormat.getInstance().format(n) + "='" + SpellNumber.convert(n) + "'");

		n = 9805;
		System.out.println(NumberFormat.getInstance().format(n) + "='" + SpellNumber.convert(n) + "'");

		n = 13456;
		System.out.println(NumberFormat.getInstance().format(n) + "='" + SpellNumber.convert(n) + "'");

	}

}
