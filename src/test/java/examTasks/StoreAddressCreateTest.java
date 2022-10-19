package examTasks;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features/store/createAddressStore.feature",
        publish = true,
        plugin = {"pretty", "html:report/storeResults.html"})

public class StoreAddressCreateTest {

}
