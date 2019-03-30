//Ben Guan, DongMei Sarafan,Yu Xiong
//Final Project
//Due: 05/10/2017
//COM212: Data Structure 
//AdminLoop contains all the options for administrator
// They are able to access the customers' information and edit it at anytime.
// They can also edit the movie database, delte movie with the lowest rating, 
//and add and edit customers' information

//import
import java.util.Scanner;
import java.io.FileReader;
import java.io.*;
import java.io.Serializable;
import java.io.IOException;

//create a calss Adminloop
public class AdminLoop implements Serializable{
	
	// all the variables
	public static void mainAL(){		
		try{
			//scanner and initialize the adminloop
			Scanner reader = new Scanner(System.in);
			boolean adminloop=true;
			
			CustomerBST custBST= new CustomerBST();
			MovieDatabase movieDB = new MovieDatabase();
			MovieDate movieD = new MovieDate();
			MovieID movieId= new MovieID();
			
			custBST=deserializationC(custBST);
			movieDB=deserializationDB(movieDB);
			movieD=deserializationD(movieD);
			movieId=deserializationID(movieId);;		
			
			//while the adminloop is true, then go throught it 
			while(adminloop==true){				
				//set the adminloop to false at first
				adminloop=false;
				//3 options for the administrator to choose
				System.out.println("---------------------------------------------------------------");
				System.out.println("Enter 1: access customer information");
				System.out.println("Enter 2: access movie database");
				System.out.println("Enter 0: exit to main menu");
				System.out.println("---------------------------------------------------------------");
				int a=reader.nextInt();
				//remind users if they fail to enter an integer  from 1-3
				if (a!=1&& a!=2&& a!=0){
					System.out.println("Please enter number from 0-2.");
					a=reader.nextInt();
					adminloop=true;
				}

				//if entering 1: access customer info
				if (a==1){
					accessCustInfo(adminloop, custBST, movieDB, movieD, movieId);
					adminloop=true;
				}
				//access the movie database
				else if (a==2){
					//create some other options
					accessMovie(adminloop, custBST, movieDB, movieD, movieId);
				}
				//end the program
				else if (a==0){
					System.out.println("Thank you Administrator for using Netflix");
				}
			}
			serialization(custBST, movieDB,movieD, movieId);
		}
		
		catch(NumberFormatException e){
			System.out.println("Input Error");
			e.printStackTrace();
		}
	
	}
	public static void accessMovie(boolean adminloop, CustomerBST custBST, MovieDatabase movieDB, MovieDate movieD, MovieID movieId){
		Scanner reader = new Scanner(System.in);
		System.out.println("---------------------------------------------------------------");
		System.out.println("Enter 1: see the movie with the lowest rating");
		System.out.println("Enter 2: delete from unavailable movie list");
		System.out.println("Enter 3: delete from available movie list");
		System.out.println("Enter 4: insert a new movie");
		System.out.println("Enter 5: print all the movies ");
		System.out.println("Enter 6: search movie by ID");
		System.out.println("Etner 0: exit to administrator menu");
		System.out.println("---------------------------------------------------------------");
		int m=reader.nextInt();
		//remind user to enter a integer from 1-3
		if (m!=1&& m!=2&& m!=3&&m!=4&&m!=5&&m!=6&m!=0){
			System.out.println("Please enter number from 0-6.");
			m=reader.nextInt();
		}

		//see the movie with the lowest rating
		if (m==1){
			//print out the lowest rating movie from available 
			System.out.println(movieDB.findMin().getTitle()+" has the lowest score");
			System.out.println("");

			//aske if the admin want to delete it or not
			System.out.println("---------------------------------------------------------------");
			System.out.println("Enter 1: delete");
			System.out.println("Enter 2: keep");
			System.out.println("---------------------------------------------------------------");

			int p=reader.nextInt();

			//remind user to enter a integer from 1-2
			while (p!=1 && p!=2){
				System.out.println("Please enter number from 1 or 2.");
				p=reader.nextInt();
			}

			//delete the lowest movie
			if (p==1){
				Movie min = movieDB.findMin();	
				//find the least rated movie in MovieDate and MovieId and set them flase (unavailable)						
				int minID=min.getID();
				Movie minId = movieId.search(minID);
				minId.setFalse();
				//delete the movie from available pool
				movieDB.deleteMin();

				//print out the new order of available movies
				System.out.println("new available movies");
				movieDB.printRecord();
				System.out.println(min.getTitle()+" has been removed from Available Movies");
			}
			else{
				System.out.println("we will keep this movie for you!");
			}
			adminloop=true;
		}

		//delete any movie from unavailable pool by id 
		else if (m==2){
			//print out all movies and delete by id number
			movieId.printTree();
			System.out.println("Enter ID number to delete movie");
			int id0 = reader.nextInt();
			
			//search the movie node that matches the id number and delete it from movieD and movieId
			Movie movie1 = movieId.search(id0);
			if (movie1.check()==true){
				System.out.println("you can only delete from unavailable pool!");	
			}
			else{
				movieD.delete(movie1);
				movieId.delete(movie1);
				System.out.println(movie1.getTitle()+" has been removed");
			}
			adminloop=true;			
		}

		//delete any movie from available pool and then mark it as unavailable
		else if (m==3){
			//print out all movies and delete by id number
			movieId.printTree();
			System.out.println("Enter ID number to delete movie");
			int id0 = reader.nextInt();
			
			//search the movie node that matches the id number and delete it from movieD and movieId
			Movie movie1 = movieId.search(id0);

			//if it is an unavailable movie, remind the user
			if (movie1.check()==false){
				System.out.println("you can only delete from available pool");	
			}
			//if it is available, delete it and mark it as unavailable
			else{
				Movie min = movieDB.findMin();	
				//find the least rated movie in MovieDate and MovieId and set them flase (unavailable)						
				int minID=min.getID();
				Movie minId = movieId.search(minID);
				minId.setFalse();
				//delete the movie from available pool
				movieDB.deleteMin();

				System.out.println(min.getTitle()+" has been removed from Available Movies");
			}

		}
		
		//add a new movie
		else if (m==4){
			addNewMovie(custBST, movieDB, movieD, movieId);
		}
		
		//print all movies
		else if (m==5){
			movieId.printTree();
		}
		
		else if (m==6){
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the 6-digit ID of a specific movie that you want to access");
			int id =scan.nextInt();
			Movie movie = movieId.search(id);
			if (movie != null){
				System.out.println("Here is the information of the movie with ID: " + id);
				printMovieInfo(movie);
			}
			else{
				System.out.println("movie is not in system");
			}
		}

		else if (m==0){
			adminloop=true;
		}

		//remind user to enter a integer from 1-3
		else{
			System.out.println("Please enter an integer between 0-6.");
		}
		adminloop=true;
	}

