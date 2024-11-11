package utillity;


import com.thoughtworks.gauge.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver driver;

    @BeforeScenario
    public void setUp() throws InterruptedException {
        String BaseUrl = "https://www.enuygun.com/";
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS).implicitlyWait(10,TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(BaseUrl);
            Thread.sleep(2000);
        }
    }

    @AfterScenario
    public void closeDriver(){
        driver.quit();
        driver = null;
    }
}

