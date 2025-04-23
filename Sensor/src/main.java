import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public  class main {
    public static void main(String[] args) {
        try {

            SensorMonitoring stub = new Sensor();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("PatientDataService", stub);
            System.out.println("✅ Bank Operation Server is ready on port 1099...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}



//"192.168.94.193"