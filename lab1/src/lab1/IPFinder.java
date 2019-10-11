/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author harti
 */
import java.net.*;
import java.io.*;

public class IPFinder {
    public static void main(String[] args) throws IOException {
            String host;
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\n Enter host name:");
            host = input.readLine();
            try {
                InetAddress address = InetAddress.getByName(host);
                System.out.print("IP Address: " + address.toString());
            }
            catch (UnknownHostException e) {
                System.out.println("Could not find " + host);
            }
    }
    
}
