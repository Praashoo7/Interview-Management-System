import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.util.*;
import java.io.*;
public class Displayy //extends JFrame //implements ActionListener
{
	Connection conn;
	Statement stmt;
	ResultSet rs;
	TableColumnModel cm;
	JTable jtb;
	JFrame f;
	JScrollPane jsp;
	Vector colheading,rowdata,row;
	Displayy() 
	{
		f=new JFrame();
		try
		{
			Class.forName("postgresql.Driver");
			System.out.println("Driver loaded");
			conn=DriverManager.getConnection("jdbc:postgresql:registration","postgres","");
			System.out.println("postgresql connected");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from addcan");
			colheading=new Vector();
			colheading.add("Candidate No");
			colheading.add("Name");
			colheading.add("CV");
			colheading.add("E-Mail");
			colheading.add("Phone No");
			
			rowdata=new Vector();		
			while(rs.next())
			{
				row=new Vector();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                                
		 		rowdata.add(row);
			}
			jtb=new JTable(rowdata,colheading);
			jsp=new JScrollPane(jtb);
			
			/*cm=jtb.getColumnModel();
                        cm.getColumn(1).setPreferredWidth(5);
                        cm.getColumn(2).setPreferredWidth(20);
                        cm.getColumn(3).setPreferredWidth(20);
                        cm.getColumn(4).setPreferredWidth(30);
                        cm.getColumn(5).setPreferredWidth(30);
                        cm.getColumn(6).setPreferredWidth(10);
                        cm.getColumn(7).setPreferredWidth(15);
                        cm.getColumn(8).setPreferredWidth(20);
                        cm.getColumn(9).setPreferredWidth(20);
                        cm.getColumn(10).setPreferredWidth(30);
                        cm.getColumn(11).setPreferredWidth(20);
                       	*/
		
		}
		catch(Exception ex)
		{
			System.out.println(ex+"");
		}
		f.add(jsp);
		f.setVisible(true);
		f.pack();
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	public static void main(String args[]) 
	{
		new Displayy();
	}
}
