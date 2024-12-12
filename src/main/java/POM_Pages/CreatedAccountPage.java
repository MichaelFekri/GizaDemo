package POM_Pages;

import Utilities.ElementsAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreatedAccountPage {
    WebDriver driver;

    By accountCreatedAlert = By.xpath("//h2[@class='title text-center']");
    By continueButton = By.xpath("//a[@data-qa='continue-button']");
//    By displayedUserNameIcon = By.xpath("//li/a/b[text()='TestName']");

    public CreatedAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public CreatedAccountPage validateAccountCreated() {
        Assert.assertTrue(driver.findElement(accountCreatedAlert).isDisplayed(), "Account creation alert not displayed.");
        Assert.assertEquals(driver.findElement(accountCreatedAlert).getText(), "ACCOUNT CREATED!", "Account creation alert not displayed.");
        return this;

    }

    public void clickContinueButton() {
//        driver.findElement(continueButton).click();
//        return this;
        ElementsAction.click(driver,continueButton);

    }

//    public CreatedAccountPage validateUserIsLoggedIn(String UserName) {
//        Assert.assertTrue(driver.findElement(displayedUserNameIcon).isDisplayed(), "User is not logged in.");
//        Assert.assertEquals(driver.findElement(displayedUserNameIcon).getText(), UserName, "User is not logged in.");
//        return this;
//
//    }


}
