package kraftchick_p2;

import java.util.Scanner;

public class BMICalc {

	public static void main(String[] args) {
		Scanner scanChar = new Scanner(System.in).useDelimiter("");
		Scanner scan = new Scanner(System.in);
		boolean imperialFomula = true;
		double weight;
		double height;
		double bmi;
		
		System.out.print("Use Imperial units of measurement? ('y' or 'n'): ");
		imperialFomula = (scanChar.next().charAt(0) == 'y' ? true : false);
		
		System.out.print("Please enter your weight in " + (imperialFomula ? "Pounds" : "Kilos") + ": ");
		weight = scan.nextDouble();
		
		System.out.print("Please enter your height in " + (imperialFomula ? "Inches" : "Meters") + ": ");
		height = scan.nextDouble();
		scan.close();
		
		bmi = (((imperialFomula ? 703 : 1) * weight) / Math.pow(height, 2));

		System.out.printf("\nBMI Categories\nUnderweight   = <18.5\nNormal weight = 18.5–24.9\nOverweight    = 25–29.9\nObesity       = BMI of 30 or greater\n\n");
		
		if (bmi < 18.5)
		{
			System.out.printf("You are Underweight with a bmi of %.1f", bmi);
		}
		else if (bmi < 24.9)
		{
			System.out.printf("You are a Normal weight with a bmi of %.1f\n", bmi);
		}
		else if (bmi < 29.9)
		{
			System.out.printf("You are Overweight with a bmi of %.1f\n", bmi);
		}
		else
		{
			System.out.printf("You are Obese with a bmi of %.1f\n", bmi);
		}
	}

}
