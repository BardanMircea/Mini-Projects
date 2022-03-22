package SkiResort;

public class RegisteredCustomer extends Customer {
    private String emailAddress;
    private Card card;


    public RegisteredCustomer(String name, Card card) {
        super(name);
        this.card = card;
    }


    public void setCard(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void topUpCard(int amount) {

        switch (amount) {
            case 5, 10, 15, 25, 50 -> card.setPoints(card.getPoints() + amount);
            default -> throw new ValidationException("Only 5, 10, 15, 25 or 50 values accepted");
        };


    }

    public boolean ownsValidCard() {
        return card.active;
    }

    public void useCardForALift(SkiLift skiLift) {
        if (ownsValidCard()){
            card.setPoints(card.getPoints() - skiLift.getCost());
            return;
        }
        System.out.println("SkyResort.Card has been returned and is no longer active.");
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "SkiResort.RegisteredCustomer{" +
                "emailAddress='" + emailAddress + '\'' +
                ", card=" + card +
                '}';
    }
}
