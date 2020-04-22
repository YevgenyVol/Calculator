import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {
    static AndroidDriver<MobileElement> driver;

    @BeforeClass
    public static void setUp() throws IOException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Device");
        capabilities.setCapability("newCommandTimeout", 120);
        capabilities.setCapability("platformVersion", "6.0.1");

        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        capabilities.setCapability("unicodekeyboard", true);
        capabilities.setCapability("resetkeyboard", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub/");

        driver = new AndroidDriver(url, capabilities);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(3000);
    }

    @Test
    public void testing(){

//       WebElement three = driver.findElementById("com.android.calculator2:id/digit_3");
       WebElement three = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
       three.click();
    }


}
