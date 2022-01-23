import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class About extends JFrame implements ActionListener
{
	JLabel l,l1,l2,l3,l4,l5,l6,l7;
	public About() 
	{
		setContentPane(new JLabel(new ImageIcon("16.jpg")));
		setVisible(true);
		setSize(1120, 660);
		setLayout(null);
		setLocationRelativeTo(null);
		
		setTitle("AboutUs");
		setResizable(false);
		
		Font f = new Font("Caviar Dreams",Font.PLAIN,23);
		Font f1 = new Font("Caviar Dreams",Font.PLAIN,40);
		Font f2 = new Font("Caviar Dreams",Font.PLAIN,30);
		Font f3 = new Font("Caviar Dreams",Font.PLAIN,30);
		Font f4 = new Font("Caviar Dreams",Font.PLAIN,80);
		
		l = new JLabel("AboutUs");
		l.setFont(f4);
		l.setForeground(Color.white);
		l1 = new JLabel("Guidance by");
		l1.setForeground(Color.white);
		l1.setFont(f2);
		l2 = new JLabel("Mali Mam");
		l2.setFont(f1);
		l2.setForeground(Color.white);
		l3 = new JLabel("Developer");
		l3.setFont(f2);
		l3.setForeground(Color.white);
		l4 = new JLabel("Prashant Patil");
		l4.setFont(f);
		l4.setForeground(Color.white);
		l5 = new JLabel("E-Mail : rnttl90@gmail.com");
		l5.setFont(f);
		l5.setForeground(Color.white);
		
		l.setBounds(400, 79, 400, 100);
		l1.setBounds(460, 200, 400, 50);
		l2.setBounds(460, 240, 400, 50);
		l3.setBounds(475, 350, 400, 50);
		l4.setBounds(479, 390, 400,50);
		l5.setBounds(400, 425, 400,50);
		
		add(l);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
	}
	public void actionPerformed(ActionEvent e)
	{
		
	}
	public static void main(String args[])
	{
		new About();
	}
}
