package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class MobilePage {
    WebDriver driver;
    @FindBy(xpath = "(//input[@title='Qty'])[1]")
    private WebElement updateQuantity;
    @FindBy(xpath = "(//p[@class='item-msg error'])[1]")
    private WebElement errorMsg;
    @FindBy(xpath = "//span[contains(text(),'Empty Cart')]")
    private WebElement emptyCardBtn;

    @FindBy(xpath = "//div[@class='cart-empty']//p[contains(text(),'You have no items in your shopping cart.')]")
    private WebElement cardIsEmptyMsg;

    public MobilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void changeTheQuantity() {
        updateQuantity.clear();
        updateQuantity.sendKeys("1000");
        updateQuantity.sendKeys(Keys.ENTER);
    }
    public boolean isErrorMsgDisplayed() {
        return errorMsg.isDisplayed();
    }

    public void clickEmptyCardBtn() {
        emptyCardBtn.click();
    }
    public boolean isCartEmpty(){
        return cardIsEmptyMsg.isDisplayed();
    }
}
