import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;

public class NextPage
{
   public static void main(String arg[])
   {  
    NextPage ac=new NextPage();
   }
   public NextPage()
   {
      NextPageForm frame = new NextPageForm();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable (false);
      frame.show();
      frame.setLocationRelativeTo(null);
   }
}

class NextPageForm extends JFrame
{
	public NextPageForm()
	{
		JLabel time,time2;
		setTitle("Interview Management System");
		setSize(WIDTH,HEIGHT);
		
	    final Container contentPane = getContentPane();
		setContentPane(new JLabel(new ImageIcon("24.jpg")));
               					
//ACCEPT SYSTEM DATE		
		try
		{
			setLayout(new FlowLayout(FlowLayout.RIGHT));
			time = new JLabel();                                                                                            
                        time2 = new JLabel();
			
			//time.setBounds(355,350,200,30);
        	     	//add(time);
			
        		new Timer(0, new ActionListener() 
			{
        	    		public void actionPerformed(ActionEvent e) 
				{
        	        		Date d = new Date();

        	        		SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                                        SimpleDateFormat s1 = new SimpleDateFormat("dd/MM/yyyy ");

					time.setText(s.format(d));                 //time= jbutton 
                                        time2.setText(s1.format(d));                 //time= jbutton 

					time.setForeground(Color.white);
					time.setFont(new Font("Caviar Dreams", Font.PLAIN,18)); 

                                        time2.setForeground(Color.white);
                                        time2.setFont(new Font("Caviar Dreams", Font.PLAIN,18));
			
					//contentPane.add(time);
					add(time2);
					
					add(time);					
				}
			}).start();	
		}
		catch(Exception e)
		{
			System.out.println(""+e);
		}
		
		JMenuBar mbar = new JMenuBar();
		setJMenuBar(mbar);
		
		Font f = new Font("Century Gothic",Font.PLAIN,15);
		Font f1 = new Font("Caviar Dreams",Font.PLAIN,15);
		
		JMenu HomeMenu = new JMenu("System");
		mbar.add(HomeMenu);
		HomeMenu.addSeparator();
		HomeMenu.setFont(f);
		
			JMenuItem AddcMenu = new JMenuItem("Add Candidate");
			HomeMenu.add(AddcMenu);
			HomeMenu.addSeparator();
			HomeMenu.setFont(f);
			AddcMenu.setFont(f);
					AddcMenu.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent event)
						{
							Addcan ad = new Addcan();
						}
					});
					
	
      		JMenuItem exitItem = new JMenuItem("Exit");
      		exitItem.addActionListener(new ActionListener()
         	{
            		public void actionPerformed(ActionEvent event)
            		{
				System.exit(0);
			}
         	});
      		HomeMenu.add(exitItem);
      		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
      		exitItem.setMnemonic('X');
			exitItem.setFont(f);
	
	
		JMenu rm = new JMenu("Question Administration");
		mbar.add(rm);
		rm.addSeparator();
		rm.setFont(f);
		
			JMenuItem AddqMenu = new JMenuItem("Question Papers");
			rm.add(AddqMenu);
			rm.addSeparator();
			rm.setFont(f);
				AddqMenu.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent event)
						{
							Quedat qd = new Quedat();	
						}
					});
			AddqMenu.setFont(f);
		
		JMenu fm = new JMenu("Results");
		mbar.add(fm);
		fm.setFont(f);
			JMenuItem AddaMenu = new JMenuItem("Add Result Details");
			fm.add(AddaMenu);
			fm.addSeparator();
			fm.setFont(f);
				AddaMenu.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent event)
						{
								Addres ar = new Addres();	
						}
					});
			AddaMenu.setFont(f);
	
		JMenu rc = new JMenu("About");
		mbar.add(rc);
		rc.setFont(f);
			JMenuItem AdduMenu = new JMenuItem("IMS");
			rc.add(AdduMenu);
			rc.addSeparator();
			rc.setFont(f);
			AdduMenu.setFont(f);
				AdduMenu.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						About au=new About();	
					}
				});
			JMenuItem AddhMenu = new JMenuItem("Help");
			rc.add(AddhMenu);
			rc.addSeparator();
			rc.setFont(f);
			AddhMenu.setFont(f);
				AddhMenu.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{
							Help hw=new Help();	
					}
				});
			
	}
	public static final int WIDTH = 1120;
   	public static final int HEIGHT = 660;
}
