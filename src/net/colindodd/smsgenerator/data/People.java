package net.colindodd.smsgenerator.data;

import java.util.Random;

public final class People {
	
	private static Random random = new Random();
	
	private final static String[] people = {
		"Terrie Schwartzkopf",
		"Louise Addington",
		"Joane Parris",
		"Marianne Matthews",
		"Lissette Carrol",
		"Brendon Rielly",
		"Wilson Rappa",
		"Phil Million",
		"Derick Harris",
		"Rolland Meritt",
		"Salvador Cox",
		"Courtney Armstrong",
		"Richard Delgado",
		"Teresa Mack",
		"Bernard Williamson",
		"Jacquelyn Cruz",
		"Judith Wolfe",
		"Essie Jacobs",
		"Brittany Mccarthy",
		"Rosie Robinson"
	};
	
	public static String getRandomPerson() {
		int index = random.nextInt(people.length);
		return people[index];
	}
}
