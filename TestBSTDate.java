//Ben Guan, DongMei Sarafan,Yu Xiong
//Final Project
//Due: 05/10/2017
//COM212: Data Structure 
//This file allow user to search the movies by their release dates
public class TestBSTDate {
	
	public static void main(String[] args){
		MovieDate a = new MovieDate();
		System.out.println("isEmptyTree = " + a.isEmptyTree());
		Movie xNode = new Movie("Forever", 20030213, 223312, 83);
		Movie yNode = new Movie("Fast car", 20010930, 395712, 92);
		Movie zNode = new Movie("Never forget", 20020330, 8395783, 51);
		Movie kNode = new Movie("Mean girl", 20100302,294768,73);
		Movie aNode = new Movie("The ocean", 20110305,392847, 94);
		Movie bNode = new Movie("Sunshine", 20140403,395768, 62);
		Movie cNode = new Movie("Fast and Furious", 20150220,392869, 73);
		Movie dNode = new Movie("Moon", 19950324,998572, 61);
		Movie mNode = new Movie("Running", 19680525,204860, 34);
		Movie nNode = new Movie("Finishline", 19920318,234234,89);
		Movie oNode = new Movie("Call me number one", 19870319,345723, 96);
		a.insert(xNode);
		a.insert(yNode);
		a.insert(zNode);
		a.insert(kNode);
		a.insert(cNode);
		a.insert(nNode);
		a.insert(oNode);
		a.traverse();
		a.printTree();
		a.insert(mNode);
		a.insert(dNode);
		System.out.println("search");
		System.out.println(a.search(20030213).getTitle());
		System.out.println(a.search(20150220).getTitle());
		System.out.println(a.search(19920318).getTitle());
		System.out.println(a.search(19870319).getTitle());
		a.traverse();
		a.printTree();
		System.out.println("searchFor 20030213");
		System.out.println(a.search(20030213).getTitle());
		System.out.println("delete20030213");
		a.delete(xNode);
		a.traverse();
		a.printTree();
		System.out.println("delete19680525");
		Movie qq=a.search(19680525);
		a.delete(mNode);
		a.traverse();
		a.printTree();
		System.out.println("delete19920318");
		a.delete(nNode);
		a.traverse();
		a.printTree();
		System.out.println("insert20110305");
		a.insert(aNode);
		a.traverse();
		a.printTree();
		System.out.println("insert20140403");
		a.insert(bNode);
		a.traverse();
		a.printTree();
		System.out.println("delete20020330");
		a.delete(zNode);
		a.traverse();
		a.printTree();
		System.out.println("isEmptyTree = " + a.isEmptyTree());
	    
	

	}

}

