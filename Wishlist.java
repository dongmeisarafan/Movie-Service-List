//Ben Guan, Dong Mei Sarafan,Yu Xiong
//Final Project
//Due: 05/10/2017
//COM212: Data Structure 
//This file allow user to access the wishlist which contains all the movies of their interest.
//Wishlist contains the method: length, isEmpty, delete, nextmovie, insert, and print.

//import
import java.util.Scanner;
import java.io.FileReader;
import java.io.*;
import java.io.Serializable;

//create a class Wishlist
public class Wishlist implements Serializable {
	//variables
	Movie[] wishlist;
	private int n;
	private int front; 
	private int tail;
	
	//constructors
	public Wishlist(){
		wishlist=new Movie [20];
		front=0;
		tail = 0;
		n=0;
	}
	
	//return the length of the wishlist
	public int length(){
		return n;
	}
	
	//return true if the wishlist is empty
	public boolean isEmptyList(){
		return n==0;
	} 
	
	//delete a movie from the wishlist
	public void delete(){	
		//return null if the list is empty
		if (n==0){
			System.out.println("Movie does not exist.");
		}
		else{
			//int temp = front;
			front = (front +1) %20;
			n--;
		}
	}
	
	//return the next movie on the list
	public Movie nextMovie(){
		//if the list is not empty, go to the first one.
		Movie next = wishlist[front];
		System.out.println("The next movie in the list is " + next.getTitle() + ".");
		return next;
	}
		
	//add an movie of user's interest to the end of the list
	public void insert(Movie node0){
		wishlist[tail]=node0;
		tail = (tail+1)%20;
		n++;
	}
	
	//print out the movie one by one
	public void printMovies(){
  	//first print the length of the list n
		System.out.println("There are " + n + " movies in the wish list.");
		if (front <= tail){
			for (int i = front; i < tail; i++)
					System.out.println("Movie: " + wishlist[i].getTitle() + " ID: " + wishlist[i].getID());
		}
		else{
			for (int i = front; i < 20; i++)
				System.out.println("Movie: " + wishlist[i].getTitle() + " ID: " + wishlist[i].getID());
			for (int i = 0; i < tail; i++)
				System.out.println("Movie: " + wishlist[i].getTitle() + " ID: " + wishlist[i].getID());
		}
	}
}