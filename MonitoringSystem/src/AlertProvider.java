import java.rmi.RemoteException;

public interface AlertProvider {
    Alert provideCriticalAlert(String patientId) throws RemoteException;
}
