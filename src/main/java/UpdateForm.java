import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class UpdateForm extends JFrame {
    public UpdateForm() {
        setTitle("Update Student");
        setSize(400,200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3,2,10,10));

        JTextField txtId = new JTextField();
        JTextField txtName = new JTextField();

        add(new JLabel("Student ID:")); add(txtId);
        add(new JLabel("New Name:")); add(txtName);

        JButton btnUpdate = new JButton("Update");
        add(btnUpdate); add(new JLabel());

        btnUpdate.addActionListener(e -> {
            try(Connection con = DBConnection.getConnection()) {
                Statement st = con.createStatement();
                st.executeUpdate("CREATE TABLE IF NOT EXISTS students(" +
                        "id TEXT PRIMARY KEY, name TEXT, dept TEXT, batch TEXT, section TEXT)");
                PreparedStatement ps = con.prepareStatement(
                    "UPDATE students SET name=? WHERE id=?");
                ps.setString(1, txtName.getText());
                ps.setString(2, txtId.getText());
                int rows = ps.executeUpdate();
                JOptionPane.showMessageDialog(this, rows+" record updated!");
            } catch(Exception ex) { ex.printStackTrace(); }
        });

        setVisible(true);
    }
}
