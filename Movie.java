
//Ben Guan, DongMei Sarafan,Yu Xiong
//Final Project
//Due: 05/10/2017
//COM212: Data Structure 
//Movie Node

//This class will take title, release data, ID, RTscore, Available, 
//right , left, leftID, rightID of the Movie


//import
import java.io.*;
import java.io.Serializable;
import java.util.Scanner;


//create a Movie class 
public class Movie implements Serializable{
	//define variables
	private String Title;
	private int Release;
	private int ID;
	private float RTscore;
	private boolean Available;
	private Movie right;
	private Movie left;
	private Movie leftID;
	private Movie rightID;

	//constructors
	public Movie(String Title0,int Release0,int ID0, float RTscore0, boolean Available0){
		Title = Title0;
		Release = Release0;
		ID = ID0;
		RTscore = RTscore0;
		Available= Available0;
		right=null;
		left=null;
		leftID=null;
		rightID=null;
	}

	//set Title
	public void setTitle(String Title){
		Title=Title;
	}

	//get Title
	public String getTitle(){
		return Title;
	}

	//set ID
	public void setID(int ID){
		ID = ID;
	}

	//get ID
	public int getID(){
		return ID;
	}

	//set Release;
	public void setRelease(int Release){
		Release=Release;
	}

	//get Release;
	public int getRelease(){
		return Release;
	}

	//set RTscore
	public void setRTscore(float RTsocre){
		RTscore=RTscore;
	}

	//get RTscore
	public float getRTscore(){
		return RTscore;
	}
	
	//set Left
	public void setLeft(Movie newLeft){
		left=newLeft;
	}

	//get Left
	public Movie getLeft(){
		return left;
	}

	//set Right
	public void setRight(Movie newRight){
		right=newRight;
	}

	//get Right
	public Movie getRight(){
		return right;
	}

	//set LeftID
	public void setLeftID(Movie newLeftID){
		leftID=newLeftID;
	}

	//get LeftID
	public Movie getLeftID(){
		return leftID;
	}

	//set RightID
	public void setRightID(Movie newRightID){
		rightID=newRightID;
	}

	//get RightID
	public Movie getRightID(){
		return rightID;
	}
	
	//set the boolean variable available to false
	public void setFalse(){
		Available = false;
	}
	
	//set the boolean variable available to true
	public void setTrue(){
		Available = true;
	}
	
	//check the boolean variable Available
	public boolean check(){
		return Available;
	}
}
