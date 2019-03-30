//Ben Guan, DongMei Sarafan,Yu Xiong
//Final Project
//Due: 05/10/2017
//COM212: Data Structure 
//BST Movie Date
//BST Movie ID is a BST that stores the movie based on the 6 digit ID of the movies

//import
import java.io.*;

//create a class MovieID
public class MovieID implements Serializable{

	//create variables
	private Movie root;
	int n;

	//constructors
	public MovieID(){
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
		if (p.getID()<t.getID()){
			//if it is ,and there is no node on the left of r, add the Node p on the left
			if (t.getLeftID()==null){
				t.setLeftID(p);
			}
			//if r has a left child, call the recursive function insert2 again
			else{
				insert2(t.getLeftID(),p);
			}
		}
		//the other situation which is similiar
		else{
			if(t.getRightID()==null){
				t.setRightID(p);
			}
			else{
				insert2(t.getRightID(),p);
			}
		}
	}

	//search():returns a pointer to the node in T that has a key that matches key
	public Movie search(int ID){
		Movie temp=root;
		//if the key>than the key of temp, go left; otherwise, go right
		while (temp !=null && ID!=temp.getID()){
			if (ID<temp.getID()){
				temp=temp.getLeftID();
			}
			else if (ID> temp.getID()){
				temp=temp.getRightID();
			}
		}
		//returns null if the node is not found 
		if (temp==null){
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
				traverse2(r.getLeftID());
				//then print it out and go to the right, print the key of each node in order.
				System.out.print(r.getID() + " ");
				traverse2(r.getRightID());
			}
		}


	//delete():removes the node pointed to by p from the tree T
	public void delete(Movie p){
		//check whether root is the one we want to delete. If it is, call deleteRoot function
		if (p.getID()==root.getID()){
			root=deleteRoot(p);
		}

		//if root is not the one we want to delete, call the delete2 to find where the p is and delete it
		else{
			delete2(root,p);
		}
	}


	//deleteRoot(): to delete the root when x = root
	public Movie deleteRoot(Movie x){
		//if there is only one node (root), then return null
		if ((x.getLeftID()==null) && (x.getRightID()==null)){
			return null;
		}
		//if root just has one right child:
		else if (x.getLeftID()==null){
				Movie temp=x.getRightID();
				x.setRightID(null);
				return temp;
		}

		//if root just has one left child
		else if (x.getRightID()==null){
				Movie temp=x.getLeftID();
				x.setLeft(null);
				return temp;
		}

		//if the root has two children, we need to find the successor and move the successor to 
		//the location of root, and let it be the new root
		else{
			Movie successor = successor(x);
			delete(successor);
			successor.setRightID(x.getRightID());
			successor.setLeftID(x.getLeftID());
			x.setRightID(null);
			x.setLeftID(null);
			return successor;
		}
	}


	//delete2() : find where x is and delete x
	public void delete2(Movie tree,Movie x){
		//if x is on the right of the tree, then call deleteRoot function and connect the tree
		if (tree.getRightID()==x){
			tree.setRightID(deleteRoot(x));
		}
		//similarly, the other side
		else if (tree.getLeftID()==x){
			tree.setLeftID(deleteRoot(x));
		}

		//if it is not tree's kid, call the recursive delete2() until we found the x
		else if (x.getID() < tree.getID()){
			delete2(tree.getLeftID(),x);
		}
		else if (x.getID() > tree.getID()){
			delete2(tree.getRightID(),x);
		}
	}

	//successor(): we call it only when p has two children
	//we first goes to the right for once to make sure we do not loss the child of the successor. 
	//then we goes to the left until the last because we want to find the one that can connect the tree.
	public Movie successor(Movie s){
		Movie temp=s;
		temp=temp.getRightID();
		while (temp.getLeftID() != null){
			temp=temp.getLeftID();
		}
		return temp;
	}

}



