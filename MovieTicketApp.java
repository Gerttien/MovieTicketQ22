import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;

public class MovieTicketApp extends JFrame {
    private JComboBox<String> cmbMovie;
    private JTextField txtTickets, txtPrice;
    private JTextArea txtReport;
    private MovieTicket movieTickets;

    public MovieTicketApp() {
        setTitle("MOVIE TICKETS");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        movieTickets = new MovieTicket();

        JLabel heading = new JLabel("MOVIE TICKETS", SwingConstants.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 8, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Movie Information"));

        cmbMovie = new JComboBox<>(new String[]{"Napoleon", "Oppenheimer", "Damsel"});
        txtTickets = new JTextField();
        txtPrice = new JTextField();

        addFormRow(formPanel, "MOVIE:", cmbMovie);
        addFormRow(formPanel, "NUMBER OF TICKETS:", txtTickets);
        addFormRow(formPanel, "TICKET PRICE:", txtPrice);

        txtReport = new JTextArea(8, 30);
        txtReport.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtReport);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JButton btnProcess = new JButton("Process");
        JButton btnClear = new JButton("Clear");
        JButton btnExit = new JButton("Exit");
        buttonPanel.add(btnProcess);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnExit);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        btnProcess.addActionListener(e -> processTickets());
        processItem.addActionListener(e -> processTickets());
        btnClear.addActionListener(e -> clearFields());
        clearItem.addActionListener(e -> clearFields());
        btnExit.addActionListener(e -> System.exit(0));
        exitItem.addActionListener(e -> System.exit(0));

        add(heading, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(scroll, BorderLayout.CENTER);
        bottom.add(buttonPanel, BorderLayout.SOUTH);
        add(bottom, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void addFormRow(JPanel panel, String label, JComponent field) {
        panel.add(new JLabel(label));
        panel.add(field);
    }

    private void processTickets() {
        try {
            String movie = (String) cmbMovie.getSelectedItem();
            int tickets = Integer.parseInt(txtTickets.getText());
            double price = Double.parseDouble(txtPrice.getText());

            MovieTicketData data = new MovieTicketData(movie, tickets, price);
            if (!movieTickets.ValidateData(data)) {
                JOptionPane.showMessageDialog(this, "Please enter valid data. Price and tickets must be greater than 0.", "Invalid Data", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double total = movieTickets.CalculateTotalTicketPrice(tickets, price);
            txtReport.setText("MOVIE NAME: " + movie + "\nMOVIE TICKET PRICE: R " + price + "\nNUMBER OF TICKETS: " + tickets + "\nTOTAL TICKET PRICE: R " + total);

            FileWriter writer = new FileWriter("report.txt");
            writer.write("MOVIE TICKET REPORT\n");
            writer.write("********************************\n");
            writer.write(txtReport.getText() + "\n");
            writer.write("********************************\n");
            writer.close();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values.", "Invalid Marks", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving file.");
        }
    }

    private void clearFields() {
        txtTickets.setText("");
        txtPrice.setText("");
        txtReport.setText("");
        cmbMovie.setSelectedIndex(0);
    }
}