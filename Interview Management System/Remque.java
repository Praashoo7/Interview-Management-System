import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.Toolkit;

public class Remque extends JFrame implements ActionListener
{
	JLabel l1;
	JTextField tf1;
	JButton btn1;
	
	public Remque() 
	{
		setContentPane(new JLabel(new ImageIcon("17.jpg")));
		setVisible(true);
		setSize(400, 300);
		setLayout(null);
		setLocationRelativeTo(null);
		
		setTitle("Remove QuePaper");
		setResizable(false);
		
		Font f = new Font("Caviar Dreams",Font.PLAIN,20);
		Font f1 = new Font("Caviar Dreams",Font.PLAIN,15);
		l1 = new JLabel("QuePaper No:");
		l1.setForeground(Color.white);
		l1.setFont(f);
		
		tf1 = new JTextField();
		
		btn1 = new JButton("Remove");
		btn1.setFont(f1);
		
		btn1.addActionListener(this);
		
		l1.setBounds(70, 90, 150, 30);
		
		tf1.setBounds(210, 90, 100, 30);
		
		btn1.setBounds(145, 155, 100, 30);
			
		add(l1);
		add(tf1);
		add(btn1);

	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn1)
		{
			String s1=tf1.getText();
			PreparedStatement ps=null;
			String query="delete from quedat where queno=?";
			try 
			{
				Class.forName("postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql:registration","postgres","");
				ps = con.prepareStatement(query);
				//int i=Integer.parseInt(s1);
				ps.setString(1,s1);				
				int y=ps.executeUpdate();
				if(y>0)
				{
							UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams", Font.PLAIN, 15));
	                        JOptionPane.showMessageDialog(btn1,"Deleted Succesfully","Remove QuePaper",JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
								UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams", Font.PLAIN, 15));
						JOptionPane.showMessageDialog(btn1,"Result Record not Found","Remove QuePaper",JOptionPane.PLAIN_MESSAGE);
				}
			}
			
			catch(Exception ex) 
			{
							UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams", Font.PLAIN, 15));
	                        JOptionPane.showMessageDialog(btn1,"Enter QuePaper No","Remove QuePaper",JOptionPane.PLAIN_MESSAGE);
				System.out.println(""+ex);
			}
		}
	}
	public static void main(String[] args) 
	{
		new Remque();
    }
}
