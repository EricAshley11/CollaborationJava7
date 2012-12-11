/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import java.io.Serializable;



/**
 *
 */

public class Status implements Serializable {
    public enum States {

        INITIAL("Initial"),
        DEFINED("Defined"),
        IN_PROGRESS("In Progress"),
        IN_REVIEW("Being Reviewed"),
        REVIEWED("Reviewed"),
        COMPLETE("Complete");
        private final String displayString;

        States(String displayString) {
            this.displayString = displayString;
        }

        public String toString() {
            return displayString;
        }

        public States getNext() {
            if (this.ordinal() < States.values().length - 1) {
                return States.values()[this.ordinal() + 1];
            } else {
                System.err.println("Already at terminal state");
                return null; //TODO: Not sure if this is how we want to do this
            }
        }

        public boolean isComplete() {
            return this == States.COMPLETE;
        }
    }
    private boolean blocked;
    private States state;
    
    public Status() {
        this.blocked = false;
        this.state = States.INITIAL;
    }

    void setState(States state) {
        this.state = state;
    }
    void setState(String state){
        for(States s : States.values()){
            if(s.toString().equals(state)){
                this.state = s;
                break;
            }
        }
    }
    public Status nextState() {
        this.state = this.state.getNext();
        return this;
    }

    public boolean isComplete() {
        return this.state.isComplete();
    }

    public boolean isBlocked() {
        return this.blocked;
    }

    public boolean toggleBlocked() {
        this.blocked = !this.blocked;
        return isBlocked();
    }
    public States getState(){
        return this.state;
    }

    @Override
    public String toString(){
        return this.state.toString();
    }
}
