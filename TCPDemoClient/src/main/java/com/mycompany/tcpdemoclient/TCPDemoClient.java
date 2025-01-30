package com.mycompany.tcpdemoclient;
import java.util.Scanner;

import com.mycompany.tcpdemoclient.networklayer.TCPClient;
public class TCPDemoClient {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Type your name");
            String name = in.nextLine();
            System.out.println("Type your last name");
            String lastName = in.nextLine();
            TCPClient client =  new TCPClient("172.30.123.16", 9090);
            String response = client.sendMesagge(name, lastName);
            System.out.println(response);
        }
        
    }
}
