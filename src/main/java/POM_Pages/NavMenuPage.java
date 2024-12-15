package POM_Pages;

import Utilities.ElementsAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NavMenuPage {
    WebDriver driver;

    public NavMenuPage(WebDriver driver) {
        this.driver = driver;
    }


    By logoImage = By.xpath("//img[@alt='Website for automation practice']");
    By homeButton = By.xpath("//a[i[@class='fa fa-home']]");

    By loginButton = By.xpath("//a[@href='/login']");

    By deleteAccountButton = By.xpath("//a[@href='/delete_account']");

    By displayedUserNameIcon = By.xpath("//li/a/b");

    public NavMenuPage ValidateHomePageLoaded() {
        Assert.assertTrue(driver.findElement(logoImage).isDisplayed(), "Logo not displayed.");
        Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Incorrect Page Title");
        Assert.assertTrue(driver.getCurrentUrl().contains("automation"), "Incorrect URL");
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/", "URL Doesn't match");
        Assert.assertTrue(driver.findElement(homeButton).isDisplayed(), "Home button not displayed.");
        return this;
    }

    public void NavigateToSignUpPage() {
//        driver.findElement(loginButton).click();
//        return this;
        ElementsAction.click(driver,loginButton);
    }

    public void deleteAccount() {
//        driver.findElement(deleteAccountButton).click();
//        return this;
        ElementsAction.click(driver,deleteAccountButton);

    }

    public NavMenuPage validateUserIsLoggedIn(String UserName) {
        Assert.assertTrue(driver.findElement(displayedUserNameIcon).isDisplayed(), "User is not logged in.");
        Assert.assertEquals(driver.findElement(displayedUserNameIcon).getText(), UserName, "User is not logged in.");
        return this;
    }


}
