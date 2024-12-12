package POM_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DeleteAccountPage {
    WebDriver driver;
//    By deleteAccountButton = By.xpath("//a[@href='/delete_account']");
    By accountDeletedAlert = By.xpath("//h2[@data-qa='account-deleted']");

    public DeleteAccountPage(WebDriver driver) {
        this.driver = driver;
    }
//    public DeleteAccountPage deleteAccount() {
//        driver.findElement(deleteAccountButton).click();
//        return this;
//
//    }

    public DeleteAccountPage validateAccountDeleted() {
        Assert.assertTrue(driver.findElement(accountDeletedAlert).isDisplayed(), "Account deletion alert not displayed.");
        Assert.assertEquals(driver.findElement(accountDeletedAlert).getText(),"ACCOUNT DELETED!", "Account deletion alert not displayed.");
        return this;
    }

}
