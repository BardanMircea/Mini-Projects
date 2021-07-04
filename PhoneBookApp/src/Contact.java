import java.util.Objects;

public class Contact {

    private String lastName;
    private String firstName;
    private Address homeAddress;
    private String phoneNumber;


    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new ValidationException("Invalid phone number");
        }
        this.phoneNumber = phoneNumber;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 12) {
            return false;
        }

        try {
            Long.parseLong(phoneNumber);
        } catch (NumberFormatException exception){
            return false;
        }

         return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getLastName(), contact.getLastName()) &&
                Objects.equals(getFirstName(), contact.getFirstName()) &&
                Objects.equals(getHomeAddress(), contact.getHomeAddress()) &&
                Objects.equals(getPhoneNumber(), contact.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLastName(), getFirstName(), getHomeAddress(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return "Contact{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", homeAddress=" + homeAddress +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
