import java.util.*;

public class PhoneBook {

    private final List<Contact> contactList = new ArrayList<>();


    public void displayAllContacts() {
        System.out.println();
        System.out.println("Contacts List:");
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
        System.out.println();
    }

    public void addAContact(Contact contact) {
        contact.setFirstName(contact.getFirstName().trim().toLowerCase());
        contact.setLastName(contact.getLastName().trim().toLowerCase());
        contactList.add(contact);
    }

    public void searchForContact(String nameOrPhoneNumber) {
        List<Contact> found = getContactsBy(nameOrPhoneNumber);

        displayFoundContact(found);
    }

    public void deleteContact(String nameOrPhoneNumber) {
        List<Contact> found = getContactsBy(nameOrPhoneNumber);

        if (isListEmpty(found)) return;

        displayFoundContact(found);

        if (found.size() == 1) {
            contactList.remove(found.get(0));
            System.out.println("Contact deleted.");
        } else { multipleChoiceDelete(found);}

        displayAllContacts();
    }

    private boolean isListEmpty(List<Contact> list) {
        if (list.isEmpty()) {
            System.out.println("No contact found.");
            return true;
        }
        return false;
    }

    private void displayFoundContact(List<Contact> found) {
        if (isListEmpty(found)) return;

        System.out.println("Contact(s) found: ");
        int i = 1;
        for(Contact contact : found) {
            System.out.println(i + "." + contact);
            i++;
        }
    }

    private List<Contact> getContactsBy(String nameOrPhoneNumber) {
        nameOrPhoneNumber = nameOrPhoneNumber.trim().toLowerCase();

        List<Contact> found = new ArrayList<>();
        for(Contact contact : contactList) {
            if (contact.getFirstName().equals(nameOrPhoneNumber) ||
                contact.getLastName().equals(nameOrPhoneNumber) ||
                contact.getPhoneNumber().contains(nameOrPhoneNumber)) {

                found.add(contact);
            }
        }
        return found;
    }

    private void multipleChoiceDelete(List<Contact> found) {
        System.out.println("Multiple contact entries found. To delete first - enter (1), to delete second - enter (2) etc. " +
                           "To delete all - enter (*). Any other input to cancel.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (inputNotANumber(found, input)) return;

        handleNumericalInput(found, input);
    }

    private void handleNumericalInput(List<Contact> found, String input) {
        if (Integer.parseInt(input) > 0 && Integer.parseInt(input) < found.size() ){
            Iterator<Contact> iterator = contactList.iterator();
            for(Contact contact : contactList) {
                iterator.next();
                if (contact.equals(found.get(Integer.parseInt(input) - 1))) {
                    iterator.remove();
                    break;
                }
            }
        } else {
            System.out.println("Operation cancelled.");
            return;
        }

        System.out.println("Contact deleted.");
    }

    private boolean inputNotANumber(List<Contact> found, String input) {
        try  {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            if (input.equals("*")) {
                contactList.removeAll(found);
                System.out.println("Contacts deleted");
            } else {
                System.out.println("Operation cancelled.");
            }
            return true;
        }
        return false;
    }
}
