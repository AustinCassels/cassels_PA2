package cassels_p01;

import java.util.Scanner;

public class Decrypt {

	public static void main(String[] args) {
		//initialize variables
		Scanner scnr = new Scanner(System.in);
		int inputData;
		int[] inputDigits = new int[4];
		int[] outputDigits = new int[4];
		String outputData;
		
		//get data input
		System.out.println("Please enter your 4-digit integer:");
		inputData = scnr.nextInt();
		
		//split up the input into single digits
		inputDigits[0] = inputData / 1000;
		inputDigits[1] = inputData / 100 % 10;
		inputDigits[2] = inputData / 10 % 10;
		inputDigits[3] = inputData % 10;
		
		//convert each digit
		outputDigits[0] = ((inputDigits[0] - 7) + 10) % 10;
		outputDigits[1] = ((inputDigits[1] - 7) + 10) % 10;
		outputDigits[2] = ((inputDigits[2] - 7) + 10) % 10;
		outputDigits[3] = ((inputDigits[3] - 7) + 10) % 10;
		
		//collapse digits back to single integer
		outputData = "" + outputDigits[2] + outputDigits[3] + outputDigits[0] + outputDigits[1];
		
		//print "decrypted" data
		System.out.println(outputData);
		
		//close scanner
		scnr.close();
	}

}
