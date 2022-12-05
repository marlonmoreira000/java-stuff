import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Contact {
    private String name;
    private String birthDate;
    private String phoneNumber;
    private int age;

    public Contact(String name, String birthDate, String phoneNumber) throws ParseException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("phone number cannot be null or empty");
        }
        if (phoneNumber.length() < 5) {
            throw new IllegalArgumentException("phone number has to be at leat 5 digits");
        }
        this.name = name;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.age = toAge(birthDate);
    }

    public Contact(Contact source) throws ParseException {
        this.name = source.name;
        this.birthDate = source.birthDate;
        this.phoneNumber = source.phoneNumber;
        this.age = toAge(source.birthDate);
    }

    // calculate a person's age using their birth date
    public int toAge(String birthDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        long birthTime = formatter.parse(birthDate).getTime();
        long currentTime = new Date().getTime();
        long diff = currentTime - birthTime;
        int age = (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365);
        return age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        this.name = name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = birthDate;
        setAge(toAge(birthDate));
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("phone number cannot be null or empty");
        }
        if (phoneNumber.length() < 5) {
            throw new IllegalArgumentException("phone number has to be at leat 5 digits");
        }
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n" +
                "Phone number: " + this.phoneNumber + "\n" +
                "Birth Date: " + this.birthDate + "\n" +
                "Age: " + this.age + " year old\n";
    }
}
