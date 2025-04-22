import java.io.Serializable;

public class PatientMedicalFolder implements Serializable {
    private String patientId;
    private Patient patient;
    private boolean dehydration;
    private boolean medicineOverdose;
    private boolean acidious;
    private boolean cold;
    private boolean cough;
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

    public PatientMedicalFolder(String patientId,
                                String type,
                                double temperature,
                                int heartRate,
                                int pulse,
                                int bpSys,
                                int bpDia,
                                int respiratoryRate,
                                double oxygenSaturation,
                                double ph,
                                String causesRespiratoryImbalance) {
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

    public String getPatientId() {
        return patientId;
    }

    public boolean isAcidious() {
        return acidious;
    }

    public boolean isMedicineOverdose() {
        return medicineOverdose;
    }

    public boolean isDehydration() {
        return dehydration;
    }

    public Patient getPatient() {
        return patient;
    }

    public boolean isCold() {
        return cold;
    }

    public boolean isCough() {
        return cough;
    }

    public String getType() {
        return type;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public int getPulse() {
        return pulse;
    }

    public int getBpSys() {
        return bpSys;
    }

    public int getBpDia() {
        return bpDia;
    }

    public int getRespiratoryRate() {
        return respiratoryRate;
    }

    public double getOxygenSaturation() {
        return oxygenSaturation;
    }

    public double getPh() {
        return ph;
    }

    public String getCausesRespiratoryImbalance() {
        return causesRespiratoryImbalance;
    }
}