import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GetPatientData extends Remote {
    public PatientData getPatientData(String patientId) throws RemoteException;
}
