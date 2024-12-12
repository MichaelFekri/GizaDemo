package POM_Pages;

import Utilities.ElementsAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {
    WebDriver driver;
    By accountInformationHeading = By.xpath("(//h2[@class='title text-center'])[1]");
    By genderMaleRadioButton = By.id("id_gender1");
    By genderFemaleRadioButton = By.id("id_gender2");
    By inputUserPassword = By.id("password");
    By dayDropdown = By.id("days");
    By monthDropdown = By.id("months");
    By yearDropdown = By.id("years");
    By newsletterCheckbox = By.id("newsletter");
    By specialOffersCheckbox = By.id("optin");
    By inputFirstName = By.xpath("//input[@data-qa='first_name']");
    By inputLastName = By.xpath("//input[@data-qa='last_name']");
    By inputCompanyName = By.xpath("//input[@data-qa='company']");
    By inputAddressLine1 = By.xpath("//input[@data-qa='address']");
    By inputAddressLine2 = By.xpath("//input[@data-qa='address2']");
    By countryDropdown = By.id("country");
    By inputState = By.xpath("//input[@data-qa='state']");
    By inputCity = By.xpath("//input[@data-qa='city']");
    By inputZipCode = By.xpath("//input[@data-qa='zipcode']");
    By inputMobileNumber = By.xpath("//input[@data-qa='mobile_number']");
    By createAccountButton = By.xpath("//button[@data-qa='create-account']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage ValidateRegistrationPageLoaded() {
        String headingText = driver.findElement(accountInformationHeading).getText();
        Assert.assertTrue(driver.findElement(accountInformationHeading).isDisplayed(), "Account Information heading not displayed.");
        Assert.assertEquals(headingText, "ENTER ACCOUNT INFORMATION", "Incorrect heading text.");
        return this;

    }

    public RegistrationPage SelectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(genderMaleRadioButton).click();
        } else if (gender.equalsIgnoreCase("female")) {
            driver.findElement(genderFemaleRadioButton).click();
        }
        return this;

    }

    public RegistrationPage FillAccountInformation(String password, String day, String month, String year) {
        driver.findElement(inputUserPassword).sendKeys(password);
        new Select(driver.findElement(dayDropdown)).selectByValue(day);
        new Select(driver.findElement(monthDropdown)).selectByValue(month);
        new Select(driver.findElement(yearDropdown)).selectByValue(year);
        driver.findElement(newsletterCheckbox).click();
        driver.findElement(specialOffersCheckbox).click();
        return this;
    }

    public RegistrationPage FillUserDetails(String firstName, String lastName, String company, String address1,
                                            String address2, String country, String state, String city,
                                            String zipCode, String mobileNumber) {
        driver.findElement(inputFirstName).sendKeys(firstName);
        driver.findElement(inputLastName).sendKeys(lastName);
        driver.findElement(inputCompanyName).sendKeys(company);
        driver.findElement(inputAddressLine1).sendKeys(address1);
        driver.findElement(inputAddressLine2).sendKeys(address2);
        new Select(driver.findElement(countryDropdown)).selectByValue(country);
        driver.findElement(inputState).sendKeys(state);
        driver.findElement(inputCity).sendKeys(city);
        driver.findElement(inputZipCode).sendKeys(zipCode);
        driver.findElement(inputMobileNumber).sendKeys(mobileNumber);
        return this;

    }

    public void ClickOnCreateAccountButton() {
//        driver.findElement(createAccountButton).click();
//        return this;
        ElementsAction.click(driver,createAccountButton);

    }

}
