package Main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainWindow implements ActionListener{
	private JPanel titlePanel;
	private JFrame window ;
	public MainWindow() 
	{
		initializeMain();
	}

	public void initializeMain()
	{
		window = new JFrame();
		window.setTitle("Main");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(1600,1000);
		window.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenuItem newMenuItem = new JMenuItem("New... ");
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newMenuItem.addActionListener(this);
		
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.add(exitMenuItem);
		
		menuBar.add(fileMenu);
		window.setJMenuBar(menuBar);
		
		// Main Panel
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		panel.setBackground(Color.gray);
		
		// Shop Button
		JButton button1 = new JButton("Shop");
		button1.setToolTipText("Access the shop!");
		button1.setMnemonic(KeyEvent.VK_S);
		button1.setPreferredSize(new Dimension(200,75));
		button1.setFont(new Font("Arial", Font.PLAIN, 16));
		button1.setMargin(new Insets(10,10,10,30));
		panel.add(button1);
		
		// Profile Button
		JButton button2 = new JButton("Profile");
		button2.setPreferredSize(new Dimension(200,75));
		button2.setToolTipText("Access your profile!");
		button2.setMnemonic(KeyEvent.VK_P);
		button2.setFont(new Font("Arial", Font.PLAIN, 16));
		button2.setMargin(new Insets(10,10,10,30));
		panel.add(button2);
		
		// Planner Button
		JButton button3 = new JButton("Planner");
		button3.setPreferredSize(new Dimension(200,75));
		button3.setToolTipText("See your planner!");
		button3.setMnemonic(KeyEvent.VK_L);
		button3.setFont(new Font("Arial", Font.PLAIN, 16));
		button3.setMargin(new Insets(10,10,10,30));
		button3.setBackground(Color.CYAN);
		panel.add(button3);
		
		// Jlabel is a display for a short text String
		titlePanel = new JPanel();
		titlePanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		titlePanel.setBackground(Color.DARK_GRAY);
		window.add(titlePanel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("Incentiplanner - \"Incentivize your planning\"");
		titlePanel.add(label);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sans-serif", Font.BOLD, 36));
		
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		panel.setPreferredSize(new Dimension(250, 250));
		window.add(panel, BorderLayout.WEST);
		
		window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		window.setVisible(true);
	}
	public void initializePlanner(){
		window = new JFrame();
		window.setTitle("Selection");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(1600,1000);
		window.setLocationRelativeTo(null);
		
		Font font = new Font("Arial", Font.BOLD, 16);
		Insets inset = new Insets(10,10,10,30);
		JPanel selector = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		Dimension dms = new Dimension(200, 75);
		
		JButton monthly = new JButton("Monthly");
		monthly.setPreferredSize(dms);
		monthly.setFont(font);
		monthly.setMargin(inset);
		monthly.addActionListener(e -> InitializeMonthly());

		JButton weekly = new JButton("Weekly");
		weekly.setPreferredSize(dms);
		weekly.setFont(font);
		weekly.setMargin(inset);
		weekly.addActionListener(e -> initializeWeekly());
		
		JButton daily = new JButton("Daily");
		daily.setPreferredSize(dms);
		daily.setFont(font);
		daily.setMargin(inset);
		daily.addActionListener(e -> initializeDaily());

		window.add(selector);
		selector.add(weekly);
		selector.add(daily);
		selector.add(monthly);
		selector.setVisible(true);
		window.setVisible(true);
	}
	public void InitializeMonthly(){
		JPanel panel = new JPanel(new GridLayout(6, 7, 5, 0));
		JPanel currentPanel = new JPanel();
		JButton backButton = new JButton("Menu");
		JPanel dayPanel = new JPanel();
		JLabel current = new JLabel();
		
		Font font = new Font("Arial", Font.BOLD, 16);
		Insets inset = new Insets(10,10,10,30);
		Dimension dms = new Dimension(200, 75);
		
		window.setVisible(false);
		window = new JFrame();
		window.setTitle("Monthly view");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(1600,1000);
		window.setLayout(new BorderLayout(30,30));
		window.setLocationRelativeTo(null);
		
		current.setFont(font);
		dayPanel.setLayout(new BorderLayout(10, 10));
		backButton.setToolTipText("Go back to the Menu");
		backButton.setMnemonic(KeyEvent.VK_M);
		backButton.setPreferredSize(dms);
		backButton.setFont(font);
		backButton.setMargin(inset);
		backButton.addActionListener(e -> initializeMain()); 
		
		dayPanel.add(backButton, BorderLayout.WEST);
		panel.add(new JLabel("Monday"));
		panel.add(new JLabel("Tuesday"));
		panel.add(new JLabel("Wednesday"));
		panel.add(new JLabel("Thursday"));
		panel.add(new JLabel("Friday"));
		panel.add(new JLabel("Saturday"));
		panel.add(new JLabel("Sunday"));

		for(int i = 8; i <= 42; i++)
		{
			JTextArea textField = new JTextArea("Text Box");
			textField.setFont(font);
			textField.setMargin(new Insets(2, 3, 2, 3));
			textField.addActionListener(e -> current.setText(textField.getText()));
			panel.add(textField);
		}
		
		currentPanel.add(current, BorderLayout.CENTER);
//		currentPanel.setPreferredSize(new Dimension(1000, 100));
		window.add(panel, BorderLayout.CENTER);
		window.add(currentPanel, BorderLayout.SOUTH);
		window.add(dayPanel, BorderLayout.NORTH);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		window.pack();
		window.setVisible(true);
		
	}
	public void initializeWeekly()
	{
		
	}
	public void initializeDaily()
	{
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() instanceof JMenuItem) {
			JMenuItem item = (JMenuItem) e.getSource();
			String text = item.getText();
			System.out.println(text);
		}
	}
}
