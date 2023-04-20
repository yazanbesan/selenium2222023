import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class SeleTest {
    public WebDriver driver = null;

    @BeforeEach
    public void initializeSelenium() {
        //Config the webdriver.chrome.driver which is a permanent key with the path value
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\coding\\edgedriver_win64 (2)\\.chromedriver.exe");
        //The web driver is an interface. The ChromeDriver inherits the WebDriver.
        //ChromeDriver will open the chrome browser for us.
        driver = new EdgeDriver();
        driver.manage().window().maximize();//Make the browser open on the whole screen

        }
        @Test
    public void testingtobuy() throws InterruptedException {//here we gonna test if the link lead us to the store and we can go to visa info to fill it
            driver.get("https://merch.riotgames.com/en-gb/product/sugar-rush-poro-figure");
            WebElement checkout = driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/main/div[2]/div/div[2]/div[1]/div[3]/div/div[3]/button"));
            checkout.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));//here i set wait duration for the driver so it can load and then click on the right button
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"riot-games-merch\"]/div/div/div[2]/div[3]/div[2]")));
            WebElement checkoutButton = popup.findElement(By.xpath("//*[@id=\"riot-games-merch\"]/div/div/div[2]/div[3]/div[2]/div/div[3]/button[1]"));
            checkoutButton.click();

    }
    @Test
    public void MediaTest() throws InterruptedException {//in this test im going to go to league website and then im going to test if the media link works and i can run the video
    driver.get("https://www.leagueoflegends.com/en-gb/");
    WebElement news = driver.findElement(By.linkText("NEWS"));
    news.click();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));//we have to seit wait duration so it the element I want can be clickable
    WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Media")));
    popup.click();
        Assertions.assertEquals("https://www.leagueoflegends.com/en-gb/news/media/",driver.getCurrentUrl());
    WebElement Show = driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div/div[1]/div/ol/li[3]"));
    Show.click();
    Thread.sleep(2000);
    driver.close();

    }
    @Test
    public void opentickt () throws InterruptedException {
        driver.get("https://www.leagueoflegends.com/en-gb/");
        WebElement support = driver.findElement(By.linkText("SUPPORT"));
        support.click();

    }
}

