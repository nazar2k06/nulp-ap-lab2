package Main;

import java.time.LocalDate;
import java.util.Scanner;
import Car.Car;

public class Main {

	public static void main(String[] args) {
		Car[] cars = null;
		in = new Scanner(System.in);

		while (true) {
			int menu_select = 0;

			System.out.println("\n~~~ Menu ~~~");
			System.out.println(" 0. Exit");
			System.out.println(" 1. Add car");
			System.out.println(" 2. Print cars");
			System.out.println(" 3. Print cars of a given model");
			System.out.println(" 4. Print cars of a given model and working more than given years");
			System.out.println(" 5. Print cars of a given year and more expensive than given price");

			do {
				menu_select = enterIntValue("Select an item:");
			}
			while (menu_select < 0 || menu_select > 5);

			switch (menu_select) {
				case 0:
					return;
				case 1:
					cars = addCar(cars);
					break;
				case 2:
					printCars(cars);
					break;
				case 3:
					printModelCars(cars);
					break;
				case 4:
					printModelYearCars(cars);
					break;
				case 5:
					printYearPriceCars(cars);
					break;
			}
		}
	}


	public static Car[] addCar(Car[] cars) {
		Car[] new_cars;
		byte cars_len = (byte) ((cars == null) ? 0 : cars.length);

		System.out.println("\n~~ Add Main.Car ~~");

		if (cars == null) {
			new_cars = new Car[1];
		}
		else {
			new_cars = new Car[cars_len + 1];
			System.arraycopy(cars, 0, new_cars, 0, cars_len);
		}

		new_cars[cars_len] = new Car();
		new_cars[cars_len].setId(cars_len + 1);
		new_cars[cars_len].setModel(enterStringValue(" Main.Car model:"));
		new_cars[cars_len].setYear(enterIntValue(" Main.Car year:"));
		new_cars[cars_len].setPrice(enterIntValue(" Main.Car price:"));
		new_cars[cars_len].setRegNumber(enterStringValue(" Main.Car reg. number:"));

		return new_cars;
	}

	public static void printCars(Car[] cars) {
		System.out.println("\n~~ Print cars ~~");

		if (cars == null) {
			System.out.println(" No cars added");
			return;
		}

		for (byte i = 0;i < cars.length;i++) {
			System.out.println(cars[i].toString() + '\n');
		}
	}


	public static void printModelCars(Car[] cars) {
		System.out.println("\n~~ Print cars of a given model ~~");
		String car_model = "";

		if (cars == null) {
			System.out.println(" No cars added");
			return;
		}

		car_model = enterStringValue(" Main.Car model:");

		for (byte i = 0;i < cars.length;i++) {
			if (cars[i].getModel().equals(car_model)) {
				System.out.println(cars[i].toString() + '\n');
			}
		}
	}

	public static void printModelYearCars(Car[] cars) {
		System.out.println("\n~~ Print cars of a given model and working more than given years ~~");
		LocalDate date = LocalDate.now();
		String car_model = "";
		int year_delta = 0;

		if (cars == null) {
			System.out.println(" No cars added");
			return;
		}

		car_model = enterStringValue(" Main.Car model:");
		year_delta = enterIntValue(" Working years:");

		for (byte i = 0;i < cars.length;i++) {
			if (cars[i].getModel().equals(car_model)
				&& date.getYear() - cars[i].getYear() >= year_delta) {

				System.out.println(cars[i].toString() + '\n');
			}
		}
	}

	public static void printYearPriceCars(Car[] cars) {
		System.out.println("\n~~ Print cars of a given year and more expensive than given price ~~");
		int year = 0;
		int min_price = 0;

		if (cars == null) {
			System.out.println(" No cars added");
			return;
		}

		year = enterIntValue(" Main.Car year:");
		min_price = enterIntValue(" Main.Car min price:");

		for (byte i = 0;i < cars.length;i++) {
			if (cars[i].getYear() == year && cars[i].getPrice() >= min_price) {
				System.out.println(cars[i].toString() + '\n');
			}
		}
	}


	public static int enterIntValue(String hint) {
		while (true) {
			System.out.print(hint);

			if (in.hasNextInt()) {
				int value = in.nextInt();
				in.nextLine();

				return value;
			}
			else {
				in.nextLine();
			}
		}
	}

	public static String enterStringValue(String hint) {
		System.out.print(hint);
		return in.nextLine();
	}

	private static Scanner in;
}