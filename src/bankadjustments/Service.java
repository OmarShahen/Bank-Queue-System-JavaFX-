package bankadjustments;


class Service {
    private String serviceName;
    private int serviceNumber;
    private Window window;
    
    
     Service (){
     
     }
     
    Service(int serviceNumber , String serviceName , Window window)
    {
        this.serviceName=serviceName;
        this.serviceNumber=serviceNumber;
        this.window=window;
        
    }

     public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
     
    public String getServiceName() {
        return serviceName;
    }


     public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }
     
    public int getServiceNumber() {
        return serviceNumber;
    }



    public void setWindow(Window window)
    {
        this.window = window; 
    }
    public Window getWindow() {
        return window;
    }
    
    
      public String toString()
    {
        return serviceName;
    }
    
}
