//Ben Guan, DongMei Sarafan,Yu Xiong
//Final Project
//Due: 05/10/2017
//COM212: Data Structure 
///Movie database stores the movie nodes (heap)

//import
import java.io.*;
import java.io.Serializable;


// create a class MovieDatabse
public class MovieDatabase implements Serializable{
	//variables
	public Movie [] movie;
	public int n;

	//constructors
	//assume the max size is 120
	//declare an int n to track the number of elements in the priority queue
	public MovieDatabase(){
		movie=new Movie[255];
		n=0;
	}

	//isEmpty: check if the list is empty or not
	//returns true if S is empty and false if it is not.
	public boolean isEmpty(){
		if (n==0){
			return true;
		}
		else{
			return false;
		}
	}

	//findMin: find the smallest one in the list, which is the very first one in heap
	public Movie findMin(){
		if (movie[0] != null){
			return movie[0];
		}
		else{
			return null;
		}
	}
	
	//searchMovie: 
	public Movie searchMovie (int ID){
		for (int j=0; j<=n; j++){
			if (movie[j].getID()== ID){
				return movie[j];
			}
		}
		return null;
	}
	

	//getParent(int p):
	//left child's parent=(n-1)-2)/2
	//right child's parent=((n-1)-1)/2
	public int getParent(int pIndex){
		if ((n-1)%2 ==0){
			return pIndex=((n-1)-2)/2;
		}
		else{
			return pIndex=((n-1)-1)/2;
		}
	}
	
	//swap(y,x):swap the node with index y and index x. 
	public void swap(int y, int x){
		Movie temp;
		temp=movie[y];
		movie[y]=movie[x];
		movie[x]=temp;
	}
	
	//insert the node x at the appopriate postion.
	public void insert (Movie x){
		//if it is full, then return Full
		if (n==255){
			System.out.println("The movie datavase is full");
		}
		//if the list is empty, then then let x be the first one in the list
		else if(isEmpty()==true){
			movie[0]=x;
			n++;
		}
		//if it is not, then add x to the last one, if it is smaller than its parents, then swap.
		//until x get to its right position.
		else{
			movie[n]=x;
			n++;

			int index=n-1;
			int pIndex= (index-1)/2;
			while (movie[index].getRTscore() < movie[pIndex].getRTscore()){
				swap(index, pIndex);
				index=pIndex;
				pIndex= (index-1)/2;
			}
		}
	}
	
	//leftOrRight(w): return the key of the smaller child of node with index w.
	private int leftOrRight(int w){
		//if w in in the range of the array and the node with index w has two children
		//check keys of its two children, and return the index of
		//the children with smaller key.
		if ((w>-1)&&(movie[2*w+1]!=null)&&(movie[2*w+2]!=null)){
			if (movie[2*w+1].getRTscore()>movie[2*w+2].getRTscore()){
				return 2*w+2;
			}
			else{
				return 2*w+1;
			}
		}
		//if w in in the range of the array and the node with index w only one child(it must be the left child)
		//return the index of the left child
		//of the node with index w.
		else if((w>-1)&&(movie[2*w+1]!=null)){
			return 2*w+1;
		}
		//Otherwise, return -1.
		else{
			return (-1);
		}
	}

	//deleteMin(): delete the node with the smallest key.
	public void deleteMin(){
		//check whether the heap is empty or not.
		//If it is empty, then we can not delete.
		if (isEmpty()){
			System.out.println("Error");

		//When Heap is not empty. 
		//We know the node with smallest key is always at the postion of root index=0. 
		//So we swap the node with index 0 and the last one. 
		//Then check whether the key of the node that we just put at the index 0 is larger than the smaller key of its children. If it is , swap.
		//until it get to its right position.
		}
		else{
			swap(0,n-1);
			movie[n-1]=null;
			n--;
			int i=0;
			while (leftOrRight(i)!=(-1)){
				if((i>-1)&&(movie[i].getRTscore()>movie[leftOrRight(i)].getRTscore())){
					int x=leftOrRight(i);
					swap(i,leftOrRight(i));
					i = x;
				}
				else{
					i=-1;
				}
			}
		}
	}	

	//a boolean variables telling if k is on the left or right
	private Boolean isLeft(int k){
		if (k%2 !=0){
			return true;
		}
		else{
			return false;
		}
	}
	
	//print the records
	public void printRecord(){
		//for (int i=0;i<n;i++){
			//System.out.println("Info: " + i+ " : " + (movie[i].getRTscore()));
;
		System.out.println("---------------------------------------------------------------");
		if(n==0){
			System.out.println("There are no movies in the database!");
			}
		else{
			for(int i=0;i<n;i=i+1){
				if(movie[i].check()==true){
				System.out.println("Movie Title: " + movie[i].getTitle() );
				System.out.println(" ID: " +movie[i].getID());
				System.out.println(" Rotten Tomatoes Score: " +movie[i].getRTscore());
				//System.out.println("Avaliable");
				}
			}
			System.out.println("---------------------------------------------------------------");
		}
	}
}
		
























