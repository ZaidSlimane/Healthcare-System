import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProvideInst extends Remote {
    public void provideInst() throws RemoteException;
}
