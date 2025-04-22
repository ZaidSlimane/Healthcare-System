import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AlertProviderImpl extends UnicastRemoteObject implements AlertProvider {
    protected AlertProviderImpl() throws RemoteException {
    }

    @Override
    public Alert provideCriticalAlert(String patientId) throws RemoteException {
        return null;
    }
}
