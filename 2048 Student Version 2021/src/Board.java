import java.util.Random;
import java.util.Arrays;

public class Board {
 
	private int[][] board; // holds state of game
	private Random rnd = new Random(0); // setup random # generator
	
	/* default constructor for board */
	// constructors must match exactly the name
	// of the class.
	public Board() {
		// instantiate the board
		board = new int[4][4];
		populateOne(); 
		populateOne();
	}
	
	public void eraseBoard() {
		boolean temp = false;
		for (int r = 0; r < board.length; r++) {
			   for (int c = 0; c < board[0].length; c ++) {
				   if (board[r][c] == 0) {
					      temp = true;
				   	}
			   }   
        }
        
		if (!temp) {
			for (int r = 0; r < board.length; r++) {
				   for (int c = 0; c < board[0].length; c ++) {
					   board[r][c] = 0;
				   }
			}
		} 
    }
			

	/*
	 * return a String representation of the 2D array board
	 * each row should be in its own line
	 * 
	 * Example:
	 * 
	 * { {1, 2, 3}, {4, 5, 6}} -> 1 2 3
	 * 
	 * 4 5 6
	 */

	
	// overriding a method is when a "child"
	// class implement the same method of the parent
	public String toString() {
		String builder = "";
		for (int r = 0; r < board.length; r++) {
			for(int c = 0; c< board[0].length; c++) {
				String str = String.format("%04d", board [r][c]);
				builder += str + " ";
			}
			builder += "\n"; // \n adds new line character
		}
		return builder;
	}

	/*
	 * set one of the empty spaces (at random)
	 * 
	 * to a 2 or 4 (90/10 chance). an empty spot is defined to be a 0 element
	 * 
	 * Must use the Random class object rnd.
	 * 
	 * Example Use of rnd object.
	 * 
	 * int randomNum = rnd.nextInt(10); //returns a number in range [0 10) (not
	 * inclusive on the 10)
	 */

	public void populateOne() {
		// is there an empty spot?
		// for randomness, generate a row and column
		// check if that tile is empty, if not
		// generate another set of row and column
		// what happens if the entire board is full??! 
		int num = rnd.nextInt(10);
		int val = rnd.nextInt(10);
		int r = rnd.nextInt(4);
		int c = rnd.nextInt(4);
		if (board[r][c] == 0) {
			if (val < 8) {
				board[r][c] = 2;
			}
			if (val >= 8) {
				board[r][c] = 4;
			}
		}
	}
	/*
	 * 
	 * Given an array of integers, slide all non-zero elements to the right.
	 * 
	 * zero elements are considered open spots.
	 * 
	 * example:
	 * 
	 * [0 2 0 2]->[0 0 2 2]
	 * 
	 * [2 8 0 2]->[0 2 8 2]
	 * 
	 * [4 0 0 0]->[0 0 0 4]
	 */

	public void slideRight(int[] row) {
		int num = row.length;
		while (num > 0) {
			for(int i = 1; i < row.length; i ++) {
				if (row[i]==0) {
					int temp = row[i-1];
					row[i-1] = row[i];
					row[i] = temp;
				}
			}
			num --;
	    }
	
    }

	/*
	 * 
	 * Move the numbers as far to the right as they can go
	 * aka the numbers are trying to move to the right-most
	 * empty spaces. This method must utilize the slideRight(int[] row) method
	 * must utilize the helper method above for full credit.
	 * param: a valid row of 2048 where 0s are "empty" spots
	 * effect: row is modified so all numbers are to the right side
	 * return: none
	 */

	public void slideRight() {
		slideRight(board[0]);
		slideRight(board[1]);
		slideRight(board[2]);
		slideRight(board[3]);
	}

	/**
	 * Given an array of integers, slide all non-zero elements to the left.
	 * 
	 * zero elements are considered open spots.
	 * 
	 * example:
	 * 
	 * [0 2 0 2] -> [2 2 0 0]
	 * [2 0 0 2] -> [2 2 0 0]
	 */

