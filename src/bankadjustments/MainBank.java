package bankadjustments;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
public class MainBank implements MainOperation{
   
    
   //List of services of the Choice Box
   private ObservableList<Service> allServices = FXCollections.observableArrayList();  
   
   
   private ArrayList<Reserve> allResets = new ArrayList<>();
   private ArrayList<Reserve> resets = new ArrayList<>();
    
    //creating windows
    private Window windowA = new Window("A",1);
    private Window windowB = new Window("B",2);
    private Window windowC = new Window("C",3);
    private Window windowD = new Window("D",4);

    // creating services objects
    private Service service1 = new Service(1,"Advancing of Loans",windowA);
    private Service service2 = new Service(2,"overdraft",windowA);
    private Service service3 = new Service(3,"Discounting of bills of exchange",windowA);
    private Service service4 = new Service(4,"check payment",windowA);
    private Service service5 = new Service(5,"collection and payment of credit Instrument",windowA);
    private Service service6 = new Service(6,"Forien curency Exchange",windowB);
    private Service service7 = new Service(7,"Counstancy",windowB);
    private Service service8 = new Service(8,"Bank Guaratee",windowB);
    private Service service9 = new Service(9,"Renittance of funds",windowB);
    private Service service10 = new Service(10,"Credit Cards",windowC);
    private Service service11 = new Service(11,"ATMs Services",windowC);
    private Service service12 = new Service(12,"Debit Cards",windowC);
    private Service service13 = new Service(13,"Home banking",windowC);
    private Service service14 = new Service(14,"Online banking",windowD);
    private Service service15 = new Service(15,"Mobile banking",windowD);
    private Service service16 = new Service(16,"Accepting Deposit",windowD);
    private Service service17 = new Service(17,"Priority banking",windowD);
    private Service service18 = new Service(18,"Privet banking",windowD);
    
    private Employee employee1 = new Employee(1,"MOHAMED",windowA);
    private Employee employee2 = new Employee(2,"AHMED",windowB);
    private Employee employee3 = new Employee(3,"ABDELHAMED",windowC);
    private Employee employee4 = new Employee(4,"OMAR",windowD);
    
    private Reserve reset;
    
    private BankQueueDataBase dataBase;
    /*Main bank class is the class where all classes are connected to it and all opertaions are done in it and 
      the output goes to the GUI tables*/
    public MainBank()
    {

        
        addServicesToWindows();
        addEmployeesToWindows();
        addAllServices();
        
        dataBase = new BankQueueDataBase(); // to save data of clients in files
        
    
    }
    
    
    private void addServicesToWindows() // add each service to its Window
    {
        windowA.addService(service1);
        windowA.addService(service2);
        windowA.addService(service3);
        windowA.addService(service4);
        windowA.addService(service5);
        windowB.addService(service6);
        windowB.addService(service7);
        windowB.addService(service8);
        windowB.addService(service9);
        windowC.addService(service10);
        windowC.addService(service11);
        windowC.addService(service12);
        windowC.addService(service13);
        windowD.addService(service14);
        windowD.addService(service15);
        windowD.addService(service16);
        windowD.addService(service17);
        windowD.addService(service18);
    
    }
    private void addEmployeesToWindows() //add each employee to its window
    {
         
        windowA.setEmployee(employee1);
        windowB.setEmployee(employee2);
        windowC.setEmployee(employee3);
        windowD.setEmployee(employee4);
        
    }
    public ObservableList<Service> addAllServices() //adding services to a list to put it in the choice Box
    {
        allServices.add(service1);
        allServices.add(service2);
        allServices.add(service3);
        allServices.add(service4);
        allServices.add(service5);
        allServices.add(service6);
        allServices.add(service7);
        allServices.add(service8);
        allServices.add(service9);
        allServices.add(service10);
        allServices.add(service11);
        allServices.add(service12);
        allServices.add(service13);
        allServices.add(service14);
        allServices.add(service15);
        allServices.add(service16);
        allServices.add(service17);
        allServices.add(service18);
        
        return allServices;
    
    }
   
    public Reserve giveReset(String name,String serviceName) throws IOException //Makes a reservation and decide which window the customer will go according to the service
    {                                                                           //This is for getting clients from the GUI
        
        int serviceNumber = formattedServiceNumber(serviceName); //determine the service number of the service from its name
        
        if(serviceNumber <= 5) //if service number between 1 to 5 then go to window A
        {
            reset = new Reserve(windowA,windowA.getSpecificService(serviceNumber),new Customer(name));
            allResets.add(reset); 
            resets.add(reset);
            dataBase.writeToFile(resets);
            return reset;
    
        }
        else if(serviceNumber <=9) //if service number between 6 to 9 then go to window B
        {
            reset = new Reserve(windowB,windowB.getSpecificService(serviceNumber),new Customer(name));
            allResets.add(reset); 
            resets.add(reset);
            dataBase.writeToFile(resets);
            return reset;
        }
        else if(serviceNumber <= 13) //if service number between 10 to 13 then go to window C
        {
            reset = new Reserve(windowC,windowC.getSpecificService(serviceNumber),new Customer(name));
            allResets.add(reset);   
            resets.add(reset);
            dataBase.writeToFile(resets);
            return reset;
        }
        else //if service number between 14 to 18 then go to window D
        {
            reset = new Reserve(windowD,windowD.getSpecificService(serviceNumber),new Customer(name));
            allResets.add(reset);
            resets.add(reset);
            dataBase.writeToFile(resets);
            return reset;
        }
    
    }
    
     public Reserve giveReset(String name,int serviceNumber) throws IOException//Same as giveReset() method above but for taking clients online(Network)
                                                                                //OverLoading
     {
        
        if(serviceNumber <= 5)
        {
            reset = new Reserve(windowA,windowA.getSpecificService(serviceNumber),new Customer(name));
            allResets.add(reset); 
            resets.add(reset);   
            dataBase.writeToFile(resets);
            return reset;
    
        }
        else if(serviceNumber <=9)
        {
            reset = new Reserve(windowB,windowB.getSpecificService(serviceNumber),new Customer(name));
            allResets.add(reset); 
            resets.add(reset);
            dataBase.writeToFile(resets);
            return reset;
        }
        else if(serviceNumber <= 13)
        {
            reset = new Reserve(windowC,windowC.getSpecificService(serviceNumber),new Customer(name));
            allResets.add(reset);   
            resets.add(reset);
            dataBase.writeToFile(resets);
            return reset;
        }
        else
        {
            reset = new Reserve(windowD,windowD.getSpecificService(serviceNumber),new Customer(name));
            allResets.add(reset);
            resets.add(reset);
            dataBase.writeToFile(resets);
            return reset;
        }
    
    }                                                                       
    
    
    public int formattedServiceNumber(String serviceName) //takes service name and gives its service number
    {
        for(int i=0;i<allServices.size();i++)
        {
            if(allServices.get(i).getServiceName().equals(serviceName))
            {
                 return allServices.get(i).getServiceNumber();
            }
            
        }
        return 0;
    }

    }
        

