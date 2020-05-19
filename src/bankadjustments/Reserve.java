package bankadjustments;

import java.time.LocalDateTime;
import java.util.Date;

class Reserve {
    
    private Window window;
    private Customer customer;
    private Date dateOfReservation;
    private Service service;
    private Employee employee;
    private String serialNumber;
    private static int counterA = 1;
    private static int counterB = 1;
    private static int counterC = 1;
    private static int counterD = 1;
    
    public Reserve()
    {
    
    }
    
    public Reserve(Window window,Service service,Customer customer) //Reserve class determines which window the client will go for according to his service
    {
        /*All data of the Reservation*/
        this.window = window;
        this.customer = customer;
        this.service = service;
        this.dateOfReservation = new Date();
        
        /*According to the window number it takes the last number in the queue and add it to the name of the window to determine its destination */
        
        if(window.getWindowNumber() == 1)
        {
            this.serialNumber = window.getWindowName() + Integer.toString(counterA);
            counterA++;
        }
        else if(window.getWindowNumber() == 2)
        {
            this.serialNumber = window.getWindowName() + Integer.toString(counterB);
            counterB++;
        }
        else if(window.getWindowNumber() == 3)
        {
            this.serialNumber = window.getWindowName() + Integer.toString(counterC);
            counterC++;
        }
        else if(window.getWindowNumber() == 4)
        {
            this.serialNumber = window.getWindowName() + Integer.toString(counterD);
            counterD++;
        }
            
    }
    
    public void setWindow(Window window)
    {
        this.window = window;
    }
    public Window getWindow()
    {
        return window;
    }
    public String getWindowName()
    {
        return window.getWindowName();
    }
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    public Customer getCustomer()
    {
        return customer;
    }
    public void setDateOfReservation(Date date)
    {
        dateOfReservation = date;
    }
    public String getDateofReservation()
    {
        return dateOfReservation.toString();
    }
    public void setService(Service service)
    {
        this.service = service;
    }
    public Service getService()
    {
        return service;
    }
    public String getServiceName()
    {
        return service.getServiceName();
    }
    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }
    public String getSerialNumber()
    {
        return serialNumber;
    }
    
       public void incrementStaticCounterA()
    {
        counterA++;
    }
    public void decrementStaticCounterA()
    {
        counterA--;
    }
    public void incrementStaticCounterB()
    {
        counterB++;
    }
    public void decrementStaticCounterB()
    {
        counterB--;
    }
    public void incrementStaticCounterC()
    {
        counterC++;
    }
    public void decrementStaticCounterC()
    {
        counterC--;
    }
    public void incrementStaticCounterD()
    {
        counterD++;
    }
    public void decrementStaticCounterD()
    {
        counterD--;
    }
    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
    public Employee getEmployee()
    {
        return this.employee;
    }
   
    
  
    public String toString()
    {
        return customer.getName() +" "+ serialNumber + " "+ window.getWindowName() + " " + window.getWindowNumber() + " " + service.getServiceName() + " " + service.getServiceNumber() + " " + dateOfReservation;
    }
    

}
   



