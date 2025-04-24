import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProvideInst extends Remote {
    public void provideInst() throws RemoteException;
    void setInstructionDetails(String patientId, String instruction) throws RemoteException;
}


