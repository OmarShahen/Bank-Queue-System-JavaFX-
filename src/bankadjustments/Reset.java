package bankadjustments;


public class Reset{
    
    private String serialNumber;
    private Window window;
    private Employee employee;
    private Customer customer;
    private Service service; 
    
    public Reset(Reserve reserve) //Reset class is the class used in the tables to show the serial number of the customer
    {                            //It gets all data from the reserve object  
                                //This class was made because the tables was not able to read from reserve so we made reset to add to the table without any complexity
      
      this.serialNumber = reserve.getSerialNumber();
       this.window = reserve.getWindow();
       this.employee = reserve.getEmployee();
       this.customer = reserve.getCustomer();
       this.service = reserve.getService();
            
    }
    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }
    public String getSerialNumber()
    {
        return serialNumber;
    }
    public void setWindow(Window window)
    {
        this.window = window;
    }
    public Window getWindow()
    {
        return window;
    }
    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
    public Employee getEmployee()
    {
        return employee;
    }
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
    public Customer getCustomer()
    {
        return this.customer;
    }
    public void setService(Service service)
    {
        this.service = service;
    }
    public Service getService()
    {
        return this.service;
    } 
    
    public String toString()
    {
        return serialNumber;
    }
    
    
    
}