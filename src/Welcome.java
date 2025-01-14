import javax.swing.*;

import rent.Start_Page;

import java.awt.*;

public class Welcome extends javax.swing.JFrame {

    public Welcome() {
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jLabelImage = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        
        jLabel1.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 36));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Welcome to Go Now");
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setOpaque(true);
        jLabel1.setBackground(new Color(0, 102, 204));
        
        ImageIcon imageIcon = new ImageIcon("src/resources/car1.jpeg"); 
        Image image = imageIcon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        jLabelImage.setIcon(new ImageIcon(image));
        jLabelImage.setHorizontalAlignment(SwingConstants.CENTER);
        
       
        jButton1.setText("Get Started");
        jButton1.setFont(new Font("Arial", Font.BOLD, 18));
        jButton1.setBackground(new Color(50, 205, 50));
        jButton1.setForeground(Color.WHITE);
        jButton1.setFocusPainted(false);
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jButton1.setToolTipText("Click to enter the application");
        jButton1.addActionListener(evt -> openStartPage());

        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelImage, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(50, Short.MAX_VALUE))
            );

            layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabelImage, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))
            );

            getContentPane().setBackground(new Color(240, 248, 255));
            pack();
            setLocationRelativeTo(null); // Center the frame
        }

    private void openStartPage() {
        this.dispose(); 
        Start_Page startPage = new Start_Page();
        startPage.setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new Welcome().setVisible(true));
    }

    private JLabel jLabel1;
    private JButton jButton1;
    private JLabel jLabelImage;
}
