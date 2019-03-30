//Ben Guan, Dong Mei, Rita Xiong
//This menu have two main loops, adminloop and customerloop
//admin loop allows the adminstrators to access the customers' information and edit it at anytime.
// They can also edit the movie database, delte movie with the lowest rating, and add and edit customers' information
//customer loop allows the customer to access movie database, their information and be able to change their name, email, etc.

import java.util.Scanner;
import java.io.FileReader;
import java.io.*;

public class NetflixMenu {
	public static void main(String []args) {
		try{
			//reader to take in user's input
			Scanner readerS = new Scanner(System.in);
			Scanner reader = new Scanner(System.in);
			//add customers and movies into the system
			
			System.out.println("Enter 1: Add in old information");
			System.out.println("Enter any integer (except 1): Continue with changed info");
			int read = reader.nextInt();

			//when starting the program fresh, press 1 to add in info to databases
			//if continuing with saved changes, than ignore

			if (read==1){
				Addin.mainAddin();
			}
			System.out.println("Dear user, welcome to Netflix!");
			System.out.println("");
			boolean mainloop=true;
			while (mainloop == true){
				mainloop=false;
				//three options that users can choose from
				System.out.println("---------------------------------------------------------------");
				System.out.println("Log in as an administrator or a customer.");
				System.out.println();
				System.out.println("Enter 1 if you are an administrator");
				System.out.println("Enter 2 if you are a customer");
				System.out.println("Enter 0 if you want to exit Netflix");
				System.out.println("User's Input Number: ");
				
				int n=reader.nextInt();	
				
				if (n!=1&& n!=2&& n!=0){
					System.out.println("Please enter an integer from 0-2.");
					mainloop=true;
				}
				
				//administrator loop
				if (n==1){
					System.out.println("Enter password to enter administration portal");
					int pass = reader.nextInt();
					if (pass == 12345){
						AdminLoop.mainAL();
					}
					else{
						System.out.println("Wrong password");
					}
					mainloop=true;
				}
				
				else if(n==2){
					CustomerLoop.mainCL();
					mainloop=true;
				}
				//if user enter 3 at anytime, quie the program 
				else if (n==0){
					System.out.println("Ending program. Thank you for using Netflix!");
				}
			}
		}
		catch(NumberFormatException e){
			System.out.println("Input Error");
		}
	}
}

