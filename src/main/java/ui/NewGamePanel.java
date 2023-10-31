package ui;

import game.Languages;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class NewGamePanel extends JPanel {
	private UserInterface userInterface;

	private JLabel languageLabel;
	private JComboBox<String> languageBox;
	private JLabel player1NameLabel;
	private JLabel player2NameLabel;
	private JTextField player1NameField;
	private JTextField player2NameField;
	private JButton startButton;

	public NewGamePanel(UserInterface userInterface) {
		this.userInterface = userInterface;

		// Instantiate all the UI components
		languageLabel = new JLabel();
		languageBox = new JComboBox<String>(Languages.getAvailableLanguages());
		player1NameLabel = new JLabel();
		player2NameLabel = new JLabel();
		player1NameField = new JTextField();
		player2NameField = new JTextField();
		startButton = new JButton();

		// Make sure English is selected by default in the language selection box,
		// as that's the default language
		languageBox.setSelectedItem("English");

		// Attach event listeners to the language selection box and start game button
		languageBox.addActionListener((ActionEvent e) -> {
			this.userInterface.setLanguage((String) languageBox.getSelectedItem());
			updateLanguage();
		});

		startButton.addActionListener((ActionEvent e) -> {
			this.userInterface.startButtonPressed(player1NameField.getText(), player2NameField.getText());
		});

		// Set all the text from the current language (English by default)
		updateLanguage();

		// Set a margin inside the window
		setBorder(new javax.swing.border.EmptyBorder(40, 40, 40, 40));

		// Give the inputs some extra padding
		player1NameField.setMargin(new Insets(4, 6, 6, 6));
		player2NameField.setMargin(new Insets(4, 6, 6, 6));
		startButton.setMargin(new Insets(6, 14, 6, 14));

		var layout = new GridBagLayout();
		var constraints = new GridBagConstraints();

		layout.columnWeights = new double[] { 0.0, 1.0 };
		constraints.insets = new Insets(10, 10, 10, 10);

		setLayout(layout);

		// Add all the components with the right layout
		constraints.gridx = 0;
		constraints.anchor = GridBagConstraints.WEST;
		add(languageLabel, constraints);
		add(player1NameLabel, constraints);
		add(player2NameLabel, constraints);
		constraints.gridx = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.BOTH;
		add(languageBox, constraints);
		add(player1NameField, constraints);
		add(player2NameField, constraints);
		constraints.gridx = 0;
		constraints.gridwidth = 2;
		add(startButton, constraints);

	}

	private void updateLanguage() {
		var language = userInterface.getLanguage();

		languageLabel.setText(language.get("language"));
		player1NameLabel.setText(language.get("player1Name"));
		player2NameLabel.setText(language.get("player2Name"));
		startButton.setText(language.get("startGame"));
	}
}
