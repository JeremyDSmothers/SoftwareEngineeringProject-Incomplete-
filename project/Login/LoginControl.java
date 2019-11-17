package project.Login;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import project.GameClient;
import project.Game.GamePanel;
import project.Initial.InitialPanel;

public class LoginControl implements ActionListener {
	// private data field for storing the container
	private JPanel container;
	private GameClient client;

	// constructor for the login controller
	public LoginControl(JPanel container, GameClient client, JFrame frame) {
		this.container = container;
		this.client = client;
		frame.setTitle("Login Panel");
	}

	// Handle button clicks
	public void actionPerformed(ActionEvent ae) {
		// get the name of the button clicked
		String command = ae.getActionCommand();

		// The submit button gets the username and password entered and stores them in
		// variables

		// The cancel button sends the user back to the InitialPanel
		if (command.contentEquals("Cancel")) {
			InitialPanel initialPanel = (InitialPanel) container.getComponent(0);
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "1");
		} else if (command.contentEquals("Submit")) {
			LoginPanel loginPanel = (LoginPanel) container.getComponent(1);
			// String vars
			String username = loginPanel.getUsername();
			String password = loginPanel.getPassword();
			loginPanel.setError("");

			// handle submit here
			// need to get data back from DataBase file and check inputs to see if they're
			// in there

			// LoginData to check
//			LoginData loginData = new LoginData(username, password);

			GamePanel gamePanel = (GamePanel) container.getComponent(3);
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "4");

		}
	}
}
