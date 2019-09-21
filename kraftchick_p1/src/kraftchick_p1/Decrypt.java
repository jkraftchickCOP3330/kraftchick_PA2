package kraftchick_p1;

import java.util.Scanner;

public class Decrypt {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in).useDelimiter("");
		int userNum[] = new int[4];
		int tmp;
		
		// Number input
		System.out.print("Please enter 4 digits to decrypt: ");
		for (int i = 0; i < 4; i++)
		{
			userNum[i] = Integer.parseInt(scan.next());
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