	public static void accessCustInfo(boolean adminloop, CustomerBST custBST, MovieDatabase movieDB, MovieDate movieD, MovieID movieId){
		Scanner reader = new Scanner(System.in);
		System.out.println("---------------------------------------------------------------");	
		System.out.println("Enter 1: access an existed customer node");
		System.out.println("Enter 2: add a new customer");
		System.out.println("---------------------------------------------------------------");	
		int c=reader.nextInt();

		//remind users if they fail to enter
		while (c!=1&& c!=2){
			System.out.println("Please enter number from 1-2.");
			c=reader.nextInt();
		}

		//if the admin want to acess existed info
		if (c==1){
			//access the customer node and ask what info the user wants to change 
			System.out.println("Enter the 9-digit credit card number of the customer node you want to access:");
			int num = reader.nextInt();

			// search by credit card number
			CustomerNode currentCustomer = custBST.search(num % 10000);
			if (currentCustomer != null){
				printCustInfo(currentCustomer);

				//ask the admin if he wants to change or delete
				System.out.println("Enter 1: change this customers information");
				System.out.println("Enter 2: change this customers wish-list");
				System.out.println("Enter 3: delete this customers information");
				System.out.println("Enter 0: administrator menu");		

				//remind users if they fail to enter
				int decide=reader.nextInt();					
				while (decide!=1&& decide!=2&&decide!=3&&decide!=0){
					System.out.println("Please enter 0-3");
					decide=reader.nextInt();
				}

				//if the admin does want to edit the info						
				if (decide==1){
					changeCustInfo(currentCustomer, custBST, movieDB, movieD, movieId);
				}
				
				else if (decide==2){
					//edit wish-list
					editWL(currentCustomer, custBST, movieDB, movieD, movieId);
				}
				
				else if (decide==3){
					custBST.delete(currentCustomer);
					System.out.println("The customer "+currentCustomer.getName()+" has been deleted from the system.");
				}	
				
				//if the admin does not want to edit the customer info, then set the adminloop to true for next entering
				else if (decide==0){
					adminloop=true;
				}
			}
			else{
				System.out.println("Customer does not exist");
				System.out.println();
			}
			adminloop=true;
		}
		
		//add a new customer
		else if (c==2){
			addNewCust(custBST, movieDB, movieD, movieId);
		}

	}
				
