package bankadjustments;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BankQueueDataBase {
    
    private File file;
    
    public BankQueueDataBase()
    {
        
        
    }
    public void writeToFile(ArrayList<Reserve> reset) //Saves the data of reservation Object 
    {
        try{
            
       file = new File("Bank Queue DataBase.txt");
       BufferedWriter writeInFile = new BufferedWriter(new FileWriter(file));
       
       for(int i=0;i<reset.size();i++)
       {
           writeInFile.write(reset.get(i).toString() + System.lineSeparator());
       }
       writeInFile.close();
        }
        catch(IOException e)
        {
            System.out.println("Data is Not saved");
            e.printStackTrace();
        }
    }
    public void setFile(String fileName)
    {
        file = new File(fileName);
    }
    public File getFile()
    {
        return file;
    }
    public String getFileName(String name)
    {
        return file.getName();
    }   
    public double getFileSize()
    {
        return file.length();
    }
  
   
    

    
    
     

 
}
    
        
    

