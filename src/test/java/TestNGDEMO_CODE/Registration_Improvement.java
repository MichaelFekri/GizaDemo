package TestNGDEMO_CODE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Registration_Improvement {
    WebDriver D;

    @BeforeClass
    public void Setup() {
        D = new ChromeDriver();
        D.get("https://automationexercise.com/");
        D.manage().window().maximize();
    }

    @Test
    public void HomePage() {

        if (D.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed()) {
            System.out.println("Page Loaded");
        } else
            System.out.println("Page Not Loaded");
        Assert.assertTrue(D.findElement(By.xpath("//a[i[@class='fa fa-home']]")).isDisplayed(),"Home Page isn't Displayed");

        D.findElement(By.xpath("//a[@href='/login']")).click();
        D.findElement(By.xpath("(//h2)[3]")).isDisplayed();
        Assert.assertTrue(D.findElement(By.xpath("(//h2)[3]")).isDisplayed(),"New User Signup isn't displayed");

        D.findElement(By.xpath("//input[@name='name']")).sendKeys("TestName");
        D.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("TestMail@gmail.com");
        D.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
    }

    @Test(dependsOnMethods = "HomePage")
    public void Register_Page() {

        //D.findElement(By.xpath("//h2[b[text()='Enter Account Information']]")).isDisplayed();
            //D.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).isDisplayed();
        D.findElement(By.xpath("//h2[@class='title text-center' and b[text()='Enter Account Information']]")).isDisplayed();
        Assert.assertTrue(D.findElement(By.xpath("//h2[@class='title text-center' and b[text()='Enter Account Information']]")).isDisplayed(),"Enter Account Information isn't Displayed");

        //String Account_Information = D.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).getText();
        //String Account_Information = D.findElement(By.xpath("//h2[b[text()='Enter Account Information']]")).getText();
        String Account_Information = D.findElement(By.xpath("//h2[b[text()='Enter Account Information']]")).getText();
        Assert.assertEquals(Account_Information, "ENTER ACCOUNT INFORMATION", "Account information isn't displayed");

        D.findElement(By.id("id_gender1")).click();


        D.findElement(By.id("password")).sendKeys("TestPassword");


        new Select(D.findElement(By.id("days"))).selectByValue("21");
        new Select(D.findElement(By.id("months"))).selectByValue("3");
        new Select(D.findElement(By.id("years"))).selectByValue("2000");


        WebElement check = D.findElement(By.id("newsletter"));
        Actions actions = new Actions(D);
        actions.moveToElement(check).perform();
        check.click();

        D.findElement(By.id("optin")).click();
        D.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("first name");
        D.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("last name");
        D.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("company name");
        D.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("address name");
        D.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("address2 name");

        new Select(D.findElement(By.id("country"))).selectByValue("Canada");

        D.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("state name");
        D.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("city name");
        D.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("123123");
        D.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("123123");

        D.findElement(By.xpath("//button[@data-qa='create-account']")).click();
    }

    @Test(dependsOnMethods = "Register_Page")
    public void Verify_RegisteredUser() {
        Assert.assertTrue(D.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed(),"Account isn't created");
        D.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        Assert.assertTrue(D.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed(),"user name isn't displayed");

    }

    @Test(dependsOnMethods = "Verify_RegisteredUser")
    public void Delete_Account() {
        D.findElement(By.xpath("//a[@href='/delete_account']")).click();
        Assert.assertTrue(D.findElement(By.xpath("//h2[@data-qa='account-deleted']")).isDisplayed(),"Account isn't deleted");
        D.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
    }

    @AfterClass
    public void TearDown() {
        D.close();
    }
}
