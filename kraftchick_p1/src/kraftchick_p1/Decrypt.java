package kraftchick_p1;

import java.util.Scanner;

public class Decrypt {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in).useDelimiter("");
		String tmpC;
		int userNum[] = new int[4];
		int tmp;
		
		// Number input
		System.out.print("Please enter 4 digits to decrypt (ex: 0123 or 9999): ");
		for (int i = 0; i < 4; i++)
		{
			tmpC = scan.next();
			userNum[i] = Integer.parseInt((Character.isDigit(tmpC.charAt(0)) ? tmpC : "-1"));
		}
		
		// decyphers 0123 and 123 the same
		for (int i = 0; i < 4; i++)
		{
			if (userNum[i] == -1)
			{
				// shift characters one position back in int array
				for (int j = i; j > 0; j--)
				{
					userNum[j] = userNum[j - 1];
				}
				userNum[0] = 0;		
			}
		}
		
		// Decryption Step 1
		tmp = userNum[0];
		userNum[0] = userNum[2];
		userNum[2] = tmp;
		
		tmp = userNum[1];
		userNum[1] = userNum[3];
		userNum[3] = tmp;
		
		// Decryption Step 2
		for (int i = 0; i < 4; i++)
		{
			userNum[i] = (userNum[i] + 3) % 10;
		}
		
		// Number Output
		System.out.print("Your decrypted number is: ");
		for (int i = 0; i < 4; i++)
		{
			System.out.print(userNum[i]);
		}
		System.out.println("");
	}
	
}