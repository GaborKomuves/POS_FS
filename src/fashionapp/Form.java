package fashionapp;

import javax.swing.*;

public class Form extends JFrame {

    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnLogin;
    private String userType;

    public Form(String userType) {
        this.userType = userType;
        initComponents();
    }

    private void initComponents() {
        JLabel lblUser = new JLabel("User");
        JLabel lblPass = new JLabel("Password");
        txtUser = new JTextField(15);
        txtPass = new JPasswordField(15);
        btnLogin = new JButton("Login");

        btnLogin.addActionListener(evt -> btnLoginActionPerformed(evt));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblUser)
                                        .addComponent(lblPass))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(txtUser)
                                        .addComponent(txtPass)))
                        .addComponent(btnLogin)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblUser)
                                .addComponent(txtUser))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPass)
                                .addComponent(txtPass))
                        .addComponent(btnLogin)
        );

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        pack();
        setLocationRelativeTo(null);
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        String user = txtUser.getText();
        String pass = new String(txtPass.getPassword());

        if ("Customer".equals(userType)) {
            if ("Customer".equals(user) && "Password1".equals(pass)) {
                JOptionPane.showMessageDialog(this, "Successfully Login");
                new Item().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "User or Password invalid!");
            }
        } else if ("Stock Manager".equals(userType)) {
            if ("SMngr".equals(user) && "PasswordSM".equals(pass)) {
                JOptionPane.showMessageDialog(this, "Successfully Login");
                new Stock().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "User or Password invalid!");
            }
        } else if ("Manager".equals(userType)) {
            if ("Mngr".equals(user) && "PasswordM".equals(pass)) {
                JOptionPane.showMessageDialog(this, "Successfully Login");
                new User().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "User or Password invalid!");
            }
        } else if ("Clerk".equals(userType)) {
            if ("Clerk".equals(user) && "PasswordC".equals(pass)) {
                JOptionPane.showMessageDialog(this, "Successfully Login");
                new Billing().setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "User or Password invalid!");
            }
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Form("Customer").setVisible(true));
    }
}
