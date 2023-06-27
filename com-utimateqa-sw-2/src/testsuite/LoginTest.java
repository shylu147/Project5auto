package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl="https://courses.ultimateqa.com/";
    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfully(){
        driver.findElement(By.xpath("//li[@class ='header__nav-item header__nav-sign-in']")).click();

        driver.findElement(By.id("user[email]")).sendKeys("shy@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("shy123");
        String expectedMessage="Welcome Back!";
        String actualMessage= driver.findElement(By.tagName("h2")).getText();
        System.out.println(actualMessage);
        Assert.assertEquals("Welcome message not displayed",expectedMessage,actualMessage);

    }
    @Test
    public void verifyTheErrorMessage(){

        driver.findElement(By.xpath("//li[@class ='header__nav-item header__nav-sign-in']")).click();
        driver.findElement(By.id("user[email]")).sendKeys("shy@gmai.com");
        driver.findElement(By.id("user[password]")).sendKeys("shy123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedMessage="Invalid email or password.";
        String actualMessage= driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        System.out.println(actualMessage);

        Assert.assertEquals("Welcome message not displayed",expectedMessage,actualMessage);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
