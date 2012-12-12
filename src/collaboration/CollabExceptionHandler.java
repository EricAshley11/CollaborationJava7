/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaboration;

/**
 *
 * @author Cam
 */
public class CollabExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if(e.getMessage().contains("Communication Error")){
            mainView.communicationError();
        }
    }
    public void handle(Throwable thrown){
        thrown.printStackTrace();
    }
    
}
