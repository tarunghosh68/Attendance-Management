import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class RegisterForm extends JFrame {
    public RegisterForm() {
        setTitle("Register Student");
        setSize(400,300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6,2,10,10));

        JTextField txtId = new JTextField();
        JTextField txtName = new JTextField();
        JTextField txtDept = new JTextField();
        JTextField txtBatch = new JTextField();
        JTextField txtSection = new JTextField();

        add(new JLabel("ID:")); add(txtId);
        add(new JLabel("Name:")); add(txtName);
        add(new JLabel("Department:")); add(txtDept);
        add(new JLabel("Batch:")); add(txtBatch);
        add(new JLabel("Section:")); add(txtSection);

        JButton btnSave = new JButton("Save");
        add(btnSave); add(new JLabel());

        btnSave.addActionListener(e -> {
            try(Connection con = DBConnection.getConnection()) {
                Statement st = con.createStatement();
                st.executeUpdate("CREATE TABLE IF NOT EXISTS students(" +
                        "id TEXT PRIMARY KEY, name TEXT, dept TEXT, batch TEXT, section TEXT)");
                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO students(id,name,dept,batch,section) VALUES(?,?,?,?,?)");
                ps.setString(1, txtId.getText());
                ps.setString(2, txtName.getText());
                ps.setString(3, txtDept.getText());
                ps.setString(4, txtBatch.getText());
                ps.setString(5, txtSection.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this,"Student Registered!");
            } catch(Exception ex) { ex.printStackTrace(); }
        });

        setVisible(true);
    }
}
