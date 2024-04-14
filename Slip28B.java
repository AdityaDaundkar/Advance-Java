package jdbcDemo;
import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

import javax.swing.table.*;

import java.util.*;

 

public class Slip28B extends JFrame implements ItemListener

{

    JFrame f1;

    JLabel l1;

    JComboBox cmb;

    JPanel p1;

    JTable jt;

    JScrollPane jp;

    DefaultTableModel dtm;

    GridLayout g1,g2;

    Connection con;

    Statement stmt;

    ResultSet rs;

 

    public Slip28B()

    {

       

        l1= new JLabel("Select Emp No");

        cmb= new JComboBox();

        dtm=new DefaultTableModel();

        dtm.addColumn("Emp No");

        dtm.addColumn("Emp Name");

        dtm.addColumn("Emp Salary");

        jt=new JTable(dtm);

        g1=new GridLayout(1,2);

        p1= new JPanel();

        p1.setLayout(g1);

        p1.add(l1); p1.add(cmb);

        g2=new GridLayout(2,1);

        f1=new JFrame();

        f1.setLayout(g2);

        jp=new JScrollPane(jt);

        add(p1,BorderLayout.NORTH);

        add(jp,BorderLayout.CENTER);

        this.setSize(500,500);

        this.setVisible(true);

        cmb.addItemListener(this);

 

        try

        {

            Class.forName("com.mysql.jdbc.Driver");

 

        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya","root","1234");

        stmt=con.createStatement();

        rs=stmt.executeQuery("select * from emp1");

       

        cmb.addItem("--");

 

        }catch(Exception e){}

 

    }

 

    public void itemStateChanged(ItemEvent ie)

    {

        try

        {

            while(rs.next())

            {

                cmb.addItem(rs.getInt(1));

 

            }

            int en=Integer.parseInt(cmb.getSelectedItem().toString());

 

            rs=stmt.executeQuery("select * from emp1 where Eid="+en+"");

 

            if(rs.next())

            {

                Vector v=new Vector();

                v.add(rs.getInt(1));

                v.add(rs.getString(2));

                v.add(rs.getInt(3));

 

                if(dtm.getRowCount()>0)

                    dtm.removeRow(0);

                    dtm.addRow(v);

 

            }

            //con.close();

        }catch(Exception e1){}

    }

    public static void main(String args[])

{

    new Slip28B();

}
}









/*create table emp1(Eid int , Ename char(40), sal float);
insert into emp1 values(1,"Aditya","75000"); 
insert into emp1 values(2,"vijay","55000"); 
insert into emp1 values(3,"Samir","50000"); 
insert into emp1 values(4,"Gaurav","55000"); 
insert into emp1 values(5,"pranit","60000"); 
insert into emp1 values(6,"vinay","69000"); 
select * from emp1;*/