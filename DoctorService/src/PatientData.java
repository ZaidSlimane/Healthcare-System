import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PatientData implements Serializable {
    private static final long serialVersionUID = 1L;
    private String patientId;
    private String type;
    private double temperature;
    private int heartRate;
    private int pulse;
    private int bpSys;
    private int bpDia;
    private int respiratoryRate;
    private double oxygenSaturation;
    private double ph;
    private String causesRespiratoryImbalance;
    private String error;


    public PatientData(String patientId, String type, double temperature, int heartRate,
                       int pulse, int bpSys, int bpDia, int respiratoryRate,
                       double oxygenSaturation, double ph, String causesRespiratoryImbalance) {
        this.patientId = patientId;
        this.type = type;
        this.temperature = temperature;
        this.heartRate = heartRate;
        this.pulse = pulse;
        this.bpSys = bpSys;
        this.bpDia = bpDia;
        this.respiratoryRate = respiratoryRate;
        this.oxygenSaturation = oxygenSaturation;
        this.ph = ph;
        this.causesRespiratoryImbalance = causesRespiratoryImbalance;
    }


    public PatientData(String input){
        parsePatientData(input);
    }

    public PatientData() {

    }

    public String getPatientId() { return patientId; }
    public String getType() { return type; }
    public double getTemperature() { return temperature; }
    public int getHeartRate() { return heartRate; }
    public int getPulse() { return pulse; }
    public int getBpSys() { return bpSys; }
    public int getBpDia() { return bpDia; }
    public int getRespiratoryRate() { return respiratoryRate; }
    public double getOxygenSaturation() { return oxygenSaturation; }
    public double getPh() { return ph; }
    public String getCausesRespiratoryImbalance() { return causesRespiratoryImbalance; }
    public String getError() { return error; }

    public PatientData parsePatientData(String input) {
        input = input.substring(input.indexOf("{") + 1, input.lastIndexOf("}")); // supprimer PatientData{...}
        String[] parts = input.split(", (?=[a-zA-Z]+=)"); // séparer chaque champ proprement

        Map<String, String> data = new HashMap<>();
        for (String part : parts) {
            String[] keyValue = part.split("=", 2);
            String key = keyValue[0].trim();
            String value = keyValue[1].trim().replaceAll("'", ""); // enlever les guillemets
            data.put(key, value);
        }

        return new PatientData(
                data.get("patientId"),
                data.get("type"),
                Double.parseDouble(data.get("temperature")),
                Integer.parseInt(data.get("heartRate")),
                Integer.parseInt(data.get("pulse")),
                Integer.parseInt(data.get("bpSys")),
                Integer.parseInt(data.get("bpDia")),
                Integer.parseInt(data.get("respiratoryRate")),
                Double.parseDouble(data.get("oxygenSaturation")),
                Double.parseDouble(data.get("ph")),
                data.get("causesRespiratoryImbalance")
        );
    }

    @Override
    public String toString() {
        return "PatientData_{" +
                "patientId='" + patientId + '\'' +
                ", type='" + type + '\'' +
                ", temperature=" + temperature +
                ", heartRate=" + heartRate +
                ", pulse=" + pulse +
                ", bpSys=" + bpSys +
                ", bpDia=" + bpDia +
                ", respiratoryRate=" + respiratoryRate +
                ", oxygenSaturation=" + oxygenSaturation +
                ", ph=" + ph +
                ", causesRespiratoryImbalance='" + causesRespiratoryImbalance + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
