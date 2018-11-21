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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;


/**
 *
 * @author Sameer Naumani
 */


public class Manager {
    //static String userName = "admin";
    //static String password = "admin";
    static Button b1, b2, b3, b4;
    Stage window, window2;
    static Scene scene;
    static Formatter x;
    private static Scanner y;
    //static String filepath = "C:\\Users\\Sameer Naumani\\Documents\\NetBeansProjects\\coe528\\Project\\Project\\accounts.txt";
    
    
    public static void Add() {
        Stage window = new Stage();
        
        window.setTitle("Manager");
        window.setMinWidth(250);
        
        GridPane grid =new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(10);
        grid.setVgap(10);
        //grid.setGridLinesVisible(true); 
        
        b1 = new Button ("Add User");
        b2 = new Button ("Remove User");
        b3 = new Button ("Logout");
        
        GridPane.setConstraints(b1, 0, 0);
        GridPane.setConstraints(b2, 1, 0);
        GridPane.setConstraints(b3, 1, 2);
        
        grid.getChildren().addAll(b1,b2,b3);
      
        //Actions
        b1.setOnAction( e-> newForm.form());
        b2.setOnAction( e -> removeUser());
        b3.setOnAction( e -> window.close() );
        
        
        
        scene = new Scene(grid, 300, 275);
        window.setScene(scene);
        window.show();
        
        
    }
    
    public static void removeUser(){
        String filepath = "C:\\Users\\Sameer Naumani\\Documents\\NetBeansProjects\\coe528\\Project\\Project\\accounts.txt";
        
        Stage window2 = new Stage();
        
        window2.setTitle("Remove");
        window2.setMinWidth(250);
        
        GridPane grid =new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10,10,10,10));
        grid.setHgap(10);
        grid.setVgap(10);
        
        Label user = new Label("Username:"); 
        TextField usernameField = new TextField();
        
        b4 = new Button("Submit");
        
        GridPane.setConstraints(user, 0, 0);
        GridPane.setConstraints(usernameField, 1, 0);
        GridPane.setConstraints(b4, 1, 2);
        
        grid.getChildren().addAll(user,usernameField,b4);
        
        b4.setOnAction( e -> {   //You can do the entire logic upon the button click
        RemoveTest.removeRecord(filepath, usernameField.getText());
        
        });
        
        scene = new Scene(grid, 300, 275);
        window2.setScene(scene);
        window2.show();
        
    }
      

    
  
    
}









        /*HBox layout = new HBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll (b1,b2,b3);*/
        //b2.setOnAction(this);
        //b3.setOnAction(value);
        