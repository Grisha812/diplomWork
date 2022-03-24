import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntrantPage extends AbstractPage{

    @FindBy (xpath = "//div[@class='unit-30 top-left-block']//a[1]//img[1]")
    private WebElement entrant;
    @FindBy (xpath = "//span[contains(text(),'Учись в политехе')]")
    private WebElement studying;
    @FindBy (xpath = "//span[contains(text(),'Выбор специальности')]")
    private WebElement change;
    @FindBy (xpath = "//span[contains(text(),'Прием 2022')]")
    private WebElement reception;
    @FindBy (xpath = "//span[contains(text(),'Контакты')]")
    private WebElement contains;

    //title каждой вкладки
    @FindBy(xpath = "//img[@alt='ВолгГТУ']")
    private WebElement entrantTitle;
    @FindBy(xpath = "//h1[contains(text(),'Учись в политехе')]")
    private WebElement studyingTitle;
    @FindBy(xpath = "//h1[contains(text(),'Выбор подразделения университета')]")
    private WebElement changeTitle;
    @FindBy(xpath = "//h1[contains(text(),'Прием в политех')]")
    private WebElement receptionTitle;
    @FindBy(xpath = "//h1[contains(text(),'Контактная информация')]")
    private WebElement containsTitle;

    public EntrantPage() {
        driver.get("https://www.vstu.ru/");
        PageFactory.initElements(driver, this);
    }
    public EntrantPage abiturient() {
        entrant.click();
        String title = driver.getTitle();
        Assertions.assertEquals(title, "Направления подготовки бакалавриата/специалитета");
        studying.click();
        Assertions.assertEquals("Учись в политехе", studyingTitle.getText());
        change.click();
        Assertions.assertEquals("Выбор подразделения университета", changeTitle.getText());
        reception.click();
        Assertions.assertEquals("Прием в политех", receptionTitle.getText());
        contains.click();
        Assertions.assertEquals("Контактная информация", containsTitle.getText());
        return this;
    }
}
