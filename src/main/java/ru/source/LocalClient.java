package ru.source;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class LocalClient {
    private InetAddress ipAddress;
    private Socket socket;
    private DataInputStream socIn;
    private DataOutputStream socOut;

    public LocalClient() throws IOException {
        ipAddress = InetAddress.getByName("192.168.1.101");
        socket = new Socket(ipAddress, 1010);
        socIn = new DataInputStream(socket.getInputStream()); //поток принятия данных
        socOut = new DataOutputStream(socket.getOutputStream()); //поток отсылки данных
    }

    public void sendToDevice(byte m) throws IOException{
        socOut.writeByte(m);
        socOut.flush();
    }

}
