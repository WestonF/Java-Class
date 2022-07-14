import java.util.function.Consumer;
import java.io.*;
import java.util.*;

import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.toList;
import java.util.stream.Collectors.*;

import java.util.Collections.*;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;


class byLength implements Comparator<String>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(String a, String b)
    {
        return a.length() - b.length();
    }
}

class byLengthReverse implements Comparator<String>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(String a, String b)
    {
        return b.length() - a.length();
    }
}

class byFirstLetter implements Comparator<String>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(String a, String b)
    {
        return a.charAt(0) - b.charAt(0);
    }
}

class has_e implements Predicate<String>
{
    public boolean test(String s)
    {
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == 'e')
            {
                return true;
            }
        }
        return false;
    }
}

class not_has_e implements Predicate<String>
{
    public boolean test(String s)
    {
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == 'e')
            {
                return false;
            }
        }
        return true;
    }
}
public class Assign1
{
    public static void main(String[] args)
    {
        System.out.println("By Increasing Length");
        Collections.sort(stringList, (String a, String b) -> {return a.length() - b.length();});
        stringList.forEach(System.out::println);
        System.out.println("");

        System.out.println("By Decreasing Length");
        Collections.sort(stringList, (String a, String b) -> {return b.length() - a.length();});
        stringList.forEach(System.out::println);
        System.out.println("");

        System.out.println("By First Char ID");
        Collections.sort(stringList, (String a, String b) -> {return (a.charAt(0) - b.charAt(0));});
        stringList.forEach(System.out::println);
        System.out.println("");

        System.out.println("Contains Char \'e\' first");
        List<String> halfList = stringList.stream()
                .filter(s ->
                {
                    for(int i = 0; i < s.length(); i++)
                    {
                        if(s.charAt(i) == 'e')
                        {
                            return true;
                        }
                    }
                    return false;
                }
                )
                .collect(toList());

        List<String> extraList = stringList.stream()
            .filter(s ->
                    {
                        for(int i = 0; i < s.length(); i++)
                        {
                            if(s.charAt(i) == 'e')
                            {
                                return false;
                            }
                        }
                        return true;
                    }
            )
            .collect(toList());
        halfList.addAll(extraList);
        halfList.forEach(System.out::println);
        System.out.println("");
        System.out.println("");

        System.out.println("By Increasing Length");
        Collections.sort(stringList, new byLength());
        stringList.forEach(System.out::println);
        System.out.println("");

        System.out.println("By Decreasing Length");
        Collections.sort(stringList, new byLengthReverse());
        stringList.forEach(System.out::println);
        System.out.println("");

        System.out.println("By First Char ID");
        Collections.sort(stringList, new byFirstLetter());
        stringList.forEach(System.out::println);
        System.out.println("");

        System.out.println("Contains Char \'e\' first");
        List<String> halfList2 = stringList.stream()
                .filter(new has_e())
                .collect(toList());

        List<String> extraList2 = stringList.stream()
                .filter(new not_has_e())
                .collect(toList());
        halfList2.addAll(extraList2);
        halfList2.forEach(System.out::println);

        System.out.println("");
        System.out.println("");
        List<String> intouts = new ArrayList<String>();
        for(int i = 0; i < intlist.length; i++)
        {
            String current = new String();
            if(intlist[i] % 2 == 0)
            {
                current= "e";
            }
            else
            {
                current = "o";
            }
            String numwords = Integer.toString(intlist[i]);
            current = current.concat(numwords);
            if((i + 1) < intlist.length)
            {
                current = current.concat(", ");
            }
            intouts.add(current.substring(0));

        }
        for(int i = 0; i < intouts.size(); i++)
        {
            System.out.println(intouts.get(i));
        }

        System.out.println("");
        System.out.println("");
        List<String> aList = stringList.stream()
                .filter(s -> s.charAt(0) == 'a')
                .filter(s -> s.length() == 3)
                .collect(toList());
        for(int i = 0; i < aList.size(); i++)
        {
            System.out.println(aList.get(i));
        }
    }

    public static List<String> stringList = Arrays.asList("aWo", "WordTwo", "awo", "low", "aeW", "eOt", "MoreWord", "aExtraWord", "aLastWord","thing", "stuff", "wind");
    public static int intlist[] = {22, 32, 42, 54, 677, 1, 3, 1, 2, 78};
    //public static String[] stringArr = {"WordOne", "WordTwo", "word", "lowerword", "eWord", "eOtherWord", "MoreWord", "ExtraWord", "LastWord"};
}
