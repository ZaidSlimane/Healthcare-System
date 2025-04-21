import java.io.Serializable;

public class Alert implements Serializable {

    public enum AlertType {
        NORMAL,
        CRITICAL
    }

    private Patient patient;
    private AlertType type;

    public Alert(Patient patient, AlertType type) {
        this.patient = patient;
        this.type = type;
    }

    public Patient getPatient() {
        return patient;
    }

    public AlertType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Alert for " + patient.getName() + ": " + type;
    }
}
