package bankadjustments;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.*;
import java.io.*;
   
 
public class BankGUI extends Application {
    
    Label clientService,RunningService,A,B,C,D;
    
    Label clientName, serviceType;
    TextField clientNameField,sericeField;
    
    Label AserviceName,AserviceType2,AserviceSerialNumber;
    TextField AserviceNameField,AserviceType2Field,AserviceSerialNumberField;
    
    Label BserviceName,BserviceType2,BserviceSerialNumber;
    TextField BserviceNameField,BserviceType2Field,BserviceSerialNumberField;
    
    Label CserviceName,CserviceType2,CserviceSerialNumber;
    TextField CserviceNameField,CserviceType2Field,CserviceSerialNumberField;
    
    Label DserviceName,DserviceType2,DserviceSerialNumber;
    TextField DserviceNameField,DserviceType2Field,DserviceSerialNumberField;
    
    Button addQueue,Acomplete,Bcomplete,Ccomplete,Dcomplete;
    
    ChoiceBox serviceTypes;

    TableView table;
       
    GridPane ArunningServiceGrid,BrunningServiceGrid,CrunningServiceGrid,DrunningServiceGrid,clientGrid,ServicesGrid,tablesOrganizer;
    
    TableView<Reset> tableA;
    TableColumn columnA;
    TableColumn <Reset,String> serialNumberA;
    
    TableView<Reset> tableB;
    TableColumn columnB;
    TableColumn <Reset,String>serialNumberB;
    
    TableView<Reset> tableC;
    TableColumn columnC;
    TableColumn <Reset,String>serialNumberC;
    
    TableView<Reset> tableD;
    TableColumn columnD;
    TableColumn <Reset,String>serialNumberD;
    
    MainBank bank = new MainBank();
    
    
 
    @Override
    public void start(Stage primaryStage) throws IOException
    {
       
        /*using this methods techinique is for better viewing and debugging in all the GUI*/
        
        ClientService();
        WindowA();
        WindowB();
        WindowC();
        WindowD();
        
        table_A();
        table_B();
        table_C();
        table_D();
        tablesOrganizer();
        
        
        
        ServicesGrid = new GridPane();
        ServicesGrid.addRow(0,ArunningServiceGrid,BrunningServiceGrid);
        ServicesGrid.addRow(1,CrunningServiceGrid,DrunningServiceGrid);
        
        
        
        BorderPane organizer = new BorderPane();
        organizer.setLeft(clientGrid);
        organizer.setRight(ServicesGrid);
        organizer.setTop(tablesOrganizer);
        
        Scene scene = new Scene(organizer,2000,2000);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //BankServer server = new BankServer(this);
        //addReservation(server.getClientName(),server.getServiceNumber());
        
        
                 
    }
    
    
    
