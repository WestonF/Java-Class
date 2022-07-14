import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;

class singleton
{
    static int spawn_count;
    private singleton()
    {
        spawn_count++;
        System.out.println("New singleton created");
    }
    //public static singleton
    public static synchronized singleton instanciate()
    {
        if(spawn_count >= 1)
        {
            System.out.println("Singleton creation prevented!");
            return null;
        }

        singleton newsing = new singleton();
        return newsing;
    }

}
//singleton::spawn_count = 0;

public class Assign1
{

   public static void main(String[] args)
   {
       singleton sing = singleton.instanciate();
       singleton sing2 = singleton.instanciate();
   }
}
