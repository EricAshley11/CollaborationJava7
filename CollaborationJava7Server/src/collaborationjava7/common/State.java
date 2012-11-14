/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import java.io.Serializable;

/**
 *
 */
public class State implements Serializable {

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

        public String getDisplayString() {
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
    
    public State() {
        this.blocked = false;
        this.state = States.INITIAL;
    }

    public State nextState() {
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

    public String getDisplayString() {
        return this.state.getDisplayString();
    }
}
