import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.util.*;
import java.io.*;
public class Displayfail //extends JFrame //implements ActionListener
{
	Connection conn;
	Statement stmt;
	ResultSet rs;
	TableColumnModel cm;
	JTable jtb;
	JFrame f;
	JScrollPane jsp;
	Vector colheading,rowdata,row;
	Displayfail() 
	{
		f=new JFrame();
		try
		{
			Class.forName("postgresql.Driver");
			System.out.println("Driver loaded");
			conn=DriverManager.getConnection("jdbc:postgresql:registration","postgres","");
			System.out.println("postgresql connected");
			
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from addres where result = 'FAIL'");
			colheading=new Vector();
			colheading.add("Result No");
			colheading.add("Name");
			colheading.add("Obatained Marks");
			colheading.add("Total Marks");
			colheading.add("Time Taken");
			colheading.add("Time Mins/Hrs");
			colheading.add("Total Time");
			colheading.add("Time Mins/Hrs");
			colheading.add("Result");

			rowdata=new Vector();		
			while(rs.next())
			{
				row=new Vector();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
                		row.add(rs.getString(4));
                		row.add(rs.getString(5));
				row.add(rs.getString(6));
				row.add(rs.getString(7));
				row.add(rs.getString(8));
				row.add(rs.getString(9));
                                
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
		new Displayfail();
	}
}
