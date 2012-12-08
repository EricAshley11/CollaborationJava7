package com.src.collabandroid;

import java.util.ArrayList;

import collaborationjava7.common.*;

import org.restlet.engine.Engine;
import org.restlet.engine.http.connector.*;

public class ClientBackend {
	private static Backend backend = null;
	private static String serverAddr = "192.168.10.105";
	private static User currentUser= null;
	private static Project currentProj = null;
	public static Backend getBackend(){
		if(backend == null){			
			backend = new Backend(serverAddr);
			Engine.getInstance().getRegisteredClients().clear();
			Engine.getInstance().getRegisteredClients().add(new HttpClientHelper(null)); 
			currentUser = backend.loginUser("cam", "abc");
			System.out.println("Got user: "+currentUser);
			currentProj = backend.retrieveProjects(currentUser).get(0);
		}
		return backend;
	}
	public static User getUser(){
		return currentUser;
	}
	public static User setUser(User u){
		currentUser = u;
		return currentUser;
	}
	public static Project getProj(){
		return currentProj;
	}
	public static Project setProj(Project p){
		currentProj = p;
		return currentProj;
	}
}