     public void WindowA() //creating window A elemrnts
     {
        A = new Label("A:"); 
        AserviceName = new Label("Name");
        AserviceNameField = new TextField();
        AserviceType2 = new Label("Type");
        AserviceType2Field = new TextField();
        AserviceSerialNumber = new Label("Serial");
        AserviceSerialNumberField = new TextField();
        Acomplete = new Button("Complete");
        Acomplete.setOnAction(e->removeClientFromWindow_A());
        
        ArunningServiceGrid = new GridPane();
        ArunningServiceGrid.addRow(0,A);
        ArunningServiceGrid.addRow(1,AserviceName,AserviceNameField);
        ArunningServiceGrid.addRow(2,AserviceType2,AserviceType2Field);
        ArunningServiceGrid.addRow(3,AserviceSerialNumber,AserviceSerialNumberField);
        ArunningServiceGrid.addRow(4,Acomplete);
   
        ArunningServiceGrid.setVgap(5);
        ArunningServiceGrid.setPadding(new Insets(10,100,0,0));
     }
     public void WindowB() //creating window B elemrnts
     {
        
        B = new Label("B:"); 
        BserviceName = new Label("Name");
        BserviceNameField = new TextField();
        BserviceType2 = new Label("Type");
        BserviceType2Field = new TextField();
        BserviceSerialNumber = new Label("Serial");
        BserviceSerialNumberField = new TextField();
        Bcomplete = new Button("Complete");
        Bcomplete.setOnAction(e->removeClientFromWindow_B());
        
        BrunningServiceGrid = new GridPane();
        BrunningServiceGrid.addRow(0,B);
        BrunningServiceGrid.addRow(1,BserviceName,BserviceNameField);
        BrunningServiceGrid.addRow(2,BserviceType2,BserviceType2Field);
        BrunningServiceGrid.addRow(3,BserviceSerialNumber,BserviceSerialNumberField);
        BrunningServiceGrid.addRow(4,Bcomplete);
        
        BrunningServiceGrid.setVgap(5);
        BrunningServiceGrid.setPadding(new Insets(10,100,0,0));
     
     }
     public void WindowC() //creating window C elemrnts
     {
        C = new Label("C:"); 
        CserviceName = new Label("Name");
        CserviceNameField = new TextField();
        CserviceType2 = new Label("Type");
        CserviceType2Field = new TextField();
        CserviceSerialNumber = new Label("Serial");
        CserviceSerialNumberField = new TextField();
        Ccomplete = new Button("Complete");
        Ccomplete.setOnAction(e->removeClientFromWindow_C());
        
        CrunningServiceGrid = new GridPane();
        CrunningServiceGrid.addRow(0,C);
        CrunningServiceGrid.addRow(1,CserviceName,CserviceNameField);
        CrunningServiceGrid.addRow(2,CserviceType2,CserviceType2Field);
        CrunningServiceGrid.addRow(3,CserviceSerialNumber,CserviceSerialNumberField);
        CrunningServiceGrid.addRow(4,Ccomplete);
        
        CrunningServiceGrid.setVgap(5);
        CrunningServiceGrid.setPadding(new Insets(20,100,0,0));
         
     }
      public void WindowD() //creating window D elemrnts
     {
        D = new Label("D:"); 
        DserviceName = new Label("Name");
        DserviceNameField = new TextField();
        DserviceType2 = new Label("Type");
        DserviceType2Field = new TextField();
        DserviceSerialNumber = new Label("Serial");
        DserviceSerialNumberField = new TextField();
        Dcomplete = new Button("Complete");
        Dcomplete.setOnAction(e->removeClientFromWindow_D());
        
        DrunningServiceGrid = new GridPane();
        DrunningServiceGrid.addRow(0,D);
        DrunningServiceGrid.addRow(1,DserviceName,DserviceNameField);
        DrunningServiceGrid.addRow(2,DserviceType2,DserviceType2Field);
        DrunningServiceGrid.addRow(3,DserviceSerialNumber,DserviceSerialNumberField);
        DrunningServiceGrid.addRow(4,Dcomplete);
        
        DrunningServiceGrid.setVgap(5);
        DrunningServiceGrid.setPadding(new Insets(20,100,0,0));
         
     }
      
     public void table_A() //tableA is for holding the queue for windowA services
     {
         columnA = new TableColumn("A");
         serialNumberA = new TableColumn<>("Serial Number");
         serialNumberA.setMinWidth(350);
         serialNumberA.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
         
        
         
         
         columnA.getColumns().addAll(serialNumberA);
         tableA = new TableView();
         tableA.getColumns().add(columnA);      
                     
     }
     
     public void table_B() //tableB is for holding the queue for windowB services
     {
         columnB = new TableColumn("B");
         serialNumberB = new TableColumn<>("Serial Number");
         serialNumberB.setMinWidth(350);
         serialNumberB.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
         
         
         
         columnB.getColumns().addAll(serialNumberB);
         tableB = new TableView();
         tableB.getColumns().add(columnB);
         
         
     }
     
     public void table_C() //tableC is for holding the queue for windowC services
     {
         columnC = new TableColumn("C");
         serialNumberC = new TableColumn<>("Serial Number");
         serialNumberC.setMinWidth(350);
         serialNumberC.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
         
         
         
         columnC.getColumns().addAll(serialNumberC);
         tableC = new TableView();
         tableC.getColumns().add(columnC);
         
         
     }
      public void table_D() //tableD is for holding the queue for windowD services
     {
         columnD = new TableColumn("D");
         serialNumberD = new TableColumn<>("Serial Number");
         serialNumberD.setMinWidth(350);
         serialNumberD.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
         
         
         
         columnD.getColumns().addAll(serialNumberD);
         tableD = new TableView();
         tableD.getColumns().add(columnD);
         
         
     }
     
   
     
