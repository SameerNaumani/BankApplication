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
class Gold implements State {
    Customer myState;
    
    public Gold(Customer aThis) {
        myState = aThis;
    }

    @Override
    public void nextState(double bal) {
        if(bal >20000){
            System.out.println("Changing State to Platinum");
            myState.setStates(myState.getPlatinum());
        }
        else 
             System.out.println("Put more money in your account");
        
    }

    @Override
    public void prevState(double bal) {
        if(bal <10000){
               System.out.println("Changing State to Silver");
        myState.setStates(myState.getSilver());
        }
        else if(bal > 10000 && bal <20000)
            System.out.println("Stay in same state");
     
    }
}
    
