package fashionapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Stock extends JFrame {

    private JTable table;
    private JButton btnAdd;
    private DefaultTableModel model;

    public Stock() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Stock");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String[] columnNames = {"No", "Product No", "Qty", "Price"};
        Object[][] data = {
                {1, "", "", ""}
        };

        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        btnAdd = new JButton("Add");

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addRow(new Object[]{model.getRowCount() + 1, "", "", ""});
                JOptionPane.showMessageDialog(Stock.this, "Product Successfully Added!");
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(btnAdd, BorderLayout.SOUTH);

        getContentPane().add(panel);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Stock().setVisible(true));
    }
}
