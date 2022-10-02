package cucomber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features/hotel/createAddress.feature",
        plugin = {"pretty","html:report/hotelResults.html"}
)
public class AddressCreateTest {

}
