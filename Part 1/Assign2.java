import java.util.Scanner;
import java.util.Random;


class Assign2
{
    public static void main(String[] args) 
	{

		Random rand = new Random();	//create instance of random
		int number = rand.nextInt(100);	//get a number between 0 and 99
		number = number + 1;	//correct range to 1-100
		//int number = 53;
		int check = 0;
		int count = 0;
		System.out.println("Guess a number between 1 and 100 (inclusive)");

		while(count < 5)
		{
			Scanner in = new Scanner(System.in);
			int guess = in.nextInt();

			System.out.println("You guessed " + guess);
				
			check = number - guess;
			//manage negatives
			if(check < 0)
			{
				check = check * -1;
			}
			//actually test
			if(check <= 10)
			{
				System.out.println("The number was " + number);
				break;
			}
			else
			{
				if(count < 4)
				{
					System.out.println("Guess again");
				}
			}

			count++;
		}

		if(count >= 5)
		{
			System.out.println("Sorry, the number was " + number);
		}


    }
}