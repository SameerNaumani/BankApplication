/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Sameer Naumani
 */
public class Verify {   
    private static Scanner x; 
    
    public Verify()
    {
    }
    
    public static boolean verifyLogin(String username, String password, String filepath) {
        boolean found = false;
        String tempUsername = "";
        String tempPassword = "";
        
        try
        {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\r]");
            
            while(x.hasNext() && !found)
            {
                tempUsername = x.next();
                tempPassword = x.next();
                
                //trim Returns a string whose value is this string, with any leading and trailing whitespace removed.
                if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim()))
                {
                    found = true;
                }
            }
            x.close(); //close the file
            System.out.println(found);
            
        }
        catch (Exception e)
        {
            System.out.println("Error");
            
        }
        if(found)
            return true;
        else
            return false;
        
    }
    
   /* public static void main(String[] args) {
        String username = "James";
        String password = "Franco";
        String filepath = "C:\\Users\\Sameer Naumani\\Documents\\NetBeansProjects\\coe528\\Project\\Project\\accounts.txt";  
        verifyLogin(username, password, filepath);
    }*/

    
}