     public void addReservation() throws IOException //gets the data from client service data fields
     {
        
          
         if(!checkInput()) //check if the input is valid and clean if not the input wont be accepted and no reservation will happen
         {
             clientNameField.setText("Invalid input");
             clientNameField.setStyle("-fx-text-inner-color: red");   
             clientNameField.setStyle("-fx-text-inner-color: black");
         }
         else
         {
             //reset object to put it in its window
        Reset reset = new Reset(bank.giveReset(clientNameField.getText(),serviceTypes.getValue().toString()));
        
           /*According to the window number determine its table*/   
           
        switch (reset.getWindow().getWindowNumber()) {
            case 1:
                tableA.getItems().addAll(reset);
                AserviceNameField.setText(tableA.getItems().get(0).getCustomer().getName());
                AserviceType2Field.setText(tableA.getItems().get(0).getService().getServiceName());
                AserviceSerialNumberField.setText(tableA.getItems().get(0).getSerialNumber());
                break;
            case 2:
                tableB.getItems().add(reset);
                BserviceNameField.setText(tableB.getItems().get(0).getCustomer().getName());
                BserviceType2Field.setText(tableB.getItems().get(0).getService().getServiceName());
                BserviceSerialNumberField.setText(tableB.getItems().get(0).getSerialNumber());
                break;
            case 3:                
                tableC.getItems().add(reset);
                CserviceNameField.setText(tableC.getItems().get(0).getCustomer().getName());
                CserviceType2Field.setText(tableC.getItems().get(0).getService().getServiceName());
                CserviceSerialNumberField.setText(tableC.getItems().get(0).getSerialNumber());
                break;
            case 4:
                tableD.getItems().add(reset);
                DserviceNameField.setText(tableD.getItems().get(0).getCustomer().getName());
                DserviceType2Field.setText(tableD.getItems().get(0).getService().getServiceName());
                DserviceSerialNumberField.setText(tableD.getItems().get(0).getSerialNumber());
                break;
                
            default:
                break;
        }
        
          clientNameField.clear(); //clear the fields after making reservation
         }
         
     }
     
     public void addReservation(String name,int serviceNumber) throws IOException // same as the addReservation method but for the online reservation(Network)
     {
         
         Reset reset = new Reset(bank.giveReset(name,serviceNumber));
         
         switch (reset.getWindow().getWindowNumber()) {
            case 1:
                tableA.getItems().addAll(reset);
                AserviceNameField.setText(tableA.getItems().get(0).getCustomer().getName());
                AserviceType2Field.setText(tableA.getItems().get(0).getService().getServiceName());
                AserviceSerialNumberField.setText(tableA.getItems().get(0).getSerialNumber());
                break;
            case 2:
                tableB.getItems().add(reset);
                BserviceNameField.setText(tableB.getItems().get(0).getCustomer().getName());
                BserviceType2Field.setText(tableB.getItems().get(0).getService().getServiceName());
                BserviceSerialNumberField.setText(tableB.getItems().get(0).getSerialNumber());
                break;
            case 3:                
                tableC.getItems().add(reset);
                CserviceNameField.setText(tableC.getItems().get(0).getCustomer().getName());
                CserviceType2Field.setText(tableC.getItems().get(0).getService().getServiceName());
                CserviceSerialNumberField.setText(tableC.getItems().get(0).getSerialNumber());
                break;
            case 4:
                tableD.getItems().add(reset);
                DserviceNameField.setText(tableD.getItems().get(0).getCustomer().getName());
                DserviceType2Field.setText(tableD.getItems().get(0).getService().getServiceName());
                DserviceSerialNumberField.setText(tableD.getItems().get(0).getSerialNumber());
                break;
            default:
                break;
        }
     
     }
     
