import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SysAsServer {
    public static void main(String[] args) {
        try {
            SensorMonitoring stub = new SensorMonitoringImpl();
            Registry registry = LocateRegistry.createRegistry(1098);
            registry.rebind("SysServer", stub);
            System.out.println("✅  Server is ready on port 1098...");
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println( e.getMessage());
        }
    }
}
