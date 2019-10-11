/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.net.*;

public class IPAddrDemo {
    public static void main(String args[]){
        System.out.println ("Looking up the IP address of the local host");
        try {
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("IP address of this machine: " + localAddress.getHostName());
        }
        catch (UnknownHostException uhe) {
            System.out.println("Error - unable to resolve localhost");
        }
    }
}
