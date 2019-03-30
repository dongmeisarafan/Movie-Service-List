//Ben Guan, DongMei Sarafan,Yu Xiong
//Final Project
//Due: 05/10/2017
//COM212: Data Structure .
//customer loop allows the customer to access movie database, their information and
// they are be able to change their name, email, credit card number and edit their wishlist, etc.

import java.util.Scanner;
import java.io.*;
import java.io.Serializable;
import java.io.IOException;


public class CustomerLoop implements Serializable{
	public static void mainCL(){
		try{
			boolean customerloop=true;
			Scanner reader = new Scanner(System.in);
			Scanner readerS = new Scanner(System.in);
			
			CustomerBST custBST= new CustomerBST();
			MovieDatabase movieDB = new MovieDatabase();
			MovieDate movieD = new MovieDate();
			MovieID movieId= new MovieID();
			
			custBST=deserializationC(custBST);
			movieDB=deserializationDB(movieDB);
			movieD=deserializationD(movieD);
			movieId=deserializationID(movieId);
			
			System.out.println("Enter last 4 digits of credit card number to enter customer portal");
			int pass=reader.nextInt();
			CustomerNode currentCustomer = custBST.search(pass);
			
			if (currentCustomer!=null){
				while(customerloop==true){
					
					customerloop=false;
					System.out.println("---------------------------------------------------------------");
					System.out.println("Enter 1 : Access your information");
					System.out.println("Enter 2 : Access your wish-list");
					System.out.println("Enter 3 : Search for a movie");
					System.out.println("Enter 0 : Exit to main menu");
					System.out.println("---------------------------------------------------------------");
					
					int t=reader.nextInt();
					while (t!=1&& t!=2&& t!=3&&t!=0){
						System.out.println("Please enter an integer from 0-3.");
						t =reader.nextInt();
					}

					//customer can access their own information
					if (t==1){
						//access the customer node, maybe have another menu asking
						//what the user wants to change about the node
						printCustInfo1(currentCustomer);
						System.out.println("Enter 1: Change your information");
						System.out.println("Enter 2: Delete your information");
						System.out.println("Enter 0: Customer menu");
						int decide=reader.nextInt();
						while (decide!=1&& decide!=2&&decide!=0){
							System.out.println("Please enter 0-2");
							decide =reader.nextInt();
						}

						if (decide==1){
							changeCustInfo(custBST, movieDB, movieD, movieId, currentCustomer);
							System.out.println("Your information has been updated");
							customerloop=true;
						}
							
						else if(decide==2){
							custBST.delete(currentCustomer);
							System.out.println("Your information has been deleted");
						}
						
						else if (decide==0){
							customerloop=true;
						}
					}
					
					else if (t==2){
						System.out.println("---------------------------------------------------------------");
						System.out.println("Wishlist Option: ");
						System.out.println("Enter 1: Print wish-list ");
						System.out.println("Enter 2: Next movie");
						System.out.println("Enter 3: Add movie");
						System.out.println("Enter 4: Delete movie");
						System.out.println("Enter 0: Customer menu");
						System.out.println("---------------------------------------------------------------");
						int list=reader.nextInt();
						while (list!=1&& list!=2 &&list!=3&&list!=4&&list!=0){
							System.out.println("Please enter an integer from 0-4.");
							list =reader.nextInt();
						}					    
						if (list == 1){
							currentCustomer.getWishlist().printMovies();
						}
						else if (list == 2){
							if (currentCustomer.getWishlist().isEmptyList() == false){
								Movie movie=currentCustomer.getWishlist().nextMovie();
								if  (movie.check() == false){
									System.out.println("This movie is unavailable and will be deleted from wish-list");
									System.out.println();
									currentCustomer.getWishlist().delete();
									if (currentCustomer.getWishlist().isEmptyList() == true){
										System.out.println("Wishlist is empty");
									}
									else{
										movie=currentCustomer.getWishlist().nextMovie();
										//ask the user if they want to delete the movie
										Scanner input = new Scanner(System.in);
										System.out.println("Do you want to delete this movie? (Yes=1/No=2)");
										int s=reader.nextInt();
										while (s!=1 && s!=2){
											System.out.println("Please enter (Yes=1/No=2)");
											s=reader.nextInt();
										}
										//if yes, delete the movie
										if (s==1){
											System.out.println("Movie deleted");
											currentCustomer.getWishlist().delete();
										}
										else if (s==2){
											customerloop=true;
										}
									}
								}
								
								else if (movie.check() == true){
									//ask the user if they want to delete the movie
									Scanner input = new Scanner(System.in);
									System.out.println("Do you want to delete this movie? (Yes=1/No=2)");
									int s=reader.nextInt();
									while (s!=1 && s!=2){
										System.out.println("Please enter (Yes=1/No=2)");
										s=reader.nextInt();
									}
									//if yes, delete the movie
									if (s==1){
										System.out.println("Movie deleted");
										currentCustomer.getWishlist().delete();
									}
									else if (s==2){
										customerloop=true;
									}
								}
							}
							else if (currentCustomer.getWishlist().isEmptyList() == true){
								System.out.println("Wishlist is empty");							
							}
						}
						else if (list == 3){
							movieId.printTree();
							System.out.println("Enter the ID of movie to insert into wish-list:");            	               
							int movieIDSearch = readerS.nextInt();
							Movie movie = movieId.search(movieIDSearch);
							if (movie != null){
								currentCustomer.getWishlist().insert(movie);
								System.out.println(movie.getTitle() + " has been added to your wish list.  Here is your new wish-list: ");
								currentCustomer.getWishlist().printMovies();
								//System.out.println();
							}
							else
								System.out.println("Movie does not exist");
						}
						else if (list == 4){
							currentCustomer.getWishlist().delete();
							System.out.println("The first movie in the wish list has been removed.  Here is your new wish-list: ");
							currentCustomer.getWishlist().printMovies();
						}
						
						else if (list==0){
							customerloop=true;
						}
						customerloop=true;
					}
					
					//customer search for a movie
					else if(t==3){
						System.out.println("---------------------------------------------------------------");
						System.out.println("Enter 1 : Print movies in order of release date");
						System.out.println("Enter 2 : Access any movie in term of release date");
						System.out.println("Enter 3 : Print movies in order of ID");
						System.out.println("Enter 4 : Access any movie in term of ID");
						System.out.println("Enter 0 : Customer menu");
						System.out.println("---------------------------------------------------------------");
						int h=reader.nextInt();
						while (h!=1&& h!=2&& h!=3&& h!=4 && h!=0){
							System.out.println("Please enter number from 0-4.");
							h =reader.nextInt();
						}					
						if (h==1){
							movieD.printTree();
						}
						else if (h==2){
							movieD.printTree();
							Scanner scan = new Scanner(System.in);
							System.out.println("Enter the release date of a specific movie that you want to access");
							int date =scan.nextInt();
							Movie movie = movieD.search(date);
							System.out.println("Here is the information of the movie with release date: " + date);
							printMovieInfo(movie);
							System.out.println("Enter 1: Add to wish-list");
							System.out.println("Enter 2: Customer Menu");
							int a=reader.nextInt();
							while (a!=1&& a!=2){
								System.out.println("Please enter number from 1-2.");
								a =reader.nextInt();
							}						
							if (a==1){
								System.out.println("You are adding this movie into " + currentCustomer.getName() +"'s wish-list.");
								//add movie to the wish list
								currentCustomer.getWishlist().insert(movie);
							}
							else if (a==2){
								customerloop=true;
							}
						}
						else if (h==3){
							movieId.printTree();
							}
							
						else if (h==4){
							Scanner scan = new Scanner(System.in);
							System.out.println("Enter the ID of a specific movie that you want to access");
							int id =scan.nextInt();
							Movie movie = movieD.search(id);
							if (movie != null){
								System.out.println("Here is the information of the movie with ID: " + id);
								System.out.println("Enter 1: Add movie to wishlist");
								System.out.println("Enter 0: Exit to customer menu");
								printMovieInfo(movie);
								int k=reader.nextInt();
								while (k!=1&& k!=0){
									System.out.println("Please enter number from 0-1.");
									System.out.println("User's Input Number: ");
									k =reader.nextInt();
								}						
								if (k==1){
									System.out.println("You are adding this movie into " + currentCustomer.getName() +"'s wish-list.");
									//add movie to the wish list
									currentCustomer.getWishlist().insert(movie);
								}
								else if (k==0){
									customerloop=true;
								}
							}
							else{
								System.out.println();
							}
						}
						
						else if (h==5){
							customerloop=true;
						}
						customerloop=true;
					}
					
					else if (t==0){
						System.out.println("Thank You for using Netflix!");
					}								
				}
			}
			else if (pass==0){
				System.out.println("Thank You for using Netflix!");
			}
		
			else{
				System.out.println("Credit Card number does not match anyone in the system");
				customerloop=true;
			}
			serialization(custBST, movieDB,movieD, movieId);
		}
		
		catch (NumberFormatException n){
			n.printStackTrace();
		}
	}


	
	public static void printCustInfo1(CustomerNode currentCustomer0){
		System.out.println("---------------------------------------------------------------");
		System.out.println("Below is your customer information:");
		System.out.println("Name: " + currentCustomer0.getName());
		System.out.println("Credit card number: " + currentCustomer0.getCredit());
		System.out.println("Email: " + currentCustomer0.getEmail());
		System.out.println("Movie list: ");
		currentCustomer0.getWishlist().printMovies();
		System.out.println("---------------------------------------------------------------");
	}

