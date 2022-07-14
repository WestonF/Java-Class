import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Assign2
{
    public static void main(String[] args)
		throws IOException
  
	{

		System.out.println("Enter some numbers");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
        // Reading data using readLine
        String values = reader.readLine();
 
        // Printing the read line
        System.out.println(values);


        String[] arrOfStr = values.split(" ", -1); //split string into values
        int length = arrOfStr.length;

        System.out.println(length + " Numbers were entered");

        int big = 0;
        int number = 0;
        int location = 0;

        for(int i = 0; i < length; i++)
        {
            number = Integer.parseInt(arrOfStr[i]);
            if(number > big)
            {
                big = number;
                location = i;
            }
        }

        System.out.println("The largest value is " + big + " at location " + location);
    }
}