//Ben Guan, DongMei Sarafan,Yu Xiong
//Final Project
//Due: 05/10/2017
//COM212: Data Structure 
//This is a test file for customer BST

import java.util.Scanner;
import java.io.FileReader;
import java.io.*;
import java.io.Serializable;
import java.io.IOException;

public class Addin implements Serializable {
	public static void mainAddin(){
		
		CustomerBST customers= new CustomerBST();
		MovieDatabase movies = new MovieDatabase();
		MovieDate movieDates = new MovieDate();
		MovieID movieID = new MovieID();
		
		Wishlist aWl = new Wishlist();
		Wishlist bWl = new Wishlist();
		Wishlist cWl = new Wishlist();
		Wishlist dWl = new Wishlist();
		Wishlist eWl = new Wishlist();
		Wishlist fWl = new Wishlist();
		Wishlist gWl = new Wishlist();
		Wishlist hWl = new Wishlist();
		Wishlist iWl = new Wishlist();

		Movie a1Node = new Movie("Forever", 20030213, 223312, 83, true);
		Movie a2Node = new Movie("Fast car", 20010930, 395712, 92, true);
		Movie a3Node = new Movie("Never forget", 20020330, 839572, 51,true);
		Movie a4Node = new Movie("Mean girl", 20100302,294768,73, false);
		Movie a5Node = new Movie("The ocean", 20110305,392847, 94, true);
		Movie a6Node = new Movie("Sunshine", 20140403,395768, 62, true);
		Movie a7Node = new Movie("Fast and Furious", 20150220,392869, 73,true);
		Movie a8Node = new Movie("Moon", 19950324,998572, 61,false);
		Movie a9Node = new Movie("Running", 19680525,204860, 34,true);
		Movie a10Node = new Movie("Finishline", 19920318,234234,89,true);
		Movie a11Node = new Movie("Call me number one", 19870319,345674, 80,true);

		aWl.insert(a1Node);
		aWl.insert(a5Node);
		aWl.insert(a4Node);

		bWl.insert(a3Node);
		bWl.insert(a4Node);
		bWl.insert(a2Node);

		cWl.insert(a1Node);
		cWl.insert(a2Node);
		cWl.insert(a3Node);
		cWl.insert(a6Node);
		
		CustomerNode aNode = new CustomerNode("Becca", 901234437, "email", aWl);
		CustomerNode bNode = new CustomerNode("Jackson", 123456789, "email1", bWl);
		CustomerNode cNode = new CustomerNode("Jose", 934567890,"email2", cWl);
		CustomerNode dNode = new CustomerNode("Manny", 223452234,"email3", dWl);
		CustomerNode eNode = new CustomerNode("Kay", 934567856,"email4", eWl);
		CustomerNode fNode = new CustomerNode("Franny", 123456788,"email5", fWl);
		CustomerNode gNode = new CustomerNode("Mike", 723452237,"email6", gWl);
		CustomerNode hNode = new CustomerNode("Dick", 734567857,"email7", hWl);
		CustomerNode iNode = new CustomerNode("Christian", 734562278,"email8", iWl);
				
		movieID.insert(a1Node);
		movieID.insert(a2Node);
		movieID.insert(a3Node);
		movieID.insert(a4Node);
		movieID.insert(a5Node);
		movieID.insert(a6Node);
		
		movieDates.insert(a1Node);
		movieDates.insert(a2Node);
		movieDates.insert(a3Node);
		movieDates.insert(a4Node);
		movieDates.insert(a5Node);
		movieDates.insert(a6Node);
		
		
		movies.insert(a1Node);
		movies.insert(a2Node);
		movies.insert(a3Node);
		movies.insert(a5Node);
		movies.insert(a6Node);
		
		customers.insert(aNode);
		customers.insert(bNode);
		customers.insert(cNode);
		customers.insert(dNode);
		customers.insert(eNode);
		customers.insert(fNode);
		customers.insert(gNode);
		
		serialization(customers, movies,movieDates, movieID);
	}

	public static void serialization(CustomerBST customers, MovieDatabase movies, MovieDate movieDates, MovieID movieID){
		try{
			FileOutputStream fileOutMovieD = new FileOutputStream("outputDate.txt");
			ObjectOutputStream outMovieD = new ObjectOutputStream(fileOutMovieD);
			outMovieD.writeObject(movieDates);	
			outMovieD.close();
			fileOutMovieD.close();

			FileOutputStream fileOutCustBST = new FileOutputStream("outputCustomer.txt");
			ObjectOutputStream outCustBST = new ObjectOutputStream(fileOutCustBST);
			outCustBST.writeObject(customers);	
			outCustBST.close();
			fileOutCustBST.close();

			FileOutputStream fileOutMovieDB = new FileOutputStream("outputDB.txt");
			ObjectOutputStream outMovieDB = new ObjectOutputStream(fileOutMovieDB);
			outMovieDB.writeObject(movies);	
			outMovieDB.close();
			fileOutMovieDB.close();
			
			
			FileOutputStream fileOutMovieId = new FileOutputStream("outputID.txt");
			ObjectOutputStream outMovieId = new ObjectOutputStream(fileOutMovieId);
			outMovieId.writeObject(movieID);	
			outMovieId.close();
			fileOutMovieId.close();
		} 
		catch(IOException i) {
			i.printStackTrace();
		}
	}
}