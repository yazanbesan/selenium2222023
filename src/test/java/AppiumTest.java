import io.appium.java_client.MobileCommand;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppiumTest {
    private AndroidDriver driver;
    @BeforeEach
    public void SetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.example.my_tic_tac_toe");
        caps.setCapability("appActivity", "com.example.my_tic_tac_toe.MainActivity");
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl,caps);
}
@Test
    public void TestClickOnscreen(){
        TicTacToe game = new TicTacToe();
        driver.findElement(By.id("com.example.my_tic_tac_toe:id/button_00")).click();
        driver.findElement(By.id("com.example.my_tic_tac_toe:id/button_01")).click();
        driver.findElement(By.id("com.example.my_tic_tac_toe:id/button_11")).click();
        driver.findElement(By.id("com.example.my_tic_tac_toe:id/button_12")).click();
        driver.findElement(By.id("com.example.my_tic_tac_toe:id/button_22")).click();
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button")).click();





}
}
