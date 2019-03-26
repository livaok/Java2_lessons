package lesson4;

import javax.swing.*;
import java.awt.*;

/**
 * @author liva
 */

public class BaseExampleFrame extends JFrame {

	JMenuBar   jMenuBar;
	JMenu      fileMenu;
	JMenu      helpMenu;
	JTextArea  jTextArea;
	JTextField textField;
	JPanel     panel;

	public BaseExampleFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(400, 400);

		createMenu();
		createContent();
		seElementPositions();

		setVisible(true);
	}

	private void seElementPositions() {
		getContentPane().add(jTextArea, BorderLayout.CENTER);
		getContentPane().add(jMenuBar, BorderLayout.NORTH);
		getContentPane().add(panel, BorderLayout.SOUTH);
	}

	private void createActionSend() {
		String text = jTextArea.getText().concat("\n");
		text = text.concat(textField.getText());
		jTextArea.setText(text);
		textField.setText("");
	}

	private void createContent() {
		panel = new JPanel();
		JLabel label = new JLabel("Enter your texy");
		textField = new JTextField(10);
		JButton sendButton = new JButton("Send");
		JButton resetButton = new JButton("Reset");

		jTextArea = new JTextArea();
		jTextArea.setEditable(false);

		sendButton.addActionListener(e -> {
			createActionSend();
		});

		resetButton.addActionListener(e -> textField.setText(""));

		textField.addActionListener(e -> {
			createActionSend();
		});

		panel.add(label);
		panel.add(textField);
		panel.add(sendButton);
		panel.add(resetButton);
	}

	private void createMenu() {

		jMenuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		helpMenu = new JMenu("Help");
		jMenuBar.add(fileMenu);
		jMenuBar.add(helpMenu);

		JMenuItem menuItemOpen = new JMenuItem("Open");
		JMenuItem menuItemClose = new JMenuItem("Close");

		fileMenu.add(menuItemOpen);
		fileMenu.add(menuItemClose);
	}
}
