package kraftchick_p3;

import java.util.Scanner;

public class SimplePoll {

	public static void main(String[] args) {
		
		// Topics
		String topics[] = new String[5];
		topics[0] = "Legislating Loot-boxes in video games";
		topics[1] = "Cleaning up the water-ways";
		topics[2] = "Stopping Global Warming";
		topics[3] = "Removing Pineapple from all Pizza";
		topics[4] = "Stopping Corruption in the Gov";
		String topicsAbrv[] = new String[5];
		topicsAbrv[0] = "Loot Boxes";
		topicsAbrv[1] = "Water-ways";
		topicsAbrv[2] = "Global Warming";
		topicsAbrv[3] = "Pineapple Pizza";
		topicsAbrv[4] = "Gov Corruption";
		
		// Var initializations
		int responses[][] = new int[5][10];
		double avg[] = new double[5];
		int total[] = new int[5];
		double max[] = new double[] {-1, -Double.MIN_VALUE};
		double min[] = new double[] {-1, Double.MAX_VALUE};
		Scanner scan = new Scanner(System.in);
		int userInput = -1;
		int numInputs[] = new int[] {0, 0, 0, 0, 0};
		
		// User input
		while (userInput != 0)
		{
			System.out.println("Rate each topic on a scale of 1 (not important) to 10 (super important)");
			if (numInputs[0] == 0)
			{
				System.out.println("Enter a 0 to quit");
			}
			
			for (int j = 0; j < 5; j++)
			{
				System.out.print(topics[j] + ": ");
				userInput = scan.nextInt();
				
				// User input validation
				while (userInput < 0 || userInput > 10)
				{
					System.out.println("Please enter a valid number (0 to quit, 1-10 to rank topic)");
					System.out.print(topics[j] + ": ");
					userInput = scan.nextInt();
				}
				
				// exit case
				if (userInput == 0) 
				{
					break;
				}
				
				responses[j][userInput - 1]++;
				numInputs[j]++;				
			}
		}
		
		// Data analyzation
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				total[i] += responses[i][j] * (j + 1);
			}
			avg[i] = total[i] / (numInputs[i] == 0 ? 1 : (double)numInputs[i]); // prevents divide by 0 if no inputs
			if (total[i] > max[1] && total[i] != 0)
			{
				max[0] = i;
				max[1] = total[i];
			}
			if (total[i] < min[1] && total[i] != 0)
			{
				min[0] = i;
				min[1] = total[i];
			}
			
		}

		
		// Data output
		// Uses vars to control width of prints so they can be easily scaled to fit the data better
		final String questionLen = "%" + (-15.15) + "s";
		final String numLen = "%" + 2.2 + "s";
		final String avgLen = "%" + 4.4 + "s";
		System.out.printf("%n");
		System.out.printf(questionLen + "  | " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " | " + avgLen + "\n", "Questions", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", " Avg");
		System.out.printf(questionLen + "--+-" + numLen + "-" + numLen + "-" + numLen + "-" + numLen + "-" + numLen + "-" + numLen + "-" + numLen + "-" + numLen + "-" + numLen + "-" + numLen + "-+-" + avgLen + "\n", "---------------", "--", "--", "-----", "-----", "-----", "-----", "-----", "-----", "-----", "-----", "-----");
		for (int i = 0; i < 5; i++)
		{
			System.out.printf(questionLen + "  | " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " | " + avgLen + "\n",
					topicsAbrv[i], responses[i][0], responses[i][1], responses[i][2], responses[i][3], responses[i][4], responses[i][5], responses[i][6], responses[i][7], responses[i][8], responses[i][9], avg[i]);
			
		}
		//System.out.printf(questionLen + "  | " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " " + numLen + " | " + avgLen + "\n", "", "", "", "", "", "", "", "", "", "", "", "avg[0]");

		if ((int)min[0] != -1)
			System.out.printf("%nLowest Total : Question %d with a total of %d, %s%n", (int)min[0] + 1, (int)min[1], topics[(int)min[0]]);
		else
			System.out.printf("%nNo response was given, cant have a min value%n");
		
		if ((int)max[0] != -1)
			System.out.printf("Highest Total: Question %d with a total of %d, %s", (int)max[0] + 1, (int)max[1], topics[(int)max[0]]);
		else
			System.out.printf("No response was given, cant have a max value");
	}

}
