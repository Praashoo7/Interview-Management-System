import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumnModel;
import java.io.File;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.util.*;

class Display
{
   	public static void main(String arg[])
   	{  
   	   	Display d=new Display();
   	}
   
   	public Display()
   	{
			Addcan frame = new Addcan();
	      	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      	frame.setResizable (false);
	      	frame.show();
			frame.setLocationRelativeTo(null);
	}
}


public class Addcan extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField tf1, tf2, tf3, tf4 ,tf5;
	JButton btn1, btn2, btn3 ,btn4 ,btn5 ,btn6 ,btn7;

	Connection conn;
	Statement stmt;
	ResultSet rs;
	TableColumnModel cm;
	JTable jtb;
	JFrame fr;
	JScrollPane jsp;
	Vector colheading,rowdata,row;
	
	public Addcan() 
	{
		setContentPane(new JLabel(new ImageIcon("14.jpg")));
		setVisible(true);
		setSize(1120, 660);
		setLayout(null);
		setLocationRelativeTo(null);
		
		setTitle("Add Candidate");
		setResizable(false);
		
		Font f = new Font("Caviar Dreams",Font.PLAIN,23);
		Font f1 = new Font("Caviar Dreams",Font.PLAIN,15);
		l1 = new JLabel("Add");
		l1.setForeground(Color.white);
		l1.setFont(f);
		l2 = new JLabel("Candidate No");
		l2.setFont(f1);
		l2.setForeground(Color.white);
		l3 = new JLabel("Name:");
		l3.setFont(f1);
		l3.setForeground(Color.white);
		l4 = new JLabel("Add CV:");
		l4.setFont(f1);
		l4.setForeground(Color.white);
		l5 = new JLabel("Email ID");
		l5.setFont(f1);
		l5.setForeground(Color.white);
		l6 = new JLabel("Phone No");
		l6.setFont(f1);
		l6.setForeground(Color.white);

		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		

		btn1 = new JButton("Add");
		btn1.setFont(f1);
		btn2 = new JButton("Remove");
		btn2.setFont(f1);
		btn3 = new JButton("Browse");
		btn3.setFont(f1);
		btn4 = new JButton("Open");
		btn4.setFont(f1);
		btn5 = new JButton("Clear");
		btn5.setFont(f1);
		btn6 = new JButton("Display");
		btn6.setFont(f1);
		btn7 = new JButton("Send Mail");
		btn7.setFont(f1);

		btn1.addActionListener(this);
		btn2.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e)
				{
					Remcan rc = new Remcan();
				}
		});
		btn3.addActionListener(new ActionListener()
			{
            		public void actionPerformed(ActionEvent e)
            		{
               			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
						jfc.setDialogTitle("Choose file");
						jfc.setAcceptAllFileFilterUsed(false);
					
						FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf");
						jfc.addChoosableFileFilter(filter);
						
						int returnValue = jfc.showOpenDialog(null);
						if (returnValue == JFileChooser.APPROVE_OPTION) 
						{
							tf3.setText("" + jfc.getSelectedFile().getAbsolutePath());
						}
					}	
         	});
			
		btn4.addActionListener(new ActionListener()
		{
            		public void actionPerformed(ActionEvent e)
            		{
               			try {
							File pdfFile = new File(tf3.getText());
							if (pdfFile.exists()) 
							{
							if (Desktop.isDesktopSupported()) {
							Desktop.getDesktop().open(pdfFile);
							} 
							else 
							{
							UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams",Font.PLAIN,20));
							JOptionPane.showMessageDialog(Addcan.this,"AWT Desktop is not Supported","Please try Again !",JOptionPane.WARNING_MESSAGE);
							}
							} 
							else 
							{
							UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams",Font.PLAIN,20));
							JOptionPane.showMessageDialog(Addcan.this,"Browse a file or File does not Exist","Please try Again !",JOptionPane.WARNING_MESSAGE);
							}
							} 
							catch (Exception ex) 
							{
							System.out.println(ex);
							}
					}
		});
		
		btn5.addActionListener(new ActionListener()
		{
            		public void actionPerformed(ActionEvent e)
            		{
               				tf1.setText("");
					tf2.setText("");
					tf3.setText("");
					tf4.setText("");
					tf5.setText("");
					//textfield.setText(null); //or use this	
					}
		});
		
		btn6.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e)
				{
					Displayy dd = new Displayy();
				}
		});
		
		btn7.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e)
				{
					
				}
		});
		
		l1.setBounds(300, 90, 500, 130);
		l2.setBounds(300, 140, 300, 130);
		l3.setBounds(300, 180, 300, 130);
		l4.setBounds(300, 220, 300, 130);
		l5.setBounds(300, 260, 300, 130);
		l6.setBounds(300, 300, 300, 130);
		tf1.setBounds(415, 190, 410, 30);
		tf2.setBounds(415, 230, 410, 30);
		tf3.setBounds(415, 270, 200, 30);
		tf4.setBounds(415, 310, 410, 30);
		tf5.setBounds(415, 350, 410, 30);
		btn1.setBounds(260, 450, 100, 30);
		btn2.setBounds(375, 450, 100, 30);
		btn3.setBounds(725, 270 ,100, 30);
		btn4.setBounds(620, 270,100, 30);
		btn5.setBounds(490, 450, 100, 30);
		btn6.setBounds(610, 450, 100, 30);
		btn7.setBounds(730, 450, 115, 30);
		
	
		add(l1);
		add(l2);
		add(tf1);
		add(l3);
		add(tf2);
		add(l4);
		add(tf3);
		add(btn4);
		add(btn3);
		add(l5);
		add(tf4);
		add(l6);
		add(tf5);
		add(btn1);
		add(btn2);
		add(btn5);
		add(btn6);
		//add(btn7);
	}
	public void actionPerformed(ActionEvent e)
	{
		boolean freeflag = false;
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		String regex1 = "^[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$";
		String regex2 = "^[a-zA-Z a-zA-Z a-zA-Z]*$";
		String regex3 = "^[0-9]$|^[0-9][0-9]$|^[0-9][0-9][0-9]$";
		String regex4 = "[^\n]+";
		if(e.getSource()==btn1)
		{   	
			String s1=tf1.getText();
            String s2=tf2.getText();
			String s3=tf3.getText();
			String s4=tf4.getText();
			String s5=tf5.getText();
			
		        PreparedStatement ps=null;
			//ResultSet rs;
			String query="insert into addcan(canno,name,cv,email,phno) values(?,?,?,?,?)";
			//JOptionPane.showMessageDialog(Student.this, "Data Saved Successfully.","Student",JOptionPane.PLAIN_MESSAGE,new ImageIcon("done.png"));
			try 
			{
				if(tf1.getText().matches(regex3) && tf2.getText().matches(regex2) && tf4.getText().matches(regex) && tf5.getText().matches(regex1) && tf3.getText().matches(regex4))
				{
				Class.forName("postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql:registration","postgres","");
				ps = con.prepareStatement(query);
				ps.setString(1,s1);
				ps.setString(2,s2);
				ps.setString(3,s3);
				ps.setString(4,s4);
				ps.setString(5,s5);
				//String 
				ps.executeUpdate();
			UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams", Font.PLAIN, 15));
	            JOptionPane.showMessageDialog(btn1, "Data Saved Successfully ","Candidate",JOptionPane.PLAIN_MESSAGE);
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
	            JOptionPane.showMessageDialog(btn1, "Wrong Field Input","Candidate",JOptionPane.PLAIN_MESSAGE);
				}
					
			}
			catch(Exception ex) 
			{
				UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams", Font.PLAIN, 15));
	            JOptionPane.showMessageDialog(btn1, "Candidate No Already Exists","Candidate",JOptionPane.PLAIN_MESSAGE);
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
			//rb2.setSelected(false);
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			//tf8.setText("");
		}
                //JOptionPane.showMessageDialog(btn1, "Data Saved Successfully.","Student",JOptionPane.PLAIN_MESSAGE,new ImageIcon("done.png"));
//JOptionPane.showMessageDialog(btn1, "Data Saved Successfully.","Student",JOptionPane.PLAIN_MESSAGE,new ImageIcon("done.png"));
	}
	public static void main(String[] args) 
	{
		new Addcan();
    }
}
