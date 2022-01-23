import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Toolkit;
import java.sql.*;
 
public class Login
{
   	public static void main(String arg[])
   	{  
   	   	Login l=new Login();
   	}
   
   	public Login()
   	{
			PassForm frame = new PassForm();
	      	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      	frame.setResizable (false);
	      	frame.show();
			frame.setLocationRelativeTo(null);
	}
}

class PassForm extends JFrame 
{  
	public PassForm()
	{    	KeyStroke keystroke;
		Container contentPane = getContentPane();

		setLayout(null);
      	setTitle("Login");
      	setSize(WIDTH,HEIGHT);
		setResizable(false);

		JPanel p4=new JPanel();
		p4.setBounds(355,250,350,240);
		setResizable(false);
				
      		JPanel panel1=new JPanel();
    		JPanel panel2=new JPanel();
			JPanel panel3=new JPanel();
 		
		Font f = new Font("Caviar Dreams",Font.PLAIN,20);
		Font f1 = new Font("Caviar Dreams",Font.PLAIN,15);
			
			JLabel lun = new JLabel("UserName");
      		panel1.add(lun);
			lun.setFont(f);
			lun.setForeground(Color.WHITE);	
      	
      		txtUserName = new JTextField(20);
      		panel1.add(txtUserName);
			
     		JLabel lPassword = new JLabel("Password");
      		panel2.add(lPassword);
			lPassword.setFont(f);
			lPassword.setForeground(Color.WHITE);
			
      		txtPassword = new JPasswordField(20);
      		panel2.add(txtPassword);
      		
           	JButton btnOK = new JButton("Login");
			btnOK.setFont(f1);
      		panel3.add(btnOK);
     		btnOK.addActionListener(new ButtonClick());
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.setFont(f1);
     		panel3.add(btnCancel);
     		btnCancel.addActionListener(new ActionListener()
         	{
            		public void actionPerformed(ActionEvent event)
            		{
               			System.exit(0);
            		}
         	});
			
			JButton btnRegister = new JButton("Register");
			btnRegister.setFont(f1);
      		panel3.add(btnRegister);
     		btnRegister.addActionListener(new ActionListener()
			{
            		public void actionPerformed(ActionEvent event)
            		{
               			Registration rc=new Registration();	
            		}
         	});
			


		panel1.setBackground(new Color(0,0,0,0));
 	        panel2.setBackground(new Color(0,0,0,0));
                panel3.setBackground(new Color(0,0,0,0));



		setContentPane(new JLabel(new ImageIcon("13.jpg")));

      		contentPane.add(panel1);
      		contentPane.add(panel2);
      		contentPane.add(panel3);
		contentPane.setLayout (new GridLayout(3,1));

		p4.setBackground(new Color(0,0,0,0));
         	p4.add(panel1);
     		p4.add(panel2);
    		p4.add(panel3);
		add(p4);
    	} 
  	public static final int WIDTH = 1120;
   	public static final int HEIGHT =660;  
   	private JTextField txtUserName;
   	private JPasswordField txtPassword;
   	   
   	private class ButtonClick implements ActionListener
   	{
    	       	public void actionPerformed(ActionEvent event)
            	{    	
			String uname = txtUserName.getText();
			char[] p1  = txtPassword.getPassword();
                        String pass = new String(p1);        		
        
        		try 
			{
				Class.forName("postgresql.Driver");
                                Connection con = DriverManager.getConnection("jdbc:postgresql:registration","postgres","");
        	    			
				PreparedStatement ps = con.prepareStatement("select * from reg where uname=? and pass=?");
	            
				ps.setString(1, uname);
            			ps.setString(2, pass);
            
            			ResultSet rs = ps.executeQuery();
            
            			if(rs.next())
            			{
            	       			NextPage np = new NextPage();
                                	PassForm.this.dispose();
            			}
            			else
						{	
								 UIManager.put("OptionPane.messageFont",new Font("Caviar Dreams", Font.PLAIN, 15));
                    			JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
                		}
            
        		}
			catch (Exception ex) 
			{
            			System.out.println(""+ex);
        		}
            	}
       	}
}
