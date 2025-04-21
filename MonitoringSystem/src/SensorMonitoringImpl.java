import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SensorMonitoringImpl extends UnicastRemoteObject implements SensorMonitoring {
    protected SensorMonitoringImpl() throws RemoteException {
    }

    @Override
    public void consumeSensorData(PatientMedicalFolder folder) throws RemoteException {
        System.out.println("== Nouveau dossier médical reçu pour le patient ID : " + folder.getPatientId() + " ==");

        System.out.println(folder);
        if (folder.getTemperature() > 102 || folder.getHeartRate() > 180 || folder.getpH() < 7.0 || folder.getpH() > 7.8) {
            System.out.println("⚠️ Données critiques détectées !");
        } else {
            System.out.println("✅ Données dans les normes.");
        }
    }
}
