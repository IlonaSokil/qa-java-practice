package ui.automation_module3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void checkPageTitle() {
        String title = driver.getTitle();
        System.out.println("Заголовок сторінки: " + title);

        Assert.assertTrue(title.contains("Swag Labs"));
    }

    @Test
    public void checkLocators() {
        checkElement(By.id("user-name"), "ID: user-name");

        checkElement(By.className("submit-button"), "ClassName: submit-button");

        checkElement(By.xpath("//input[@id='password']"), "XPath: //input[@id='password']");

        checkElement(By.cssSelector(".login_logo"), "CSS Selector: .login_logo");
    }

    private void checkElement(By locator, String description) {
        try {
            WebElement element = driver.findElement(locator);
            if (element.isDisplayed()) {
                System.out.println("Елемент знайдено → " + description);
            }
        } catch (Exception e) {
            System.out.println("Елемент НЕ знайдено → " + description);
            Assert.fail("Елемент не знайдено: " + description);
        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}