	public void slideLeft(int[] arr) {
		int num = arr.length;
		while (num > 0) {
			for(int i = 0; i < arr.length-1; i ++) {
				if (arr[i]==0) {
					int temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
			}
			num --;
		}
	}

	/*
	 * Slide all the numbers to the left so that
	 * 
	 * all of the empty spaces are on the right side
	 */

	public void slideLeft() {
		slideLeft(board[0]);
		slideLeft(board[1]);
		slideLeft(board[2]);
		slideLeft(board[3]);
	}

	/*
	 * Given a 2D array and a column number, return a 1D array representing the
	 * elements in the given column number.
	 */
	public int[] getCol(int[][] data, int c) {
		int [] arr = new int[data.length];
		for (int r = 0; r < data.length; r++) {
			arr[r] = data[r][c];
		}
		return arr;
	}
		//String[][] data = new String[2][5];	
		
	/*
	 * Given an array of integers, slide all non-zero elements to the top.
	 * 
	 * zero elements are considered open spots.
	 */

	public void slideUp(int[] arr) {
		slideLeft(arr);
	}
	/*
	 * 
	 * Slide all elements in the board towards the top.
	 * 
	 * You must use slideUp and getCol for full credit.
	 */
	public void slideUp() {
        for (int i = 0; i < board[0].length; i++ ) {
		    int [] temp = getCol(board , i);
		    slideUp(temp);
		        for(int j = 0; j < board.length; j++) {
			           board[j][i] = temp[j];
			           board[j][i] = temp[j];
		           	   board[j][i] = temp[j];
			           board[j][i] = temp[j];
		        }
		}
		
	}   
		
	public void slideDown(int[] arr) {
		slideRight(arr);
	}
	
	public void slideDown() {
		for (int i = 0; i < board[0].length; i++ ) {
			int [] temp = getCol(board , i);
			slideDown(temp);
			
			for(int j = 0; j < board.length; j++) {
				board[j][i] = temp[j];
				board[j][i] = temp[j];
				board[j][i] = temp[j];
				board[j][i] = temp[j];
			}
			
		}
	}

	/*
	 * Given the 2D array, board, combineRight will take adjacent numbers that
	 * are the same and combine them (add them).
	 * 
	 * After adding them together, one of the numbers is zeroed out. For
	 * example, if row 0 contained [0 0 4 4],
	 * 
	 * a call to combineRight will produce [0 0 0 8]. If row 1 contained [2 2 2
	 * 2], a call to combineRight will
	 * 
	 * produce [0 4 0 4].
	 * 
	 * Notice that the left element is zeroed out.
	 */

	public void combineRight() {
		for (int r = 0; r < board.length; r++) {
			for(int c = board.length-1; c > 0; c--) {
				if (board[r][c] == board[r][c-1]) {
					board[r][c] = board[r][c]*2;
					board[r][c-1] = 0;
				}
			}
		}
	}

	/*
	 * same behavior as combineRight but the right element is zeroed out when
	 * two elements are combined
	 */

	public void combineLeft() {
		for (int r = 0; r < board.length; r++) {
			for(int c = 0; c< board[0].length-1; c++) {
				if (board[r][c] == board[r][c+1]) {
					board[r][c] = board[r][c]*2;
					board[r][c+1] = 0;
				}
			}
		}
	}
	
	/*
	 * same behavior as combineRight but the bottom element is zeroed out when
	 * two elements are combined
	 */

	public void combineUp() {
		for (int r = 0; r < board.length-1; r++) {
			for(int c = 0; c< board[0].length; c++) {
				if (board[r][c] == board[r+1][c]) {
					board[r+1][c] = board[r][c]*2;
					board[r][c] = 0;
				}
			}
		}
	}
	/*
	 * same behavior as combineRight but the top element is zeroed out when two
	 * elements are combined
	 */
	public void combineDown() {
		for (int r = 0; r < board.length-1; r++) {
			for(int c = 0; c< board[r].length; c++) {
				if (board[r][c] == board[r+1][c]) {
					board[r][c] = board[r][c]*2;
					board[r+1][c] = 0;
				}
			}
		}
	}

	/* reminder: these are the methods that will ultimately invoke
	 * a series of methods
	 * 
	 * the combine and slide methods should not worry about each other's methods
	 */
	public void left() {
		slideLeft();
		combineLeft();
		slideLeft();
	}

	public void right() {
		slideRight();
		combineRight();
		slideRight();
	}

	public void up() {
		slideUp();
		combineUp();
		slideUp();
	}

	public void down() {
	    slideDown();
	    combineDown();
	    slideDown();
	}

	public boolean gameOver() {
		boolean temp = true;
		for (int r = 0; r < board.length; r++) {
			   for (int c = 0; c < board[0].length; c ++) {
				   if (board[r][c] == 0) {
					   temp = false;
				   }
			    }
		}
		
		if (!temp) {
			return false;
		} else {
			return true;
		}
	}

	public int[][] getBoard() {
		return board;
	}
	
	// populate with a given 2d array
	public void populate(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				board[r][c] = arr[r][c];
			}
		}
		
		int val = rnd.nextInt(6);
		while(val==4){
			val = rnd.nextInt(6);
		}
		int total = val+2; 
	}

}
