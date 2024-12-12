package DemoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Demo {
    public static void main(String[] args) {
        WebDriver D = new ChromeDriver();
        D.get("https://automationexercise.com/");
        D.manage().window().maximize();
        WebElement HomePage = D.findElement(By.xpath("//img[@alt='Website for automation practice']"));

        if(HomePage.isDisplayed())
        {
            System.out.println("Page Loaded");
        }
        else
            System.out.println("Page Not Loaded");

        D.findElement(By.xpath("//a[@href='/login']")).click();

        D.findElement(By.xpath("(//h2)[3]")).isDisplayed();

        D.findElement(By.xpath("//input[@name='name']")).sendKeys("TestName");
        D.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("TestMail@gmail.com");
        D.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        D.findElement(By.xpath("(//h2[@class='title text-center'])[1]")).isDisplayed();

        //D.findElement(By.id("id_gender1")).click();
//        D.findElement(By.xpath("//div[@id='uniform-id_gender2']")).click();

        D.findElement(By.id("password")).sendKeys("TestPassword");

        WebElement DaysMenu =D.findElement(By.id("days"));
        WebElement MonthsMenu =D.findElement(By.id("months"));
        WebElement YearsMenu =D.findElement(By.id("years"));

        Select selectDays = new Select(DaysMenu);
        selectDays.selectByValue("21");

        Select selectMonths = new Select(MonthsMenu);
        selectMonths.selectByValue("3");

        Select selectYears = new Select(YearsMenu);
        selectYears.selectByValue("2000");


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

        WebElement country =D.findElement(By.id("country"));

        Select select_Country = new Select(country);
        select_Country.selectByValue("Canada");

        D.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("state name");
        D.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("city name");
        D.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("123123");
        D.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("123123");

        D.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        D.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed();
        System.out.println(D.findElement(By.xpath("//h2[@class='title text-center']")).getText());

        D.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        D.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed();
        String ayhaga=D.findElement(By.xpath("//li/a/b[text()='TestName']")).getText();
        String kaka=D.findElement(By.xpath("//li/a[contains(text(), 'Logged in as') and .//b[text()='TestName']]")).getText();

        System.out.println(ayhaga);
        System.out.println(kaka);

        D.findElement(By.xpath("//a[@href='/delete_account']")).click();

        String delete= D.findElement(By.xpath("//h2[@data-qa='account-deleted']")).getText();
        System.out.println(delete);
        D.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        D.close();
    }

}
