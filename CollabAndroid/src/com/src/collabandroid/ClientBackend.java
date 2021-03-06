package com.src.collabandroid;

import java.util.ArrayList;

import android.util.Log;
import collaborationjava7.common.*;

public class ClientBackend {
	private static Backend backend = null;
	private static String serverAddr = "35.40.127.176";
	private static String username = "";

	private static User currentUser = null;
	private static Project currentProj = null;

	public static Backend newBackend() {
		if (backend == null) {
			backend = new Backend(serverAddr);
		}
		return getBackend();
	}

	public static Backend getBackend() {
		return backend;
	}

	public static User getUser() {
		return currentUser;
	}

	public static User setUser(User u) {
		currentUser = u;
		return currentUser;
	}

	public static Project getProj() {
		return currentProj;
	}

	public static Project setProj(Project p) {
		currentProj = p;
		return currentProj;
	}

	public static String getName() {
		return username;
	}

	public static boolean validCredentials(String userName, String password) {
		boolean validCreds = false;
		User u = backend.loginUser(userName, password);
		Log.i("validateCredentials", "makeing user");
		if (u != null) {
			Log.i("validateCredentials", "User not null");
			validCreds = true;
			currentUser = u;
			username = userName;
			boolean done = false;
			while (!done) {
				try {
					Team team = currentUser.getTeam();
					Log.i("ClientBackend", "Got team");
					ArrayList<Project> projs = team.getProjects();
					System.out.println("Got proj");
					currentProj = projs.get(0);
					done = true;
				} catch (Exception e) {
					System.out.println("FAILED----------------------------");
					System.gc();
				}
			}
		}
		Log.i("validateCredentials", "End validate = " + validCreds);

		return validCreds;
	}

}
