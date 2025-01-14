
package rent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class CarRegistration extends javax.swing.JFrame {

    private Object statement;
    
    public CarRegistration() {
        initComponents();
        autoID();  // Calling the autoID() function
        table_update();
    }
    Connection con;
    PreparedStatement pst;

     @SuppressWarnings("unchecked")

    public void table_update()
    {
        int c;

        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentcar", "root", "ADI#27#nal");
            pst = con.prepareStatement("Select * from carregistration;");
            ResultSet Rs = pst.executeQuery();

            ResultSetMetaData rd = Rs.getMetaData();
            c = rd.getColumnCount();
            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);
            
            while(Rs.next())
            {
                Vector v2 = new Vector(); // Creating a vector object

                for(int i=1; i<=c; i++)
                {
                    v2.add(Rs.getString("car_no"));
                    v2.add(Rs.getString("make"));
                    v2.add(Rs.getString("model"));
                    v2.add(Rs.getString("available"));
                }

                df.addRow(v2);
            }


        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarRegistration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CarRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }


    }


    public void autoID()
    {
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentcar", "root", "ADI#27#nal");
            Statement s = con.createStatement();

            ResultSet rs;
            rs = s.executeQuery("Select Max(car_no) from carregistration;");
            rs.next();
            rs.getString("max(car_no)");

            if(rs.getString("Max(car_no)") == null)
            {
                jTextField1.setText("C0001");
            }
            else
            {
                long id = Long.parseLong(rs.getString("Max(car_no)").substring(2, rs.getString("Max(car_no)").length()));
                id++;
                jTextField1.setText("C0" + String.format("%03d", id));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
        	    javax.swing.BorderFactory.createEtchedBorder(),
        	    "Car Registration Form",
        	    javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
        	    javax.swing.border.TitledBorder.DEFAULT_POSITION,
        	    new java.awt.Font("Arial", java.awt.Font.BOLD, 16), 
        	    new java.awt.Color(0, 0, 120))); 
        	jPanel1.setBackground(new java.awt.Color(230, 240, 250)); 

        	jLabel1.setText("Car Reg No.");
        	jLabel1.setForeground(new java.awt.Color(0, 0, 120)); 
        	jLabel1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));

        	jLabel2.setText("Company");
        	jLabel2.setForeground(new java.awt.Color(0, 0, 120)); 
        	jLabel2.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));

        	jLabel3.setText("Model");
        	jLabel3.setForeground(new java.awt.Color(0, 0, 120));
        	jLabel3.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));

        	jLabel4.setText("Available");
        	jLabel4.setForeground(new java.awt.Color(0, 0, 120));
        	jLabel4.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));


        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
            
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.setBackground(new java.awt.Color(0, 102, 204)); 
        jButton1.setForeground(new java.awt.Color(255, 255, 255)); 
        jButton1.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        jButton1.setToolTipText("Click to add a new record");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.setBackground(new java.awt.Color(0, 153, 76)); 
        jButton2.setForeground(new java.awt.Color(250, 220, 200));
        jButton2.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        jButton2.setToolTipText("Click to edit the selected record"); 
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.setBackground(new java.awt.Color(204, 0, 0)); 
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        jButton3.setToolTipText("Click to delete the selected record");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancel");
        jButton4.setBackground(new java.awt.Color(102, 102, 102)); 
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        jButton4.setToolTipText("Click to cancel the current operation"); 
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jComboBox1.setBackground(new java.awt.Color(255, 255, 255)); 
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0)); 
        jComboBox1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));

        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);

        jPanel1.setBackground(new java.awt.Color(240, 248, 255)); 

        jLabel1.setForeground(new java.awt.Color(0, 51, 102)); 
        jLabel2.setForeground(new java.awt.Color(0, 102, 0)); 
        jLabel3.setForeground(new java.awt.Color(102, 0, 102)); 
        jLabel4.setForeground(new java.awt.Color(153, 51, 0)); 

        jTextField1.setBackground(new java.awt.Color(255, 255, 255)); 
        jTextField1.setForeground(new java.awt.Color(0, 0, 0)); 
        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setForeground(new java.awt.Color(0, 0, 0));
        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setForeground(new java.awt.Color(0, 0, 0));

        jComboBox1.setBackground(new java.awt.Color(224, 255, 255)); 
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0)); 

        jButton1.setBackground(new java.awt.Color(135, 206, 250)); 
        jButton1.setForeground(new java.awt.Color(0, 0, 0)); 
        jButton2.setBackground(new java.awt.Color(144, 238, 144)); 
        jButton2.setForeground(new java.awt.Color(0, 0, 0)); 
        jButton3.setBackground(new java.awt.Color(250, 128, 114)); 
        jButton3.setForeground(new java.awt.Color(255, 255, 255)); 
        jButton4.setBackground(new java.awt.Color(255, 255, 0)); 
        jButton4.setForeground(new java.awt.Color(0, 0, 0)); 

        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jTextField3)
                            .addComponent(jTextField1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
        	    new Object [][] {
        	       
        	    },
        	    new String [] {
        	        "CarRegNo", "Company", "Model", "Available"
        	    }
        	) {
        	    Class[] types = new Class [] {
        	        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
        	    };

        	    @Override
        	    public Class getColumnClass(int columnIndex) {
        	        return types[columnIndex];
        	    }
        	});

        	jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        	    @Override
        	    public void mouseClicked(java.awt.event.MouseEvent evt) {
        	        jTable1MouseClicked(evt);
        	    }
        	});

        	jTable1.setBackground(new java.awt.Color(255, 255, 255));
        	jTable1.setForeground(new java.awt.Color(0, 0, 0));
        	jTable1.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14)); 

        	
        	jTable1.setSelectionBackground(new java.awt.Color(255, 99, 71)); 
        	jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255)); 

        	
        	jTable1.getTableHeader().setBackground(new java.awt.Color(255, 0, 0)); 
        	jTable1.getTableHeader().setForeground(new java.awt.Color(255, 255, 255)); 
        	jTable1.getTableHeader().setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16)); 

        	
        	jTable1.setRowHeight(30); 

        	
        	jTable1.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
        	    @Override
        	    public java.awt.Component getTableCellRendererComponent(
        	        javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, 
        	        int row, int column) {
        	        java.awt.Component c = super.getTableCellRendererComponent(
        	            table, value, isSelected, hasFocus, row, column);
        	        
        	        // Alternate row colors
        	        if (row % 2 == 0) {
        	            c.setBackground(new java.awt.Color(255, 240, 240)); 
        	        } else {
        	            c.setBackground(new java.awt.Color(255, 255, 255)); 
        	        }

        	        return c;
        	    }
        	});


        	jScrollPane1.setViewportView(jTable1);

        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Tibetan Machine Uni", 1, 24)); 
        jLabel5.setText("Available Cars");
        jLabel5.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24)); 
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            
            String rgno = jTextField1.getText();  
            String make = jTextField2.getText();  
            String model = jTextField3.getText();  
            String aval = jComboBox1.getSelectedItem().toString();  

            try {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentcar", "root", "ADI#27#nal");
                pst = con.prepareStatement("insert into carregistration(car_no, make, model, available) values (?, ?, ?, ?)");
                pst.setString(1, rgno);
                pst.setString(2, make);
                pst.setString(3, model);
                pst.setString(4, aval);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(this, "Car Added......");

                jTextField2.setText("");
                jTextField3.setText("");
                jComboBox1.setSelectedIndex(-1);  
                jTextField2.requestFocus();  

                autoID();
                table_update();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CarRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }



        } catch (SQLException ex) {
            Logger.getLogger(CarRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        
        DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();

        int selectIndex = jTable1.getSelectedRow();

        jTextField1.setText(d1.getValueAt(selectIndex, 0).toString());
        jTextField2.setText(d1.getValueAt(selectIndex, 1).toString());
        jTextField3.setText(d1.getValueAt(selectIndex, 2).toString());
        jComboBox1.setSelectedItem(d1.getValueAt(selectIndex, 3).toString());

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

        DefaultTableModel d1= (DefaultTableModel) jTable1.getModel();

        int selectIndex = jTable1.getSelectedRow();

        try {
            String id = d1.getValueAt(selectIndex, 0).toString();  
            String make = jTextField2.getText(); 
            String mod = jTextField3.getText();
            String status = jComboBox1.getSelectedItem().toString();


            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentcar", "root", "ADI#27#nal");

            pst = con.prepareStatement("Update carregistration set make=?, model=?, available=? where car_no =?;");

            pst.setString(1, make);
            pst.setString(2, mod);
            pst.setString(3, status);
            pst.setString(4, id);
            pst.executeUpdate();  

            JOptionPane.showMessageDialog(this, "Record Updated....");
            table_update();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        

    	DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();

    	int selectIndex = jTable1.getSelectedRow();

    	String id = d1.getValueAt(selectIndex, 0).toString(); 

    	UIManager.put("OptionPane.messageForeground", new java.awt.Color(255, 99, 71));
    	UIManager.put("OptionPane.background", new java.awt.Color(255, 240, 240));
    	UIManager.put("OptionPane.buttonBackground", new java.awt.Color(0, 102, 204));
    	UIManager.put("OptionPane.buttonForeground", new java.awt.Color(255, 255, 255));
    	UIManager.put("Button.font", new java.awt.Font("Arial", java.awt.Font.BOLD, 14));

    	int dialogResult = JOptionPane.showConfirmDialog(this, "Do you want to Delete the records?", "Warning", JOptionPane.YES_NO_OPTION);

    	if (dialogResult == JOptionPane.YES_OPTION) {
    	    try {
    	        Class.forName("java.sql.Driver");
    	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentcar", "root", "ADI#27#nal");

    	        pst = con.prepareStatement("Delete from carregistration where car_no = ?;");
    	        pst.setString(1, id);
    	        pst.executeUpdate();

    	        JOptionPane.showMessageDialog(this, "Record Deleted....", "Success", JOptionPane.INFORMATION_MESSAGE);

    	        table_update();
    	    } catch (ClassNotFoundException | SQLException ex) {
    	        Logger.getLogger(CarRegistration.class.getName()).log(Level.SEVERE, null, ex);
    	    }
    	}
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
       
        dispose();
    }
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
			public void run() {
                new CarRegistration().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    
}
