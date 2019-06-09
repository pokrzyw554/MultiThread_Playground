package Consumer;

public class Q
{
    int n;
    boolean valueSet = false;

    synchronized int get()
    {
        if(!valueSet)
            try
            {
                wait();
            }catch(InterruptedException e)
            {
                System.out.println("złapano Interputa");
            }
        System.out.println("Pobrano " + n);
        valueSet = false;
        notify();
        return n;
    }
    synchronized void put(int n)
    {
        if(valueSet)
        {
            try
            {
                wait();     //zrzeka sie zasobów procesora (ale po co)
            }catch(InterruptedException e)
            {
                System.out.println("złapano interputted exception");
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Włożono "+n);
        notify();   //informuje że dane są dostępne
    }
}
