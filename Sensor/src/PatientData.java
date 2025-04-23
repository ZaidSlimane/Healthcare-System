public  class PatientData {
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

    public String getPatientId() { return patientId; }
    public String getType() { return type; }
    public double getTemperature() { return temperature; }
    public int getHeartRate() { return heartRate; }
    public int getPulse() { return pulse; }

    @Override
    public String toString() {
        return "PatientData{" +
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
                '}';
    }

    public int getBpSys() { return bpSys; }
    public int getBpDia() { return bpDia; }
    public int getRespiratoryRate() { return respiratoryRate; }
    public double getOxygenSaturation() { return oxygenSaturation; }
    public double getPh() { return ph; }
    public String getCausesRespiratoryImbalance() { return causesRespiratoryImbalance; }
}
