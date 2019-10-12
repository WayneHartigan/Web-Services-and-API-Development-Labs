/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_part2;

/**
 *
 * @author harti
 */
import java.io.*;
import java.net.*;

public class TCPEchoServer {

    /**
     * @param args the command line arguments
     */
    
    private static ServerSocket servSock;
    private static final int PORT = 1234;
    
    public static void main(String[] args) {
        System.out.println("Opening port...\n");
        try{
            servSock = new ServerSocket(PORT);
        }
        catch(IOException e){
            System.out.println("Unable to attach to port!");
            System.exit(1);
        }
        
        do{
            run();
        }
        while (true);
    }
    
    private static void run(){
        Socket link = null;
        try{
            link = servSock.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(link.getInputStream()));
            PrintWriter out = new PrintWriter(link.getOutputStream(),true);
            
            int numMessages = 0;
            String message = in.readLine();
            while (!message.equals("***CLOSE***")){
                System.out.println("Message received: " + message);
                numMessages++;
                out.println("Message " + numMessages + ": " + message);
                message = in.readLine();
            }
            out.println("A Total of " + numMessages + " messages were received.");
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                System.out.println("\n* Closing connection... *");
                link.close();
            }
            catch(IOException e){
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }
    }
}