import java.util.Random;
class intQueue
{
    int data[] = new int[10];
    int last = 0;

    public synchronized boolean addInt(int number)
    // throws InterruptedException
    {
        if (last >= 9)
        {
            return false;
        }
        last++;
        data[last] = number;

        return true;
    }

    public synchronized int takeInt()
    {
        int number = -1;
        if(last <= 0)
        {
            return number;
        }
        number = data[0];
        for (int i = 0; i < last; i++)
        {
            data[i] = data[i + 1];
        }
        data[last] = 0;
        last--;

        return number;
    }
}

class counter
{
    int count = 0;

    public int inc()
    {
        count++;
        return count;
    }

    public int dec()
    {
        count--;
        return count;
    }

    public int check()
    {
        return count;
    }
}
class intProducer implements Runnable
{
    intQueue Q;
    counter count;
    public intProducer(intQueue i_Q, counter i_count)
    {
        Q = i_Q;
        count = i_count;
    }

    public boolean makeInt()
    {
        Random rand = new Random();	//create instance of random
        int number = rand.nextInt(100);	//get a number between 0 and 99
        return Q.addInt(number);
   }

    @Override
    public void run()
    {
        try
        {
            while (count.check() < 20)
            {
                if (!makeInt())
                {
                    Thread.yield();
                    Thread.sleep(250);
                    System.out.println("makeYield");
                }
                System.out.println("Made");
            }
        }
        catch(Exception e)
        {

        }
    }

}

class intConsumer implements Runnable
{
    intQueue Q;
    counter count;
    public intConsumer(intQueue i_Q, counter i_count)
    {
        Q = i_Q;
        count = i_count;

    }

    public int takeInt()
    {
        int number = Q.takeInt();
        return number;
    }

    @Override
    public void run()
    {
        try
        {
            while (count.check() < 20)
            {
                int number = 0;
                number = takeInt();
                if (number < 0)
                {
                    Thread.yield();
                    Thread.sleep(250);
                    count.inc();
                    System.out.println("getYield");
                }
                else
                {
                    count.inc();
                    System.out.println("got number: " + number);
                }
            }
        }
        catch(Exception e)
        {

        }
    }

}
public class Assign3 
{

    public static void main(String[] args)
    {
        counter count = new counter();
        intQueue Q = new intQueue();
        intProducer produce= new intProducer(Q, count);
        intConsumer consume= new intConsumer(Q, count);
        Thread T1 = new Thread(produce);
        Thread T2 = new Thread(consume);

        System.out.println("Start comes now");
        T1.start();
        T2.start();
    }
}
