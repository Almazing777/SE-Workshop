import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class DemoTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){

    }

    @AfterMethod
    public void tearUp(){
        driver.quit();
    }

    //TC 1 Existing Email and Password
    @Test
    public void loginSuccessTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Test Case Logic
        driver.get("https://deens-master.now.sh/login");
        driver.findElement(By.cssSelector("#email")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("azat+workshop");
        driver.findElement(By.cssSelector("#password")).sendKeys("Qwerty1!");

        Thread.sleep(400);

        driver.navigate().refresh();

//        Assert.assertTrue(driver.findElement(By.cssSelector("[class*='DesktopDropDownMenu__AvatarWrapper']")).isDisplayed());

        driver.findElement(By.cssSelector("#[data-testid='loginSubmit']")).click();


    }

    //TC 2 Not existing email and password
    @Test
    public void loginNotExistingUser(){
        driver.get("https://deens-master.now.sh/login");
        driver.findElement(By.cssSelector("#email")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("azat+asdasd");
        driver.findElement(By.cssSelector("#password")).sendKeys("asdasdads!");
        Assert.assertTrue(driver.findElement(By.cssSelector("ui.error.message")).isDisplayed());
    }


    //TC3 Empty email and empty password
    @Test
    public void loginEmptyCredentials(){
        driver.get("https://deens-master.now.sh/login");
        driver.findElement(By.cssSelector("#email")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("");
        driver.findElement(By.cssSelector("#password")).sendKeys("");
        Assert.assertTrue(driver.findElement(By.cssSelector("ui.error.message")).isDisplayed());
    }
}
