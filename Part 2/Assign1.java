import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Assign1
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
        //int[] arrOfInt = new int[length];

        System.out.println(length + " Numbers were entered");

        int sum = 0;
        int number = 0;

        for(int i = 0; i < length; i++)
        {
            number = Integer.parseInt(arrOfStr[i]);
            sum = sum + number;
            
            //arrOfInt[i] = parseInt(arrOfStr[i]);
            //System.out.println(arrOfStr[i]);
        }

        System.out.println("The sum of the entered values is " + sum);
    }
}