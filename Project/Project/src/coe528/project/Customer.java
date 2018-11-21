/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author Sameer Naumani
 */

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


//Context
public class Customer {
    static State Silver;
    static State Gold;
    static State Platinum;
    static State myState;
    
    private String username;
    private String password;
    public static Button b1,b2,b3,b4,b5;
    public static Scene scene3;
    public static Stage window;
    
    public static double balance = 100;
   
    public Customer(){
        Silver = new Silver(this);
        Gold = new Gold(this);
        Platinum = new Platinum(this);
        myState = Silver;
    }
   
    //State Pattern
    public void setStates(State newStates){ //setter
        myState = newStates;
    } 
    public void nextState(double bal){ //depending on the balance change state
        balance = bal;
        myState.nextState(bal);
    }
    public void prevState(double bal){
        balance = bal;
        myState.prevState(bal);
    }
    
    public State getSilver(){ //getters
        return Silver;
    }
    public State getGold(){
        return Gold;
    }
    public State getPlatinum(){
        return Platinum; 
    } 
    
    //Deposit
    public static void Deposit(double amount){
        balance += amount;
    }
    
    //Withdraw
    public static void Withdraw(double amount){
        balance = balance - amount;
    }
    
    //Online Purchase
    public static void onlinePurchase(double amount){
        if(amount > 49){
            if(balance < 10000)
            {
                balance = balance - 20 - amount;
                System.out.println("You are a silver Customer a fee of $20 is charged");
            }
            else if(balance > 10000 && balance < 20000)
            {
                balance = balance - 10 -amount;
                System.out.println("You are a Gold Customer a fee of $10 is charged");
            }
            else if(balance > 20000)
            {
                balance = balance - amount;
                System.out.println("You are a Platinum Customer no fee is charged");
            } 
        }
            
    }
    
    //GetBalance
    public static double getBalance(){
        return balance;
    }
    
    public static void UI(){
        window = new Stage();
        window.setTitle("Customer");
        window.setMinWidth(250);
        
        GridPane grid =new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(10);
        grid.setVgap(10);
        
       
        TextField withdraw = new TextField();
        TextField deposit = new TextField();
        TextField online = new TextField();
        
        
        b1 = new Button ("Refresh Balance");
        b2 = new Button ("Withdraw");
        b3 = new Button ("Deposit");
        b4 = new Button ("Online Purchase");
        b5 = new Button ("Upgrade");
        
        GridPane.setConstraints(b1, 0, 0);
        GridPane.setConstraints(withdraw, 1, 1);
        GridPane.setConstraints(b2, 0, 1);
        GridPane.setConstraints(deposit, 1,2 );
        GridPane.setConstraints(b3, 0, 2);
        GridPane.setConstraints(b4, 0, 3);
        GridPane.setConstraints(online, 1,3 );
        GridPane.setConstraints(b5, 0,4 );
        
        grid.getChildren().addAll(b1,b2,b3,b4,b5,withdraw,deposit,online);
        
        //Get Balance
        b1.setOnAction( e -> {
            System.out.println(getBalance());
            
        });
        
        //Withdraw Money
        b2.setOnAction( e -> {
            double n = Integer.parseInt(withdraw.getText()); //Convert String to double
            Withdraw(n);
            System.out.println("Successfully withdew: $" + n );
            getBalance();
        });
        
        //Deposit Money
        b3.setOnAction(e -> {
            double n = Integer.parseInt(deposit.getText()); 
            Deposit(n);
            System.out.println("Successfully deposited: $" + n);
            getBalance();
                });
        
        //Online Purchase 
        b4.setOnAction(e -> {
            double n = Integer.parseInt(online.getText());
            onlinePurchase(n);
            System.out.println("Successfully conducted Online Purchase of: $" + n);
            getBalance();
                });
        Customer c1 = new Customer();
        
        b5.setOnAction( e -> {
            
            c1.nextState(getBalance());
            
        });

        scene3 = new Scene(grid, 300, 275);
        window.setScene(scene3);
        window.show();
  
    }
}
  

