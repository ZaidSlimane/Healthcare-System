import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SysAsClient {
    public static void main(String[] args) {
        try {
            // Étape 1 : Récupération des données depuis le serveur
            Registry registry = LocateRegistry.getRegistry("40.67.241.136", 1099);
            SensorMonitoring stub = (SensorMonitoring) registry.lookup("PatientDataService");
            String data_ = stub.providePatientData();

            PatientData data = new PatientData();
            PatientData parsedData = data.parsePatientData(data_);

            System.out.println("Données du patient :");
            System.out.println(parsedData);

            // Étape 2 : Vérification des alertes
            String cause = checkCriticalCause(parsedData);
            if (cause != null) {
                String patientId = parsedData.getPatientId();
                sendAlertToDoctor(patientId, cause);
            }

            // Étape 3 : Publication du patient dans le service GetPatientData
            GetPatientData patient = new GetPatientDataImpl(parsedData); // ici on passe les données
            Registry reg = LocateRegistry.createRegistry(2000);
            reg.rebind("PatientData", (Remote) patient);

        } catch (Exception e) {
            System.err.println("Erreur dans le client : " + e);
            e.printStackTrace();
        }
    }

    public static String checkCriticalCause(PatientData data) {
        if (data.getOxygenSaturation() < 90)
            return "Low oxygen saturation";
        if (data.getPh() < 7.2 || data.getPh() > 7.6)
            return "Abnormal pH level";
        if (data.getTemperature() < 35 || data.getTemperature() > 40)
            return "Abnormal body temperature";
        if (data.getHeartRate() < 40 || data.getHeartRate() > 130)
            return "Abnormal heart rate";
        if (data.getBpSys() < 90 || data.getBpSys() > 180)
            return "Abnormal blood pressure (systolic)";
        if (data.getRespiratoryRate() < 8 || data.getRespiratoryRate() > 30)
            return "Abnormal respiratory rate";
        if (data.getCausesRespiratoryImbalance() != null && !data.getCausesRespiratoryImbalance().isEmpty())
            return data.getCausesRespiratoryImbalance();

        return null;
    }

    public static void sendAlertToDoctor(String patientId, String cause) throws RemoteException {
        try {
            AlertProvider alert = new AlertProviderImpl();
            Registry registry = LocateRegistry.createRegistry(1098);
            registry.rebind("AlertGeneration", alert);
            alert.sendAlert(patientId, cause);
        } catch (Exception e) {
            System.err.println("Erreur lors de l’envoi d’alerte : " + e);
            e.printStackTrace();
        }
    }
}
