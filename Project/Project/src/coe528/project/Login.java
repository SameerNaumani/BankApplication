/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import javafx.application.Application;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Sameer Naumani
 */
public class Login extends Application {
    
    public static String username;
    public static String password;
    String filepath = "C:\\Users\\Sameer Naumani\\Documents\\NetBeansProjects\\coe528\\Project\\Project\\accounts.txt"; 
    Button btn, btn2, btn3, btn4;
    public Stage window;
    Scene scene1, scene2, scene3;
    ComboBox<String> userType;
    Boolean Login;
    
    @Override   
    public void start(Stage primaryStage) {
        window = primaryStage;
        primaryStage.setTitle("Welcome");
        window.setMinWidth(502);
        
        //Import javafx grid pane class 
        //use a GridPane layout because it enables you to create a flexible grid of rows and columns in which to lay out controls. 
        //You can place controls in any cell in the grid, and you can make controls span cells as needed
        
        GridPane grid = new GridPane(); //creates gridPane object and assigns it to variable named grid
        grid.setAlignment(Pos.CENTER); //Alignment property sets the default position of the grid from top left of the scene to center.
        grid.setHgap(10); //Gap properties manage the spacing between the rows and the columsn
        grid.setVgap(10); //Vertical Gap
        grid.setPadding(new Insets (25,25,25,25));  //Insets are in order of top right bottom and left: 25 pixels of padding on each side. 
        //padding property manages the space around the edges of the grid pane
        
        Text scenetitle = new Text("Welcome"); //assigns welcome to variable scenetitle
        scenetitle.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0,2,1);//adds the scenetitle variable to the layout grid. scenetitle is added at column 0 and row 0.  Column span 2 row span 1.
        
        //Add username, password Labels and Textfields for them
        Label userName = new Label("Username:"); 
        Label pass = new Label("Password:");
        TextField usernameField = new TextField();
        PasswordField pwField = new PasswordField();
       
        grid.add(userName, 0, 1);//Label object called userName at column 0 and row 1
        grid.add(usernameField, 1, 1);//Textfield is added to gridpane at column 1 and row 1
        grid.add(pass, 0, 2); //column 0 and row 2
        grid.add(pwField, 1, 2); //column 1 and row 2
       
        //Add ComboBox (drop down menu)
        userType = new ComboBox<>();
        userType.getItems().addAll(
            "Manager",
            "Customer"
        );
        userType.setPromptText("User Type");
        grid.add(userType, 0,4);
        userType.setOnAction(e -> {
            if("Manager".equals(userType.getValue()))
            {
                usernameField.setText("admin");
                pwField.setText("admin");
            }
            else
            {
                System.out.println("Enter Credentials");
            }
        });
        
        //Button 1
        btn = new Button("Sign In");
        
        HBox hbBtn = new HBox(10);//creates HorizontalBox layout pane named HbBtn with spacing of 10 pixels
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);//Position the button on the bottom right
        hbBtn.getChildren().add(btn); //Button is added as a child of the HBox pane.
        grid.add(hbBtn, 1, 4); //the HBox pane is added to the grid in col 1 row 4
              
        //Handle Event. Lambda notation for Java 8
        btn.setOnAction(e -> 
        { 
            if("Manager".equals(userType.getValue()))
            {
                Manager.Add();
            }
            else 
            {
                boolean verif;
                verif = Verify.verifyLogin(usernameField.getText(), pwField.getText(),filepath);
                if(verif == true)
                {
                    Customer.UI();
                }
                else    
                    System.out.println("Please Enter the correct Credentials");
            }
        }); 

        //scene is created with grid at root node. Sets scene width and height to 300 by 275
        //As the window is resized, the nodes within the grid pane are resized according to their layout constraints. Will remain in the center
        //If scene dimensions are not provided then the default is the minimum size needed to discplay contents
        //Show the scene
        scene1 = new Scene(grid, 300, 275);
       
        window.setScene(scene1);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
        
    }
    
}

 /* btn.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent e){
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Sign in button pressed");
            } This can be replaced by lambda function e ->*/