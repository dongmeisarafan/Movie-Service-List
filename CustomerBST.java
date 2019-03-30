import java.io.*;
import java.io.Serializable;


public class CustomerBST implements Serializable{
	private CustomerNode root;

	//create empty list with root marked
	public CustomerBST(){
		root = null;
	}

	//method to insert new node into tree, recursively
	public void insert(CustomerNode x){
		//if tree is empty, make root new node
		if (root == null){
			root = x;
		}
		//if tree not empty, recursively find place to insert
		else{
			insert2(root, x);
		}
	}

	public void insert2(CustomerNode t, CustomerNode x){
		//go going left from top
		if (x.getKey() < t.getKey()){
			//found location and insert
			if (t.getLeft() == null){
				t.setLeft(x);
			}
			//use recursion to find correct spot
			else{
				insert2(t.getLeft(), x);
			}
		}
		//going right from top
		else{
			//found location and insert
			if (t.getRight() == null){
				t.setRight(x);
			}
			//use recursion to find correct spot
			else{
				insert2(t.getRight(), x);
			}
		}
	}

	//use recursion to search for correct node
	public CustomerNode search (int key){
		return search2(root, key);
	}

	//using recursion to find correct node
	private CustomerNode search2(CustomerNode t1, int key){
		//if it is not found, then return null
		if (t1 == null){
			return null;
		}
		//if top node is k, then return that
		else if (t1.getKey() == key){
			return t1;
		}
		//if not found key, but current node is more, go left
		// and recursively search again
		else if(key < t1.getKey()){
			return search2(t1.getLeft(), key);
		}
		//if not found key, but current node is more, go right
		// and recursively search again            
		else{
			return search2(t1.getRight(), key);
		}
	}

	//using recursion to find and delete node
	public void delete(CustomerNode x){
		//if node is root, then go to helper function deleteRoot
		if (x == root){
			root = deleteRoot(x);
		}
		//if not root, then go to helper function delete2
		else{
			delete2(root, x);
		}
	}

	//searching for node, and then use helper function deleteRoot
	private void delete2(CustomerNode tree, CustomerNode x){
		if (tree.getRight() == x){
			tree.setRight(deleteRoot(x));
		}
		else if (tree.getLeft() == x){
			tree.setLeft(deleteRoot(x));
		}
		else if (x.getKey() < tree.getKey()){
			delete2(tree.getLeft(), x);
		}
		else{
			delete2(tree.getRight(), x);
		}
	}

	//delete node based on location
	private CustomerNode deleteRoot(CustomerNode x){
		//if node is leaf
		if (x.getLeft() == null && x.getRight() == null){
			return null;
		}
		//node has 1 child on right
		else if (x.getLeft() == null){
			CustomerNode temp = x.getRight();
			x.setRight(null);
			return temp;
		}
		//node has 1 child on left
		else if (x.getRight() == null){
			CustomerNode temp = x.getLeft();
			x.setLeft(null);
			return temp;
		}
		//node has two children, use helper function successor
		else{
			CustomerNode successor = successor(x);
			delete(successor);
			successor.setRight(x.getRight());
			successor.setLeft(x.getLeft());
			x.setRight(null);
			x.setLeft(null);
			return successor;
		}
	}

	//finds successor of node
	private CustomerNode successor(CustomerNode x){
		CustomerNode temp = x.getRight();
		while (temp.getLeft() != null)
			temp = temp.getLeft();
		return temp;
	}

	//recursively printing tree in order
	public void traverse(){
		traverse2(root);
		System.out.println();
	}
    
	//as long as node does not equal null, then continue left then right
	private void traverse2(CustomerNode x){
		if (x!= null){
			traverse2(x.getLeft());
			System.out.print(x.getKey()+ " ");
		traverse2(x.getRight());
		}
	}

	//return true or false if tree is empty
	public boolean isEmptyTree(){
		return (root == null);
	}
    
	//printing tree recursively
	public void printTree() {
		printTree2(root);
		System.out.println();
	}

	//printing node, then right and left child of node
	private void printTree2(CustomerNode tree) {
		if (tree != null) {
			System.out.print(tree.getKey() + " ");
			if (tree.getLeft() != null){
				System.out.println("Customer Info: " + tree.getLeft().getName());
				System.out.println(" Credit Card Number "+ tree.getLeft().getCredit());
			}
			else{
				System.out.print(" ");
			}
			if (tree.getRight() != null){
				System.out.println("Customer Info: " + tree.getRight().getName());
				System.out.println(" Credit Card Number "+  tree.getRight().getCredit());
			}
			else{
				System.out.println(" ");
			}
                printTree2(tree.getLeft());
                printTree2(tree.getRight());
		}
	}
}

