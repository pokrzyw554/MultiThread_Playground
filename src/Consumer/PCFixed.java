package Consumer;

public class PCFixed
{
    public static void main(String[] args)
    {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
        System.out.println("ctrl c zeby wyjsc");
    }
}
