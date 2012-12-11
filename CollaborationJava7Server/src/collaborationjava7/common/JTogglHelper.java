/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collaborationjava7.common;

import ch.simas.jtoggl.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author Cam
 */
public class JTogglHelper {
    String userName;
    String password;
    JToggl jToggl;
    ch.simas.jtoggl.User user;
    String fullName;
    boolean isLoggedIn = false;
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
    
    public JTogglHelper(String userName, String password){
        this.userName = userName;
        this.password = password;
        this.jToggl = new JToggl(userName, password);
        user = jToggl.getCurrentUser();
        fullName = user.getFullname();  
        isLoggedIn=true;
    }
    public String startNewTimeEntry(String description){
        this.description = description;
        //Calendar.getInstance().setTimeZone(TimeZone.getTimeZone("EST"));
        startTime = Calendar.getInstance().getTime();
        return DateFormat.getDateInstance().format(startTime);
    }
    public String endNewTimeEntry(){
        endTime = Calendar.getInstance().getTime();
        duration = (endTime.getTime() - startTime.getTime())/1000;
        billable = false;
        return sendTimeEntry();        
    }
    public String sendTimeEntry(){
        TimeEntry t = new TimeEntry();
        t.setStart(startTime);
        t.setStop(endTime);
        t.setBillable(billable);
        t.setCreated_with(CREATED_WITH);
        t.setDuration(duration);
        t.setDescription(description);
        String new2 =t.toJSONString();
        try{
            TimeEntry ret = jToggl.createTimeEntry(t);
            String re = ret.toJSONString();
            return String.format("Created new time entry: %s    Duration: %.2f",ret.getDescription(),getLastDurationInHours());
        }catch(Exception e){
            return "Failed to create new time entry.";
        }
    }
    
    public double getLastDurationInHours(){
        DecimalFormat twoPlaces = new DecimalFormat("#.##");
        return Double.valueOf(twoPlaces.format(this.duration/3600));
    }
    public ArrayList<String> getProjectNames(){
        List<ch.simas.jtoggl.Project> projs = jToggl.getProjects();
        ArrayList<String> retVal = new ArrayList<String>();
        for(ch.simas.jtoggl.Project p : projs){
            retVal.add(p.getName());
        }
        return retVal;
    }
    public ch.simas.jtoggl.Project getProjectByName(String name){
        List<ch.simas.jtoggl.Project> projs = jToggl.getProjects();
        for(ch.simas.jtoggl.Project p : projs){
            if(p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }
    public boolean selectProjectByName(String name){
        boolean flag = false;
        ch.simas.jtoggl.Project p = getProjectByName(name);
        if(p != null){
            project = p;
            flag = true;
        }
        return flag;
    }
    public String getFullName(){
        return this.fullName;
    }
    public boolean isLoggedIn(){
        return isLoggedIn;
    }
    public static void main(String[] args) throws InterruptedException{
        JTogglHelper jth = new JTogglHelper("user@mail.gvsu.edu", "pass");
        jth.startNewTimeEntry("test entry");
        Thread.sleep(10000);
        String response = jth.endNewTimeEntry();
        System.out.println(response);
    }
    
}
