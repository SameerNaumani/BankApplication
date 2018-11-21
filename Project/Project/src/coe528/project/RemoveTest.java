/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Sameer Naumani
 */
public class RemoveTest {
    
    public static void removeRecord(String inputFileName, String lineToRemove) {
        // All the important information
        //String inputFileName = "accounts.txt";
        String outputFileName = "temp.txt";
        //String lineToRemove = "Nancy,Drew";
        // The traps any possible read/write exceptions which might occur
        try {
            File inputFile = new File(inputFileName);
            File outputFile = new File(outputFileName);
            // Open the reader/writer, this ensure that's encapsulated
            // in a try-with-resource block, automatically closing
            // the resources regardless of how the block exists
                try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                    // Read each line from the reader and compare it with
                    // with the line to remove and write if required
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        if (!line.equals(lineToRemove)) {
                        writer.write(line);
                        writer.newLine();
                        }
                    }
                }

            // This is some magic, because of the compounding try blocks
            // this section will only be called if the above try block
            // exited without throwing an exception, so we're now safe
            // to update the input file

            // If you want two files at the end of his process, don't do
            // this, this assumes you want to update and replace the 
            // original file

            // Delete the original file, you might consider renaming it
            // to some backup file
            if (inputFile.delete()) {
            // Rename the output file to the input file
                if (!outputFile.renameTo(inputFile)) {
                    throw new IOException("Could not rename " + outputFileName + " to " + inputFileName);
                }
            } 
            else {
                throw new IOException("Could not delete original input file " + inputFileName);
            }
        } catch (IOException ex) {
            // Handle any exceptions
            System.err.println("Error");
        }
    }
    
    
    /*public static void main(String[] args) throws IOException {
        String filepath = "accounts.txt";
        String removeTerm = "Sameer";
        
        removeRecord();
        //removeUser(filepath, removeTerm);
    }*/
    
    /*public static void removeUser(String filepath, String removeTerm){
        
        String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        String user = ""; 
        String pass = "";

        try{
                FileWriter fw = new FileWriter(tempFile, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
            
                y = new Scanner(new File(filepath));
                y.useDelimiter("[,\r]");
            
                while(y.hasNext()) {
                    user = y.next();
                    pass = y.next();
                    if(!user.equals(removeTerm))
                    {
                        pw.println(user + "," + pass); 
                    }
                }
                y.close();
                pw.flush();
                pw.close();
                oldFile.delete();
                File dump = new File(filepath);
                newFile.renameTo(dump);
             } 
        catch(Exception e)
        {    
            System.err.println("Error");   
        }
    }*/
}