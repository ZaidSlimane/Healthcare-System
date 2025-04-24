import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Nurse {
    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry("localhost", 2001);
            ProvideInst inst = (ProvideInst) registry.lookup("Instructions");
            inst.provideInst();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        }
    }
