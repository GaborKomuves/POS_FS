package fashionapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Billing extends JFrame {

    private JTable table;
    private JButton btnPrint;
    private JButton btnSave;

    public Billing() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Bill");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String[] columnNames = {"Item", "Description", "Quantity", "Price"};
        Object[][] data = {
                {"", "", "", ""}
        };

        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        btnPrint = new JButton("Print");
        btnSave = new JButton("Save");

        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    printReceipt();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Billing.this, "Error printing receipt: " + ex.getMessage());
                }
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveReceipt();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Billing.this, "Error saving receipt: " + ex.getMessage());
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnPrint);
        buttonPanel.add(btnSave);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(panel);
    }

    private void printReceipt() throws IOException {
        FileWriter writer = new FileWriter("Bill.csv");
        for (int i = 0; i < table.getColumnCount(); i++) {
            writer.write(table.getColumnName(i) + ",");
        }
        writer.write("\n");
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                writer.write(table.getValueAt(i, j).toString() + ",");
            }
            writer.write("\n");
        }
        writer.close();
        JOptionPane.showMessageDialog(this, "Receipt printed successfully!");
    }

    private void saveReceipt() throws IOException {
        FileWriter writer = new FileWriter("D:\\01. Data\\02. Developer\\JAVA\\JetBeansProjects\\POS_FS\\billing\\Bill.csv");
        for (int i = 0; i < table.getColumnCount(); i++) {
            writer.write(table.getColumnName(i) + ",");
        }
        writer.write("\n");
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                writer.write(table.getValueAt(i, j).toString() + ",");
            }
            writer.write("\n");
        }
        writer.close();
        JOptionPane.showMessageDialog(this, "Receipt saved successfully!");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Billing().setVisible(true));
    }
}
