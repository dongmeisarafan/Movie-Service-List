//Ben Guan, DongMei Sarafan,Yu Xiong
//Final Project
//Due: 05/10/2017
//COM212: Data Structure 
//BST Movie Date

//import
import java.io.*;
import java.io.Serializable;


//create the class MovieDate
public class MovieDate implements Serializable{

	//create variables
	private Movie root;
	int n;

	//constructors
	public MovieDate(){
		root=null;
	}

	//printTree method for BST to print out the tree
	public void printTree(){
		System.out.println("---------------------------------------------------------------");
		//print out the root first
		printTree2(root);
		System.out.println("---------------------------------------------------------------");
	}

	//print out the left side and the right side
	private void printTree2(Movie tree) {
		if (tree != null) {
			if (tree.getLeft() != null){
				System.out.println("Movie Title: " + tree.getLeft().getTitle() );
				System.out.println("ID: " + tree.getRight().getID());
				System.out.println("Release data (yyyy/mm/dd): "+ tree.getLeft().getRelease());
				System.out.println("Avaliable: "+tree.getLeft().check() );	
				System.out.println();
			}
			if (tree.getRight() != null){
				System.out.println("Movie Title: " + tree.getRight().getTitle());
				System.out.println("ID: " + tree.getRight().getID());
				System.out.println("Release data (yyyy/mm/dd): "+ tree.getRight().getRelease());
				System.out.println("Avaliable: "+tree.getRight().check()) ;
				System.out.println();
			}
			printTree2(tree.getLeft());
			printTree2(tree.getRight());
		}
		else
			System.out.println();
	}


	//isEmptyTree: returns ture if T is empty and false if it is not
	public boolean isEmptyTree(){
		return root==null;
	}
	

	//insert: node pointed to by p added in the proper location
	public void insert(Movie p){
		//if there is no node in the tree, add the Node at the position of root
		if (root==null){
			root=p;
		}
		//otherwise, call the function insert2() to  check different situations to put p
		else{
			Movie temp=root;
			insert2(temp, p);
		}
	}

	//insert2 function to insert node p in the right location 
	public void insert2(Movie t, Movie p){
		//check whether the key of Node p smaller than the key of r
		if (p.getRelease()<t.getRelease()){
			//if it is ,and there is no node on the left of r, add the Node p on the left
			if (t.getLeft()==null){
				t.setLeft(p);
			}
			//if r has a left child, call the recursive function insert2 again
			else{
				insert2(t.getLeft(),p);
			}
		}
		//the other situation which is similiar
		else{
			if(t.getRight()==null){
				t.setRight(p);
			}
			else{
				insert2(t.getRight(),p);
			}
		}
	}

	//search():returns a pointer to the node in T that has a key that matches key
	public Movie search(int key){
		Movie temp=root;
		//if the key>than the key of temp, go left; otherwise, go right
		while (temp !=null && key!=temp.getRelease()){
			if (key<temp.getRelease()){
				temp=temp.getLeft();
			}
			else if (key> temp.getRelease()){
				temp=temp.getRight();
			}
		}
		//returns null if the node is not found 
		if (temp==null){
			System.out.println("Movie is not in system");
			return null;
		}
		//if the node is found, return it
		else{
			return temp;
		}
	}
		
	//traverse(): prints the contents of T in order
	public void traverse(){
		//if the root not equl to null, call the tranverse2 function 
		if (root!=null){
			traverse2(root);
			System.out.println();
		}
	}

	//traverse2 to go throught the left side and right side
	private void traverse2(Movie r){
		//When r not equl to null, go to the left,call the tranverse2 fucntion with parameter r.left
		//until we hit the node with the smallest key
		if (r!=null){
			traverse2(r.getLeft());
			//then print it out and go to the right, print the key of each node in order.
			System.out.println("Release Date of "+r.getTitle() + " is "+ r.getRelease());
			traverse2(r.getRight());
		}
	}

	//delete():removes the node pointed to by p from the tree T
	public void delete(Movie p){
		//check whether root is the one we want to delete. If it is, call deleteRoot function
		if (p.getRelease()==root.getRelease()){
			root=deleteRoot(p);
		}
		//if root is not the one we want to delete, call the delete2 to findMo where the p is and delete it
		else{
			delete2(root,p);
		}
	}

	//deleteRoot(): to delete the root when x = root
	public Movie deleteRoot(Movie x){
		//if there is only one node (root), then return null
		if ((x.getLeft()==null) && (x.getRight()==null)){
			return null;
		}
		//if root just has one right child:
		else if (x.getLeft()==null){
				Movie temp=x.getRight();
				x.setRight(null);
				return temp;
		}
		//if root just has one left child
		else if (x.getRight()==null){
				Movie temp=x.getLeft();
				x.setLeft(null);
				return temp;
		}
		//if the root has two children, we need to find the successor and move the successor to 
		//the location of root, and let it be the new root
		else{
			Movie successor = successor(x);
			delete(successor);
			successor.setRight(x.getRight());
			successor.setLeft(x.getLeft());
			x.setRight(null);
			x.setLeft(null);
			return successor;
		}
	}

	//delete2() : find where x is and delete x
	public void delete2(Movie tree,Movie x){
		//if x is on the right of the tree, then call deleteRoot function and connect the tree
		if (tree.getRight()==x){
			tree.setRight(deleteRoot(x));
		}
		//similarly, the other side
		else if (tree.getLeft()==x){
			tree.setLeft(deleteRoot(x));
		}

		//if it is not tree's kid, call the recursive delete2() until we found the x
		else if (x.getRelease() < tree.getRelease()){
			delete2(tree.getLeft(),x);
		}
		else if (x.getRelease() > tree.getRelease()){
			delete2(tree.getRight(),x);
		}
	}

	//successor(): we call it only when p has two children
	//we first goes to the right for once to make sure we do not loss the child of the successor. 
	//then we goes to the left until the last because we want to find the one that can connect the tree.
	public Movie successor(Movie s){
		Movie temp=s;
		temp=temp.getRight();
		while (temp.getLeft() != null){
			temp=temp.getLeft();
		}
		return temp;
	}
}