/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sameer Naumani
 */
public class Test {
    public static void main(String[] args) {
        double bal;
        Context c1 = new Context();
        
        
       
        c1.Deposit(10000);
        c1.Deposit(1000);
        bal = c1.getBalance();
        
        System.err.println("" + bal);
        c1.nextState(bal);
        c1.nextState(bal);
        c1.Deposit(10000);
        bal = c1.getBalance();
        c1.nextState(bal);
       

        
    }
    
}
