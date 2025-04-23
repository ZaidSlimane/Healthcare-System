import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Sensor extends UnicastRemoteObject implements SensorMonitoring {
    private List<String> dataset;
    private Random random = new Random();
    private String[] headers;

    public Sensor() throws RemoteException, IOException {
        super();
        this.dataset = loadDataset();
        if (!dataset.isEmpty()) {
            this.headers = dataset.get(0).split(",");
        }
    }

    @Override
    public String providePatientData() {
        return getPatientData();
    }

    private List<String> loadDataset() throws IOException {
        try {
            List<String> data = Files.readAllLines(Paths.get("HealthMonitorDataset.csv"));
            System.out.println("Dataset loaded. Rows: " + data.size());
            return data;
        } catch (IOException e) {
            System.err.println("Error loading dataset: " + e.getMessage());
            throw e;
        }
    }

    private String getPatientData() {
        if (dataset == null || dataset.size() <= 1) {
            return ("No data available");
        }

        String randomRow = dataset.get(random.nextInt(dataset.size() - 1) + 1); // Skip header
        String[] values = randomRow.split(",");

        PatientData patient = new PatientData(
                UUID.randomUUID().toString(),
                values[10],  // Type
                Double.parseDouble(values[11]),  // Temperature
                Integer.parseInt(values[12]),    // Heart Rate
                Integer.parseInt(values[13]),    // Pulse
                Integer.parseInt(values[14]),    // BPSYS
                Integer.parseInt(values[15]),    // BPDIA
                Integer.parseInt(values[16]),    // Respiratory Rate
                Double.parseDouble(values[17]),  // Oxygen Saturation
                Double.parseDouble(values[18]),  // PH
                values[19]                        // Causes Respiratory Imbalance
        );

        return patient.toString();
    }
}