/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7server;

import ch.simas.jtoggl.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Cam
 */
public class JTogglHelper {
    String userName;
    String password;
    JToggl jToggl;
    
    //---------------------------
    //required for new time entry
    final String CREATED_WITH = "Project Tracker";
    String description;
    Date startTime;
    long duration;
    boolean billable;
    //---------------------------
    
    ch.simas.jtoggl.Project project;    
    Date endTime;
    
    JTogglHelper(String userName, String password){
        this.userName = userName;
        this.password = password;
        this.jToggl = new JToggl(userName, password);
    }
    String startNewTimeEntry(String description){
        this.description = description;
        startTime = Calendar.getInstance().getTime();
        return DateFormat.getDateInstance().format(startTime);
    }
    String endNewTimeEntry(){
        endTime = Calendar.getInstance().getTime();
        duration = (endTime.getTime() - startTime.getTime())/1000;
        billable = false;
        return sendTimeEntry();        
    }
    String sendTimeEntry(){
        TimeEntry t = new TimeEntry();
        t.setStart(startTime);
        t.setStop(endTime);
        t.setBillable(billable);
        t.setCreated_with(CREATED_WITH);
        t.setDuration(duration);
        t.setDescription(description);
        try{
            return "Created new time entry: "+jToggl.createTimeEntry(t).toString();
        }catch(Exception e){
            return "Failed to create new time entry.";
        }
    }
    
    ArrayList<String> getProjectNames(){
        List<ch.simas.jtoggl.Project> projs = jToggl.getProjects();
        ArrayList<String> retVal = new ArrayList<>();
        for(ch.simas.jtoggl.Project p : projs){
            retVal.add(p.getName());
        }
        return retVal;
    }
    private ch.simas.jtoggl.Project getProjectByName(String name){
        List<ch.simas.jtoggl.Project> projs = jToggl.getProjects();
        for(ch.simas.jtoggl.Project p : projs){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }
    boolean selectProjectByName(String name){
        boolean flag = false;
        ch.simas.jtoggl.Project p = getProjectByName(name);
        if(p != null){
            project = p;
            flag = true;
        }
        return flag;
    }
    
    public static void main(String[] args) throws InterruptedException{
        JTogglHelper jth = new JTogglHelper("user@mail.gvsu.edu", "pass");
        jth.startNewTimeEntry("test entry");
        Thread.sleep(10000);
        String response = jth.endNewTimeEntry();
        System.out.println(response);
    }
    
}
