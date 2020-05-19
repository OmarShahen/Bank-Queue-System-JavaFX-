package bankadjustments;


class Customer {
    private String customerName;
    
    public Customer(String name)
    {
        this.customerName = name;
    }

    public String getName() {
        return customerName;
    }

    public void setName(String name) {
        this.customerName = name;
    }
    
}
