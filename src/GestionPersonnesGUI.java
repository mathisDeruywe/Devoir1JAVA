import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class GestionPersonnesGUI extends JFrame {
    private JTextField nomField;
    private JTextField ageField;
    private JButton addButton;
    private JButton removeButton;
    private JTable table;
    private DefaultTableModel tableModel;

    public GestionPersonnesGUI() {
        setTitle("Gestion Personnes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new FlowLayout());
        nomField = new JTextField(10);
        ageField = new JTextField(5);
        addButton = new JButton("Ajouter");
        removeButton = new JButton("Supprimer");

        inputPanel.add(new JLabel("Nom:"));
        inputPanel.add(nomField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        add(inputPanel, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"Nom",  "Age"}, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        addButton.addActionListener(e -> addPersonne());
        removeButton.addActionListener(e -> removePersonne());

        setVisible(true);
    }

    private void addPersonne() {
        String nom = nomField.getText().trim();
        String ageText = ageField.getText().trim();

        if (nom.isEmpty() || ageText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
            if (age < 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "L'âge doit être un entier positif.", "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModel.addRow(new Object[]{nom, age});
        nomField.setText("");
        ageField.setText("");
    }

    private void removePersonne() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une personne à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GestionPersonnesGUI::new);
    }
}