public class TestMovies{
	public static void main(String[] args) {
		MovieID a = new MovieID();
		System.out.println("isEmptyTree = " + a.isEmptyTree());
		Movie xNode = new Movie("Forever", 20030213, 223312, 83, true);
		Movie yNode = new Movie("Fast car", 20010930, 395712, 92, true);
		Movie zNode = new Movie("Never forget", 20020330, 8395783, 51, false);
		Movie kNode = new Movie("Mean girl", 20100302,294768,73, true);
		Movie aNode = new Movie("The ocean", 20110305,392847, 94, false);
		Movie bNode = new Movie("Sunshine", 20140403,395768, 62, true);
		Movie cNode = new Movie("Fast and Furious", 20150220,392869, 73, true);
		Movie dNode = new Movie("Moon", 19950324,998572, 61, true);
		Movie mNode = new Movie("Running", 19680525,204860, 34, true);
		Movie nNode = new Movie("Finishline", 19920318,234234,89, false);
		Movie oNode = new Movie("Call me number one", 19870319,345723, 96, false);
		a.insert(xNode);
		a.insert(yNode);
		a.insert(zNode);
		a.insert(kNode);
		a.insert(cNode);
		a.insert(nNode);
		a.insert(oNode);
		System.out.println("Available: " + xNode.check());
		System.out.println("Available: " + yNode.check());
		System.out.println("Available: " + zNode.check());
		System.out.println("Available: " + kNode.check());
		System.out.println("Available: " + cNode.check());
		System.out.println("Available: " + nNode.check());
		
	}
}