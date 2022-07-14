import java.io.IOException;
import java.io.File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class Assign3
{

   public static void main(String[] args)
        throws IOException
   {
       int count = 0;
       if (args.length <= 1)
       {
           count = countchar(args[0]);
       }
       System.out.println(count);
   }
   public static int countchar(String ref)
   {
       int count = 0;
       char target = ref.charAt(0);
       String FileName = "TargetFile.txt";

       BufferedReader bread = null;
       try
       {
           bread = new BufferedReader(new FileReader(FileName));
           if (bread == null)
           {
               System.out.println("Panic Bread");
           }

           String line;
           while ((line = bread.readLine()) != null)
           {
               for (int i = 0; i < line.length(); i++)
               {
                   if (line.charAt(i) == target)
                   {
                        count++;
                   }
               }
           }

            return count;
       }
       catch (Exception e)
       {
           return count;
       }
       finally
       {
           try
           {
               if (bread != null)
               {
                   bread.close();
               }
           }
           catch (IOException e)
           {

           }
       }

   }
}
