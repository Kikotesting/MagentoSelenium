package scenarios;

import base.BaseTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.HomePage;
import pages.LoginPage;
import reports.ListenerTest;
import utils.ProductDetails;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(ListenerTest.class)
public class ProductTests extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    ProductDetails productDetails;

}
