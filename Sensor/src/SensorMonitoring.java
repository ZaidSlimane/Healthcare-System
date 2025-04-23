import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SensorMonitoring extends Remote {
    String providePatientData () throws RemoteException;
}
