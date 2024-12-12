package DemoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo2 {
    WebDriver driver;

    private By logoImage = By.xpath("//img[@alt='Website for automation practice']");
    private By homeButton = By.xpath("//a[i[@class='fa fa-home']]");
    private By loginButton = By.xpath("//a[@href='/login']");
    private By newUserHeading = By.xpath("(//h2)[3]");
    private By inputUserName = By.xpath("//input[@name='name']");
    private By inputUserEmail = By.xpath("//input[@data-qa='signup-email']");
    private By signUpButton = By.xpath("//button[@data-qa='signup-button']");
    private By accountInformationHeading = By.xpath("(//h2[@class='title text-center'])[1]");
    private By genderMaleRadioButton = By.id("id_gender1");
    private By genderFemaleRadioButton = By.id("id_gender2");
    private By inputUserPassword = By.id("password");
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By specialOffersCheckbox = By.id("optin");
    private By inputFirstName = By.xpath("//input[@data-qa='first_name']");
    private By inputLastName = By.xpath("//input[@data-qa='last_name']");
    private By inputCompanyName = By.xpath("//input[@data-qa='company']");
    private By inputAddressLine1 = By.xpath("//input[@data-qa='address']");
    private By inputAddressLine2 = By.xpath("//input[@data-qa='address2']");
    private By countryDropdown = By.id("country");
    private By inputState = By.xpath("//input[@data-qa='state']");
    private By inputCity = By.xpath("//input[@data-qa='city']");
    private By inputZipCode = By.xpath("//input[@data-qa='zipcode']");
    private By inputMobileNumber = By.xpath("//input[@data-qa='mobile_number']");
    private By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    private By accountCreatedAlert = By.xpath("//h2[@class='title text-center']");
    private By continueButton = By.xpath("//a[@data-qa='continue-button']");
    private By displayedUserNameIcon = By.xpath("//li/a/b[text()='TestName']");
    private By deleteAccountButton = By.xpath("//a[@href='/delete_account']");
    private By accountDeletedAlert = By.xpath("//h2[@data-qa='account-deleted']");

    private String UserName="TestName";
    private String UserMail="TestMail@gmail.com";
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyUserRegistrationAndDeletion() {

        ///////////////////////////////////
        // Home Page Validation////////////
        validateHomePageLoaded();
        navigateToSignUpPage();
        validateNewUserHeader();
        performSignUp(UserName, UserMail);
        ///////////////////////////////////
        ///////////////////////////////////

        ///////////////////////////////////
        // Registration Page///////////////
        validateRegistrationPageLoaded();
        selectGender("female");
        fillAccountInformation("TestPassword", "21", "3", "2000");
        fillUserDetails("First Name", "Last Name", "Company Name", "Address one",
                "Address two", "Canada", "State", "City", "12345", "1231234567");
        clickCreateAccountButton();
        ///////////////////////////////////
        ///////////////////////////////////

        //////////////////////////////////
        // Account Created Verification//
        validateAccountCreated("ACCOUNT CREATED!");
        clickContinueButton();
        validateUserIsLoggedIn();
        ///////////////////////////////////
        ///////////////////////////////////

        ///////////////////////////////////
        // Account Deletion////////////////
        deleteAccount();
        validateAccountDeleted("ACCOUNT DELETED!");
        clickContinueButton();
        ///////////////////////////////////
        ///////////////////////////////////
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

    private void validateHomePageLoaded() {
        Assert.assertTrue(driver.findElement(logoImage).isDisplayed(), "Logo not displayed.");
        Assert.assertEquals(driver.getTitle(), "Automation Exercise", "Incorrect Page Title");
        Assert.assertTrue(driver.getCurrentUrl().contains("automation"), "Incorrect URL");
        Assert.assertTrue(driver.findElement(homeButton).isDisplayed(), "Home button not displayed.");
    }


    private void navigateToSignUpPage() {
        driver.findElement(loginButton).click();
    }

    private void validateNewUserHeader() {
        Assert.assertTrue(driver.findElement(newUserHeading).isDisplayed(), "New User heading not displayed.");
    }


    private void performSignUp(String username, String email) {
        driver.findElement(inputUserName).sendKeys(username);
        driver.findElement(inputUserEmail).sendKeys(email);
        driver.findElement(signUpButton).click();
    }

    private void validateRegistrationPageLoaded() {
        String headingText = driver.findElement(accountInformationHeading).getText();
        Assert.assertTrue(driver.findElement(accountInformationHeading).isDisplayed(), "Account Information heading not displayed.");
        Assert.assertEquals(headingText, "ENTER ACCOUNT INFORMATION", "Incorrect heading text.");
    }

    private void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(genderMaleRadioButton).click();
        } else if (gender.equalsIgnoreCase("female")) {
            driver.findElement(genderFemaleRadioButton).click();
        }
    }

    private void fillAccountInformation(String password, String day, String month, String year) {
        driver.findElement(inputUserPassword).sendKeys(password);
        new Select(driver.findElement(dayDropdown)).selectByValue(day);
        new Select(driver.findElement(monthDropdown)).selectByValue(month);
        new Select(driver.findElement(yearDropdown)).selectByValue(year);
        driver.findElement(newsletterCheckbox).click();
        driver.findElement(specialOffersCheckbox).click();
    }

    private void fillUserDetails(String firstName, String lastName, String company, String address1,
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
    }

    private void clickCreateAccountButton() {
        driver.findElement(createAccountButton).click();
    }

    private void validateAccountCreated(String ValidationMesseage) {
        Assert.assertTrue(driver.findElement(accountCreatedAlert).isDisplayed(), "Account creation alert not displayed.");
        Assert.assertEquals(driver.findElement(accountCreatedAlert).getText(),ValidationMesseage, "Account creation alert not displayed.");
    }

    private void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    private void validateUserIsLoggedIn() {
        Assert.assertTrue(driver.findElement(displayedUserNameIcon).isDisplayed(), "User is not logged in.");
        Assert.assertEquals(driver.findElement(displayedUserNameIcon).getText(),UserName, "User is not logged in.");

    }

    private void deleteAccount() {
        driver.findElement(deleteAccountButton).click();
    }

    private void validateAccountDeleted(String ValidationMesseage) {
        Assert.assertTrue(driver.findElement(accountDeletedAlert).isDisplayed(), "Account deletion alert not displayed.");
        Assert.assertEquals(driver.findElement(accountDeletedAlert).getText(),ValidationMesseage, "Account deletion alert not displayed.");

    }
}

