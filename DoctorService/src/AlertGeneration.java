import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AlertGeneration extends Remote {
    void sendAlert(String message)throws RemoteException;
    void sendCriticalAlert(String patientId, String message)throws RemoteException;
    void sendAutoAlert(String patientId, double temperature, double threshold)throws RemoteException;
}
