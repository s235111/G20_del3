package ui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GamePanel extends JPanel {
	private UserInterface userInterface;

	private JPanel playersPanel;
	private JPanel playerStatusPanel;
	private JPanel playerInfoPanel;
	private JPanel player1Panel;
	private JPanel player2Panel;
	private JLabel player1NameLabel;
	private JLabel player2NameLabel;
	private JLabel player1BalanceLabel;
	private JLabel player2BalanceLabel;
	private JLabel player1StatusLabel;
	private JLabel player2StatusLabel;
	private JLabel feedbackLabel;
	private JButton playTurnButton;

	public GamePanel(UserInterface userInterface) {
		this.userInterface = userInterface;
		var language = userInterface.getLanguage();

		// Instantiate all the UI components
		playersPanel = new JPanel(new GridBagLayout());
		playerStatusPanel = new JPanel(new GridLayout(1, 2, 40, 0));
		playerInfoPanel = new JPanel(new GridLayout(1, 2, 40, 0));
		player1Panel = new JPanel(new GridBagLayout());
		player2Panel = new JPanel(new GridBagLayout());
		player1NameLabel = new JLabel("", SwingConstants.CENTER);
		player2NameLabel = new JLabel("", SwingConstants.CENTER);
		player1BalanceLabel = new JLabel("", SwingConstants.CENTER);
		player2BalanceLabel = new JLabel("", SwingConstants.CENTER);
		player1StatusLabel = new JLabel(language.get("yourTurn"), SwingConstants.CENTER);
		player2StatusLabel = new JLabel(language.get("yourTurn"), SwingConstants.CENTER);
		feedbackLabel = new JLabel(language.get("startInfo"), SwingConstants.CENTER);
		playTurnButton = new JButton(language.get("playTurn"));

		// Attach an event listener to the play turn button
		playTurnButton.addActionListener((ActionEvent e) -> {
			this.userInterface.playTurnButtonPressed();
		});

		// Set a margin inside the window
		setBorder(new EmptyBorder(40, 40, 40, 40));
		// Put borders around the player info boxes
		player1Panel.setBorder(new EtchedBorder());
		player2Panel.setBorder(new EtchedBorder());
		// Give the play turn button some extra padding
		playTurnButton.setMargin(new Insets(6, 14, 6, 14));

		var layout = new GridBagLayout();
		var constraints = new GridBagConstraints();

		layout.rowWeights = new double[] { 0.5, 1.0, 0.5 };
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 1.0;
		constraints.gridx = 0;

		setLayout(layout);

		// Add all the components with the right layout
		// First add the player info to the player info boxes
		constraints.insets = new Insets(10, 40, 10, 40);
		player1Panel.add(player1NameLabel, constraints);
		player1Panel.add(player1BalanceLabel, constraints);
		player2Panel.add(player2NameLabel, constraints);
		player2Panel.add(player2BalanceLabel, constraints);

		// Then add the player stuff to the right panels for layouting
		playerStatusPanel.add(player1StatusLabel);
		playerStatusPanel.add(player2StatusLabel);
		playerInfoPanel.add(player1Panel);
		playerInfoPanel.add(player2Panel);
		constraints.insets = new Insets(0, 0, 10, 0);
		playersPanel.add(playerStatusPanel, constraints);
		constraints.insets.bottom = 0;
		playersPanel.add(playerInfoPanel, constraints);

		// Then add everything to the window
		constraints.insets = new Insets(10, 10, 10, 10);
		add(playersPanel, constraints);
		add(feedbackLabel, constraints);
		add(playTurnButton, constraints);
	}

	public void updatePlayerNames(String player1Name, String player2Name) {
		player1NameLabel.setText(player1Name);
		player2NameLabel.setText(player2Name);
	}

	public void updatePlayerBalances(int player1Balance, int player2Balance) {
		player1BalanceLabel.setText(Integer.toString(player1Balance));
		player2BalanceLabel.setText(Integer.toString(player2Balance));
	}

	public void updatePlayerTurn(boolean isPlayerTwo) {
		player1StatusLabel.setVisible(!isPlayerTwo);
		player2StatusLabel.setVisible(isPlayerTwo);
	}

	public void updateFeedback(String feedback) {
		feedbackLabel.setText(feedback);
	}

	public void gameOver(boolean isPlayerTwo) {
		var language = userInterface.getLanguage();
		playTurnButton.setEnabled(false);
		player1StatusLabel.setVisible(true);
		player2StatusLabel.setVisible(true);
		var winner = isPlayerTwo ? player2StatusLabel : player1StatusLabel;
		var loser = isPlayerTwo ? player1StatusLabel : player2StatusLabel;
		winner.setForeground(new Color(0.0f, 0.5f, 0.0f));
		loser.setForeground(new Color(0.5f, 0.0f, 0.0f));
		winner.setText(language.get("youWon"));
		loser.setText(language.get("youLost"));
	}
}
