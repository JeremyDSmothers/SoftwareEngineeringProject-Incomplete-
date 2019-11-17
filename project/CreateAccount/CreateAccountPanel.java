package project.CreateAccount;

import ocsf.server.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;

public class CreateAccountPanel extends JPanel {
	private JPasswordField passwordField;
	private JPasswordField verifyField;
	private JTextField usernameField;
	private JLabel errorLabel;
	
	public String getUsername() {
		return usernameField.getText();
	}
	
	public String getPassword() {
		return new String(passwordField.getPassword());
	}
	
	public String getVerify() {
		return new String(verifyField.getPassword());
	}
	
	public void setError(String error)
	{
		errorLabel.setText(error);
	}
	
	public CreateAccountPanel(CreateAccountControl cac) {
		// Create the controller and set it in the chat client.
	    //LoginControl controller = new LoginControl(container, client);
	    //client.setLoginControl(controller);
	        
	    // Create a panel for the labels at the top of the GUI.
	    JPanel labelPanel = new JPanel(new GridLayout(2, 1, 5, 5));
	    JLabel instructionLabel = new JLabel("Enter your username and password to create an account", SwingConstants.CENTER);
	    labelPanel.add(instructionLabel);

	    // Create a panel for the login information form.
	    JPanel loginPanel = new JPanel(new GridLayout(2, 2, 5, 5));
	    JLabel usernameLabel = new JLabel("Username:", SwingConstants.CENTER);
	    JLabel passwordLabel = new JLabel("Verify Password:", SwingConstants.CENTER);
	    usernameField = new JPasswordField(10);
	    loginPanel.add(usernameLabel);
	    
	    JLabel lblPassword = new JLabel("Password:", JLabel.CENTER);
	    loginPanel.add(lblPassword);
	    loginPanel.add(passwordLabel);
	    loginPanel.add(usernameField);

	    // Arrange the three panels in a grid.
	    JPanel grid = new JPanel(new GridLayout(4, 1, 0, 10));
	    grid.add(labelPanel);
	    
	    JLabel lblYourPasswordMust = new JLabel("Your password must be at least 6 characters.", JLabel.CENTER);
	    labelPanel.add(lblYourPasswordMust);
	    grid.add(loginPanel);
	    
	    passwordField = new JPasswordField();
	    loginPanel.add(passwordField);
	    passwordField.setColumns(10);
	    
	    verifyField = new JPasswordField();
	    loginPanel.add(verifyField);
	    verifyField.setColumns(10);
	    
	    // Create a panel for the buttons.
	    JPanel buttonPanel = new JPanel();
	    JButton submitButton = new JButton("Submit");
	    submitButton.addActionListener(cac);
	    JButton cancelButton = new JButton("Cancel");
	    cancelButton.addActionListener(cac);
	    buttonPanel.add(submitButton);
	    buttonPanel.add(cancelButton);
	    grid.add(buttonPanel);
	    
	    JPanel panel = new JPanel();
	    grid.add(panel);
	    
	    errorLabel = new JLabel("");
	    panel.add(errorLabel);
	    this.add(grid);
	}
	
}