     public void removeClientFromWindow_A() //removes client from the queue and the next one goes in in window A
     {       
         tableA.getItems().remove(0);
         
         if(tableA.getItems().size() == 0)
         {
             AserviceNameField.clear();
             AserviceType2Field.clear();
             AserviceSerialNumberField.clear();       
         }
         else
         {
             
         AserviceNameField.setText(tableA.getItems().get(0).getCustomer().getName());
         AserviceType2Field.setText(tableA.getItems().get(0).getService().getServiceName());
         AserviceSerialNumberField.setText(tableA.getItems().get(0).getSerialNumber()); 
             
         }
     }
     public void removeClientFromWindow_B() //removes client from the queue and the next one goes in in window B
     {   
         tableB.getItems().remove(0);
         
         if(tableB.getItems().size() == 0)
         {
             BserviceNameField.clear();
             BserviceType2Field.clear();
             BserviceSerialNumberField.clear();
          
         }
         else
         {
            BserviceNameField.setText(tableB.getItems().get(0).getCustomer().getName());
            BserviceType2Field.setText(tableB.getItems().get(0).getService().getServiceName());
            BserviceSerialNumberField.setText(tableB.getItems().get(0).getSerialNumber()); 
         }
     }
     public void removeClientFromWindow_C() //removes client from the queue and the next one goes in in window C
     {
         tableC.getItems().remove(0);
         
         if(tableC.getItems().size() == 0)
         {
             CserviceNameField.clear();
             CserviceType2Field.clear();
             CserviceSerialNumberField.clear();
          
         }
         else
         {
            CserviceNameField.setText(tableC.getItems().get(0).getCustomer().getName());
            CserviceType2Field.setText(tableC.getItems().get(0).getService().getServiceName());
            CserviceSerialNumberField.setText(tableC.getItems().get(0).getSerialNumber()); 
         }  
     }
       public void removeClientFromWindow_D() //removes client from the queue and the next one goes in in window D
     {
         tableD.getItems().remove(0);
         
         if(tableD.getItems().size() == 0)
         {
             DserviceNameField.clear();
             DserviceType2Field.clear();
             DserviceSerialNumberField.clear();
          
         }
         else
         {
            DserviceNameField.setText(tableD.getItems().get(0).getCustomer().getName());
            DserviceType2Field.setText(tableD.getItems().get(0).getService().getServiceName());
            DserviceSerialNumberField.setText(tableD.getItems().get(0).getSerialNumber()); 
         }  
     }    
     public void tablesOrganizer() //organizes the table
     {
         tablesOrganizer = new GridPane();
         tablesOrganizer.addRow(0,tableA,tableB,tableC,tableD);   
     }
      public void ClientService() // client reservation Area
      {
      
        clientGrid = new GridPane();
        clientService = new Label("Customer Service:");
        clientName = new Label("Name:");
        clientNameField = new TextField();
        serviceType = new Label("Service:");
        serviceTypes = new ChoiceBox(bank.addAllServices()); //all services in method addAllServices in bank class returns all services in the choice box which when any service is chosen it sends an object
        
        addQueue = new Button("Add Queue");
        addQueue.setOnAction(e->{   //after filling the required information make a reservation and a reset
            try {
                addReservation();
            } catch (IOException ex) {
                System.out.println("There was a problem");
            }
        });
        
        
        clientGrid.addRow(0,clientService);
        clientGrid.addRow(1,clientName,clientNameField);
        clientGrid.addRow(2,serviceType,serviceTypes);
        clientGrid.addRow(3,addQueue);
        
        clientGrid.setHgap(20);
        clientGrid.setVgap(20);
        clientGrid.setPadding(new Insets(10,10,10,10));
      }
      public boolean checkInput() // check input validity
      {
          String errors = "0123456789!#@$%^&*()_-+=/*|[]{};:/<>.,";
          for(int i=0;i<clientNameField.getText().length();i++)
          {
              for(int j=0;j<errors.length();j++)
              {
                  if(errors.charAt(j) == clientNameField.getText().charAt(i))
                  {      
                      return false;
                  }
                  
              }
              
          }
          if("Invalid input".equals(clientNameField.getText()))
          {
              return false;
          }
          
          return true;
      }

    public static void main(String[] args) {
        launch(args);
    }
    
   
            
    }
