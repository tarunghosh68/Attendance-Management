import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ReportForm extends JFrame {
    public ReportForm() {
        setTitle("Attendance Report");
        setSize(600,350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextField txtId = new JTextField("Optional ID");
        JButton btnSearch = new JButton("Search");

        JPanel top = new JPanel(new GridLayout(1,2));
        top.add(txtId); top.add(btnSearch);

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID","Date","Status"},0);
        JTable table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);

        btnSearch.addActionListener(e -> {
            try(Connection con = DBConnection.getConnection()) {
                Statement st = con.createStatement();
                st.executeUpdate("CREATE TABLE IF NOT EXISTS attendance(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, student_id TEXT, date TEXT, status TEXT)");
                String sql = "SELECT * FROM attendance WHERE student_id LIKE ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, "%"+txtId.getText()+"%");
                ResultSet rs = ps.executeQuery();
                model.setRowCount(0);
                while(rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("student_id"),
                        rs.getString("date"),
                        rs.getString("status")
                    });
                }
            } catch(Exception ex) { ex.printStackTrace(); }
        });

        add(top, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }
}
