public class Main {

    public static void main(String[] args) {
        Contact contact1 = new Contact("adi", "pop", "123465789123");
        Contact contact2 = new Contact("ana", "Popa","123469889123");
        Contact contact3 = new Contact("adi", "Man","123465289123");

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addAContact(contact1);
        phoneBook.addAContact(contact2);
        phoneBook.addAContact(contact3);

        phoneBook.displayAllContacts();

        phoneBook.searchForContact("123465");

        phoneBook.deleteContact("Adi");
    }
}
