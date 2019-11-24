package project;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import project.CreateAccount.CreateAccountControl;
import project.CreateAccount.CreateAccountPanel;
import project.Game.GameControl;
import project.Game.GamePanel;
import project.Initial.InitialControl;
import project.Initial.InitialPanel;
import project.Login.LoginControl;
import project.Login.LoginPanel;

public class ClientGUI extends JFrame {
	private GameClient client;
	private int height;
	private int width;
	private ArrayList<String> countries;

	// Constructor that creates the client GUI
	public ClientGUI() {
		this.setTitle("RISK (Client)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		client = new GameClient();
		try {
			client.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Create the card layout container
		CardLayout cardLayout = new CardLayout();
		JPanel container = new JPanel(cardLayout);

		// Create the Controllers next
		InitialControl ic = new InitialControl(container, client, this);
		LoginControl lc = new LoginControl(container, client, this);
		CreateAccountControl cac = new CreateAccountControl(container, client, this);
		GameControl gc = new GameControl(container, client, this);

		// Create the views. (need the controller to register with the Panels)
		JPanel view1 = new InitialPanel(ic);
		JPanel view2 = new LoginPanel(lc);
		JPanel view3 = new CreateAccountPanel(cac);
		JPanel view4 = new GamePanel(gc);

		// Add the views to the card layout container
		container.add(view1, "1");
		container.add(view2, "2");
		container.add(view3, "3");
		container.add(view4, "4");

		// Show the initial view in the card layout
		cardLayout.show(container, "1");

		// Add the card layout container to the JFrame
		this.add(container, BorderLayout.CENTER);

		// Show the JFrame
		setHeighthWidth();
		this.setSize(width, height);
		this.setVisible(true);
	}

	public void setHeighthWidth() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.height = (int) screenSize.getHeight();
		this.width = (int) screenSize.getWidth();
	}

	// Main function that creates the client GUI when the program is started
	public static void main(String[] args) {
		new ClientGUI();
	}
}
