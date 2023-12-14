package Main;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MainWindow implements ActionListener
{
	private JPanel titlePanel;
	private JFrame window ;
	public MainWindow() 
	{
		initializeLogin();
	}
	public void initializeLogin()
	{
//		File file = new File("/Incentiplanner/src/Objects/Untitled 1");  // created a file object called file
//		FileWriter fw = new FileWriter(file); // created a filewriter object called fw
//		PrintWriter pw = new PrintWriter(fw); // created a printwriter object called pw
//		
//		pw.println("Line 1");
//		pw.println("Line 2");
//		pw.println("Line 3");
//		
//		pw.close();
		
		window = new JFrame();
		window.setTitle("Login");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setLocationRelativeTo(null);
			
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		panel.setBackground(Color.gray);
		
		JPasswordField pwField = new JPasswordField();
		pwField.setPreferredSize(new Dimension(750,150));
		
		JButton mainButton = new JButton("Main");
		mainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setVisible(false);
				initializeMain();
			}
		});
		mainButton.setPreferredSize(new Dimension(750,150));
		mainButton.setBackground(Color.green);
		
		
		panel.add(pwField);
		panel.add(mainButton);

		window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		window.add(panel);
		window.setVisible(true);
	}
	public void initializeMain()
	{
		window = new JFrame();
		window.setTitle("Main");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(1600,1000);
		window.setLocationRelativeTo(null);
		
		Font f = new Font("sans-serif", Font.PLAIN, 18);
		UIManager.put("Menu.font", f);
		UIManager.put("MenuItem.font", f);
		UIManager.put("CheckBoxMenuItem.font", f);
		UIManager.put("RadioButtonMenuItem.font", f);
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenuItem newMenuItem = new JMenuItem("New... ");
//		ImageIcon notepad = new ImageIcon("Images/notebook.png");		
//		newMenuItem.setIcon(notepad);
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newMenuItem.addActionListener(this);
		
		JMenuItem saveMenuItem = new JMenuItem("Save");
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.add(exitMenuItem);
		
		fileMenu.add(new JRadioButtonMenuItem("RadioButton"));
		fileMenu.add(new JCheckBoxMenuItem("CheckBox"));
		fileMenu.add(new JMenu("Sub Menu"));
		fileMenu.addSeparator();
		
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
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("Hello World!");
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
			public void actionPerformed(ActionEvent e) {
				System.out.print("Hello World!");
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
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InitializeMonthly();
			}
		});
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
		
		//ImageIcon labelIcon = new ImageIcon("logo.png");
		//label.setIcon(labelIcon);
		//label.setIconTextGap(10);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		panel.setPreferredSize(new Dimension(250, 250));
		window.add(panel, BorderLayout.WEST);
		
		window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		window.setVisible(true);
	}
	
	public void InitializeMonthly()
	{
		
		JLabel current = new JLabel();
		current.setFont(new Font("Arial", Font.BOLD, 24));
		window.setVisible(false);
		window = new JFrame();
		window.setTitle("Monthly view");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(1600,1000);
		window.setLayout(new BorderLayout(30,30));
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
		
		fileMenu.add(new JRadioButtonMenuItem("RadioButton"));
		fileMenu.add(new JCheckBoxMenuItem("CheckBox"));
		fileMenu.add(new JMenu("Sub Menu"));
		fileMenu.addSeparator();
		
		menuBar.add(fileMenu);
		
		window.setJMenuBar(menuBar);
		
		JPanel panel = new JPanel(new GridLayout(5, 7, 5, 0));
		JPanel currentPanel = new JPanel();
		
		JPanel dayPanel = new JPanel();
		dayPanel.setLayout(new BorderLayout(10, 10));
		
		JButton backButton = new JButton("Menu");
		backButton.setToolTipText("Go back to the Menu");
		backButton.setMnemonic(KeyEvent.VK_M);
		backButton.setPreferredSize(new Dimension(200,75));
		backButton.setFont(new Font("Arial", Font.PLAIN, 16));
		backButton.setMargin(new Insets(10,10,10,30));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.setVisible(false);
				initializeMain();
			}
		});
		dayPanel.add(backButton, BorderLayout.WEST);
		
		for(int i = 1; i <= 35; i++)
		{
			
			JTextField textField = new JTextField("Text Box");
			textField.setFont(new Font("Arial", Font.BOLD, 24));
			textField.setForeground(Color.blue);
			textField.setBackground(Color.yellow);
			textField.setMargin(new Insets(2, 3, 2, 3));
			
			textField.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					current.setText(textField.getText());
				}
				
			});
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
	
	public void initiateWeekly()
	{
		String[] col;
		Object[][] data;
		
		window = new JFrame("JTable");
		col = new String[]{"Accounts","Amount"};
		data = getData();
		JTable jt = new JTable(data, col);
		JScrollPane js = new JScrollPane(jt);
		window.add(js);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
	}
	
	Object[][] getData()
	{
		try{
			String path = null; // set up path
			BufferedReader br = new BufferedReader(new FileReader(path + "/name.csv")); // just get the files
			ArrayList<String> list = new ArrayList();
			String str = "";
			while((str = br.readLine()) != null){
				list.add(str);
				System.out.println(str);
			}
			int n = list.get(0).split(",").length;
			Object[][] data = new Object[list.size()][n];
			
			for(int i = 0; i < list.size(); i++){
				data[i] = list.get(i).split(",");
			}
			br.close();
			return data;
			
		}catch(Exception x){
			x.printStackTrace();
			return null;
		}
	}
	public void initiateDaily()
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() instanceof JMenuItem) {
			JMenuItem item = (JMenuItem) e.getSource();
			String text = item.getText();
			System.out.println(text);
		}
	}

}
