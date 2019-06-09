package moje;

import com.fazecast.jSerialComm.SerialPort;

import java.util.Arrays;

/**
 * POC odczytywania danych z wybranego portu szeregowego (działa na PC)
 */
public class OdczytRun
{
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(SerialPort.getCommPorts()));
        SerialPort GSM = SerialPort.getCommPorts()[0];
        GSM.setBaudRate(115200);
        GSM.openPort();
        try {
            while (true)
            {
                while (GSM.bytesAvailable() == 0)
                    Thread.sleep(10);

                byte[] readBuffer = new byte[GSM.bytesAvailable()];
                int numRead = GSM.readBytes(readBuffer, readBuffer.length);
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
        GSM.closePort();

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
