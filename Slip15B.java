package jdbcDemo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Slip15B extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4;
    JButton b1, b2;
    JComboBox<String> comboBox;
    Connection conn = null;
    PreparedStatement pst = null;

    public Slip15B() {
        setTitle("Student Details");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        l1 = new JLabel("Roll No:");
        l2 = new JLabel("Name:");
        l3 = new JLabel("Percentage:");
        l4 = new JLabel("Gender:");
        l5 = new JLabel("Class:");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();

        String[] genders = {"Male", "Female", "Other"};
        comboBox = new JComboBox<>(genders);

        t4 = new JTextField();

        b1 = new JButton("Save");
        b2 = new JButton("Cancel");

        JPanel p = new JPanel(new GridLayout(6, 2));
        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(l3);
        p.add(t3);
        p.add(l4);
        p.add(comboBox);
        p.add(l5);
        p.add(t4);
        p.add(b1);
        p.add(b2);

        add(p);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setVisible(true);

        // Connect to the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aditya", "root", "1234");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new Slip15B();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) { // Save button is clicked
            try {
                String query = "insert into students(RNo, SName, Per, Gender, Class) values (?, ?, ?, ?, ?)";
                pst = conn.prepareStatement(query);
                pst.setInt(1, Integer.parseInt(t1.getText()));
                pst.setString(2, t2.getText());
                pst.setDouble(3, Double.parseDouble(t3.getText()));
                pst.setString(4, (String) comboBox.getSelectedItem());
                pst.setInt(5, Integer.parseInt(t4.getText()));
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data saved successfully!");
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        } else if (ae.getSource() == b2) { // Cancel button is clicked
            System.exit(0);
        }
    }
}






//Create Table students(RNo int, SName varchar(45), Per Float, Gender Char(45), Class char(45));
//Select * from students;
//DROP table students;