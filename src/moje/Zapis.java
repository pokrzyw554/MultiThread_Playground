package moje;

import com.fazecast.jSerialComm.SerialPort;

import java.util.Scanner;

public class Zapis implements Runnable
{
    //todo
    //w sumie zerżnij z tamtej klasy i wystartuj jako thread
    //+ zamiast stałej wartości, oczekuj na Stringa ze scanera
    public static SerialPort GSM;

/*    public void zielona() {
        //SerialPort GSM = SerialPort.getCommPorts()[0];
        GSM.setBaudRate(115200);    //todo musisz utworzyć instancje portu szeregowego jeszcze przed
        GSM.openPort();             //todo wywolaniem metod, inaczej bedziesz czekac na inicjacje portu
        String moj = "zielona\n";
        byte[] mojBytes = moj.getBytes();
        try {
            for (int i = 0; i < 5; i++) {
                GSM.writeBytes(mojBytes, mojBytes.length);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        GSM.closePort();
    }*/

    public Zapis(SerialPort port)
    {
        GSM = port;
        new Thread(this, "Zapis").start();
    }

    @Override
    public void run()
    {
        System.out.println("rozpoczynam zapis");
        Scanner sc = new Scanner(System.in);
        String wczytane = "zielona";
       // writer = new Writer();
        try
        {
            while(true)
            {
                wczytane = sc.nextLine();
                if(wczytane==null)
                {
                    wait();
                }else
                {
                    System.out.println(wczytane);
                    CustomWrite(wczytane, GSM);
                }
            }
        } catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public synchronized void CustomWrite(String podany, SerialPort port)
    {
        System.out.println("odebrano " + podany);
        port.setBaudRate(115200);
        if(!port.isOpen())
        {
            System.out.println("próba otwarcia portu");
            port.openPort();             //todo czemu otwieranie portu nie dziala?
        }
        String moj = podany+'\n';
        byte[] mojBytes = moj.getBytes();
        port.writeBytes(mojBytes, mojBytes.length);
        //zamykac port czy nie?

    }

}
