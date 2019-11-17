package project.Login;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginData {
	private int id;
	private String username;
	private String password;

	public LoginData() {
		this.id = -1;
		this.username = "No Username";
		this.password = "No Password";
	}

	public LoginData(String username, String password) {
		this.id = (int) (Math.random() * 10000000);
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean checkInfo() {
		File file = new File("DatabaseFile.txt");
		ArrayList<String> lines = new ArrayList<String>();
		Scanner sc = null;
		String s = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (sc.hasNextLine()) {
			s = sc.nextLine();
			lines.add(s);
		}
		boolean valid = false;
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).split(",")[0].equals(username)) {
				if (lines.get(i).split(",")[2].equals(password)) {
					valid = true;
				}
			}
		}

		return valid;
	}

	public boolean accountExists(LoginData attempt) {
		File file = new File("DatabaseFile.txt");
		ArrayList<String> lines = new ArrayList<String>();
		Scanner sc = null;
		String s = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (sc.hasNextLine()) {
			s = sc.nextLine();
			lines.add(s);
		}
		boolean exists = false;
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).split(",")[0].equals(attempt.getUsername())) {
				exists = true;
			}
		}
		return exists;
	}

	public void addNewAccount(LoginData newData) {

	}
}
