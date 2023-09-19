package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListPage {
    WebDriver driver;
    public ListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "(//span[contains(text(),'Add to Cart')])[1]")private WebElement addSony;
    public void addSonyToCart(){
        addSony.click();
    }
}
