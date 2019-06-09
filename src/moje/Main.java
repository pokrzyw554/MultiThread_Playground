package moje;

import com.fazecast.jSerialComm.SerialPort;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("START:");
        System.out.println(Arrays.toString(SerialPort.getCommPorts()));
        SerialPort arduino = SerialPort.getCommPorts()[0];
        new Zapis(arduino);
        new Odczyt(arduino);
        System.out.println(":KONIEC");
    }
}
