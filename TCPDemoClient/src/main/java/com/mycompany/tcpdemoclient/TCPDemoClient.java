package com.mycompany.tcpdemoclient;
import java.util.Scanner;
public class TCPDemoClient {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Type your name");
            String name = in.nextLine();
            System.out.println("Type your last name");
            String lastName = in.nextLine();
            System.out.println("Name: "+ name +  " Last Name: " + lastName);
        }
        
    }
}
