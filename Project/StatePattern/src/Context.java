/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sameer Naumani
 */
public class Context {
    States Silver;
    States Gold;
    States Platinum;
    States myState;
    public double balance = 100;
    
    public Context(){
        Silver = new Silver(this);
        Gold = new Gold(this);
        Platinum = new Platinum(this);
        
        myState = Silver;
    }
    
    public void setStates(States newStates){
        myState = newStates;
    }
    
    public void nextState(double bal){
        balance = bal;
        myState.nextState(bal);
    }
    public void prevState(double bal){
        balance = bal;
        myState.prevState(bal);
        
    }
    
    public States getSilver(){ 
        return Silver;
    }
    public States getGold(){
        return Gold;
    }
    public States getPlatinum(){
        return Platinum; 
    }
    
    //Deposit
    public void Deposit(double amount){
        balance += amount;
    }
    
    //Withdraw
    public void Withdraw(double amount){
        balance = balance - amount;
    }
    
    public void onlinePurchase(double amount){
        if(amount > 49){
            if(balance < 10000)
            {
                balance = balance - 20 - amount;
            }
            else if(balance > 10000 && balance < 20000)
            {
                balance = balance - 10 -amount;
            }
            else if(balance > 20000)
            {
                balance = balance - amount;
            } 
        }
            
    }
    
    //GetBalance
    public  double getBalance(){
        return balance;
    }
    
}
