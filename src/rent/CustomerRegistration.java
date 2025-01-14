
package rent;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.table.DefaultTableModel;

public class CustomerRegistration extends javax.swing.JFrame {

    private Object statement;

   
    public CustomerRegistration() {
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
            pst = con.prepareStatement("Select * from customer;");
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
                    v2.add(Rs.getString("cust_id"));
                    v2.add(Rs.getString("name"));
                    v2.add(Rs.getString("address"));
                    v2.add(Rs.getString("mobile"));
                }

                df.addRow(v2);
            }


        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerRegistration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public void autoID()
    {
        try {
            Class.forName("java.sql.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentcar", "root", "ADI#27#nal");
            Statement s = con.createStatement();

            ResultSet rs;
            rs = s.executeQuery("Select Max(cust_id) from customer;");
            rs.next();
            rs.getString("max(cust_id)");

            if(rs.getString("Max(cust_id)") == null)
            {
                jTextField1.setText("A0001");
            }
            else
            {
                long id = Long.parseLong(rs.getString("Max(cust_id)").substring(2, rs.getString("Max(cust_id)").length()));
                id++;
                jTextField1.setText("A0" + String.format("%03d", id));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CustomerRegistration.class.getName()).log(Level.SEVERE, null, ex);
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
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(200, 230, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
        	    null, 
        	    "Customer Info Form", 
        	    javax.swing.border.TitledBorder.LEFT, 
        	    javax.swing.border.TitledBorder.TOP, 
        	    new java.awt.Font("Arial", java.awt.Font.BOLD, 16),
        	    new java.awt.Color(255, 99, 71) 
        	));

        	
        	 

        jLabel1.setText("Customer ID");
        jLabel1.setForeground(new java.awt.Color(255, 99, 71)); 
        jLabel2.setText("Customer Name");
        jLabel2.setForeground(new java.awt.Color(255, 99, 71)); 
        jLabel3.setText("Address");
        jLabel3.setForeground(new java.awt.Color(255, 99, 71)); 
        jLabel4.setText("Mobile");
        jLabel4.setForeground(new java.awt.Color(255, 99, 71)); 

        jTextField1.setBackground(new java.awt.Color(240, 240, 255)); 
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            @Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.setBackground(new java.awt.Color(0, 102, 204)); 
        jButton1.setForeground(new java.awt.Color(255, 255, 255)); 
        jButton1.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancel");
        jButton4.setBackground(new java.awt.Color(255, 69, 0)); 
        jButton4.setForeground(new java.awt.Color(255, 255, 255)); 
        jButton4.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jTextField4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(55, 55, 55))))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
        	    new Object [][] {

        	    },
        	    new String [] {
        	        "CustomerID", "Customer Name", "Address", "Mobile"
        	    }
        	) {
        	    Class[] types = new Class [] {
        	        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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

        	
        	jTable1.setBackground(new Color(245, 245, 245));
        	jTable1.setBackground(new Color(245, 245, 245));
            jTable1.setForeground(Color.BLACK);
            jTable1.setFont(new Font("Arial", Font.PLAIN, 14));
            jTable1.setSelectionBackground(new Color(0, 102, 204));
            jTable1.setSelectionForeground(Color.WHITE);
            jTable1.getTableHeader().setBackground(new Color(255, 99, 71));
            jTable1.getTableHeader().setForeground(Color.WHITE);
            jTable1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        	
        	jTable1.setRowHeight(30); 

        	
        	jScrollPane1.setViewportView(jTable1);

        	jLabel5.setFont(new java.awt.Font("Tibetan Machine Uni", 1, 24));
        	jLabel5.setText("Registered Customers");
        	jLabel5.setForeground(new java.awt.Color(255, 69, 0)); 
        	//jLabel5.setBackground(new java.awt.Color(0, 10, 200)); 
        	jLabel5.setOpaque(true); 


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
           
            String custID = jTextField1.getText();  
            String Custname = jTextField2.getText();  
            String address = jTextArea1.getText();
            String mobile = jTextField4.getText();


            try {
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentcar", "root", "ADI#27#nal");
                pst = con.prepareStatement("insert into customer(cust_id, name, address, mobile) values (?, ?, ?, ?)");
                pst.setString(1, custID);
                pst.setString(2, Custname);
                pst.setString(3, address);
                pst.setString(4, mobile);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(this, "Customer Added !!");

                jTextField2.setText("");
                jTextArea1.setText("");
                jTextField4.setText("");
                jTextField2.requestFocus();  

                autoID();
                table_update();

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CustomerRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }



        } catch (SQLException ex) {
            Logger.getLogger(CustomerRegistration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        


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
            java.util.logging.Logger.getLogger(CustomerRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
			public void run() {
                new CustomerRegistration().setVisible(true);
            }
        });
    }

    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
   
}
