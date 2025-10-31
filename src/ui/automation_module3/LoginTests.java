package ui.automation_module3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class LoginTests {
    WebDriver driver;
    LoginPage loginPage;
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void checkPageTitle() {
        String title = driver.getTitle();
        System.out.println("Заголовок сторінки: " + title);
        Assert.assertTrue(title.contains("Swag Labs"));
    }

    @Test(priority = 2)
    public void checkLoginFields() {
        softAssert.assertTrue(loginPage != null, "Сторінка логіну не ініціалізована");
        softAssert.assertAll();
    }

    @Test(dataProvider = "loginData", priority = 3)
    public void checkLoginData(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"", "secret_sauce"},
                {"standard_user", ""}
        };
    }
}