import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;


public class AutomationProject1 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "/Users/fmirzaev/Documents/Selenium Packages/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php");
        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains("Welcome to Duotify!"));
        driver.findElement(By.id("hideLogin")).click();
        driver.findElement(By.id("username")).sendKeys("fmirzaev");
        driver.findElement(By.id("firstName")).sendKeys("Firdavs");
        driver.findElement(By.id("lastName")).sendKeys("Mirzaev");
        String email = "fmirzaev@yahoo.com";
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("email2")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("Testing12345");
        driver.findElement(By.id("password2")).sendKeys("Testing12345" + Keys.ENTER);
        String actualUrl = driver.getCurrentUrl();
        Thread.sleep(2000);
        assertTrue(actualUrl.contains("http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?"));
        Thread.sleep(2000);
        assertTrue(driver.getPageSource().contains("Firdavs Mirzaev"));
        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Firdavs Mirzaev"));
        Thread.sleep(2000);
        driver.findElement(By.id("FirdavsMirzaev")).click(); // logout
        Thread.sleep(2000);
        String actualUrl2 = driver.getCurrentUrl();
        assertTrue(actualUrl2.contains("http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php"));
        Thread.sleep(2000);
        driver.findElement(By.id("loginUsername")).sendKeys("fmirzaev");
        driver.findElement(By.id("loginPassword")).sendKeys("Testing12345" + Keys.ENTER);
        Thread.sleep(2000);
        System.out.println(driver.getPageSource().contains("You Might Also Like"));
        // 12. Log out once again and verify that you are logged out.
        driver.findElement(By.id("nameFirstAndLast")).click();
        driver.quit();



    }
}
