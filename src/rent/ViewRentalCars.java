package rent;

import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;

public class ViewRentalCars extends JFrame {
    
    Connection con;
    PreparedStatement pst;
    
    public ViewRentalCars() {
        initComponents();
        table_update();
    }
    
    private void initComponents() {
    	JLabel label = new JLabel("View Rental Cars");
    	label.setFont(new Font("Tibetan Machine Uni", Font.BOLD, 24));
    	label.setText("View Rental Cars");
    	label.setForeground(new Color(255, 69, 0));
    	label.setOpaque(true);
    	label.setHorizontalAlignment(SwingConstants.CENTER);
    	add(label);

        
        jTable1 = new JTable();
        JScrollPane scrollPane = new JScrollPane(jTable1);
        add(scrollPane);
        
        jTable1.setBackground(new Color(245, 245, 245));
        jTable1.setForeground(Color.BLACK);
        jTable1.setFont(new Font("Arial", Font.PLAIN, 14));
        jTable1.setSelectionBackground(new Color(0, 102, 204));
        jTable1.setSelectionForeground(Color.WHITE);
        jTable1.getTableHeader().setBackground(new Color(255, 99, 71));
        jTable1.getTableHeader().setForeground(Color.WHITE);
        jTable1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(label);
        add(scrollPane);
        
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void table_update() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentcar", "root", "ADI#27#nal");
            pst = con.prepareStatement("SELECT * FROM carregistration"); 
            ResultSet rs = pst.executeQuery();
            
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            
            DefaultTableModel model = new DefaultTableModel();
            Vector<String> columnNames = new Vector<>();
            
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }
            model.setColumnIdentifiers(columnNames);
            
            while (rs.next()) {
                Vector<String> rowData = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.add(rs.getString(i));
                }
                model.addRow(rowData);
            }
            
            jTable1.setModel(model);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewRentalCars().setVisible(true);
            }
        });
    }

    private JTable jTable1;
}
