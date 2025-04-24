import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PorovideInstImpl extends UnicastRemoteObject implements ProvideInst {
    private static final long serialVersionUID = 1L;


    private String patientId;
    private String instruction;

    protected PorovideInstImpl() throws RemoteException {
        super();
    }


    public void setInstructionDetails(String patientId, String instruction) {
        this.patientId = patientId;
        this.instruction = instruction;
    }

    // Méthode pour envoyer l'instruction
    @Override
    public void provideInst() throws RemoteException {
        if (patientId != null && instruction != null) {
            System.out.println("Instruction envoyée à l'infirmier.");
            System.out.println("ID du Patient : " + patientId);
            System.out.println("Instruction : " + instruction);
        } else {
            System.out.println("Aucune instruction à envoyer.");
        }
    }
}
