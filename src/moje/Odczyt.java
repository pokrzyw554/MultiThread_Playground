package moje;

import com.fazecast.jSerialComm.SerialPort;

import java.util.Arrays;
//kalsa Odczyt bedzie posiadac buffer, do ktorego bedziemy zapisywac dane


public class Odczyt implements Runnable
{
    SerialPort port;
    public byte[] buffor;

    public Odczyt(SerialPort port)
    {
        this.port = port;
        new Thread(this, "Odczyt").start();
    }

    void Read()
    {
     //port.readBytes();
    }

    @Override
    public void run()
    {
        //SerialPort GSM = SerialPort.getCommPorts()[0];
        port.setBaudRate(115200);
        port.openPort();
        try {
            while (true)
            {
                while (port.bytesAvailable() == 0)
                    Thread.sleep(10);

                byte[] readBuffer = new byte[port.bytesAvailable()];
                int numRead = port.readBytes(readBuffer, readBuffer.length);
                System.out.println("Read " + numRead + " bytes.");
                System.out.println(Arrays.toString(readBuffer));
                System.out.println(metoda(readBuffer));
            }
        } catch (NegativeArraySizeException e)
        {
            System.err.println("nie można otworzyć portu. Czy używa go inny program?");
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        port.closePort();
    }
    private static String metoda(byte[] readBuffer)
    {
        char[] wynik = new char[readBuffer.length];
        for(int i=0; i<readBuffer.length;i++)
        {
            wynik[i] = (char)readBuffer[i];
        }
        String s = String.valueOf(wynik);
        return s;
    }
}
