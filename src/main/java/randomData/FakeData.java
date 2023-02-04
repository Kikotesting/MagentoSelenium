package randomData;

import net.datafaker.Faker;

import java.util.Locale;

public class FakeData {
    Faker faker = new Faker();
    public String firstname = faker.name().firstName();
    public String lastname = faker.name().lastName();
    public String emailAddress = faker.internet().emailAddress().toLowerCase(Locale.ROOT);

}
