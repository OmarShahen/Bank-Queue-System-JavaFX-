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

public class HandleAClient implements Runnable{
    
    private Socket socket;
    private BankGUI gui;
    private Customer customerName;
    private Reset reset;
    
    /* handle each client by creating threads*/
    
    public HandleAClient(Socket socket,BankGUI gui)
    {
        this.socket = socket;
        this.gui = gui;    
    }
    
    public void run()
    {
        try{
            
            DataInputStream din = new DataInputStream(socket.getInputStream());
            
            /*Takes data of reservation from client and adds it to the table of its window*/
            

                customerName = new Customer(din.readUTF());
                int serviceNumber = din.readInt();
                
                //gui.addReservation(customerName.getName(), serviceNumber);
                
                din.close();
               socket.close();
               
        
        
        }catch(IOException e)
        {
            System.out.println("Error occurred");
            e.printStackTrace();
        }
    }
    
    public Reset sendResetToGUI()
    {
        return reset;
    }
    
    
}
