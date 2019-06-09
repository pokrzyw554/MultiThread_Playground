public class Zad1
{
    public static void main(String[] args)
    {
        CallMe target = new CallMe();
        Caller ob1 = new Caller(target, "witaj");
        Caller ob2 = new Caller(target, "zsynchronizowany");
        Caller ob3 = new Caller(target, "świecie");
        try
        {
            ob3.t.join();
            ob2.t.join();
            ob1.t.join();
        }catch(InterruptedException e)
        {
            System.out.println("przerwano");
        }
    }
}
