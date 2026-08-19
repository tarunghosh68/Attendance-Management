import javax.swing.*;
import java.awt.*;

public class AttendanceDashboard extends JFrame {
    public AttendanceDashboard() {
        setTitle("BUBT Student Attendance System (SQLite)");
        setSize(1200,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel sidebar = new JPanel(new GridLayout(4,1,10,10));
        sidebar.setBorder(BorderFactory.createTitledBorder("Forms"));
        JButton btnAttendance = new JButton("Attendance Form");
        JButton btnRegister = new JButton("Register Form");
        JButton btnUpdate = new JButton("Update Form");
        JButton btnReport = new JButton("Report Form");

        btnAttendance.addActionListener(e -> new AttendanceForm());
        btnRegister.addActionListener(e -> new RegisterForm());
        btnUpdate.addActionListener(e -> new UpdateForm());
        btnReport.addActionListener(e -> new ReportForm());

        sidebar.add(btnAttendance);
        sidebar.add(btnRegister);
        sidebar.add(btnUpdate);
        sidebar.add(btnReport);

        add(sidebar, BorderLayout.WEST);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AttendanceDashboard();
    }
}
