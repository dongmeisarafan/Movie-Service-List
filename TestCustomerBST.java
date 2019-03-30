//Ben Guan, DongMei Sarafan,Yu Xiong
//Final Project
//Due: 05/10/2017
//COM212: Data Structure 
//This is a test file for customer BST
//must import java's input/output package
import java.io.*;

public class TestCustomerBST {
	public static void main(String[] args){
		CustomerBST a = new CustomerBST();
		System.out.println("isEmptyTree = " + a.isEmptyTree());
		
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
		Movie a5Node = new Movie("The ocean", 20110305,392847, 94,true);
		Movie a6Node = new Movie("Sunshine", 20140403,395768, 62,true);
		Movie a7Node = new Movie("Fast and Furious", 20150220,392869, 73,true);
		Movie a8Node = new Movie("Moon", 19950324,998572, 61,false);
		Movie a9Node = new Movie("Running", 19680525,204860, 34,true);
		Movie a10Node = new Movie("Finishline", 19920318,234234,89,true);
		Movie a11Node = new Movie("Call me number one", 19870319,345674, 80,true);		
		
		aWl.insert(a1Node);
		aWl.insert(a2Node);
		aWl.insert(a5Node);

		gWl.insert(a7Node);
		gWl.insert(a1Node);

		cWl.insert(a1Node);
		cWl.insert(a2Node);
		cWl.insert(a3Node);
		
		bWl.insert(a6Node);
	
		CustomerNode xNode = new CustomerNode("Becca", 901234437, "email", aWl);
		CustomerNode yNode = new CustomerNode("Jackson", 123456789, "email1", bWl);
		CustomerNode zNode = new CustomerNode("Jose", 934567890,"email2", cWl);
		CustomerNode mNode = new CustomerNode("Manny", 223452234,"email3", dWl);
		CustomerNode nNode = new CustomerNode("Kay", 934567856,"email4", eWl);
		CustomerNode oNode = new CustomerNode("Franny", 123456788,"email5", fWl);
		CustomerNode kNode = new CustomerNode("Mike", 723452237,"email6", gWl);
		CustomerNode hNode = new CustomerNode("Dick", 734567857,"email7", hWl);
		CustomerNode iNode = new CustomerNode("Christian", 734562278,"email8", iWl);
		a.insert(xNode);
		a.insert(yNode);
		a.insert(zNode);
		a.insert(kNode);
		a.printTree();
		a.delete(yNode);
		a.printTree();
		a.traverse();
		a.printTree();
		/*a.insert(mNode);
		a.insert(nNode);
		System.out.println("search");
		System.out.println(a.search(6789).getName());
		System.out.println(a.search(7890).getName());
		System.out.println(a.search(2234).getName());
		System.out.println(a.search(7856).getName());
		a.traverse();
		a.printTree();
		System.out.println("searchFor 7890");
		System.out.println(a.search(7890).getName());
		System.out.println("delete6789");
		a.delete(xNode);
		a.traverse();
		a.printTree();
		System.out.println("delete2237");
		a.delete(mNode);
		a.traverse();
		a.printTree();
		System.out.println("delete7857");
		a.delete(nNode);
		a.traverse();
		a.printTree();
		System.out.println("insert6788");
		a.insert(aNode);
		a.traverse();
		a.printTree();
		System.out.println("insert2278");
		a.insert(oNode);
		a.traverse();
		a.printTree();
		System.out.println("delete2234");
		a.delete(zNode);
		a.traverse();
		a.printTree();
		System.out.println("isEmptyTree = " + a.isEmptyTree());*/
 	}
}
