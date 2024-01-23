package MainWindow;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainWindow extends JFrame implements ActionListener{
	private JPanel titlePanel;
	private int coins;
	private ImageIcon coinImg= new ImageIcon("/Incentiplanner/src/MainWindow/coin.png");
	public MainWindow(int coins) {
		this.coins = coins;
		this.setTitle("Main");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setPreferredSize(new Dimension(3200, 2000));
		this.setLocationRelativeTo(null);
		
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
		this.setJMenuBar(menuBar);
		
		// Main Panel
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		panel.setBackground(Color.gray);
		
		JPanel dayPanel = new JPanel();
		JLabel coinage = new JLabel("" + coins);
		coinage.setIcon(coinImg);
		dayPanel.add(coinage, BorderLayout.EAST);
		
		// Shop Button
		JButton button1 = new JButton("Shop");
		button1.setToolTipText("Access the shop!");
		button1.setMnemonic(KeyEvent.VK_S);
		button1.setPreferredSize(new Dimension(200,75));
		button1.setFont(new Font("Arial", Font.PLAIN, 16));
		button1.setMargin(new Insets(10,10,10,30));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				close();
				Shop shop = new Shop(coins);
			}
		});
		panel.add(button1);
		
		// Profile Button
		JButton button2 = new JButton("Profile");
		button2.setPreferredSize(new Dimension(200,75));
		button2.setToolTipText("Access your profile!");
		button2.setMnemonic(KeyEvent.VK_P);
		button2.setFont(new Font("Arial", Font.PLAIN, 16));
		button2.setMargin(new Insets(10,10,10,30));
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				close();
				Profile profile = new Profile(coins);
			}
		});
		panel.add(button2);
		
		// Planner Button
		JButton button3 = new JButton("Planner");
		button3.setPreferredSize(new Dimension(200,75));
		button3.setToolTipText("See your planner!");
		button3.setMnemonic(KeyEvent.VK_L);
		button3.setFont(new Font("Arial", Font.PLAIN, 16));
		button3.setMargin(new Insets(10,10,10,30));
		button3.setBackground(Color.CYAN);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				close();
				Planners planner = new Planners(coins);
			}
		});
		panel.add(button3);
		
		// Jlabel is a display for a short text String
		titlePanel = new JPanel();
		titlePanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		titlePanel.setBackground(Color.DARK_GRAY);
		this.add(titlePanel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("Incentiplanner - \"Incentivize your planning\"");
		titlePanel.add(label);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sans-serif", Font.BOLD, 36));
		
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		panel.setPreferredSize(new Dimension(250, 250));
		this.add(panel, BorderLayout.WEST);
		this.add(dayPanel, BorderLayout.NORTH);
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			JMenuItem item = (JMenuItem) e.getSource();
			String text = item.getText();
			System.out.println(text);
		}
	}
	
	public void close()
	{
		this.setVisible(false);
	}
}
