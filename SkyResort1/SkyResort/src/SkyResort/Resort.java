package SkyResort;

import java.util.ArrayList;
import java.util.List;

public class Resort {

    List<RegisteredCustomer> registeredCustomers = new ArrayList<>();
    List<SkyLift> skyLifts = new ArrayList<>();


    public void addSkyLift(SkyLift skyLift) {
        skyLifts.add(skyLift);
    }

    public List<SkyLift> getSkiLifts() {
        return skyLifts;
    }

    public RegisteredCustomer registerAndGetYourFirstCard(Customer customer, int points) {

        return new RegisteredCustomer(customer.getName(), generateNewCard(customer,points));
    }

    public void emmitNewCard(RegisteredCustomer registeredCustomer, int points) {
        if (registeredCustomer.ownsValidCard()) {
            returnCard(registeredCustomer);
        }
        registeredCustomer.setCard(generateNewCard(registeredCustomer, points));

    }

    private Card generateNewCard(Customer customer, int points) {

        int extraPoints = 0;

        if (customer instanceof RegisteredCustomer) {
            extraPoints += ((RegisteredCustomer) customer).getCard().getPoints();
        }

        return switch (points) {
            case 5, 10, 15, 25, 50 -> new Card(points, extraPoints);
            default -> throw new ValidationException("Only 5, 10, 15, 25 or 50 values accepted");
        };
    }


    public void returnCard(RegisteredCustomer customer) {
        customer.getCard().active = false;
    }

    @Override
    public String toString() {
        return "SkyResort.Resort{" +
                "registeredCustomers=" + registeredCustomers +
                ", skyLifts=" + skyLifts +
                '}';
    }
}
