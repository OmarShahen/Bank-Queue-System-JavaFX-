package bankadjustments;

import java.util.ArrayList;
public class Window {
    private int windowNumber;
    private Employee employee;
    private String windowName;
    private ArrayList<Service> services = new ArrayList<Service>();
    
    public Window(String windowName,int windowNumber)
    {
        this.windowName = windowName;
        this.windowNumber = windowNumber;
    }
  

    public void setWindowNumber(int windowNumber) {
        
        this.windowNumber = windowNumber;
    }
    
    public int getWindowNumber() {
        return windowNumber;
    }
    public void setWindowName(String name)
    {
        windowName = name;
    }
    public String getWindowName()
    {
        return windowName;
    }
  
       public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEemployee() {
        return employee;
    }

    
    public void addService(Service service)
    {
        services.add(service);
    }
    
    public void getAllServices()
    {
        for(int i=0;i<services.size();i++)
        {
            System.out.println(services.get(i));
        }
    }
    
   public Service getSpecificService(int choice)
   {
   
       for(int i=0;i<services.size();i++)
       {
           if(services.get(i).getServiceNumber() == choice)
           {
               return services.get(i);
           }
       }
       
       return null;
   }

    @Override
    public String toString() {
        return "Window{" + "windowNumber=" + windowNumber + ", employee=" + employee + ", windowName=" + windowName + ", services=" + services + '}';
    }
   
    
    
    
    

 

  
  
    
}
