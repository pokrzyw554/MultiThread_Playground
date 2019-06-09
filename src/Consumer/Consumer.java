package Consumer;

public class Consumer implements Runnable
{
    private Q q;

    Consumer(Q q)
    {
        this.q = q;
        new Thread(this, "Konsument").start();
    }

    @Override
    public void run()
    {
        while(true)
        {
            q.get();
        }
    }
}
