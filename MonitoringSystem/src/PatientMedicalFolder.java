import java.io.Serializable;

public class PatientMedicalFolder implements Serializable {

    private Patient patient;
    private boolean dehydration;
    private boolean medicineOverdose;
    private boolean acidious;
    private boolean cold;
    private boolean cough;
    private int type;
    private double temperature;
    private int heartRate;
    private int pulse;
    private int bpSys;
    private int bpDia;
    private int respiratoryRate;
    private double oxygenSaturation;
    private double pH;
    private String causesRespiratoryImbalance;

    public PatientMedicalFolder(Patient patient,
                                boolean dehydration,
                                boolean medicineOverdose,
                                boolean acidious,
                                boolean cold,
                                boolean cough,
                                int type,
                                double temperature,
                                int heartRate,
                                int pulse,
                                int bpSys,
                                int bpDia,
                                int respiratoryRate,
                                double oxygenSaturation,
                                double pH,
                                String causesRespiratoryImbalance) {
        this.patient = patient;
        this.dehydration = dehydration;
        this.medicineOverdose = medicineOverdose;
        this.acidious = acidious;
        this.cold = cold;
        this.cough = cough;
        this.type = type;
        this.temperature = temperature;
        this.heartRate = heartRate;
        this.pulse = pulse;
        this.bpSys = bpSys;
        this.bpDia = bpDia;
        this.respiratoryRate = respiratoryRate;
        this.oxygenSaturation = oxygenSaturation;
        this.pH = pH;
        this.causesRespiratoryImbalance = causesRespiratoryImbalance;
    }

    public Patient getPatient() {
        return patient;
    }

    // ✅ Retourne l'id de type int
    public int getPatientId() {
        return patient != null ? patient.getId() : -1;  // -1 peut signifier "non défini"
    }

    // Autres getters (inchangés)
    public boolean isDehydration() { return dehydration; }
    public boolean isMedicineOverdose() { return medicineOverdose; }
    public boolean isAcidious() { return acidious; }
    public boolean isCold() { return cold; }
    public boolean isCough() { return cough; }
    public int getType() { return type; }
    public double getTemperature() { return temperature; }
    public int getHeartRate() { return heartRate; }
    public int getPulse() { return pulse; }
    public int getBpSys() { return bpSys; }
    public int getBpDia() { return bpDia; }
    public int getRespiratoryRate() { return respiratoryRate; }
    public double getOxygenSaturation() { return oxygenSaturation; }
    public double getpH() { return pH; }
    public String getCausesRespiratoryImbalance() { return causesRespiratoryImbalance; }

    @Override
    public String toString() {
        return "PatientMedicalFolder{" +
                "patientId=" + getPatientId() +
                ", dehydration=" + dehydration +
                ", medicineOverdose=" + medicineOverdose +
                ", acidious=" + acidious +
                ", cold=" + cold +
                ", cough=" + cough +
                ", type=" + type +
                ", temperature=" + temperature +
                ", heartRate=" + heartRate +
                ", pulse=" + pulse +
                ", bpSys=" + bpSys +
                ", bpDia=" + bpDia +
                ", respiratoryRate=" + respiratoryRate +
                ", oxygenSaturation=" + oxygenSaturation +
                ", pH=" + pH +
                ", causesRespiratoryImbalance='" + causesRespiratoryImbalance + '\'' +
                '}';
    }
}
