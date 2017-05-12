import java.util.Random;

/*
 * 	AJS 
 * 
 */

public class MergeSortApp {
	final static int maxSize = 20;
	final static int maxValue = 99;
	private static long[] myArray;

	public static void main(String[] args) {
		
		myArray = new long[maxSize];
		fillArray();
		System.out.print("Unsorted: ");
		for (int i=0; i<maxSize; i++) System.out.print(myArray[i] + " ");
		System.out.println();
		
		Tree234 theTree = new Tree234();
		for(int i=0; i<maxSize; i++) {
			theTree.insert(myArray[i]);
		}
		theTree.display();
	
	}
	
	public static void fillArray() {
		Random rng = new Random();
		for(int i=0; i<maxSize; i++) {
			myArray[i] = Math.abs(rng.nextLong() % (maxValue + 1));
		}
	}

}
