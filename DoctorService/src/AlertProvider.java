import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AlertProvider extends Remote {
    void sendAlert(String patientId, String cause) throws RemoteException;
    String getAlert() throws RemoteException;
}
