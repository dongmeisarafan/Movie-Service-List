
//Ben Guan, DongMei Sarafan,Yu Xiong
//Final Project
//Due: 05/10/2017
//COM212: Data Structure 
//Customer Node

//import
import java.io.*;
import java.io.Serializable;

//create a class CustomerNode
public class CustomerNode implements Serializable{
	//set all variables
	private String name;
	private int card;
	private String email;
	private Wishlist wl;
	private CustomerNode nextLeft;
	private CustomerNode nextRight;

	//constructors
	public CustomerNode(String name0, int card0, String email0, Wishlist wishlist0){
	//create new instance of node
		name = name0;
		card = card0;
		email = email0;
		wl=wishlist0;
	       //established that there are two different variables, but they will end up being the same
	}

	public void setName(String name0){
		name = name0;
		// the instance variable equals the name0
	}

	public String getName(){
		return name;
		//will say the name when called
	}
	    
	public void setCredit(int card0){
		card = card0;
		//when SSN is established, it will equal eachother, to keep them still differentiated
	}
	    
	public int getCredit(){
		return card;
		//will say the SSN when called
	}
	
	public void setEmail(String email0){
		email = email0;
		// the instance variable equals the name0
	}

	public String getEmail(){
		return email;
		//will say the name when called
	}
	
	public void setWishlist(Wishlist wishlist0){
		wl = wishlist0;
		// the instance variable equals the name0
	}

	public Wishlist getWishlist(){
		return wl;
		//will say the name when called
	}

	public void setLeft(CustomerNode next0){
		nextLeft = next0;
		//when next is established, it will equal eachother, to keep them still differentiated
	}  
	    
	public CustomerNode getLeft(){
		return nextLeft;
		//this serves as a pointer to the next node on the left
	}
	
	public void setRight(CustomerNode next0){
		nextRight = next0;
		//when next is established, it will equal eachother, to keep them still differentiated
	}
	    
	public CustomerNode getRight(){
		return nextRight;
		//this serves as a pointer to the next node on the right
	}
	
	public int getKey(){
		return (card%10000);
		//this serves as a pointer to the key
	}
}


