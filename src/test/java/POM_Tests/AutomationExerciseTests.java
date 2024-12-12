package POM_Tests;

//import POM_Pages.*;

import POM_Pages.*;
import POM_Pages.HomePage;
import Utilities.PropertiesReader;
import Utilities.browserActions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import Utilities.JsonFileManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AutomationExerciseTests {
    private WebDriver driver;
    private JsonFileManager jm;

    @BeforeClass
    public void Setup() {
        PropertiesReader.loadProperties();
        driver = browserActions.Webactions(System.getProperty("BrowserName"),Boolean.parseBoolean(System.getProperty("WindowMaximize")) );
        jm = new JsonFileManager("src/test/resources/JsonDataFile.json");
        new HomePage(driver)
                .NavigateToHomePage();
    }


    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Main Test Case Runing")
    @Step("3mlna page factory")
public void AutomationExercise_TC1() {

        new NavMenuPage(driver).ValidateHomePageLoaded()
                .NavigateToSignUpPage();

        new HomePage(driver).ValidateNewUserHeader()
                .PerformSignUp(jm.getTestData("UserName"),
                        jm.getTestData("UserMail"))
                .ClickOnSignUpButton();

        new RegistrationPage(driver).ValidateRegistrationPageLoaded()
                .SelectGender(jm.getTestData("AccountInformation.UserGenderMale"))

                .FillAccountInformation(jm.getTestData("AccountInformation.Password"),
                        jm.getTestData("AccountInformation.Day"),
                        jm.getTestData("AccountInformation.Month"),
                        jm.getTestData("AccountInformation.Year"))

                .FillUserDetails(jm.getTestData("AccountInformation.FName"),
                        jm.getTestData("AccountInformation.LName"),
                        jm.getTestData("AccountInformation.Company"),
                        jm.getTestData("AccountInformation.Address1"),
                        jm.getTestData("AccountInformation.Address2"),
                        jm.getTestData("AccountInformation.Country"),
                        jm.getTestData("AccountInformation.State"),
                        jm.getTestData("AccountInformation.City"),
                        jm.getTestData("AccountInformation.ZipCode"),
                        jm.getTestData("AccountInformation.MobileNumber"))
                .ClickOnCreateAccountButton();

        new CreatedAccountPage(driver).validateAccountCreated()
                .clickContinueButton();

        new NavMenuPage(driver).validateUserIsLoggedIn(jm.getTestData("UserName"));
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Main Test Case Runing")
    public void t1() {
        System.out.println("tc1");
    }

    @Test
    @Step("ay haga")
    public void t2() {
        System.out.println("tc2");
    }

    @Test
    public void t3() {
        System.out.println("tc3");
    }


    @AfterClass
    public void TearDown() {

        new NavMenuPage(driver).deleteAccount();
        new DeleteAccountPage(driver).validateAccountDeleted();

        driver.close();
    }
}