	public static void addNewCust(CustomerBST custBST, MovieDatabase movieDB, MovieDate movieD, MovieID movieId){
		Scanner reader = new Scanner(System.in);
		Scanner readerS = new Scanner(System.in);
		
		//enter the name and read from it
		System.out.println("Enter name: ");
		String Name = readerS.nextLine();
		
		//initialize variables
		int Card = 0;
		String Email = "";
		Wishlist wl=new Wishlist();

		System.out.println("Enter 9-digit credit card number: ");
		Card = Integer.parseInt(reader.nextLine());

		System.out.println("Enter email:  ");
		Email = readerS.nextLine();
		
		//create a new node to save the new customer info
		CustomerNode newNode = new CustomerNode(Name, Card, Email,  wl);
		custBST.insert(newNode);
		System.out.println("The customer "+Name+" has been added to the system.");

	}
				
	public static void addMovietoWL(CustomerNode currentCustomer, CustomerBST custBST, MovieDatabase movieDB, MovieDate movieD, MovieID movieId){

		Scanner reader = new Scanner(System.in);
		Scanner readerS = new Scanner(System.in);
		//enter the info of the movie : name, date, id, RTscore
		movieDB.printRecord();
		System.out.println("Enter the movie ID that you want to insert to the wish-list of this customer:");            	               
		int addMovie = reader.nextInt();
		Movie newMovie = movieDB.searchMovie(addMovie);
		currentCustomer.getWishlist().insert(newMovie);
	}
	
	public static void printMovieInfo(Movie movie0){
		System.out.println("Movie: " + movie0.getTitle());
		System.out.println( "Release Date: " + movie0.getRelease());
		System.out.println("ID: " + movie0.getID());
		System.out.println("Rotten Tomatoes Score: " + movie0.getRTscore());
		System.out.println("Available: " + movie0.check());
	}
	
	public static void addNewMovie(CustomerBST custBST, MovieDatabase movieDB, MovieDate movieD, MovieID movieId){

		Scanner reader = new Scanner(System.in);
		Scanner readerS = new Scanner(System.in);
		//enter the info of the movie : name, date, id, RTscore
		System.out.println("Enter the movie name that you want to insert to the movie database:");            	               
		String moviename = readerS.nextLine();
		System.out.println("Enter the release date of the movie(yyyymmdd)");
		int movierelease = reader.nextInt();
		System.out.println("Enter the 6-digit ID code of the movie");
		int movieID =reader.nextInt();
		System.out.println("Enter the rotten tomatoes score of the movie(1-100)");
		int movieRT=reader.nextInt();

		//create a new movie node to store the info
		Movie newmovie = new Movie(moviename, movierelease, movieID, movieRT, true);
		movieDB.insert(newmovie);
		movieD.insert(newmovie);
		movieId.insert(newmovie);
		System.out.println("The movie "+newmovie.getTitle()+" has been added");
	}
	
