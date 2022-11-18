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
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;


import java.util.List;
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
        System.setProperty("https.protocols", "TLSv1.1");
    }

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // it's new
    @AfterEach
    public void tearDown() {
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();

        if (allLogRows.size() > 0) {
            System.out.println("IT's FAIL!!!!!!");
        }
    }
    // it's new

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
