import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private JPanel itemsPanel;
    private JLabel subtotalLabel;

    public Display() {
        // make new frame
        frame = new JFrame("Scanner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 500);
        frame.setLocation(450, 50);
        frame.setLayout(new BorderLayout());

        // panel for items (scrollable)
        itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane, BorderLayout.CENTER);

        // label for subtotal
        subtotalLabel = new JLabel("Subtotal: $0.00");
        subtotalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        subtotalLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(subtotalLabel, BorderLayout.SOUTH);

        // yeah thats probably important
        frame.setVisible(true);
    }

    public void addItem(Item item) {
        String name = item.getName();
        double price = item.getPrice();

        JLabel itemLabel = new JLabel(String.format("%-20s %8.2f", name, price));
        // this font is ugly, but I don't want to make another label to right align
        // so im using text alignment and need the characters to be fixedwidth
        itemLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        itemsPanel.add(itemLabel);
    }

    public void setSubtotal(double price) {
        subtotalLabel.setText("Subtotal: $" + String.format("%.2f", price));
    }
}
