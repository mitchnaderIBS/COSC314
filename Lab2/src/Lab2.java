import java.util.Scanner;

public class Lab2 {

	
	public static void permutate(int n){
		// Initialize array and populate with ints
		int[] array = new int[n];
		
		for(int index = 0; index < array.length; index++){
			array[index] = index + 1;
		}
		
		// Print initial ordering
		printArray(array);
		
		while(findNextPermutation(array)){
			printArray(array);
		}
	}
	
	public static boolean findNextPermutation(int[] array){
	
		// Find next pair of numbers in numerical order starting at the right;
		int lastIndex = array.length - 1;
		int orderedIndex1 = lastIndex -1;
		int orderedIndex2;
		
		// Find first ordered number
		while(orderedIndex1 >= 0){
			
			
			// If numbers are in less < greater order stop iterating
			if(array[orderedIndex1] < array[orderedIndex1 + 1]){
				break;
			}
			else{
				orderedIndex1--; 
			}
		}
		// If -1 is reached there are no more permutations as all numbers are in 'reverse' order
		if(orderedIndex1 == -1){
			return false;
		}
		orderedIndex2 = lastIndex;
		// Find second 'ordered' number, the right-most number that is greater than the first 'ordered' number
		while(array[orderedIndex1] > array[orderedIndex2]){
			orderedIndex2--;
		}
		
		// Swap ordered numbers
		swapElements(array, orderedIndex1, orderedIndex2);
		
		// Swap remaining elements to the right of the larger ordered number in the earlier swap if they are 'unordered'
		orderedIndex2 = orderedIndex1 + 1;
		orderedIndex1 = lastIndex;
		while(orderedIndex1 > orderedIndex2){
			
			swapElements(array, orderedIndex1, orderedIndex2);
			orderedIndex1--;
			orderedIndex2++;
		}
		return true;
	}
	
	public static void swapElements(int[] array, int index1, int index2){
		
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	public static void printArray(int[] array){
		
		for(int index = 0; index < array.length; index++){
			System.out.print(array[index]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int n = 0;
		int endProgramFlag = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("_____________________________________________________________");
		System.out.println("COSC 314, Fall 2018, Lab 2");
		System.out.println("Mitchell Nader E01242848");
		
		while(endProgramFlag != 2){
			
			System.out.println("_____________________________________________________________");
			System.out.println("Enter length, n, of the lexicographic permutation (1, 2, ... n): \n");
			
			n = input.nextInt();
			System.out.println("_____________________________________________________________");
			
			permutate(n);
			
			System.out.println("_____________________________________________________________");
			System.out.println("Enter a number:\n\t(1) Enter new numbers\n\t(2) Terminate Program \n");
			endProgramFlag = input.nextInt();
		}
		System.out.println("Program terminated");
		input.close();

	}

}
