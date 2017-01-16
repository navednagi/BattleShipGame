package BattleShips;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class GUI 
{
	public static void main(String args[])
	{

		JFrame frame = new JFrame("Main Frame");	// original frame
		frame.setSize(600,600);
		//frame.setLayout(new BoxLayout(frame, 0));
		frame.setVisible(true);
		
		JPanel topPanel = new JPanel();
		frame.add(topPanel);
		
		JButton b = new JButton();
		b.setBackground(Color.RED);
		topPanel.add(b);
	}
}
