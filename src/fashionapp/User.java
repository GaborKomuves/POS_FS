package fashionapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class User extends JFrame {

    private JTable table;
    private JButton btnAdd;
    private JButton btnDelete;
    private DefaultTableModel model;

    public User() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Users");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String[] columnNames = {"No", "Name", "User", "Password"};
        Object[][] data = {
                {1, "", "", ""},
                {2, "", "", ""},
                {3, "", "", ""},
                {4, "", "", ""}
        };

        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        btnAdd = new JButton("Add");
        btnDelete = new JButton("Delete");

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow(new Object[]{model.getRowCount() + 1, "", "", ""});
                JOptionPane.showMessageDialog(User.this, "User Successfully Added!");
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(User.this, "User Successfully Deleted!");
                } else {
                    JOptionPane.showMessageDialog(User.this, "Please select a user to delete.");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new User().setVisible(true));
    }
}
