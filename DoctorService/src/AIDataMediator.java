import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface AIDataMediator extends Remote {
    String getAIDecision(String patientData)throws RemoteException;
    String analyzeSymptoms(String symptoms)throws RemoteException;
    String suggestTreatment(String patientData)throws RemoteException;
    double assessSeverity(String patientData)throws RemoteException;
    List<String> getGlobalStats()throws RemoteException;

}
