import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.*;

class Help
{
	JFrame frame = new JFrame("Help"); 
	JPanel panel1, panel2, panel3;
	JTextArea txtHelp;
	JScrollPane scrollHelp;
	JLabel lblImg;
	JButton btnOk;

	public Help()
 	{
		/*java.io.BufferedReader reader = new java.io.BufferedReader(new FileReader("Help.txt"));
		String temp = null;
		StringBuffer message = new StringBuffer();
		String newLine = System.getProperty("line.separator");*/
		
		Font f = new Font("Caviar Dreams",Font.PLAIN,15);
		
		//Scroll Panel
		panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
				
		//Options Panel
  		panel2 = new JPanel();		
		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));

		//Image Panel
		panel3 = new JPanel();
		panel3.setLayout(new GridBagLayout());
		lblImg = new JLabel(new ImageIcon(""));
		lblImg.setHorizontalAlignment(JLabel.CENTER);
		panel3.add(lblImg);

		Color c = new Color(45 ,192 ,255 ,240);

		//Help ScrollPane
		txtHelp = new JTextArea(36, 98);
		txtHelp.setLineWrap(true);
		
		try {
			//use buffering, reading one line at a time
			//FileReader always assumes default encoding is OK!
			BufferedReader input =  new BufferedReader(new FileReader("Help.txt"));
			try {
				String line = null; //not declared within while loop
				
				while (( line = input.readLine()) != null){
					txtHelp.append(line+"\n");
				}
			}
			finally {
				input.close();
			}
		}
		catch (IOException ex){
			ex.printStackTrace();
		}

		txtHelp.setEditable(false);
		scrollHelp = new JScrollPane(txtHelp);
		scrollHelp.setEnabled(false); 
		panel1.add(scrollHelp, getConstraints(0, 4, 2, 1, GridBagConstraints.EAST));

		//Button - Ok
		btnOk = new JButton("OK");
		btnOk.setFont(f);
		panel1.add(btnOk, getConstraints(0, 5, 2, 1, GridBagConstraints.EAST));

		btnOk.addActionListener(new okListener());		
		
  		frame.getContentPane().add(panel1);
  		frame.getContentPane().add(panel2);
		frame.getContentPane().add(panel3);
		frame.getContentPane().add(BorderLayout.CENTER, panel1);
  		frame.getContentPane().add(BorderLayout.SOUTH, panel2);
		frame.getContentPane().add(BorderLayout.NORTH, panel3);
  		frame.pack();
  		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
	}

	private GridBagConstraints getConstraints(int gridx,int gridy, int gridwidth,int gridheight,int anchor)
	{
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5,5,5,5);
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridwidth = gridwidth;
		c.gridheight = gridheight;
		c.anchor = GridBagConstraints.WEST;

		return c;
	}

	class okListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ev)
		{
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setVisible(false);
		}
	}

	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                Help st = new Help();
            }
        });
	}
}