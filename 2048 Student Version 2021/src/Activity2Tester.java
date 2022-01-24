import java.util.Random;

public class Activity2Tester {

	public static void main(String[] args) {
		//Create a Board object
		
		//call the populateOne method and print out the board each time
		//does it fill a random location? How about if the board is almost
		//full? Does it still work?
		
		Random rnd = new Random(0);
		System.out.println(rnd.nextInt(3));
		System.out.println(rnd.nextInt(3));
		System.out.println(rnd.nextInt(3));
		System.out.println(rnd.nextInt(3));
		
		
		
	}

}
