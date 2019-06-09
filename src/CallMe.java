public class CallMe
{
    synchronized void call(String msg)
    {
        System.out.print("["+msg);
        try
        {
            Thread.sleep(1000);
        } catch(InterruptedException e)
        {
            System.out.print("przerwano");
        }
        System.out.println("]");
    }
}
