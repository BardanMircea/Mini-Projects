package SkiResort;

import java.util.ArrayList;
import java.util.List;

public class Resort {

    List<RegisteredCustomer> registeredCustomers = new ArrayList<>();
    List<SkiLift> skiLifts = new ArrayList<>();


    public void addSkyLift(SkiLift skiLift) {
        skiLifts.add(skiLift);
    }

    public List<SkiLift> getSkiLifts() {
        return skiLifts;
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
        return "SkiResort.Resort{" +
                "registeredCustomers=" + registeredCustomers +
                ", skiLifts=" + skiLifts +
                '}';
    }
}
