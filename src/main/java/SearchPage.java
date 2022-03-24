
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//span[@class='sb-icon-search']")
    private WebElement search;
    @FindBy(xpath = "//input[@id='search']")
    private WebElement inputSearch;

    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    public void findWord(String inputWord) {
        search.click();
        inputSearch.sendKeys(inputWord, Keys.ENTER);
    }
}
