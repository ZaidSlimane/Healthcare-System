import java.io.Serializable;
import java.time.LocalDate;

public class Patient implements Serializable {
    private int id;
    private String name;
    private String gender;
    private String address;
    private int age;
    private LocalDate birthday;
    private String etatCivil;

    public Patient(int id, String name, String gender, String address, int age, LocalDate birthday, String etatCivil) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
        this.birthday = birthday;
        this.etatCivil = etatCivil;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getAddress() { return address; }
    public int getAge() { return age; }
    public LocalDate getBirthday() { return birthday; }
    public String getEtatCivil() { return etatCivil; }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", etatCivil='" + etatCivil + '\'' +
                '}';
    }
}
