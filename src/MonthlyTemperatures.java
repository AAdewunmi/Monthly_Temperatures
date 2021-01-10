import java.util.Scanner;

/** MonthlyTemperatures Class to display daily and weekly temperatures,
 using multidimensional arrays.
 @author Adrian Adewunmi
 @version 10 January, 2021
 */

public class MonthlyTemperatures {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		char choice;
		double [][] temperature = new double[5][8]; // create 2D array
		// offer menu
		do {
			System.out.println();
			System.out.println("[1] Enter temperature");
			System.out.println("[2] Display all");
			System.out.println("[3] Display one week");
			System.out.println("[4] Display day of the week");
			System.out.println("[5] Exit");
			System.out.println("Enter choice [1 - 5]: ");
			choice = scanner.next().charAt(0);
			System.out.println();
			// process choice by calling additional methods
			switch (choice) {
			case '1': enterTemps(temperature);
				break;
			case '2': displayAllTemps(temperature);
			    break;
			case '3': displayWeek(temperature);
			    break;
			case '4': displayDays(temperature);
			    break;
			case '5': System.out.println("Goodbye!!!");
			    break;
			default:System.out.println("Error: options 1 - 5 only!");
			}
		} while (choice != '5');

	}

	/**
	 * allows the user to display the temperatures for a particular day of the week
	 * (for example all the readings for the first day of each week).
	 * @param temperatureIn Passes a two-dimensional array to a method
	 */

	private static void displayDays(double[][] temperatureIn) {

		Scanner scanner = new Scanner(System.in);
		int day;
		System.out.println("Enter day number (1 - 7)");
		day = scanner.nextInt();
		while (day < 1|| day > 7) {
			System.out.println("Invalid day number!!!");
			System.out.println("Enter again (1 - 7): ");
			day = scanner.nextInt();
		}
		System.out.println();
		System.out.println("***TEMPERATURES ENTERED FOR DAY *** " + day + " ****");
		System.out.println();
		for (int week = 1; week < temperatureIn.length; week++) {
			System.out.println("week " + week + "day " + day + " : " + temperatureIn[week - 1][day - 1]);
		}
	}

	/**
	 * Allows the user to display the reading for a particular week (for example all the temperatures
	 * for week 3.
	 * @param temperatureIn Passes a two-dimensional array to a method
	 */

	private static void displayWeek(double[][] temperatureIn) {

		Scanner scanner = new Scanner(System.in);
		int week;
		System.out.println("Enter week number (1 - 4): ");
		week = scanner.nextInt();
		while (week < 1 || week > 4) {
			System.out.println("Invalid week number!!!");
			System.out.println("Enter again (1 - 4): ");
			week = scanner.nextInt();
		}
		System.out.println();
		System.out.println("***TEMPERATURES ENTERED FOR WEEK *** " + week + " ****");
		System.out.println();
		for (int day = 1; day < temperatureIn[0].length; day++) {
			System.out.println("week " + week + "day " + day + " : " + temperatureIn[week - 1][day - 1]);
		}
	}

	/**
	 * Allows the user to display all these readings.
	 * @param temperatureIn Passes a two-dimensional array to a method
	 */

	private static void displayAllTemps(double[][] temperatureIn) {

		System.out.println();
		System.out.println("*** TEMPERATURES ENTERED ***");
		for (int week = 1; week < temperatureIn.length; week++) {
			for (int day = 1; day < temperatureIn[0].length; day++) {
				System.out.println("week " + week + "day " + day + " : " + temperatureIn[week - 1][day - 1]);
			}
		}
	}

	/**
	 * Allows the user to enter the temperature readings for the 4 weeks of the month.
	 * @param temperatureIn Passes a two-dimensional array to a method
	 */

	private static void enterTemps(double[][] temperatureIn) {

		Scanner scanner = new Scanner(System.in);
		for (int week = 1; week < temperatureIn.length; week++) {
			for (int day = 1; day < temperatureIn[0].length; day++) {
				System.out.println("Enter temperature for week " + week + " and day " + day);
				temperatureIn[week - 1][day - 1] = scanner.nextDouble();
			}
		}
	}

}
