import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "(//span[contains(text(),'Студенту')])[2]")
    private WebElement menuStud;
    @FindBy(xpath = "//ul[@class='submenu']//a[contains(text(),'Файловое хранилище')]")
    private WebElement fileSave;
    @FindBy(xpath = "//input[@id='edit-name']")
    private WebElement login;
    @FindBy(xpath = "//input[@id='edit-pass']")
    private WebElement pass;
    @FindBy(xpath = "//input[@id='edit-submit-1']")
    private WebElement enter;
    @FindBy(xpath = "//a[contains(text(),'Факультет подготовки и переподготовки инженерных к')]")
    private WebElement fpic;
    @FindBy(xpath = "//a[contains(text(),'Выйти')]")
    private WebElement exit;
    @FindBy(xpath = "//a[contains(text(),'Файловое хранилище ВолгГТУ')]")
    private WebElement inStorage;
    @FindBy(xpath = "//h2[contains(text(),'Факультет подготовки и переподготовки инженерных к')]")
    private WebElement secondTitle;
    @FindBy(xpath = "//div[@class='messages error']")
    private WebElement messageError;
    @FindBy(xpath = "//div[@class='messages error']")
    private WebElement messageErrorTwo;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void auth (String name, String password) {

        Actions actions = new Actions(driver);
        actions.moveToElement(menuStud).build().perform();
        fileSave.click();
        login.sendKeys(name);
        pass.sendKeys(password);
        enter.click();
        fpic.click();
        Assertions.assertEquals("Факультет подготовки и переподготовки инженерных кадров", secondTitle.getText());
        exit.click();

        return;
    }
    public void negativeLog (String name) {

        login.sendKeys(name);
        enter.click();
        messageError.isDisplayed();
        driver.get("http://dump.vstu.ru/main?destination=node%2F1");
        driver.navigate().refresh();
    }
    public void negativePass (String password) {

        pass.sendKeys(password);
        enter.click();
        messageErrorTwo.isDisplayed();
    }
}
