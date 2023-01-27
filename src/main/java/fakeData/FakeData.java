package fakeData;

import net.datafaker.Faker;

import java.util.Locale;

public class FakeData {
    Faker faker = new Faker();
    public String firstname = faker.name().firstName();
    public String lastname = faker.name().lastName();

    public String emailaddress = faker.internet().emailAddress().toLowerCase(Locale.ROOT);
    public String address = faker.address().fullAddress();
}
