package faker;

import net.datafaker.Faker;

import java.util.Locale;

public class FakeData {
    Faker faker = new Faker();

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCapital() {
        return capital;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private String firstname = faker.name().firstName();
    private String lastname = faker.name().lastName();
    private String emailAddress = faker.internet().emailAddress().toLowerCase(Locale.ROOT);
    private String streetAddress = faker.address().streetAddress().toLowerCase(Locale.US);
    private String capital = faker.country().capital().toLowerCase(Locale.US);
    private String postcode = faker.address().zipCode();
    private String phoneNumber = faker.phoneNumber().phoneNumberNational();

}
