import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Interface Médecin");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setLocationRelativeTo(null); // Centrer la fenêtre

                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());

                JButton btnGetAlert = new JButton("Consulter les alertes");
                btnGetAlert.setBackground(new Color(0, 102, 204)); // Bleu foncé
                btnGetAlert.setForeground(Color.WHITE); // Texte blanc
                btnGetAlert.setFocusPainted(false);
                btnGetAlert.setFont(new Font("Arial", Font.BOLD, 14));
                btnGetAlert.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                JTextArea alertTextArea = new JTextArea();
                alertTextArea.setEditable(false);
                alertTextArea.setLineWrap(true);
                alertTextArea.setWrapStyleWord(true);
                alertTextArea.setPreferredSize(new Dimension(350, 150));
                alertTextArea.setFont(new Font("Arial", Font.PLAIN, 14));

                JScrollPane scrollPane = new JScrollPane(alertTextArea);

                btnGetAlert.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getAlert(alertTextArea);
                    }
                });

                panel.add(btnGetAlert, BorderLayout.NORTH);
                panel.add(scrollPane, BorderLayout.CENTER);

                frame.add(panel);
                frame.setVisible(true);
            }
        });
    }

    private static void getAlert(JTextArea alertTextArea) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1098);
            AlertProvider alertProvider = (AlertProvider) registry.lookup("AlertGeneration");

            String alertMessage = alertProvider.getAlert();
            alertTextArea.setText(alertMessage);

        } catch (Exception ex) {
            alertTextArea.setText("Erreur: " + ex.getMessage());
        }
    }
}