	public static void editWL(CustomerNode currentCustomer,CustomerBST custBST, MovieDatabase movieDB, MovieDate movieD, MovieID movieId){
		Scanner reader = new Scanner(System.in);
		System.out.println("---------------------------------------------------------------");	
		System.out.println("Enter 1: print wish-list");
		System.out.println("Enter 2: access the next movie");
		System.out.println("Enter 3: add a movie");
		System.out.println("Enter 4: delete first movie in wish-list");
		System.out.println("---------------------------------------------------------------");	
		int k=reader.nextInt();	
	
		//remind user if they fail to enter
		while (k!=1&& k!=2&& k!=3&& k!=4){
			System.out.println("Please enter number from 1-4.");
			System.out.println("User's Input Number: ");
			k=reader.nextInt();
		}

		//print wish-list
		if (k == 1){
			currentCustomer.getWishlist().printMovies();
		}

		//access the next movie
		else if (k == 2){
			if (currentCustomer.getWishlist().isEmptyList() != true){
				Movie movie=currentCustomer.getWishlist().nextMovie();
				while (movie.check()==false){
					System.out.println("This movie is not avaliable.");
					currentCustomer.getWishlist().delete();
					movie=currentCustomer.getWishlist().nextMovie();
				}
				System.out.println("Next movie is "+movie.getTitle());
			}
			else
				System.out.println("Wish-list is empty");
		}

		//add a new movie
		else if (k == 3){
			addMovietoWL(currentCustomer, custBST, movieDB, movieD, movieId);
		}
		//delete a movie
		else if (k == 4){
			currentCustomer.getWishlist().delete();
			currentCustomer.getWishlist().printMovies();
			if (currentCustomer.getWishlist().isEmptyList() != true){

				System.out.println("The first movie in the wish-list has been removed");
			}				
		}
	}

	//print out the infomation (customer, credit card number, email, wish-list)	
	public static void printCustInfo(CustomerNode currentCustomer){
		System.out.println("---------------------------------------------------------------");		
		System.out.println("Below is the customer information you want to access:");
		System.out.println("Name: " + currentCustomer.getName());
		System.out.println("Credit card number: " + currentCustomer.getCredit());
		System.out.println("Email: " + currentCustomer.getEmail());
		System.out.println("Movie list: ");
		currentCustomer.getWishlist().printMovies();
		System.out.println("---------------------------------------------------------------");
		}
	
	public static void changeCustInfo(CustomerNode currentCustomer, CustomerBST custBST, MovieDatabase movieDB, MovieDate movieD, MovieID movieId){
		Scanner reader = new Scanner(System.in);
		Scanner readerS = new Scanner(System.in);
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("Enter 1: change name");
		System.out.println("Enter 2: change credit card number");
		System.out.println("Enter 3: change email address");
		int change=reader.nextInt();
		System.out.println("---------------------------------------------------------------");

		//remind users if they fail to enter
		while (change!=1&& change!=2&& change!=3){
			System.out.println("Please enter number from 1-3.");
			System.out.println("User's Input Number: ");
			change=reader.nextInt();
		}

		//change name									
		if (change == 1){
			System.out.println("Please enter the new customer name:");
			String name = readerS.nextLine();
			currentCustomer.setName(name);
		}

		//change credit card number
		else if (change == 2){
			System.out.println("Please enter the new 9-digit customer credit card number:");
			int credit = reader.nextInt();
			currentCustomer.setCredit(credit);
		}

		//change email address
		else if (change == 3){
			System.out.println("Please enter the new customer email address:");
			String email = readerS.nextLine();
			currentCustomer.setEmail(email);
		}
		System.out.println("The customer's information has been updataed");
	}

