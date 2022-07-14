import java.io.IOException;
import java.io.File;
import java.util.*;

import java.util.stream.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;






public class Assign2
{

       public static void main(String[] args)
            throws IOException
    {
        System.out.println("Hello World");
        //Set<String> stuff = listFiles("C:\\Users\\westo\\WFHome\\sandbox2");
        //System.out.println(stuff);
        replace();
    }
    public static void replace()
    {
        //String oldFileName = "C:\\Users\\westo\\WFHome\\sandbox2\\TargetFile.txt";
        String oldFileName = "TargetFile.txt";
       // String tmpFileName = "\\C:\\Users\\westo\\WFHome\\sandbox2\\TestFile.txt.try";
        String tmpFileName = "TargetFile.txt.tmp";

        BufferedReader bread = null;
        BufferedWriter bwrite = null;
        try
        {
            bread = new BufferedReader(new FileReader(oldFileName));
            bwrite = new BufferedWriter(new FileWriter(tmpFileName));
            if(bread == null)
            {
                System.out.println("Panic Bread");
            }
            if(bwrite == null)
            {
                System.out.println("Panic Bwrite");
            }

            String line;
            while ((line = bread.readLine()) != null)
            {
                bwrite.write(line+"\n");    //get existing text to new temp file
            }
            line = "Additional line of text added";
            bwrite.write(line+"\n");

        }
        catch (Exception e)
        {
            return;
        }
        finally
        {
            try
            {
                if(bread != null)
                    bread.close();
            }
            catch (IOException e)
            {
                //
            }
            try
            {
                if(bwrite != null)
                    bwrite.close();
            }
            catch (IOException e)
            {
                //
            }
        }
        // Once everything is complete, delete old file..
        File oldFile = new File(oldFileName);
        oldFile.delete();

        // And rename tmp file's name to old file name
        File newFile = new File(tmpFileName);
        newFile.renameTo(oldFile);

    }
}
