import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.*;
import java.awt.*;

public class Doctor {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Interface Médecin");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 500);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(new BorderLayout(10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JPanel topPanel = new JPanel();
            topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

            JButton btnGetAlert = new JButton("Consulter les alertes");
            btnGetAlert.setBackground(new Color(0, 102, 204));
            btnGetAlert.setForeground(Color.WHITE);
            btnGetAlert.setFont(new Font("Arial", Font.BOLD, 13));

            JLabel label = new JLabel("ID du Patient : ");
            JTextField patientIdField = new JTextField(15);

            JButton btnGetPatientData = new JButton("Chercher Patient");
            btnGetPatientData.setBackground(new Color(0, 153, 76));
            btnGetPatientData.setForeground(Color.WHITE);
            btnGetPatientData.setFont(new Font("Arial", Font.BOLD, 13));

            topPanel.add(btnGetAlert);
            topPanel.add(label);
            topPanel.add(patientIdField);
            topPanel.add(btnGetPatientData);

            JTextArea outputArea = new JTextArea();
            outputArea.setEditable(false);
            outputArea.setLineWrap(true);
            outputArea.setWrapStyleWord(true);
            outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

            JScrollPane scrollPane = new JScrollPane(outputArea);
            scrollPane.setPreferredSize(new Dimension(650, 300));

            // ===== ACTIONS =====
            btnGetAlert.addActionListener(e -> getAlert(outputArea));
            btnGetPatientData.addActionListener(e -> {
                String id = patientIdField.getText().trim();
                if (id.isEmpty()) {
                    outputArea.setText("⚠️ Veuillez entrer un ID de patient.");
                } else {
                    getPatientData(outputArea, id);
                }
            });

            // ===== Section d'envoi d'instructions =====
            JPanel instructionPanel = new JPanel();
            instructionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

            JLabel instructionLabel = new JLabel("Instruction : ");
            JTextField instructionField = new JTextField(15);
            JTextField patientIdInstructionField = new JTextField(15);
            patientIdInstructionField.setText(patientIdField.getText()); // Pré-remplir avec l'ID du patient actuel
            JButton btnSendInstruction = new JButton("Envoyer Instruction");
            btnSendInstruction.setBackground(new Color(204, 102, 0));
            btnSendInstruction.setForeground(Color.WHITE);
            btnSendInstruction.setFont(new Font("Arial", Font.BOLD, 13));

            instructionPanel.add(instructionLabel);
            instructionPanel.add(instructionField);
            instructionPanel.add(new JLabel("ID du Patient : "));
            instructionPanel.add(patientIdInstructionField);
            instructionPanel.add(btnSendInstruction);

            // Action pour envoyer l'instruction
            btnSendInstruction.addActionListener(e -> sendInstruction(instructionField, patientIdInstructionField, outputArea));

            // ===== FINAL UI =====
            panel.add(topPanel, BorderLayout.NORTH);
            panel.add(scrollPane, BorderLayout.CENTER);
            panel.add(instructionPanel, BorderLayout.SOUTH); // Ajouter la section en bas

            frame.add(panel);
            frame.setVisible(true);
            frame.revalidate();  // Forcer la mise à jour
            frame.repaint();     // Redessiner
        });
    }

    private static void getAlert(JTextArea outputArea) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            AlertProvider alertProvider = (AlertProvider) registry.lookup("AlertGeneration");
            String alertMessage = alertProvider.getAlert();
            outputArea.setText("🚨 Alertes médicales :\n\n" + alertMessage);
        } catch (Exception ex) {
            outputArea.setText("❌ Erreur lors de la récupération des alertes :\n" + ex.getMessage());
        }
    }

    private static void getPatientData(JTextArea outputArea, String patientId) {
        try {
            Registry registryP = LocateRegistry.getRegistry("localhost", 2000);
            GetPatientData patient = (GetPatientData) registryP.lookup("PatientData");
            PatientData data = patient.getPatientData(patientId);
            outputArea.setText("📋 Données du patient :\n\n" + data.toString());
        } catch (Exception ex) {
            outputArea.setText("❌ Erreur lors de la récupération des données du patient :\n" + ex.getMessage());
        }
    }

    private static void sendInstruction(JTextField instructionField, JTextField patientIdField, JTextArea outputArea) {
        String instruction = instructionField.getText().trim();
        String patientId = patientIdField.getText().trim();

        if (instruction.isEmpty() || patientId.isEmpty()) {
            outputArea.setText("⚠️ Veuillez entrer l'instruction et l'ID du patient.");
        } else {
            try {
                PorovideInstImpl inst = new PorovideInstImpl();
                Registry reg = LocateRegistry.createRegistry(2001);
                reg.rebind("Instructions", inst);
                inst.setInstructionDetails(patientId, instruction);
                outputArea.setText("✅ Instruction envoyée pour le patient ID " + patientId + " : " + instruction);
            } catch (Exception ex) {
                outputArea.setText("❌ Erreur lors de l'envoi de l'instruction :\n" + ex.getMessage());
            }
        }
    }
}
