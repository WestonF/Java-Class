import java.util.HashSet;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.util.*;

import java.util.stream.*;
import static java.util.stream.Collectors.*;


public class Assign1
{

       public static void main(String[] args)
            throws IOException
    {
        System.out.println("Hello World");
        Set<String> stuff = listFiles("C:\\Users\\westo\\WFHome\\sandbox2");
        System.out.println(stuff);
    }

    public static Set<String> listFiles(String dir) {
        return Stream.of(new File(dir).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
    }

}
