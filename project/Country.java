package project;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JButton;

public class Country {
	private JButton btn;
	private String name;
	private int troops;
	private String description;
	private Rectangle bounds;
	private String owner;
	private Color color;

	public Country(JButton btn) {
		this.btn = btn;
		if (Math.random() > 0.5) {
			color = Color.red;
		} else {
			color = Color.green;
		}
		troops = 0;
		name = btn.getText();
		setTroopLabel();
		this.btn.setBackground(color);
	}

	public Country(JButton btn, String name) {
		this(btn);
		this.name = name;
	}

	public Country(JButton btn, String name, String desc) {
		this(btn, name);
		description = desc;
	}

	public void setBtnBounds(int left, int top, int right, int bottom) {
		bounds = new Rectangle(left, top, right, bottom);
		this.btn.setBounds(bounds);
	}

	public Rectangle getBtnBounds() {
		return this.btn.getBounds();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String desc) {
		description = desc;
	}

	public void setTroops(int troops) {
		this.troops = troops;
	}

	public String getName() {
		return name;
	}

	public int getTroops() {
		return troops;
	}

	public String getDescription() {
		return description;
	}

	public JButton getButton() {
		return btn;
	}

	private void setTroopLabel() {
		this.btn.setText("<html>" + name + "<br>" + troops + "<html>");

	}
}
