package project.Initial;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import project.GameClient;
import project.CreateAccount.CreateAccountPanel;
import project.Login.LoginPanel;

public class InitialControl implements ActionListener {
	// Private data field for storing the container.
	private JPanel container;
	private GameClient client;

	// Constructor for the initial controller.
	public InitialControl(JPanel container, GameClient client, JFrame frame) {
		this.container = container;
		this.client = client;
		frame.setTitle("Initial Panel");
	}

	// Handle button clicks.
	public void actionPerformed(ActionEvent ae) {
		// Get the name of the button clicked.
		String command = ae.getActionCommand();

		// The Login button takes the user to the login panel.
		if (command.equals("Login")) {
			LoginPanel loginPanel = (LoginPanel) container.getComponent(1);
			loginPanel.setError("");
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "2");

		}

		// The Create button takes the user to the create account panel.
		else if (command.equals("Create")) {
			// Handle CreatAccount Here
			CreateAccountPanel createAccountPanel = (CreateAccountPanel) container.getComponent(2);
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "3");
		}
	}
}
