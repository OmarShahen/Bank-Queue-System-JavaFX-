/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankadjustments;

import java.io.IOException;
public interface MainOperation {
    
    
    public Reserve giveReset(String customerName,String serviceName) throws IOException;
    public Reserve giveReset(String customerName,int serviceNumber) throws IOException;
    
}
