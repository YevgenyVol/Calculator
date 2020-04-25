import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
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
        //capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Device");
        capabilities.setCapability("newCommandTimeout", 120);
        capabilities.setCapability("platformVersion", "6.0.1");

        //package and activity
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        capabilities.setCapability("unicodekeyboard", true);
        capabilities.setCapability("resetkeyboard", true);

        URL url = new URL("http://0.0.0.0:4723/wd/hub/");
        driver = new AndroidDriver(url, capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(3000);
    }

    //calculator 3+2 assert method
    @Test
    public void testing(){
        WebElement three = driver.findElement(By.id("com.android.calculator2:id/digit_3")); //button 3
        three.click();
        WebElement plusOp = driver.findElement(By.id("com.android.calculator2:id/op_add")); //button +
        plusOp.click();
        WebElement two = driver.findElement(By.id("com.android.calculator2:id/digit_2"));   //button 2
        two.click();
        WebElement equalOp = driver.findElement(By.id("com.android.calculator2:id/eq"));    //button =
        equalOp.click();

        String expectedResult = "5";
        String result = driver.findElement(By.id("com.android.calculator2:id/result")).getText(); //actual result
        //assert results
        try {
            Assert.assertEquals(expectedResult,result);
            System.out.println("result is true , " + result);
        }
        catch (AssertionError e)
        {
            System.out.println("wrong result , expected  " + expectedResult + " and actual is " + result);
        }
    }//end of testing
}//end of Main class
