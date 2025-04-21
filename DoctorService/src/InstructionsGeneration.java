import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InstructionsGeneration extends Remote {
    String createInstruction(String patientId, String instruction)throws RemoteException;
    List<String> getInstructions(String patientId)throws RemoteException;
    boolean markInstructionDone(String instructionId)throws RemoteException;
    boolean deleteInstruction(String instructionId)throws RemoteException;

}
