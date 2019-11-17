package project.Game;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CardPanel extends JPanel {
	private String imageResource;
	private String title;

	public CardPanel() {
		setLayout(null);

		imageResource = "calvaryUnit.JPG";
		title = "Calvary Unit";

		JLabel cardTitle = new JLabel(title, SwingConstants.CENTER);
		cardTitle.setVerticalAlignment(SwingConstants.CENTER);
		cardTitle.setBounds(10, 5, 75, 15);
		add(cardTitle);

		File imageCheck = new File("resources/" + imageResource);
		if (imageCheck.exists()) {
			System.out.println("Image file found!");
		} else {
			System.out.println("Image file not found!");
		}

		JButton cardImage = new JButton("");
		try {
			Image img = ImageIO.read(imageCheck);
			cardImage.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		cardImage.setBounds(10, 25, 80, 155);

		this.setPreferredSize(new Dimension(100, 175));
		add(cardImage);
	}

	public void setImage(String resource) {
		imageResource = resource;
	}

	public String getImageResource() {
		return imageResource;
	}

	public void setCardTitle(String title) {
		this.title = title;
	}

	public String getCardTitle() {
		return title;
	}
}
