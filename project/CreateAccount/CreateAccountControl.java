package project.CreateAccount;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import project.GameClient;
import project.Initial.InitialPanel;
import project.Login.LoginData;

public class CreateAccountControl implements ActionListener {
	private JPanel container;
	private GameClient client;

	public CreateAccountControl(JPanel container, GameClient client, JFrame frame) {
		this.container = container;
		this.client = client;
		frame.setTitle("Create Account Panel");
	}

	public void actionPerformed(ActionEvent ae) {
		// get the name of the button clicked
		String command = ae.getActionCommand();

		if (command.contentEquals("Cancel")) {
			InitialPanel initialPanel = (InitialPanel) container.getComponent(0);
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "4");
		} else if (command.contentEquals("Submit")) {
			CreateAccountPanel createAccountPanel = (CreateAccountPanel) container.getComponent(2);
			String username = createAccountPanel.getUsername();
			String password = createAccountPanel.getPassword();
			String verify = createAccountPanel.getVerify();
			if (!username.contentEquals(verify)) {
				createAccountPanel.setError("Passwords must match");
			} else {
				LoginData newData = new LoginData(username, password);

			}
		}
	}

}
