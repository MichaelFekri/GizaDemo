package POM_Pages;

//import Utilities.ElementActions;
import Utilities.ElementsAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;

    By logoImage = By.xpath("//img[@alt='Website for automation practice']");
    By homeButton = By.xpath("//a[i[@class='fa fa-home']]");
//    By loginButton = By.xpath("//a[@href='/login']");
    By newUserHeading = By.xpath("(//h2)[3]");
    By inputUserName = By.xpath("//input[@name='name']");
    By inputUserEmail = By.xpath("//input[@data-qa='signup-email']");
    By signUpButton = By.xpath("//button[@data-qa='signup-button']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage NavigateToHomePage()
    {
        driver.get("https://automationexercise.com/");
        return this;
    }
//    public HomePage ValidateHomePageLoaded() {
//        Assert.assertTrue(driver.findElement(logoImage).isDisplayed(), "Logo not displayed.");
//        Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Incorrect Page Title");
//        Assert.assertTrue(driver.getCurrentUrl().contains("automation"), "Incorrect URL");
//        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/","URL Doesn't match");
//        Assert.assertTrue(driver.findElement(homeButton).isDisplayed(), "Home button not displayed.");
//        return this;
//    }
//
//    public HomePage NavigateToSignUpPage() {
//        driver.findElement(loginButton).click();
//        return this;
//
//    }

    public HomePage ValidateNewUserHeader() {
        Assert.assertTrue(driver.findElement(newUserHeading).isDisplayed(), "New User heading not displayed.");
        return this;

    }

    public HomePage PerformSignUp(String username, String email) {
        driver.findElement(inputUserName).sendKeys(username);
        driver.findElement(inputUserEmail).sendKeys(email);
        return this;

    }

    public void ClickOnSignUpButton() {
//        driver.findElement(signUpButton).click();
////        ElementActions.click(signUpButton);
//        return this;
         ElementsAction.click(driver,signUpButton);
    }


}
