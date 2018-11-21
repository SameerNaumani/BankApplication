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
class Platinum implements State {
    Customer myState;
    public Platinum(Customer aThis) {
        myState = aThis;
    }

    @Override
    public void nextState(double bal) {
        System.out.println("Already reached Maximum Level ");
        myState.setStates(myState.getPlatinum());
    }

    @Override
    public void prevState(double bal) {
       if(bal <20000){
        System.out.println("Changing State to Gold");
        myState.setStates(myState.getGold());
        }
    }
    
}
