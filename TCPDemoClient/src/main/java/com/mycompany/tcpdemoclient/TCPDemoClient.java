package com.mycompany.tcpdemoclient;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.tcpdemoclient.networklayer.TCPClient;
public class TCPDemoClient {

    public static void main(String[] args) {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream(new File("configuration.properties")));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TCPDemoClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TCPDemoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sslRout = p.getProperty("SSL_CERTIFICATE_ROUTE");
        String sslPassword = p.getProperty("SSL_PASSWORD");
        System.setProperty("javax.net.ssl.keyStore", sslRout);
        System.setProperty("javax.net.ssl.keyStorePassword", sslPassword);
        System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
        System.setProperty("javax.net.ssl.trustStore", sslRout);
        System.setProperty("javax.net.ssl.trustStorePassword", sslPassword);
        System.setProperty("javax.net.ssl.trustStoreType","PKCS12");

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
