package project.Game;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.GameClient;
import project.Login.LoginPanel;

public class GameControl implements ActionListener {
	private JPanel container;
	private GameClient client;
	private ArrayList<String> countries;
	private JLabel leftPanelNameLabel;
	private JLabel leftPanelOwnedByLabel;
	private JLabel leftPanelTroopsLabel;
	private JLabel southPanelTitleLabel;
	private JLabel southPanelMsgLabel;

	public GameControl(JPanel container, GameClient client, JFrame frame) {
		this.container = container;
		this.client = client;
		frame.setTitle("RISK Board");
		countries = client.getCountries();
	}

	public void actionPerformed(ActionEvent ae) {
		// get the name of the button clicked
		String command = ae.getActionCommand();
		System.out.println(command);
		if (command.contentEquals("Back")) {
			LoginPanel loginPanel = (LoginPanel) container.getComponent(1);
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "1");
		} else {
			for (String country : countries) {
				if (command.contains(country)) {
					// need to instantiate labels so we can write to them
					GamePanel gamePanel = (GamePanel) container.getComponent(3);
					leftPanelNameLabel = gamePanel.getLeftPanelNameLabel();
					southPanelTitleLabel = gamePanel.getSouthPanelTitleLabel();
					southPanelMsgLabel = gamePanel.getSouthPanelMsgLabel();

					// actually write to them
					leftPanelNameLabel.setText(country);
					southPanelTitleLabel.setText(country);
					southPanelMsgLabel.setText("You just clicked on: " + country);
				}
			}
		}
	}
}
