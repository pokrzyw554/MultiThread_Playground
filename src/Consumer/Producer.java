package Consumer;

public class Producer implements Runnable
{
    Q q;

    Producer(Q q)
    {
        this.q = q;
        new Thread(this, "Producent").start();
    }
    @Override
    public void run()
    {

        int i = 0;
        while(true)
        {
            q.put(i++);
            try
            {
                Thread.sleep(1000); //dodane przeze mnie
            } catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
