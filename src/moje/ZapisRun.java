package moje;


import com.fazecast.jSerialComm.SerialPort;

public class ZapisRun
{
    private static SerialPort GSM = SerialPort.getCommPorts()[0];
    public static void main(String[] args)
    {
        GSM.setBaudRate(115200);
        GSM.openPort();
        String moj = "zielona\n";
        byte[] mojBytes = moj.getBytes();
        try
        {
            for(int i = 0; i < 3; i++)
            {
                GSM.writeBytes(mojBytes, mojBytes.length);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        GSM.closePort();
    }

}
