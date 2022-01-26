import java.util.Arrays;

public class Activity3Tester {

	public static void main(String[] args) {
		
		//Declare a Board object
		Board b3 = new Board ();
		
		//create an array with some values you want to 
		//slideRight. ie [2 0 0 0]
		
		int[] arr3 = {0, 2, 0, 2};
		
		//invoke the slideRight method on the array 
		b3.slideRight(arr3);
		
		//print out the array to see if slideRight
		//worked
		System.out.println(Arrays.toString(arr3)); 
		
		
	}

}
