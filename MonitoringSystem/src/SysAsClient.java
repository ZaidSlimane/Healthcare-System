import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SysAsClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("192.168.94.193", 1098);
            SensorMonitoring stub = (SensorMonitoring) registry.lookup("PatientDataService");
            PatientMedicalFolder folder =stub.providePatientData();
            if(isCritical(folder)){
                System.out.println("Critical data found");
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
        /////////////////Server /////////////
        try {
            AlertProvider alert = (AlertProvider) new AlertProviderImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("AlertGeneration", (Remote) alert);
            System.out.println("✅ monitoring Server is ready on port 1099...");
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("❌ Bank Operation Server Error: " + e.getMessage());
        }
    }
    public static boolean isCritical(PatientMedicalFolder folder) {
        boolean medicineOverdose = folder.isMedicineOverdose();
        double oxygenSaturation = folder.getOxygenSaturation();
        double pH = folder.getPh();
        double temperature = folder.getTemperature();
        int heartRate = folder.getHeartRate();
        int bpSys = folder.getBpSys();
        int respiratoryRate = folder.getRespiratoryRate();
        if (medicineOverdose || oxygenSaturation < 90 || pH < 7.2 || pH > 7.6 ||
                temperature < 35 || temperature > 40 || heartRate < 40 || heartRate > 130 ||
                bpSys < 90 || bpSys > 180 || respiratoryRate < 8 || respiratoryRate > 30) {
            return true;
        }

        return false;
    }


}
