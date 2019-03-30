//Ben Guan, DongMei Sarafan,Yu Xiong
//Final Project
//Due: 05/10/2017
//COM212: Data Structure 
//This file allow user to search the movies by their 6 digits ID
public class TestBSTID {
    public static void main(String[] args){
	MovieID a = new MovieID();
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
	System.out.println(a.search(223312).getTitle());
	System.out.println(a.search(395712).getTitle());
	System.out.println(a.search(8395783).getTitle());
	System.out.println(a.search(294768).getTitle());
	a.traverse();
	a.printTree(); 
	System.out.println("searchFor 223312");
	System.out.println(a.search(223312).getTitle());
	System.out.println("delete183759");
	a.delete(xNode);
	a.traverse();
	a.printTree();
	System.out.println("delete204860");
	a.delete(mNode);
	a.traverse();
	a.printTree();
	System.out.println("delete234234");
	a.delete(nNode);
	a.traverse();
	a.printTree();
	System.out.println("insert392847");
	a.insert(aNode);
	a.traverse();
	a.printTree();
	System.out.println("insert395768");
	a.insert(bNode);
	a.traverse();
	a.printTree();
	System.out.println("delete8395783");
	a.delete(zNode);
	a.traverse();
	a.printTree();
	System.out.println("isEmptyTree = " + a.isEmptyTree());
    }
}

