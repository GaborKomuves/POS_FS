package fashionapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame {

    public Home() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("POS - Fashion Shop");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Header panel
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.LIGHT_GRAY); // Silver color
        headerPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // White space around the header

        JLabel lblHeader = new JLabel("POS - FS", SwingConstants.CENTER);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 24));
        lblHeader.setForeground(Color.WHITE); // White font color

        headerPanel.setLayout(new BorderLayout());
        headerPanel.add(lblHeader, BorderLayout.CENTER);

        // Menu panel
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // White space around the menu
        menuPanel.setBackground(Color.GRAY); // Gray color

        RoundedButton btnCustomer = createMenuButton("Customer");
        RoundedButton btnManager = createMenuButton("Manager");
        RoundedButton btnStockManager = createMenuButton("Stock Manager");
        RoundedButton btnClerk = createMenuButton("Clerk");

        btnCustomer.addActionListener(e -> new Form("Customer").setVisible(true));
        btnManager.addActionListener(e -> new Form("Manager").setVisible(true));
        btnStockManager.addActionListener(e -> new Form("Stock Manager").setVisible(true));
        btnClerk.addActionListener(e -> new Form("Clerk").setVisible(true));

        menuPanel.add(btnCustomer);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        menuPanel.add(btnManager);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        menuPanel.add(btnStockManager);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        menuPanel.add(btnClerk);

        btnCustomer.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnManager.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnStockManager.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnClerk.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Footer label
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(Color.GRAY); // Matching footer background with menu
        footerPanel.setBorder(new EmptyBorder(10, 5, 5, 5)); // Additional spacing
        JLabel lblFooter = new JLabel("© 2024 POS - Fashion Shop", SwingConstants.CENTER);
        lblFooter.setFont(new Font("Arial", Font.PLAIN, 12));
        lblFooter.setForeground(Color.WHITE);
        footerPanel.add(lblFooter);

        // Image panel
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());
        imagePanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // White space around the image
        ImageIcon imageIcon = new ImageIcon("D:\\01. Data\\02. Developer\\JAVA\\JetBeansProjects\\POS_FS\\img\\Shop.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(menuPanel, BorderLayout.WEST);
        mainPanel.add(imagePanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH); // Add footer to the main panel

        getContentPane().add(mainPanel);
        setLocationRelativeTo(null);
    }

    private RoundedButton createMenuButton(String text) {
        RoundedButton button = new RoundedButton(text);
        button.setPreferredSize(new Dimension(200, 50));
        button.setMaximumSize(new Dimension(200, 50));
        button.setMinimumSize(new Dimension(200, 50));
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(30, 30, 30, 30)); // Padding around the button

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(UIManager.getColor("Button.background"));
            }
        });

        return button;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Home().setVisible(true));
    }
}

class RoundedButton extends JButton {
    private static final int RADIUS = 30;

    public RoundedButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), RADIUS, RADIUS);
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, RADIUS, RADIUS);
        g2.dispose();
    }

    @Override
    public void updateUI() {
        super.updateUI();
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setFont(new Font("Arial", Font.PLAIN, 14));
    }
}
