package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class browserActions {
    static WebDriver driver;

    public static WebDriver Webactions(String browser, boolean maximize) {

        if (browser.equalsIgnoreCase("chrome")) {
            System.out.println("Chrome Driver initialized");
            driver = new ChromeDriver();
            System.out.println("Chrome Driver Opened");
        } else if (browser.equalsIgnoreCase("edge")) {
            System.out.println("Edge Driver initialized");
            driver = new EdgeDriver();
            System.out.println("Edge Driver Opened");
        }

        if (maximize) {
            System.out.println("Window maximized");
            driver.manage().window().maximize();
            System.out.println(driver.manage().window().getSize());
        } else {
            System.out.println("Window isn't maximized");
            System.out.println(driver.manage().window().getSize());
        }
        return driver;
    }

}
