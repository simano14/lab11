/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class BroadcastServer {

    public static final int PORT = 1200;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        MulticastSocket socket;
        DatagramPacket packet;
        InetAddress address;
        address = InetAddress.getByName("225.4.5.6");
        socket = new MulticastSocket();
// join a Multicast group and send the group salutations
        socket.joinGroup(address);
        byte[] data = null;
        for (;;) {
            Thread.sleep(1000);
            System.out.println("Sending ");
            String str = (new Date()).toString();
            data = str.getBytes();
            packet = new DatagramPacket(data, str.length(), address, PORT);
// Sends the packet
            socket.send(packet);
        }

    }
}
