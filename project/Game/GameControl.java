package project.Game;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import project.GameClient;
import project.Login.LoginPanel;

public class GameControl implements ActionListener {
	private JPanel container;
	private GameClient client;
	private ArrayList<String> countries;
	private ArrayList<String> deck;
	private ArrayList<String> descriptions;
	private ArrayList<String> cardImages;

	// country click
	private JLabel leftPanelNameLabel;
	private JLabel leftPanelOwnedByLabel;
	private JLabel leftPanelTroopsLabel;
	private JLabel southPanelTitleLabel;
	private JLabel southPanelMsgLabel;

	// card click
	private JButton cardInfoButton;
	private JLabel cardTitle;
	private JLabel cardDescription;

	public GameControl(JPanel container, GameClient client, JFrame frame) {
		this.container = container;
		this.client = client;
		frame.setTitle("RISK Board");
		countries = client.getCountries();
		deck = client.getCardOptions();
		descriptions = client.getCardDescriptions();
		cardImages = client.getCardImages();
		System.out.println(descriptions);
	}

	public void actionPerformed(ActionEvent ae) {
		// get the name of the button clicked
		String command = ae.getActionCommand();
		System.out.println(command);
		if (command.contentEquals("Back")) {
			LoginPanel loginPanel = (LoginPanel) container.getComponent(1);
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "1");
		} else if (Character.isDigit(command.charAt(0))) {
			// need to instantiate labels so we can write to them
			GamePanel gp = (GamePanel) container.getComponent(3);
			cardInfoButton = gp.getCardInfoButton();
			cardTitle = gp.getCardTitle();
			cardDescription = gp.getCardDescription();

			System.out.println(cardDescription.getText());

			// find out which card was passed by number in top right of card
			int id = Integer.parseInt(command);

			// actually write to them
			cardInfoButton.setText(Integer.toString(id));
			File imageCheck = new File("resources/" + cardImages.get(id - 1));
			if (!imageCheck.exists()) {
				System.out.println("Image file not found!");
			}
			Image img = null;
			try {
				img = ImageIO.read(imageCheck);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			cardInfoButton.setIcon(new ImageIcon(img));

			cardTitle.setText(deck.get(id - 1));

			String descript = descriptions.get(id - 1);
			cardDescription.setText(descript);

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
