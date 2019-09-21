package kraftchick_p1;

import java.util.Scanner;

public class Encrypt {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in).useDelimiter("");
		int userNum[] = new int[4];
		int tmp;
		
		// Number input
		System.out.print("Please enter 4 digits to encrypt: ");
		for (int i = 0; i < 4; i++)
		{
			userNum[i] = Integer.parseInt(scan.next());
		}

		// Encryption Step 1
		for (int i = 0; i < 4; i++)
		{
			userNum[i] = (userNum[i] + 7) % 10;
		}
		
		// Encryption Step 2
		tmp = userNum[0];
		userNum[0] = userNum[2];
		userNum[2] = tmp;
		
		tmp = userNum[1];
		userNum[1] = userNum[3];
		userNum[3] = tmp;
		
		// Number Output
		System.out.print("Your encryped number is: ");
		for (int i = 0; i < 4; i++)
		{
			System.out.print(userNum[i]);
		}
		System.out.println("");
	}
	
}
