package net.colindodd.smsgenerator.helper;

public class Helper {

	public static int safeParseString(String userInput) {
		final int DEFAULT_VALUE = 50;
		try {
			return Integer.valueOf(userInput);
		} catch (NumberFormatException e) {
			return DEFAULT_VALUE;
		}
	}
}
