/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankadjustments;

class Employee {
    String employeeName ;
    int employeeID;
    Window window;
    
     Employee(int employeeID , String employeeName , Window window)
    {
        this.employeeID=employeeID;
        this.employeeName=employeeName;
        this.window=window;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    
    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    @Override
    public String toString() {
        return "Employee{" + "employeeName=" + employeeName + ", employeeID=" + employeeID + ", window=" + window + '}';
    }
    
    
   
}
