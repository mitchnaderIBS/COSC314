import java.util.BitSet;
import java.util.Scanner;

public class Lab1 {

	public static void iterateBits(BitSet bits, int length, int k){
		
		int numSets = (int) Math.pow( 2, (double) length);
		
		for(int i = 0; i < numSets; i++){
			
			if(bits.cardinality() == k){
				
				System.out.println(bits.toString());
				addOneToBitString(bits, length);
			}
			else{
				addOneToBitString(bits, length);
			}
		}
	}
	
	public static BitSet addOneToBitString(BitSet bits, int length){
		
		int index = length;
	
		while(bits.get(index)){
			
			if(bits.get(index)){
				
				bits.flip(index);
				index--;
			}		
		}
		
		bits.set(index);
	
		return bits;
	}
	
	public static void main(String[] args) {
		
		BitSet bits;
		int n = 0;
		int k = 0;
		int endProgramFlag = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("_____________________________________________________________");
		System.out.println("COSC 314 Lab 1");
		System.out.println("Mitchell Nader");
		
		while(endProgramFlag != 2){
			
			System.out.println("_____________________________________________________________");
			System.out.println("Enter length of bit-string (n value):");
			
			n = input.nextInt();
			System.out.println("_____________________________________________________________");
			
			bits = new BitSet(n + 1);
			
			System.out.println("Enter length of desired set (k value):");
			k = input.nextInt();
			System.out.println("_____________________________________________________________");
			System.out.println("Result: \n");
			
			iterateBits(bits, n, k);
			
			System.out.println("_____________________________________________________________");
			System.out.println("Enter a number:\n\t(1) Enter new numbers\n\t(2) Terminate Program");
			endProgramFlag = input.nextInt();
		}
		System.out.println("Program terminated");
		input.close();
	}

}