	public static CustomerBST deserializationC(CustomerBST customers){
		try{
		       FileInputStream CustBST0 = new FileInputStream("outputCustomer.txt");
		       ObjectInputStream inCustBST = new ObjectInputStream(CustBST0);
		       customers = (CustomerBST) inCustBST.readObject();
		       inCustBST.close();
		       CustBST0.close();
			return customers;
		}
		catch(IOException i) {
			i.printStackTrace();
			return null;
		}		
		catch ( ClassNotFoundException e ){
			e.printStackTrace();
			return null;
		}
	}
	    
	public static MovieDatabase deserializationDB(MovieDatabase movieDatabase){
		try{
			FileInputStream MovieDB0 = new FileInputStream("outputDB.txt");
		       ObjectInputStream inMovieDB = new ObjectInputStream(MovieDB0);
		       movieDatabase = (MovieDatabase) inMovieDB.readObject();
		       inMovieDB.close();
		       MovieDB0.close();		
			return movieDatabase;
		}
		catch(IOException i) {
			i.printStackTrace();
			return null;
		}		
		catch ( ClassNotFoundException e ){
			e.printStackTrace();
			return null;
		}
	}
	    

	public static MovieDate deserializationD( MovieDate movieDates){
		try{
			FileInputStream MovieD0 = new FileInputStream("outputDate.txt");
			ObjectInputStream inMovieD = new ObjectInputStream(MovieD0);
			movieDates = (MovieDate) inMovieD.readObject();
			inMovieD.close();
			MovieD0.close();
			return movieDates;
		}
		catch(IOException i) {
			i.printStackTrace();
			return null;
		}
	
		catch ( ClassNotFoundException e ){
			e.printStackTrace();
			return null;
		}
	}

	public static MovieID deserializationID( MovieID movieID){
		try{
			FileInputStream MovieId0 = new FileInputStream("outputID.txt");
			ObjectInputStream inMovieId = new ObjectInputStream(MovieId0);
			movieID = (MovieID) inMovieId.readObject();
			inMovieId.close();
			MovieId0.close();
			return movieID;
		}
		catch(IOException i) {
			i.printStackTrace();
			return null;
		}
		catch ( ClassNotFoundException e ){
			e.printStackTrace();
			return null;
		}
	}
	
	public static void serialization(CustomerBST custBST, MovieDatabase movieDB, MovieDate movieD, MovieID movieId){
		try{
			FileOutputStream fileOutMovieD = new FileOutputStream("outputDate.txt");
			ObjectOutputStream outMovieD = new ObjectOutputStream(fileOutMovieD);
			outMovieD.writeObject(movieD);	
			outMovieD.close();
			fileOutMovieD.close();
			System.out.println();

			FileOutputStream fileOutCustBST = new FileOutputStream("outputCustomer.txt");
			ObjectOutputStream outCustBST = new ObjectOutputStream(fileOutCustBST);
			outCustBST.writeObject(custBST);	
			outCustBST.close();
			fileOutCustBST.close();

			FileOutputStream fileOutMovieDB = new FileOutputStream("outputDB.txt");
			ObjectOutputStream outMovieDB = new ObjectOutputStream(fileOutMovieDB);
			outMovieDB.writeObject(movieDB);	
			outMovieDB.close();
			fileOutMovieDB.close();

			FileOutputStream fileOutMovieId = new FileOutputStream("outputID.txt");
			ObjectOutputStream outMovieId = new ObjectOutputStream(fileOutMovieId);
			outMovieId.writeObject(movieId);	
			outMovieId.close();
			fileOutMovieId.close();
		} 
		catch(IOException i) {
			i.printStackTrace();
		}
	}
}