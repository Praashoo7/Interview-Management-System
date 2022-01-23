import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Registration extends JFrame implements ActionListener
{
	JLabel l1, l2, l3, l4 ,l5, l6;
	JTextField tf1, tf6 , tf7;
	JButton btn1, btn2;	
	JPasswordField p1, p2;

	Registration()
	{
		setContentPane(new JLabel(new ImageIcon("14.jpg")));
		setVisible(true);
		setSize(1120, 660);
		setLayout(null);
		setLocationRelativeTo(null);
		
		setTitle("Registration");
		setResizable(false);

		Font f = new Font("Caviar Dreams",Font.PLAIN,30);
		Font f1 = new Font("Caviar Dreams",Font.PLAIN,17);
		l1 = new JLabel("Register");
		l1.setForeground(Color.white);
		l1.setFont(f);
		l2 = new JLabel("UserName:");
		l2.setFont(f1);
		l2.setForeground(Color.white);
		l3 = new JLabel("Create Passowrd:");
		l3.setFont(f1);
		l3.setForeground(Color.white);
		l4 = new JLabel("Confirm Password:");
		l4.setFont(f1);
		l4.setForeground(Color.white);
		l5 = new JLabel("Phone No:");
		l5.setFont(f1);
		l5.setForeground(Color.white);
		l6 = new JLabel("Name:");
		l6.setFont(f1);
		l6.setForeground(Color.white);
		tf1 = new JTextField();
		p1 = new JPasswordField();
		p2 = new JPasswordField();
		tf6 = new JTextField();
		tf7 = new JTextField();
	
		btn1 = new JButton("Submit");
		btn1.setFont(f1);
		btn2 = new JButton("Clear");
		btn2.setFont(f1);

		btn1.addActionListener(this);
		btn2.addActionListener(new ActionListener()
			{
            		public void actionPerformed(ActionEvent e)
            		{
						tf1.setText("");
						p1.setText("");
						p2.setText("");
						tf6.setText("");
						//textfield.setText(null); //or use this
					}	
         	});
		l6.setBounds(380, 140 ,300 ,130);
		l1.setBounds(380, 90, 500, 130);
		l2.setBounds(380, 180, 300, 130);
		l3.setBounds(380, 220, 300, 130);
		l4.setBounds(380, 260, 300, 130);
		l5.setBounds(380, 300, 300, 130);
		tf7.setBounds(560, 190, 200, 30);
		tf1.setBounds(560, 230, 200, 30);
		p1.setBounds(560, 270, 200, 30);
		p2.setBounds(560, 310, 200, 30);
		tf6.setBounds(560, 350, 200, 30);
		btn1.setBounds(380, 450, 100, 30);
		btn2.setBounds(495, 450, 100, 30);	
	
		add(l1);
		add(l6);
		add(tf7);
		add(l2);
		add(tf1);
		add(l3);
		add(p1);
		add(l4);
		add(p2);
		add(l5);
		add(tf6);
		add(btn1);
		add(btn2);
	}
	

	/*public boolean checkUsername(String uname)
	{
		PreparedStatement ps=null;
		ResultSet rs;
		String s1 = tf1.getText();
		boolean checkUser = false;
		String query = "select * from reg where uname =?";
		try 
		{
			Class.forName("postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql:registration","postgres","");
			ps = con.prepareStatement(query);
			ps.setString(1, s1);
			rs = ps.executeQuery();
		     	if(rs.next())
	      	 	{
                		checkUser = true;
			}
        	} 
		catch(Exception ex) 
		{
			System.out.println(""+ex);	
        	}
	    	return checkUser;
	}*/
	public void actionPerformed(ActionEvent e)
	{
		String regex = "^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$";
		String regex1 = "^[a-zA-Z a-zA-Z a-zA-Z]*$";
		int x = 0;
			String s1 = tf7.getText();
			String s2 = tf1.getText();
			String s3 = tf6.getText();

			char[] s4 = p1.getPassword();
			char[] s5 = p2.getPassword();
			String s8 = new String(s4);
			String s9 = new String(s5);
		boolean freeflag = false;
		if (e.getSource() == btn1)
		{
				try
				{
				if(s8.equals(s9) && ((s1!=null) && (s2!=null) && (s3!=null) && (s8!=null) && (s9!=null)) && tf6.getText().matches(regex) && tf7.getText().matches(regex1))
				{
					Class.forName("postgresql.Driver");
					Connection con = DriverManager.getConnection("jdbc:postgresql:registration","postgres","");
					PreparedStatement ps = con.prepareStatement("insert into reg values(?,?,?,?,?)");
					ps.setString(1, s1);
					ps.setString(2, s2);
					ps.setString(3, s8);
					ps.setString(4, s9);
					ps.setString(5, s3);
					ps.executeUpdate();
					
					UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams", Font.PLAIN, 15));
				JOptionPane.showMessageDialog(btn1,"Data Saved Successfully");
				}
				else
				{
					UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams", Font.PLAIN, 15));
	            JOptionPane.showMessageDialog(btn1, "Wrong Field Input","Candidate",JOptionPane.PLAIN_MESSAGE);
				}
				}
				catch (Exception ex)
				{
					UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams", Font.PLAIN, 15));
	            JOptionPane.showMessageDialog(btn1, "UserName Already Exists","Candidate",JOptionPane.PLAIN_MESSAGE);
					System.out.println(""+ex);
				}
			}
			else if(freeflag == false)
		{
			tf1.setText("");
			tf6.setText("");
			tf7.setText("");
			p2.setText("");
			//rb2.setSelected(false);
			p1.setText("");
		}
		}
			
	
	public static void main(String args[])
	{
	new Registration();
	}
}
