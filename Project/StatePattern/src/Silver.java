/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sameer Naumani
 */
class Silver implements States {
    Context myState;
    
    public Silver(Context aThis) {
        myState = aThis;
    }

    @Override
    public void nextState(double bal) {
        if(bal >10000){
            System.out.println("Changing State to Gold");
            myState.setStates(myState.getGold());
        }
        else 
            System.out.println("Put more money in your account");
        
    }

    @Override
    public void prevState(double bal) {
        System.out.println("Already at Root State");
     
    }
    
}
