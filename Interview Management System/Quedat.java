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

class Show
{
   	public static void main(String arg[])
   	{  
   	   	Show s=new Show();
   	}
   
   	public Show()
   	{
			Quedat frame = new Quedat();
	      	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      	frame.setResizable (false);
	      	frame.show();
			frame.setLocationRelativeTo(null);
	}
}


public class Quedat extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField tf1,tf2;
	JButton btn1, btn2, btn3 ,btn4, btn5, btn6;
	
	public Quedat() 
	{
		setContentPane(new JLabel(new ImageIcon("14.jpg")));
		setVisible(true);
		setSize(1120, 660);
		setLayout(null);
		setLocationRelativeTo(null);
		
		setTitle("Add Question Paper");
		setResizable(false);
		
		Font f = new Font("Caviar Dreams",Font.PLAIN,23);
		Font f1 = new Font("Caviar Dreams",Font.PLAIN,18);
		Font f2 = new Font("Caviar Dreams",Font.PLAIN,15);
		
		l1 = new JLabel("Add Question Paper");
		l1.setForeground(Color.white);
		l1.setFont(f);
		
		l2 = new JLabel("QuePaper No");
		l2.setFont(f1);
		l2.setForeground(Color.white);
		l3 = new JLabel("Question Paper");
		l3.setFont(f1);
		l3.setForeground(Color.white);

		tf1 = new JTextField();
		tf2 = new JTextField();

		btn1 = new JButton("Open");
		btn1.setFont(f2);
		btn2 = new JButton("Browse");
		btn2.setFont(f2);
		btn3 = new JButton("Save");
		btn3.setFont(f2);
		btn4 = new JButton("Remove");
		btn4.setFont(f2);
		btn5 = new JButton("Clear");
		btn5.setFont(f2);
		btn6 = new JButton("Display");
		btn6.setFont(f2);
		
		btn1.addActionListener(new ActionListener()
		{
            		public void actionPerformed(ActionEvent e)
            		{
               			try {
							File phpFile = new File(tf2.getText());
							if (phpFile.exists()) 
							{
							if (Desktop.isDesktopSupported()) {
							Desktop.getDesktop().open(phpFile);
							} 
							else 
							{
							UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams",Font.PLAIN,15));
							JOptionPane.showMessageDialog(Quedat.this,"AWT Desktop is not Supported","Please try Again !",JOptionPane.WARNING_MESSAGE);
							}
							} 
							else 
							{
							UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams",Font.PLAIN,15));
							JOptionPane.showMessageDialog(Quedat.this,"Browse a file or File does not Exist","Please try Again !",JOptionPane.WARNING_MESSAGE);
							}
							} 
							catch (Exception ex) 
							{
							System.out.println(ex);
							}
					}
		});
		btn2.addActionListener(new ActionListener()
			{
            		public void actionPerformed(ActionEvent e)
            		{
               			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
						jfc.setDialogTitle("Choose file");
						jfc.setAcceptAllFileFilterUsed(false);
					
						FileNameExtensionFilter filter = new FileNameExtensionFilter("PHP", "php");
						jfc.addChoosableFileFilter(filter);
						
						int returnValue = jfc.showOpenDialog(null);
						if (returnValue == JFileChooser.APPROVE_OPTION) 
						{
							tf2.setText("" + jfc.getSelectedFile().getAbsolutePath());
						}
					}	
         	});
			
			btn3.addActionListener(this);
			btn4.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent e)
				{
				    Remque rq = new Remque();	
				}
		});
		
		btn5.addActionListener(new ActionListener()
			{
            		public void actionPerformed(ActionEvent e)
            		{
						tf1.setText("");
						tf2.setText("");
						//textfield.setText(null); //or use this
					}	
         	});
			
		btn6.addActionListener(new ActionListener()
			{
            		public void actionPerformed(ActionEvent e)
            		{
				Displayy2 ds = new Displayy2();	
			}	
         	});
			
			
		l1.setBounds(200, 140, 500, 130);
		l2.setBounds(200, 220, 300, 130);
		l3.setBounds(200, 260, 300, 130);
		
		tf1.setBounds(345, 270, 300, 30);
		tf2.setBounds(345, 310, 300, 30);
		
		btn1.setBounds(655, 310 ,100, 30);
		btn2.setBounds(765, 310 ,100, 30);
		
		btn3.setBounds(320, 450, 100, 30);
		btn4.setBounds(435, 450, 100, 30);
		btn5.setBounds(550, 450, 100, 30);
		btn6.setBounds(665, 450, 100, 30);
		
		add(l1);
		add(l2);
		add(tf1);
		add(l3);
		add(tf2);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
	}

		
public void actionPerformed(ActionEvent e)
	{
		
		String regex = "^[0-9]$|^[0-9][0-9]$|^[0-9][0-9][0-9]$";
		String regex1 = "[^\n]+";
		boolean freeflag = false;
		if(e.getSource()==btn3)
		{   	
			String s1=tf1.getText();
			String s2=tf2.getText();

		        PreparedStatement ps=null;
			//ResultSet rs;
			String query="insert into quedat(queno,loc) values(?,?)";
			//JOptionPane.showMessageDialog(Student.this, "Data Saved Successfully.","Student",JOptionPane.PLAIN_MESSAGE,new ImageIcon("done.png"));
			try 
			{
				if(tf1.getText().matches(regex) && tf2.getText().matches(regex1))
				{
				Class.forName("postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql:registration","postgres","");
				ps = con.prepareStatement(query);
				ps.setString(1,s1);
				ps.setString(2,s2);
				//String 
				ps.executeUpdate();
			UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams", Font.PLAIN, 15));
	            JOptionPane.showMessageDialog(btn1, "Data Saved Successfully","Quedatabase",JOptionPane.PLAIN_MESSAGE);
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
	            JOptionPane.showMessageDialog(btn1, "Wrong field Input","Quedatabase",JOptionPane.PLAIN_MESSAGE);
				}
			}
			catch(Exception ex) 
			{
							UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams", Font.PLAIN, 15));
	                        JOptionPane.showMessageDialog(btn1, "Que paper No Already Exists","QueDatabase",JOptionPane.PLAIN_MESSAGE);
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
			//tf8.setText("");
		}
                //JOptionPane.showMessageDialog(btn1, "Data Saved Successfully.","Student",JOptionPane.PLAIN_MESSAGE,new ImageIcon("done.png"));
//JOptionPane.showMessageDialog(btn1, "Data Saved Successfully.","Student",JOptionPane.PLAIN_MESSAGE,new ImageIcon("done.png"));		
	}
	public static void main(String[] args) 
	{
		new Quedat();
    }
}
