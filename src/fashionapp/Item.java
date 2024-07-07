package fashionapp;

import javax.swing.*;
import java.awt.*;

public class Item extends JFrame {

    private JTable table;
    private JButton btnOrder;

    public Item() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Item");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String[] columnNames = {"No", "Product No", "Qty", "Price"};
        Object[][] data = {
                {1, "", "", ""},
                {2, "", "", ""},
                {3, "", "", ""},
                {4, "", "", ""}
        };

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        btnOrder = new JButton("Order");

        btnOrder.addActionListener(e -> new Order(data).setVisible(true));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(btnOrder, BorderLayout.SOUTH);

        getContentPane().add(panel);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Item().setVisible(true));
    }
}
