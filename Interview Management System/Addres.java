import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.awt.Desktop;
import java.awt.Toolkit;

class Disp
{
   	public static void main(String arg[])
   	{  
   	   	Disp s=new Disp();
   	}
   
   	Disp()
   	{
			Addres frame = new Addres();
	      	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      	frame.setResizable (false);
			frame.setLocationRelativeTo(null);
	}
}


class Addres extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField tf1, tf2, tf3, tf4 ,tf5 ,tf6;
	JButton btn1, btn2, btn3 ,btn4 ,btn5 ,btn6 ,btn7;
	JComboBox combo1,combo2,combo3;

	public Addres() 
	{
		setContentPane(new JLabel(new ImageIcon("14.jpg")));
		setVisible(true);
		setSize(1120, 660);
		setLayout(null);
		setLocationRelativeTo(null);
		
		setTitle("Add Result");
		setResizable(false);
		
		Font f = new Font("Caviar Dreams",Font.PLAIN,23);
		Font f1 = new Font("Caviar Dreams",Font.PLAIN,15);
		l1 = new JLabel("Results");
		l1.setForeground(Color.white);
		l1.setFont(f);
		l2 = new JLabel("No");
		l2.setFont(f1);
		l2.setForeground(Color.white);
		l3 = new JLabel("Name");
		l3.setFont(f1);
		l3.setForeground(Color.white);
		l4 = new JLabel("Obatained Marks");
		l4.setFont(f1);
		l4.setForeground(Color.white);
		l5 = new JLabel("Total Marks");
		l5.setFont(f1);
		l5.setForeground(Color.white);
		l6 = new JLabel("Time Taken");
		l6.setFont(f1);
		l6.setForeground(Color.white);
		l7 = new JLabel("Total Time");
		l7.setFont(f1);
		l7.setForeground(Color.white);
		l8 = new JLabel("Result");
		l8.setFont(f1);
		l8.setForeground(Color.white);

		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		tf6 = new JTextField();
		
		combo1 = new JComboBox();
		combo1.addItem("Mins");
		combo1.addItem("Hrs");
		combo1.setFont(f1);
		combo2 = new JComboBox();
		combo2.addItem("Mins");
		combo2.addItem("Hrs");
		combo2.setFont(f1);
		combo3 = new JComboBox();
		combo3.addItem("PASS");
		combo3.addItem("FAIL");
		combo3.setFont(f1);
		
		
		btn1 = new JButton("Add");
		btn1.setFont(f1);
		btn2 = new JButton("Remove");
		btn2.setFont(f1);
		btn3 = new JButton("Clear");
		btn3.setFont(f1);
		btn4 = new JButton("Display");
		btn4.setFont(f1);
		btn5 = new JButton("Send Mail");
		btn5.setFont(f1);
		btn6 = new JButton("Passed");
		btn6.setFont(f1);
		btn7 = new JButton("Failed");
		btn7.setFont(f1);
		
		btn1.addActionListener(this);
		btn2.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e)
				{
					Remres rr = new Remres();
				}
		});
		btn3.addActionListener(new ActionListener()
			{
            		public void actionPerformed(ActionEvent e)
            		{
						tf1.setText("");
						tf2.setText("");
						tf3.setText("");
						tf4.setText("");
						tf5.setText("");
						tf6.setText("");
						//textfield.setText(null); //or use this
					}	
         	});
			
		btn4.addActionListener(new ActionListener()
		{
            		public void actionPerformed(ActionEvent e)
            		{
               			Displayy3 dp = new Displayy3();
			}
		});
		
		btn5.addActionListener(new ActionListener()
		{
            		public void actionPerformed(ActionEvent e)
            		{
               			
					}
		});
		
		btn6.addActionListener(new ActionListener()
		{
            		public void actionPerformed(ActionEvent e)
            		{
               			Displaypass ds = new Displaypass();
					}
		});
		
		btn7.addActionListener(new ActionListener()
		{
            		public void actionPerformed(ActionEvent e)
            		{
               			Displayfail dl = new Displayfail();
					}
		});
		
		l1.setBounds(400, 30, 500, 130);
		l2.setBounds(400, 100, 300, 130);
		l3.setBounds(400, 140, 300, 130);
		l4.setBounds(400, 180, 300, 130);
		l5.setBounds(400, 220, 300, 130);
		l6.setBounds(400, 260, 300, 130);
		l7.setBounds(400, 300, 300, 130);
		l8.setBounds(400, 340, 300, 130);
		combo3.setBounds(545, 390, 180, 30);
		tf1.setBounds(545, 150, 180, 30);
		tf2.setBounds(545, 190, 180, 30);
		tf3.setBounds(545, 230, 180, 30);
		tf4.setBounds(545, 270, 180, 30);
		tf5.setBounds(545, 310, 110, 30);
		combo2.setBounds(665, 350, 60, 30);
		tf6.setBounds(545, 350, 110, 30);
		combo1.setBounds(665, 310, 60, 30);
		btn1.setBounds(330, 460, 90, 30);
		btn2.setBounds(445, 460, 90, 30);
		btn3.setBounds(560, 460, 90, 30);
		btn4.setBounds(675, 460, 90, 30);
		btn5.setBounds(790, 460, 110, 30);
		btn6.setBounds(445, 510, 90, 30);
		btn7.setBounds(560, 510, 90, 30);
		
		add(l1);
		add(l2);
		add(tf1);
		add(l3);
		add(tf2);
		add(l4);
		add(tf3);
		add(l5);
		add(tf4);
		add(l6);
		add(tf5);
		add(combo1);
		add(l7);
		add(tf6);
		add(combo2);
		add(l8);
		add(combo3);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn6);
		add(btn7);
		//add(btn5);
		
	}
	public void actionPerformed(ActionEvent e)
	{
	String regex = "^[a-zA-Z a-zA-Z a-zA-Z]*$";
	String regex1 = "^[0-9]$|^[0-9][0-9]$|^[0-9][0-9][0-9]$";
			String s1=tf1.getText();
            		String s2=tf2.getText();
			String s3=tf3.getText();
			String s4=tf4.getText();
			String s5=tf5.getText();
			String s6=combo1.getSelectedItem().toString();
			String s7=tf6.getText();
			String s8=combo2.getSelectedItem().toString();
			String s9=combo3.getSelectedItem().toString();
		boolean freeflag = false;
		if(e.getSource()==btn1)
		{   	
		      //  PreparedStatement ps=null;
			//ResultSet rs;
			//String query="insert into addres(resno,name,obmarks,tmarks,ttaken,time1,ttime,time2) values(?,?,?,?,?,?,?,?)";
			//JOptionPane.showMessageDialog(Student.this, "Data Saved Successfully.","Student",JOptionPane.PLAIN_MESSAGE,new ImageIcon("done.png"));
			try 
			{
				if(tf1.getText().matches(regex1) && tf2.getText().matches(regex) && tf3.getText().matches(regex1) && tf4.getText().matches(regex1) && tf5.getText().matches(regex1) && tf6.getText().matches(regex1))
				{
				Class.forName("postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql:registration","postgres","");
				PreparedStatement ps = con.prepareStatement("insert into addres(resno,name,obmarks,tmarks,ttaken,time1,ttime,time2,result) values(?,?,?,?,?,?,?,?,?)");
				ps.setString(1,s1);
				ps.setString(2,s2);
				ps.setString(3,s3);
				ps.setString(4,s4);
				ps.setString(5,s5);
				ps.setString(6,s6);
				ps.setString(7,s7);
				ps.setString(8,s8);
				ps.setString(9,s9);
				//String 
				ps.executeUpdate();
			UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams", Font.PLAIN, 15));
	            JOptionPane.showMessageDialog(btn1, "Data Saved Succesfully","Results",JOptionPane.PLAIN_MESSAGE);
			/*	int i=0,max=0,cno=0;
                                while(rs.next())
                                {
                                        cno=rs.getInt(1);
                                        if(cno>max)
                                        {
                                                max=cno;
                                        }
                                        i++;
                                }
                          cno=max+1;*/

			}
			else
				{
					UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams", Font.PLAIN, 15));
	            JOptionPane.showMessageDialog(btn1, "Wrong field Input","Results",JOptionPane.PLAIN_MESSAGE);
				}
			}
			catch(Exception ex) 
			{
							UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams", Font.PLAIN, 15));
	                        JOptionPane.showMessageDialog(btn1, "Result No Already Exists","Results",JOptionPane.PLAIN_MESSAGE);
				System.out.println(""+ex);	
			//	freeflag = true ;
			//	System.out.println(ex);
                        //        JOptionPane.showMessageDialog(Student.this,"Please Fill All Information Of All Forms !","Try Again !!!",JOptionPane.WARNING_MESSAGE);

        		}	
			//JOptionPane.showMessageDialog(Student.this, "Data Saved Successfully.","Student",JOptionPane.PLAIN_MESSAGE,new ImageIcon("done.png"));
		}
                //JOptionPane.showMessageDialog(Student.this, "Data Saved Successfully.","Student",JOptionPane.PLAIN_MESSAGE,new ImageIcon("done.png"));

		else if(freeflag == false)
		{
			tf1.setText("");
			tf2.setText("");
			//g1.setText("");
			//rb2.setSelected(false);
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
		}
                //JOptionPane.showMessageDialog(btn1, "Data Saved Successfully.","Student",JOptionPane.PLAIN_MESSAGE,new ImageIcon("done.png"));
//JOptionPane.showMessageDialog(btn1, "Data Saved Successfully.","Student",JOptionPane.PLAIN_MESSAGE,new ImageIcon("done.png"));
	}
		public static void main(String args[])
		{
			new Addres();
		}
}
