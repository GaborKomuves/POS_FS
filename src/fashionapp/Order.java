package fashionapp;

import javax.swing.*;
import java.awt.*;

public class Order extends JFrame {

    private Object[][] data;
    private JButton btnPayment;

    public Order(Object[][] data) {
        this.data = data;
        initComponents();
    }

    private void initComponents() {
        setTitle("Order");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String[] columnNames = {"No", "Product No", "Qty", "Price"};
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        btnPayment = new JButton("Payment");

        btnPayment.addActionListener(e -> JOptionPane.showMessageDialog(this, "Payment Successfully Made!"));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(btnPayment, BorderLayout.SOUTH);

        getContentPane().add(panel);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Order(null).setVisible(true));
    }
}
