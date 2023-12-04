package Main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainWindow 
{
	private JFrame window ;
	public MainWindow()
	{
		initialize();
	}
	
	public void initialize()
	{
		
		
		window = new JFrame();
		window.setTitle("Main");
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setSize(800, 500);
		window.setLocationRelativeTo(null);
//		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		panel.setBackground(Color.gray);
		
		JButton button1 = new JButton("Shop");
		ImageIcon buttonIcon = new ImageIcon("button.png");
		button1.setIcon(buttonIcon);
		
		button1.setIconTextGap(10);
		button1.setToolTipText("Access the shop!");
		button1.setMnemonic(KeyEvent.VK_S);
		
		button1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		button1.setMargin(new Insets(10,10,10,30));
		
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("Hello World!");
			}
		});
		
		//button1.setEnabled(false);
		//button1.doClick();
		button1.setVerticalTextPosition(SwingConstants.BOTTOM);
		button1.setHorizontalAlignment(SwingConstants.CENTER);
		
		button1.setPreferredSize(new Dimension(200,75));
		panel.add(button1);
		
//		JButton button2 = new JButton("Profile");
//		panel.add(button2);
//		
//		JButton button3 = new JButton("Planner");
//		panel.add(button3);
		
		panel.setPreferredSize(new Dimension(250, 250));
		window.add(panel, BorderLayout.WEST);
		
//		JPanel panel = new JPanel(new GridLayout(5, 7, 5, 0));
//		
//		for(int i = 1; i <= 35; i++)
//		{
//			JButton button = new JButton("Button " + Integer.toString(i));
//			panel.add(button);
//			
//		}
//		window.add(panel);
		
		window.pack();
		window.setVisible(true);
	}

}
