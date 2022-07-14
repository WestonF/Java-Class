class lockbait
{
    String name;
    public lockbait(String iname)
    {
        name = iname;
    }
    public synchronized void deadlA(String tname)
            throws InterruptedException
    {
        System.out.println("lock " + name + " by thread " + tname);
       // Thread.yield();
        Thread.sleep(1000);
        System.out.println("unlock " + name + " by thread " + tname);
    }
    /*public synchronized void deadlB(String name)
            throws InterruptedException
    {
        System.out.println("lock B by thread" + name);
        Thread.yield();
        Thread.sleep(3000);
        System.out.println("unlock B by thread" + name);
    }*/

}

class AthenB implements Runnable
{
    String name = "AthenB";
    lockbait A;
    lockbait B;

    public AthenB(lockbait iA, lockbait iB)
    {
        A = iA;
        B = iB;
    }

    @Override
    public void run()
    {
        try
        {
            A.deadlA(name);

            Thread.yield();
            Thread.sleep(1000);

            B.deadlA(name);
        }
        catch(Exception e)
        {

        }
    }

}

class BthenA implements Runnable
{
    String name = "BthenA";
    lockbait A;
    lockbait B;

    public BthenA(lockbait iA, lockbait iB)
    {
        A = iA;
        B = iB;
    }

    @Override
    public void run()
    {
        try
        {
            B.deadlA(name);
            A.deadlA(name);
        }
        catch(Exception e)
        {

        }
    }

}

public class Assign2
{

   public static void main(String[] args)
   {
       lockbait A = new lockbait("A");
       lockbait B = new lockbait("B");
       AthenB AB = new AthenB(A,B);
       BthenA BA = new BthenA(B,A);
       Thread T1 = new Thread(AB);
       Thread T2 = new Thread(BA);

       System.out.println("Start comes now");
       T1.start();
       T2.start();
   }
}
