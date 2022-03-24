import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

abstract public class AfterTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void startBrowser() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {

        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //страница должна загрузиться в течении 10 сек.
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);  //время взаимодействия с элементами
        AbstractPage.setDriver(driver);
    }

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterEach
    public void onTestFailure() {
        makeScreenshot();
    }

    @AfterEach
    public void tearsFall() {
        driver.close();
        driver.quit();
    }
}