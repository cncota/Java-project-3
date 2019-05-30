/*Claudia Cota ID:60341850

MovieManagerUI class represents the input and output between the program and user. It contains all the methods that prints the
menu and communicates with the user.*/

import java.util.Scanner;

public class MovieManagerUI{
	public static void printMenu(){
		//Method prints the menu options to the console.
		System.out.print("\nWelcome to Class Roster Manager! \n"
			+ "Select an action based on the following menu:\n"
			+ "---------- \n"
			+ "am: Add Movie \n"
			+ "dm: Discountinue Movie \n"
			+ "rm: Rent Movie \n"
			+ "rr: Return Rental \n"
			+ " p: Print Movie Inventory \n"
			+ " q: Quit Program \n"
			+ "---------- \n\n");
		
	}
	
	public static String getCommand(){
		//Method gets the command from the user, loops until user enters a valid command and returns it.
		boolean loop = true;
		String command = null;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter Command: ");
		do{
			command = in.nextLine();
			if (command.equals("am") || command.equals("dm") || command.equals("rm") || command.equals("rr") || 
					command.equals("p") || command.equals("q")){
				loop = false;
			}
			else {
				System.out.print("Enter Valid Command: ");
			}
		}while (loop == true);
		
		return command;
	}
	
	
	public static String getMovieInformationCode(){
		//Method asks user for movie code and returns it.
		String code = null;
		System.out.print("Input movie code: ");
		Scanner in = new Scanner(System.in);
		code = in.nextLine();
		return code;
	}
	
	public static String getMovieInformationName(){
		//Method asks user for movie name and returns it.
		String name = null;
		System.out.print("Input movie name: ");
		Scanner in = new Scanner(System.in);
		name = in.nextLine();
		return name;
	}
	
	public static String getRenterFirstName(){
		//Method asks user for first name input and returns it. 
		String fName = null;
		System.out.print("Input renter first name: ");
		Scanner in = new Scanner(System.in);
		fName = in.nextLine();
		return fName;
	}
	
	public static String getRenterLastName(){
		//Method asks user for last name input and returns it.
		String lName = null;
		System.out.print("Input renter last name: ");
		Scanner in = new Scanner(System.in);
		lName = in.nextLine();
		return lName;
	}
	
	public static int getRenterId(){
		//Method asks user for ID and returns it.
		int id;
		System.out.print("Input renter ID: ");
		Scanner in = new Scanner(System.in);
		id = in.nextInt();
		return id;
	}

}
