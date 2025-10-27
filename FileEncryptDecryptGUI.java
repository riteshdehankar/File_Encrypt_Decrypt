package Intership_Task_Impl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FileEncryptDecryptGUI extends JFrame implements ActionListener {

    private JTextField inputPathField, outputPathField;
    private JButton browseInputBtn, browseOutputBtn, encryptBtn, decryptBtn;
    private JTextArea statusArea;
    private JFileChooser fileChooser;

    public FileEncryptDecryptGUI() {
        setTitle("🔐 File Encryptor & Decryptor");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(40, 44, 52));

        // ===== Header Label =====
        JLabel title = new JLabel("File Encryptor & Decryptor", SwingConstants.CENTER);
        title.setFont(new Font("Poppins", Font.BOLD, 24));
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);

        // ===== Center Panel =====
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(40, 44, 52));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Input file
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel inputLabel = new JLabel("Input File:");
        inputLabel.setForeground(Color.WHITE);
        centerPanel.add(inputLabel, gbc);

        gbc.gridx = 1;
        inputPathField = new JTextField(25);
        inputPathField.setFont(new Font("Consolas", Font.PLAIN, 14));
        centerPanel.add(inputPathField, gbc);

        gbc.gridx = 2;
        browseInputBtn = new JButton("Browse");
        browseInputBtn.addActionListener(this);
        centerPanel.add(browseInputBtn, gbc);

        // Output file
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel outputLabel = new JLabel("Output File:");
        outputLabel.setForeground(Color.WHITE);
        centerPanel.add(outputLabel, gbc);

        gbc.gridx = 1;
        outputPathField = new JTextField(25);
        outputPathField.setFont(new Font("Consolas", Font.PLAIN, 14));
        centerPanel.add(outputPathField, gbc);

        gbc.gridx = 2;
        browseOutputBtn = new JButton("Save As");
        browseOutputBtn.addActionListener(this);
        centerPanel.add(browseOutputBtn, gbc);

        // Encrypt / Decrypt buttons
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 3;
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(40, 44, 52));

        encryptBtn = new JButton("Encrypt");
        decryptBtn = new JButton("Decrypt");
        encryptBtn.setBackground(new Color(76, 175, 80));
        decryptBtn.setBackground(new Color(244, 67, 54));
        encryptBtn.setForeground(Color.WHITE);
        decryptBtn.setForeground(Color.WHITE);
        encryptBtn.setFont(new Font("Poppins", Font.BOLD, 16));
        decryptBtn.setFont(new Font("Poppins", Font.BOLD, 16));
        encryptBtn.setFocusPainted(false);
        decryptBtn.setFocusPainted(false);

        encryptBtn.addActionListener(this);
        decryptBtn.addActionListener(this);

        buttonPanel.add(encryptBtn);
        buttonPanel.add(decryptBtn);
        centerPanel.add(buttonPanel, gbc);

        add(centerPanel, BorderLayout.CENTER);

        // ===== Status Area =====
        statusArea = new JTextArea();
        statusArea.setEditable(false);
        statusArea.setBackground(new Color(33, 37, 43));
        statusArea.setForeground(Color.WHITE);
        statusArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        statusArea.setBorder(BorderFactory.createTitledBorder("Status"));
        JScrollPane scrollPane = new JScrollPane(statusArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));
        add(scrollPane, BorderLayout.SOUTH);

        fileChooser = new JFileChooser();

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == browseInputBtn) {
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
                inputPathField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
        else if (source == browseOutputBtn) {
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
                outputPathField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
        else if (source == encryptBtn || source == decryptBtn) {
            String inputPath = inputPathField.getText();
            String outputPath = outputPathField.getText();

            if (inputPath.isEmpty() || outputPath.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select both input and output files.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            char operation = (source == encryptBtn) ? 'E' : 'D';
            performOperation(inputPath, outputPath, operation);
        }
    }

    private void performOperation(String inputFile, String outputFile, char choice) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            int c;
            while ((c = reader.read()) != -1) {
                if (choice == 'E')
                    c += 3;
                else if (choice == 'D')
                    c -= 3;
                writer.write(c);
            }

            statusArea.append("✅ Operation successful! File saved as: " + outputFile + "\n");
        } catch (IOException e) {
            statusArea.append("❌ Error: " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FileEncryptDecryptGUI::new);
    }
}
