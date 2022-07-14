class Assign1 
{
    public static void main(String[] args) 
	{
		//part 1
		System.out.println("1)");
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j <= i; j++)
			{
     			   System.out.printf("*");
			}
			System.out.println("\n");
		}

		for (int i = 0; i < 9; i++)
		{
     		System.out.printf("."); 
		}
		System.out.println("\n");


		//part 2
		System.out.println("2)");
		for (int i = 0; i < 10; i++)
		{
     		System.out.printf(".");
		}
		System.out.println("\n");

		for (int i = 4; i > 0; i--)
		{
			for (int j = 0; j < i; j++)
			{
				System.out.printf("*"); 
			}
			System.out.println("\n");
		}

		
		//part 3
		System.out.println("3)");
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < (5-i); j++)
			{
     			   System.out.printf(" ");
			}

			for (int j = 0; j <= (2 * i); j++)
			{
     			   System.out.printf("*");
			}
			System.out.println("\n");
		}

		for (int i = 0; i < 11; i++)
		{
     		System.out.print(".");
		}
		System.out.println("\n");


		//part 4
		System.out.println("4)");
		
		for (int i = 0; i < 12; i++)
		{
     		System.out.printf(".");
		}
		System.out.println("\n");

		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < (i + 2); j++)
			{
     			   System.out.printf(" ");
			}

			for (int j = 0; j < (7 - (2 * i)); j++)
			{
     			   System.out.printf("*");
			}
			System.out.println("\n");
		}

    }
}