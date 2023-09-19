package StepsDefinitions;

import Pages.HomePage;
import Pages.ListPage;
import Pages.MobilePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Steps {
    WebDriver driver;
    HomePage home;
    ListPage list;
    MobilePage mobile;
    String url;

    @Before
    public void beforeRun() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        home = new HomePage(driver);
        list = new ListPage(driver);
        mobile = new MobilePage(driver);
        url = "http://live.techpanda.org/index.php/";
    }

    @After
    public void afterRun() {
        driver.quit();
    }

    @Given("navigate to the site")
    public void navigate_to_the_site() {
        driver.navigate().to(url);
    }

    @And("click on mobile menu")
    public void click_on_mobile_menu() {
        home.clickMobile();
    }

    @When("in the menu click add sony to cart")
    public void in_the_menu_click_add_sony_to_cart() {
        list.addSonyToCart();
    }

    @And("change the quantity value to {int} and update it")
    public void change_the_quantity_value_to_and_update_it(Integer int1) {
        mobile.changeTheQuantity();
    }

    @Test(description = "verifying if the error msg displayed or not")
    @And("verify the error msg")
    public void verify_the_error_msg() {
        boolean status = mobile.isErrorMsgDisplayed();
        Assert.assertTrue(status);
    }

    @Then("click empty card")
    public void click_empty_card() {
        mobile.clickEmptyCardBtn();
    }

    @Test(description = "verifying if the card is empty msg displayed or not")
    @And("verify card is empty")
    public void verify_card_is_empty() {
       boolean isEmpty = mobile.isCartEmpty();
       Assert.assertTrue(isEmpty);
    }

}
