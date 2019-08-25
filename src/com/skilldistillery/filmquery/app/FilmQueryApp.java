package com.skilldistillery.filmquery.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.Actor;
import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

	private void test() {
//    Film film = db.findFilmById(1);
//    System.out.println(film);
		Actor actor = db.findActorById(5);
		System.out.println(actor);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		System.out.println("Welcome to the Film Query Pro Application!");
		System.out.println("Enter \"1\" to look up a movie by its ID#");
		System.out.println("Enter \"2\" to look up movie by a keyword");
		System.out.println("Enter \"3\" to exit the application.");
		String choice = input.next();
		switch (choice) {
		case "1":
			System.out.println("Please enter a movie's ID# to look it up!");
			int intChoice = input.nextInt();
			System.out.println(db.findFilmById(intChoice));
			startUserInterface(input);
			break;
		case "2":
			System.out.println("Please enter a keyword to look up a movie");
			String stringChoice = input.next();
			List<Film> filmsKeyword = db.findFilmKeyword(stringChoice);
//			System.out.println(filmsKeyword);
			for (Film film : filmsKeyword) {
				System.out.println(film);
			}
			startUserInterface(input);
			
			break;
		case "3":
			System.out.println("Exiting application");
			break;
		default:
			System.out.println("Please enter a valid option");
			startUserInterface(input);
//			startUserInterface(input);

		}

	}

	public void again(Scanner input) {
		System.out.println("Would you like to use the Film Query Application Again? (Y/N)");
		String choice = "";
		switch (choice) {
		case "Y":
			startUserInterface(input);
			break;
		case "N":
			System.out.println("Exiting application");
			break;
		default:
			System.out.println("Please enter either \"Y\" or \"N");
			again(input);

		}

	}

}
