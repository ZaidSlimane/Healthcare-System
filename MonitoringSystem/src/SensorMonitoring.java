import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SensorMonitoring extends Remote {
    void consumeSensorData( PatientMedicalFolder patientMedicalFolder) throws RemoteException;
}
