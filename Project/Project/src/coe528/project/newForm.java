/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;

import javafx.stage.Stage;

/**
 *
 * @author Sameer Naumani
 */
public class newForm {
    private static String name,pass;
    Stage window;
    static Button b1,b2,b3;
    static Scene scene;
    static Formatter x;
    static int n = 0;

   
    public static void form() {
        Stage window = new Stage();
        
        window.setTitle("customerForm");
        window.setMinWidth(502);
        
        GridPane grid =new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(10);
        grid.setVgap(10);
        //grid.setGridLinesVisible(true); 
        
        Label user = new Label("Username:"); 
        Label password = new Label("Password:");
        
        TextField usernameField = new TextField();
        TextField passwordField = new TextField();
       
        b1 = new Button ("Submit");
       
        GridPane.setConstraints(user, 0, 0);
        GridPane.setConstraints(usernameField, 1, 0);
        GridPane.setConstraints(password, 0, 1);
        GridPane.setConstraints(passwordField, 1, 1);
        GridPane.setConstraints(b1, 3, 3);
        
        grid.getChildren().addAll(user,usernameField,password,passwordField,b1);
        
        
        b1.setOnAction(e -> {
            try {
                openFile(usernameField, usernameField.getText(), passwordField, passwordField.getText());//Open file and add the parameters into the text file
            } catch (IOException ex) {
                Logger.getLogger(newForm.class.getName()).log(Level.SEVERE, null, ex);
            }
           
                });
        
        scene = new Scene(grid, 300, 275);
        window.setScene(scene);
        window.show();
    }
    
    public static void openFile(TextField input, String message, TextField pinput, String message2) throws IOException{ //this will add the parameters into the textfile
       
        name = input.getText();
        System.out.println("User is " + message);
        
        pass = pinput.getText();
        System.out.println("Pass is " + message2);
        
        File x = new File("accounts.txt");//create a new file
        FileWriter fwriter = null; 
        BufferedWriter writer = null;
        
        
        try {
        fwriter = new FileWriter(x, true);
        if(x.exists())
        {
            writer = new BufferedWriter(fwriter);
            writer.newLine();
            writer.write( message + "," + "");
            writer.write(message2 + "\n");
            //writer.newLine();
            writer.close();
            System.err.println("Your input of " + name.length() + " characters was saved.");
        }
        else 
                System.out.println("Error");
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }               
    }
    
 
    
}








 //bal = balance.getText();
        //System.out.println("Balance is " + message3);
        
       /* try{
            int balan = Integer.parseInt(message3);
            System.out.println("User Balance is:" + balan);
        }
        catch(NumberFormatException e){
            final Text action = new Text();
            GridPane.setConstraints(action, 3, 4);
            action.setText("Enter number for balance");
                
        }*/


 //Scanner userName = new Scanner(System.in);
        //String text = usernameField.nextLine();
        //Scanner passwd = new Scanner(System.in);
        //String text2 = passwd.nextLine();
 /*  public static String addRecords(){
        Scanner userName = new Scanner(name);
        String user = userName.nextLine();
        Scanner password = new Scanner(pass);
        String pss = password.nextLine();
        x.format("%s\n,%s", userName, password);
        
        return user;
        
    }
   */
//PrintWriter writer = new PrintWriter(file);
        //x = new Formatter("accounts.txt");