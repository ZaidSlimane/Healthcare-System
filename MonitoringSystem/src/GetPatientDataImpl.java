import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GetPatientDataImpl extends UnicastRemoteObject implements GetPatientData {

    private PatientData currentPatient;

    public GetPatientDataImpl(PatientData data) throws RemoteException {
        super();
        this.currentPatient = data;
    }

    @Override
    public PatientData getPatientData(String patientId) throws RemoteException {
        if (currentPatient != null && currentPatient.getPatientId().equals(patientId)) {
            return currentPatient;
        }
        return null;
    }
}
