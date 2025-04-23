import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AlertProviderImpl extends UnicastRemoteObject implements AlertProvider {
    private String lastAlert; // Attribut pour stocker la dernière alerte

    // Constructeur
    public AlertProviderImpl() throws RemoteException {
        super();
        lastAlert = "Aucune alerte reçue pour l'instant.";
    }

    // Méthode appelée par le serveur (monitoring) pour envoyer une alerte
    @Override
    public void sendAlert(String patientId, String cause) throws RemoteException {
        lastAlert = "🚨 Patient ID: " + patientId + " | Cause: " + cause;
        System.out.println("Alerte reçue et stockée : " + lastAlert);
    }

    // Méthode appelée par le docteur pour récupérer l’alerte
    @Override
    public String getAlert() throws RemoteException {
        return lastAlert;
    }
}
