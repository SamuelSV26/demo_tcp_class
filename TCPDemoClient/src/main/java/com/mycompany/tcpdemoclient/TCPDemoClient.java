/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tcpdemoclient;

import java.util.Scanner;

/**
 *
 * @author santi
 */
public class TCPDemoClient {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Type your name");
        String name = in.nextLine();
        System.out.println("Type your last name");
        String lastName = in.nextLine();
        System.out.println("Name: "+ name +  " Last Name: " + lastName);
        
    }
}