	public static void changeCustInfo(CustomerBST custBST,MovieDatabase movieDB, MovieDate movieD, MovieID movieId, CustomerNode currentCustomer){
		boolean customerloop=true;
		Scanner reader = new Scanner(System.in);
		Scanner readerS = new Scanner(System.in);
		System.out.println("---------------------------------------------------------------");
		System.out.println("Enter 1: Change your name");
		System.out.println("Enter 2: Change your credit card number");
		System.out.println("Enter 3: Change your email address");
		System.out.println("Enter 0: Customer menu");
		System.out.println("---------------------------------------------------------------");

		int change=reader.nextInt();
		while (change!=1&& change!=2 && change!=3 && change!=0){
			System.out.println("Please enter number from 0-3.");
			change =reader.nextInt();
		}
											
		if (change == 1){
			System.out.println("Please enter your new name:");
			String name = readerS.nextLine();
			currentCustomer.setName(name);
		}
		else if (change == 2){
			System.out.println("Please enter your new credit card number:");
			int credit = reader.nextInt();
			currentCustomer.setCredit(credit);
		}
		else if (change == 3){
			System.out.println("Please enter your new email address:");
			String email = readerS.nextLine();
			currentCustomer.setEmail(email);
		}
		
		else if (change==0){
			customerloop=true;
		}
	}


	public static void printMovieInfo(Movie movie0){
		System.out.println("Movie: " + movie0.getTitle());
		System.out.println("Release Date: " + movie0.getRelease());
		System.out.println("ID: " + movie0.getID());
		System.out.println("Rotten Tomatoes popularity score: " + movie0.getRTscore());
		System.out.println("---------------------------------------------------------------");
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
		catch(IOException i){
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