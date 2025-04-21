import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SysAsClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1089);
            SensorMonitoring stub = (SensorMonitoring) registry.lookup("SysClient");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
