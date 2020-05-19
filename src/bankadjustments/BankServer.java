/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankadjustments;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
public class BankServer {
    
    private ServerSocket server;
    private Socket socket;
    private DataInputStream din;
    private String clientName;
    private int serviceNumber;
    private BankGUI gui;
    
    /*Creating a multithreaded server*/
    public BankServer(BankGUI gui)
    {
        
        this.gui = gui;
        
        try{
            
            server = new ServerSocket(7004);  // creates a server
            socket = server.accept();        // accepting clients
            din = new DataInputStream(socket.getInputStream());
            HandleAClient task = new HandleAClient(socket,this.gui); //creating a thread
            new Thread(task).start();
               
                
            
            
        }catch(IOException e)
        {
            System.out.println("Error Ocurred");
        }
        
    
    }
    
    public String getClientName()
        {
        
            return clientName;
        }
    public int getServiceNumber()
    {
        return serviceNumber;
    }
    
    
}
