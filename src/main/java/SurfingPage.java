import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SurfingPage extends AbstractPage {

    @FindBy(xpath = "(//span[contains(text(),'Университет')])[2]")
    private WebElement unit;
    @FindBy(xpath = "(//span[contains(text(),'Образование')])[2]")
    private WebElement education;
    @FindBy(xpath = "(//span[contains(text(),'Наука')])[2]")
    private WebElement science;
    @FindBy(xpath = "(//span[contains(text(),'Развитие')])[2]")
    private WebElement development;
    @FindBy(xpath = "(//span[contains(text(),'Сотрудничество')])[2]")
    private WebElement cooperation;
    @FindBy(xpath = "(//span[contains(text(),'Справочник')])[2]")
    private WebElement reference;
    @FindBy(xpath = "(//img)[15]")
    private WebElement pointBoiling;
    @FindBy(xpath = "(//img)[14]")
    private WebElement supportUnit;
    @FindBy(xpath = "(//span[@class='dis-env'])[1]")
    private WebElement dostupSreda;
    @FindBy(xpath = "(//span[contains(text(),'Версия для слабовидящих')])[1]")
    private WebElement visuallyImpaired;
    @FindBy(xpath = "(//div[contains(text(),'A')])[4]")
    private WebElement white;
    @FindBy(xpath = "(//div[contains(text(),'A')])[5]")
    private WebElement black;
    @FindBy(xpath = "(//div[contains(text(),'A')])[6]")
    private WebElement blue;

    @FindBy(xpath = "//img[@alt='ВолгГТУ']")
    private WebElement main;

    // Title каждой из вкладок
    @FindBy(xpath = "//h1[contains(text(),'Университет сегодня')]")
    private WebElement unitTitle;
    @FindBy(xpath = "//h1[contains(text(),'Образование в ВолгГТУ')]")
    private WebElement educationTitle;
    @FindBy(xpath = "//h1[contains(text(),'Наука в ВолгГТУ')]")
    private WebElement scienceTitle;
    @FindBy (xpath = "//h1[contains(text(),'Вопросы перспективного развития')]")
    private WebElement developmentTitle;
    @FindBy (xpath = "//h1[contains(text(),'Сотрудничество')]")
    private WebElement cooperationTitle;
    @FindBy (xpath = "//h1[contains(text(),'Справочник телефонов')]")
    private WebElement referenceTitle;
    @FindBy (xpath = "//h1[contains(text(),'Пространство коллективной работы «Точка Кипения»')]")
    private WebElement pointTitle;
    @FindBy(xpath = "//h1[contains(text(),'Доступная среда')]")
    private WebElement getDostupSredaTitle;
    @FindBy (xpath = "//h1[contains(text(),'Программа развития университета')]")
    private WebElement supportTitle;

    public SurfingPage() {
        driver.get("https://www.vstu.ru/");
        PageFactory.initElements(driver, this);
    }

    public SurfingPage wallkSite() {

        unit.click();
        Assertions.assertEquals("Университет сегодня", unitTitle.getText());
        education.click();
        Assertions.assertEquals("Образование в ВолгГТУ", educationTitle.getText());
        science.click();
        Assertions.assertEquals("Наука в ВолгГТУ", scienceTitle.getText());
        development.click();
        Assertions.assertEquals("Вопросы перспективного развития", developmentTitle.getText());
        cooperation.click();
        Assertions.assertEquals("Сотрудничество", cooperationTitle.getText());
        reference.click();
        Assertions.assertEquals("Справочник телефонов", referenceTitle.getText());
        pointBoiling.click();
        Assertions.assertEquals("Пространство коллективной работы «Точка Кипения»", pointTitle.getText());
        supportUnit.click();
        Assertions.assertEquals("Программа развития университета", supportTitle.getText());

        dostupSreda.click();
        Assertions.assertEquals("Доступная среда", getDostupSredaTitle.getText());
        visuallyImpaired.click();
        Assertions.assertEquals("Доступная среда", getDostupSredaTitle.getText());
        white.click();

        String colorwall =driver.findElement(By.xpath("//h1[contains(text(),'Доступная среда')]")).getCssValue("color");
        String[] numbers = colorwall.replace("rgba(", "").replace(")", "").split(",");
        int r = Integer.parseInt(numbers[0].trim());
        int g = Integer.parseInt(numbers[1].trim());
        int b = Integer.parseInt(numbers[2].trim());
        String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
        Assertions.assertEquals("#000", hex);

        black.click();

        String colorwall1 =driver.findElement(By.xpath("//div[@class='navigation-wrapper']")).getCssValue("background-color");
        String[] numbers1 = colorwall1.replace("rgba(", "").replace(")", "").split(",");
        int r1 = Integer.parseInt(numbers1[0].trim());
        int g1 = Integer.parseInt(numbers1[1].trim());
        int b1 = Integer.parseInt(numbers1[2].trim());
        String hex1 = "#" + Integer.toHexString(r1) + Integer.toHexString(g1) + Integer.toHexString(b1);
        Assertions.assertEquals("#000", hex1);

        blue.click();
        Assertions.assertEquals("Доступная среда", getDostupSredaTitle.getText());

        String colorwall2 =driver.findElement(By.xpath("//div[@class='navigation-wrapper']")).getCssValue("background-color");
        String[] numbers2 = colorwall2.replace("rgba(", "").replace(")", "").split(",");
        int r2 = Integer.parseInt(numbers2[0].trim());
        int g2 = Integer.parseInt(numbers2[1].trim());
        int b2 = Integer.parseInt(numbers2[2].trim());
        String hex2 = "#" + Integer.toHexString(r2) + Integer.toHexString(g2) + Integer.toHexString(b2);
        Assertions.assertEquals("#63472", hex2);

        visuallyImpaired.click();
        Assertions.assertEquals("Доступная среда", getDostupSredaTitle.getText());

        main.click();
        String title = driver.getTitle();
        Assertions.assertEquals(title, "Волгоградский государственный технический университет");

        return this;
    }
    public SurfingPage checkIcons() {
        WebElement vkLogo = driver.findElement(By.xpath("//img[@src='/bitrix/templates/mfrog/images/vk.svg']"));
        vkLogo.isDisplayed();
        WebElement okLogo = driver.findElement(By.xpath("//img[@class='ok_net']"));
        okLogo.isDisplayed();
        WebElement youLogo = driver.findElement(By.xpath("//img[@src='/bitrix/templates/mfrog/images/youtube.svg']"));
        youLogo.isDisplayed();
        WebElement tlgLogo = driver.findElement(By.xpath("//img[@src='/links/telegram.svg']"));
        tlgLogo.isDisplayed();
        WebElement dsLogo = driver.findElement(By.xpath("//span[@class='dis-env']"));
        dsLogo.isDisplayed();
        WebElement vfbvLogo = driver.findElement(By.xpath("//span[contains(text(),'Версия для слабовидящих')]"));
        vfbvLogo.isDisplayed();
        return this;
    }
}

