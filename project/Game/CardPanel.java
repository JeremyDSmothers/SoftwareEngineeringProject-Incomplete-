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
	private int cardNum;

	public CardPanel(GameControl gc) {
		setLayout(null);

		imageResource = "calvaryUnit.JPG";
		title = "Calvary Unit";
		cardNum = 1;

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

		JButton cardImage = null;
		Image img = null;
		try {
			img = ImageIO.read(imageCheck);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		cardImage = new JButton(Integer.toString(cardNum), new ImageIcon(img));
		cardImage.setHorizontalAlignment(SwingConstants.RIGHT);
		cardImage.setVerticalAlignment(SwingConstants.TOP);
		cardImage.setBounds(10, 25, 80, 150);
		cardImage.addActionListener(gc);
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
