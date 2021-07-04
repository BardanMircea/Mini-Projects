package SkyResort;

public class Main {
    public static void main(String[] args) {
        Resort resort = new Resort();

        SkyLift skyLift = new SkyLift(3);
        resort.addSkyLift(skyLift);


        Customer customer1 = new Customer("Ana");
        Customer customer2 = new Customer("Adi");

        RegisteredCustomer registeredCustomer1 = resort.registerAndGetYourFirstCard(customer1, 5);
        RegisteredCustomer registeredCustomer2 = resort.registerAndGetYourFirstCard(customer2, 50);

        System.out.println(registeredCustomer1.getCard().getPoints());

        registeredCustomer1.useCardForALift(skyLift);
        System.out.println(registeredCustomer1.getCard().getPoints());

        registeredCustomer1.topUpCard(10);
        System.out.println(registeredCustomer1.getCard().getPoints());

        resort.emmitNewCard(registeredCustomer1,25);
        System.out.println(registeredCustomer1.getCard().getPoints());

        resort.returnCard(registeredCustomer1);
        System.out.println( registeredCustomer1.ownsValidCard());
    }
}
