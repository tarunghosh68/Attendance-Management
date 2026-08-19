import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.time.LocalDate;

public class AttendanceForm extends JFrame {
    public AttendanceForm() {
        setTitle("Attendance Form");
        setSize(400,250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,2,10,10));

        JTextField txtId = new JTextField();

        add(new JLabel("Student ID:")); add(txtId);

        JButton btnMark = new JButton("Mark Present");
        add(btnMark); add(new JLabel());

        btnMark.addActionListener(e -> {
            try(Connection con = DBConnection.getConnection()) {
                Statement st = con.createStatement();
                st.executeUpdate("CREATE TABLE IF NOT EXISTS attendance(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, student_id TEXT, date TEXT, status TEXT)");
                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO attendance(student_id,date,status) VALUES(?,?,?)");
                ps.setString(1, txtId.getText());
                ps.setString(2, LocalDate.now().toString());
                ps.setString(3, "Present");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this,"Attendance Marked!");
            } catch(Exception ex) { ex.printStackTrace(); }
        });

        setVisible(true);
    }
}
