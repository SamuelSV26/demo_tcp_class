package com.mycompany.tcpdemoclient.networklayer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TCPClient {
    private String serverAddress;
    private int port;
    private SSLSocket clientSocket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public TCPClient(String serverAddress, int port) {
        this.serverAddress = serverAddress;
        this.port = port;
    }
    
    public void connect() throws IOException{
        // clientSocket = new SSLSocket(serverAddress, port);
        SSLSocketFactory  socketFactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
        clientSocket = (SSLSocket)socketFactory.createSocket(serverAddress, port);

        System.out.println("Connection established");
        inputStream = new DataInputStream(clientSocket.getInputStream());
        outputStream = new DataOutputStream(clientSocket.getOutputStream());
    }
    
    public String sendMesagge(String name, String lastName){
        String response = "Error";
        try{
            connect();
            StringBuilder sb = new StringBuilder();
            sb.append(name).append(":").append(lastName);
            String message = sb.toString();
            System.out.println("Sending: "+message);
            outputStream.writeUTF(message);
            response = inputStream.readUTF();
            System.out.println("Response: "+response);
        }catch(IOException e){
            System.out.println("Client error "+ e.getMessage());
        } finally{
            closeConnection();
        }
        return response;
    }
    
    public void closeConnection(){
        try{
            if(inputStream != null){
                inputStream.close();
            }
            if(outputStream != null){
                outputStream.close();
            }
            if(clientSocket != null){
                clientSocket.close();
            }
        }catch(IOException e){
            System.out.println("Error closing connection "+e.getMessage());
        }
        

    }
    
}
