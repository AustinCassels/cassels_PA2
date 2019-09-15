package cassels_p02;

import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		//initialize variables
		Scanner scnr = new Scanner(System.in);
		int isStandardUnits = 0;
		double userHeight;
		double userWeight;
		double userBMI;
		String weightUnit;
		String heightUnit;
		
		//prompt user for Standard or SI units
		System.out.println("Please enter 0 for Metric or 1 for Standard:");
		isStandardUnits = scnr.nextInt();
		
		
		//assign correct units
		weightUnit = (isStandardUnits == 1) ? "lbs" : "kg";
		heightUnit = (isStandardUnits == 1) ? "in" : "m";
		
		//prompt user for weight
		System.out.println("Please enter weight (" + weightUnit + "):");
		userWeight = scnr.nextDouble();
		
		//prompt user for height
		System.out.println("Please enter height (" + heightUnit + "):");
		userHeight = scnr.nextDouble();
		
		//calculate BMI for metric
		userBMI = userWeight / Math.pow(userHeight, 2);
		
		//multiply BMI by 703 if standard units were selected
		if(isStandardUnits == 1)
			userBMI *= 703;
		
		//print BMI
		System.out.printf("\nYou have a BMI of %.1f\n\n", userBMI);
		
		
		//print BMI groups
		System.out.println("BMI Categories:");
		System.out.println("\tUnderweight = <18.5");
		System.out.println("\tNormal weight = 18.5–24.9");
		System.out.println("\tOverweight = 25–29.9");
		System.out.println("\tObesity = BMI of 30 or greater");
		
		//close scanner
		scnr.close();
	}

}
