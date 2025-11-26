package restaurant.oop;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Framing extends JFrame {

    private JLabel totalLabel;
    private DefaultTableModel orderTableModel;
    private JTable orderTable;
    private JPanel dishesPanel;
    private JPanel dessertsPanel;
    private JPanel drinksPanel;
    private final List<JSpinner> quantitySpinners;
    private final Map<JSpinner, MenuItem> spinnerItemMap;

    public Framing() {
        setTitle("Giorno's Deli & Dreams");

        setSize(1280, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        quantitySpinners = new ArrayList<>();
        spinnerItemMap = new HashMap<>();

        orderTableModel = new DefaultTableModel(new Object[]{"Item", "Qty", "Subtotal"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        MainBackgroundPanel contentPane = new MainBackgroundPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        contentPane.add(createHeaderPanel(), BorderLayout.NORTH);
        contentPane.add(createMainLayout(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JComponent createHeaderPanel() {
        JPanel headerWrapper = new JPanel(new BorderLayout());
        headerWrapper.setOpaque(false);
        headerWrapper.setBorder(new EmptyBorder(0, 15, 15, 15));

        RoundedPanel headerPanel = new RoundedPanel(40);
        headerPanel.setBackground(new Color(170, 122, 35));
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        JLabel titleLabel = new JLabel("Giorno's dolci & dreams");
        titleLabel.setForeground(new Color(247, 233, 255));
        titleLabel.setFont(new Font("Georgia", Font.BOLD, 50));
        titleLabel.setBorder(new EmptyBorder(3, 0, 0, 0));

        JLabel subtitleLabel = new JLabel("Giorno-sama, have a dream");
        subtitleLabel.setForeground(new Color(255, 235, 245));
        subtitleLabel.setFont(new Font("Serif", Font.ITALIC, 16));

        JPanel textBlock = new JPanel();
        textBlock.setOpaque(false);
        textBlock.setLayout(new BoxLayout(textBlock, BoxLayout.Y_AXIS));
        textBlock.add(titleLabel);
        textBlock.add(Box.createVerticalStrut(3));
        textBlock.add(subtitleLabel);

        headerPanel.add(textBlock, BorderLayout.WEST);
        headerWrapper.add(headerPanel, BorderLayout.CENTER);

        return headerWrapper;
    }

    private JComponent createMainLayout() {
        JPanel mainLayout = new JPanel(new GridBagLayout());
        mainLayout.setOpaque(false);

        dishesPanel = createGridPanel();
        dessertsPanel = createGridPanel();
        drinksPanel = createColumnPanel();

        JPanel dishesSection = createSectionPanel("Dishes", dishesPanel);
        JPanel dessertsSection = createSectionPanel("Desserts", dessertsPanel);
        JPanel drinksSection = createSectionPanel("Drinks", drinksPanel);
        JPanel orderSection = createOrderSection();

        JPanel leftColumn = new JPanel();
        leftColumn.setOpaque(false);
        leftColumn.setLayout(new BoxLayout(leftColumn, BoxLayout.Y_AXIS));
        leftColumn.add(dishesSection);
        leftColumn.add(Box.createVerticalStrut(15));
        leftColumn.add(dessertsSection);

        JPanel middleColumn = new JPanel();
        middleColumn.setOpaque(false);
        middleColumn.setLayout(new BoxLayout(middleColumn, BoxLayout.Y_AXIS));
        middleColumn.add(drinksSection);

        JPanel rightColumn = new JPanel();
        rightColumn.setOpaque(false);
        rightColumn.setLayout(new BoxLayout(rightColumn, BoxLayout.Y_AXIS));
        rightColumn.add(orderSection);

        GridBagConstraints leftConstraints = new GridBagConstraints();
        leftConstraints.gridx = 0;
        leftConstraints.gridy = 0;
        leftConstraints.fill = GridBagConstraints.BOTH;
        leftConstraints.weightx = 0.4;
        leftConstraints.insets = new Insets(0, 5, 0, 15);
        mainLayout.add(leftColumn, leftConstraints);

        GridBagConstraints middleConstraints = new GridBagConstraints();
        middleConstraints.gridx = 1;
        middleConstraints.gridy = 0;
        middleConstraints.fill = GridBagConstraints.BOTH;
        middleConstraints.weightx = 0.25;
        middleConstraints.insets = new Insets(0, 0, 0, 15);
        mainLayout.add(middleColumn, middleConstraints);

        GridBagConstraints rightConstraints = new GridBagConstraints();
        rightConstraints.gridx = 2;
        rightConstraints.gridy = 0;
        rightConstraints.fill = GridBagConstraints.BOTH;
        rightConstraints.weightx = 0.35;
        rightConstraints.insets = new Insets(0, 0, 0, 5);
        mainLayout.add(rightColumn, rightConstraints);

        return mainLayout;
    }

    private JPanel createGridPanel() {
        
        JPanel panel = new JPanel(new GridLayout(0, 1, 12, 12));
        panel.setOpaque(false);
        return panel;
    }

    private JPanel createColumnPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        return panel;
    }

    private JPanel createSectionPanel(String title, JComponent bodyContent) {
        JPanel wrapper = new JPanel();
        wrapper.setOpaque(false);
        wrapper.setLayout(new BorderLayout());
        wrapper.setBorder(new EmptyBorder(0, 0, 0, 0));

        RoundedPanel header = new RoundedPanel(30);
        header.setBackground(new Color(187, 141, 56));
        header.setLayout(new BorderLayout());
        header.setPreferredSize(new Dimension(0, 45));

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setForeground(new Color(253, 245, 230));
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        header.add(titleLabel, BorderLayout.CENTER);

        RoundedPanel body = new RoundedPanel(35);
        body.setBackground(new Color(230, 210, 205));
        body.setLayout(new BorderLayout());
        body.setBorder(new EmptyBorder(15, 15, 15, 15));
        body.add(bodyContent, BorderLayout.CENTER);

        wrapper.add(header, BorderLayout.NORTH);
        wrapper.add(body, BorderLayout.CENTER);
        return wrapper;
    }
    


    private JPanel createOrderSection() {
        JPanel wrapper = new JPanel();
        wrapper.setOpaque(false);
        wrapper.setLayout(new BorderLayout());

        RoundedPanel header = new RoundedPanel(40);
        header.setBackground(new Color(187, 141, 56));
        header.setLayout(new BorderLayout());
        header.setPreferredSize(new Dimension(0, 55));

        JLabel titleLabel = new JLabel("Order", SwingConstants.CENTER);
        titleLabel.setForeground(new Color(253, 245, 230));
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        header.add(titleLabel, BorderLayout.CENTER);

        RoundedPanel body = new RoundedPanel(35);
        body.setBackground(new Color(230, 210, 205));
        body.setLayout(new BorderLayout(0, 15));
        body.setBorder(new EmptyBorder(15, 15, 15, 15));

        orderTable = new JTable(orderTableModel);
        orderTable.setFillsViewportHeight(true);
        orderTable.setRowSelectionAllowed(false);
        orderTable.setShowGrid(false);
        orderTable.setOpaque(false);
        orderTable.setBackground(new Color(230, 210, 205));
        orderTable.setFont(new Font("Serif", Font.PLAIN, 13));
        orderTable.setForeground(new Color(70, 37, 78));
        orderTable.setRowHeight(22);
        orderTable.getTableHeader().setReorderingAllowed(false);
        orderTable.getTableHeader().setResizingAllowed(false);
        orderTable.getTableHeader().setFont(new Font("Serif", Font.BOLD, 13));
        orderTable.getTableHeader().setForeground(new Color(70, 37, 78));
        orderTable.getTableHeader().setBackground(new Color(215, 190, 185));
        orderTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        orderTable.getColumnModel().getColumn(1).setPreferredWidth(50);
        orderTable.getColumnModel().getColumn(2).setPreferredWidth(80);

        JScrollPane orderScrollPane = new JScrollPane(orderTable);
        orderScrollPane.setOpaque(false);
        orderScrollPane.getViewport().setOpaque(false);
        orderScrollPane.setBorder(null);
        orderScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        totalLabel = new JLabel("Grand Total: P 0.00");
        totalLabel.setFont(new Font("Georgia", Font.BOLD, 16));
        totalLabel.setForeground(new Color(70, 37, 78));
        totalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        RoundedButton confirmButton = new RoundedButton("Confirm Payment", 25);
        confirmButton.setBackground(new Color(187, 141, 56));    
        
        confirmButton.addActionListener(e -> {
            if (!hasSelectedItems()) {
                JOptionPane.showMessageDialog(this, "Please choose at least one item before confirming.", "Empty Order", JOptionPane.INFORMATION_MESSAGE);
            } else {
                int choice = JOptionPane.showConfirmDialog(
                        this,
                        "Proceed with payment?",
                        "Confirm Payment",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE
                        
                );
                showPaymentDialog();
                if (choice == JOptionPane.OK_OPTION) {
                    for (JSpinner spinner : quantitySpinners) {
                        
                        spinner.setValue(0);
                    }
                    
                    JOptionPane.showMessageDialog(this, "Order confirmed! Thank you for visiting Giorno's.", "Payment", JOptionPane.INFORMATION_MESSAGE);
                    updateTotal();
                }
            }
        });
        
        
        
        RoundedButton clearButton = new RoundedButton("Clear Receipt", 30);
        clearButton.setBackground(new Color(153, 102, 204));
        clearButton.addActionListener(e -> {
        orderTableModel.setRowCount(0);
        ClearReceipt.clearingReceipt();
        for (JSpinner spinner : quantitySpinners) {
                spinner.setValue(0);
            }
             JOptionPane.showMessageDialog(this, "Receipt cleared!", "Receipt", JOptionPane.INFORMATION_MESSAGE);
                
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(totalLabel);
        bottomPanel.add(Box.createVerticalStrut(50));
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bottomPanel.add(confirmButton);
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonsPanel.add(clearButton);
        bottomPanel.add(buttonsPanel);

        body.add(orderScrollPane, BorderLayout.CENTER);
        body.add(bottomPanel, BorderLayout.SOUTH);

        wrapper.add(header, BorderLayout.NORTH);
        wrapper.add(body, BorderLayout.CENTER);
        return wrapper;
    }
    
    private void showPaymentDialog() {

        double totalAmount = 0.0;
        for (JSpinner spinner : quantitySpinners) {
            MenuItem item = spinnerItemMap.get(spinner);
            int quantity = (Integer) spinner.getValue();
            totalAmount += item.getPrice() * quantity;
        }

        JTextField amountGivenField = new JTextField(10);
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));

        panel.add(new JLabel("Total Amount:"));
        panel.add(new JLabel("₱" + totalAmount));
        panel.add(new JLabel("Amount Given:"));
        panel.add(amountGivenField);
        

        int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Enter Payment",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {

            try {
                double amountGiven = Double.parseDouble(amountGivenField.getText());

                if (amountGiven < totalAmount) {
                    JOptionPane.showMessageDialog(null,
                            "Insufficient funds!",
                            "Payment Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    showPaymentDialog();

                } else {
                    double change = amountGiven - totalAmount;
                    JOptionPane.showMessageDialog(this, "Payment successful!\nChange: ₱" + String.format("%.2f", change));
                    for (JSpinner spinner : quantitySpinners) spinner.setValue(0);
                    orderTableModel.setRowCount(0);
                    updateTotal();

                }
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a valid number.",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public void updateTotal() {
        if (totalLabel == null || quantitySpinners.isEmpty()) {
            return;
        }

        double grandTotal = 0.0;
        for (JSpinner spinner : quantitySpinners) {
            MenuItem item = spinnerItemMap.get(spinner);
            if (item != null) {
                int quantity = (Integer) spinner.getValue();
                grandTotal += item.getPrice() * quantity;
            }
        }

        totalLabel.setText("Grand Total: P " + String.format("%.2f", grandTotal));
        updateOrderList();
    }

    private void updateOrderList() {
        orderTableModel.setRowCount(0);
        boolean hasItems = false;

        for (JSpinner spinner : quantitySpinners) {
            MenuItem item = spinnerItemMap.get(spinner);
            int quantity = (Integer) spinner.getValue();
            if (quantity > 0) {
                double subtotal = item.getPrice() * quantity;
                orderTableModel.addRow(new Object[]{item.getName(), quantity, String.format("₱%.2f", subtotal)});
                hasItems = true;
            }
        }

        if (!hasItems) {
            orderTableModel.addRow(new Object[]{"No items selected", "-", "-"});
        }
    }

    private boolean hasSelectedItems() {
        for (JSpinner spinner : quantitySpinners) {
            if ((Integer) spinner.getValue() > 0) return true;
        }
        return false;
    }

    public void setMenuItems(MenuItem[] items) {
        if (items == null) return;

        dishesPanel.removeAll();
        dessertsPanel.removeAll();
        drinksPanel.removeAll();

        quantitySpinners.clear();
        spinnerItemMap.clear();
        orderTableModel.setRowCount(0);

        for (MenuItem item : items) {
            String category = item.getCategory();
            if ("Dishes".equalsIgnoreCase(category)) {
                dishesPanel.add(createDishDessertCard(item));
            } else if ("Desserts".equalsIgnoreCase(category)) {
                dessertsPanel.add(createDishDessertCard(item));
            } else {
                drinksPanel.add(createDrinkCard(item));
                drinksPanel.add(Box.createVerticalStrut(10));
            }
        }

        updateOrderList();
        updateTotal();

        dishesPanel.revalidate();
        dishesPanel.repaint();
        dessertsPanel.revalidate();
        dessertsPanel.repaint();
        drinksPanel.revalidate();
        drinksPanel.repaint();
    }

    private JPanel createDishDessertCard(MenuItem item) {
        RoundedPanel card = new RoundedPanel(25);
        card.setBackground(new Color(247, 234, 232));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setPreferredSize(new Dimension(180, 120));
        card.setBorder(new EmptyBorder(12, 12, 12, 12));

        JLabel titleLabel = createTitleLabel(item.getName());
        JLabel priceLabel = createPriceLabel(item.getPrice());
        JPanel controlsPanel = createControlsPanel(item);

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        controlsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(titleLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(priceLabel);
        card.add(Box.createVerticalStrut(8));
        card.add(controlsPanel);

        return card;
    }

    private JPanel createDrinkCard(MenuItem item) {
        RoundedPanel card = new RoundedPanel(20);
        card.setBackground(new Color(247, 234, 232));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(new EmptyBorder(12, 15, 12, 15));

        JLabel titleLabel = createTitleLabel(item.getName());
        JLabel priceLabel = createPriceLabel(item.getPrice());
        JPanel controlsPanel = createControlsPanel(item);

        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        controlsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(titleLabel);
        card.add(Box.createVerticalStrut(4));
        card.add(priceLabel);
        card.add(Box.createVerticalStrut(6));
        card.add(controlsPanel);

        return card;
    }

    private JLabel createTitleLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Georgia", Font.BOLD, 14));
        label.setForeground(new Color(79, 34, 91));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    private JLabel createPriceLabel(double price) {
        JLabel label = new JLabel("P " + String.format("%.2f", price));
        label.setFont(new Font("Serif", Font.PLAIN, 13));
        label.setForeground(new Color(102, 57, 81));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    private JPanel createControlsPanel(MenuItem item) {
        JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        controls.setOpaque(false);

        JLabel qtyLabel = new JLabel("Qty");
        qtyLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        qtyLabel.setForeground(new Color(79, 34, 91));

        JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        spinner.setPreferredSize(new Dimension(45, 24));
        spinner.setFont(new Font("SansSerif", Font.PLAIN, 12));

        JComponent editor = spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            ((JSpinner.DefaultEditor) editor).getTextField().setColumns(2);
            ((JSpinner.DefaultEditor) editor).getTextField().setHorizontalAlignment(JTextField.CENTER);
        }

        JLabel subtotalTitle = new JLabel("Subtotal:");
        subtotalTitle.setFont(new Font("SansSerif", Font.PLAIN, 12));
        subtotalTitle.setForeground(new Color(79, 34, 91));

        JLabel subtotalLabel = new JLabel("P 0.00");
        subtotalLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        subtotalLabel.setForeground(new Color(79, 34, 91));

        quantitySpinners.add(spinner);
        spinnerItemMap.put(spinner, item);

        spinner.addChangeListener(e -> {
            int quantity = (Integer) spinner.getValue();
            subtotalLabel.setText("P " + String.format("%.2f", item.getPrice() * quantity));
            updateTotal();
        });

        controls.add(qtyLabel);
        controls.add(spinner);
        controls.add(subtotalTitle);
        controls.add(subtotalLabel);

        return controls;
    }
    
    


    private static class MainBackgroundPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(new Color(70, 20, 78));
            g2.fillRect(0, 0, getWidth(), getHeight());

            g2.setColor(new Color(128, 48, 108));
            int[] xPointsLeft = {0, getWidth() / 2, 0};
            int[] yPointsLeft = {0, 0, getHeight()};
            g2.fillPolygon(xPointsLeft, yPointsLeft, 3);

            g2.setColor(new Color(150, 70, 135));
            int[] xPointsRight = {getWidth(), getWidth(), getWidth() / 2};
            int[] yPointsRight = {0, getHeight(), getHeight() / 2};
            g2.fillPolygon(xPointsRight, yPointsRight, 3);

            g2.dispose();
        }
    }

    private static class RoundedPanel extends JPanel {
        private final int radius;

        public RoundedPanel(int radius) {
            this.radius = radius;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    private static class RoundedButton extends JButton {
        private final int radius;

        public RoundedButton(String text, int radius) {
            super(text);
            this.radius = radius;
            setFocusPainted(false);
            setContentAreaFilled(false);
            setBorderPainted(false);
            setForeground(new Color(253, 245, 230));
            setFont(new Font("Georgia", Font.BOLD, 14));
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            setMargin(new Insets(8, 16, 8, 16));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Color base = getBackground() != null ? getBackground() : new Color(187, 141, 56);
            if (getModel().isPressed()) {
                g2.setColor(base.darker());
            } else if (getModel().isRollover()) {
                g2.setColor(base.brighter());
            } else {
                g2.setColor(base);
            }
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            g2.dispose();
            super.paintComponent(g);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Framing frame = new Framing();

            List<MenuItem> menu = new ArrayList<>();
            menu.addAll(new DISHES().loadItems());
            menu.addAll(new DESSERT().loadItems());
            menu.addAll(new DRINKS().loadItems());

            frame.setMenuItems(menu.toArray(new MenuItem[0]));
        });
    }
}
