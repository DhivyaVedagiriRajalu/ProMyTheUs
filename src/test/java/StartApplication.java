import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

//import org.openqa.selenium.android.AndroidDriver;

public class StartApplication {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException{
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "6.0.1");
        capabilities.setCapability("deviceName","Emulator");
        capabilities.setCapability("platformName","Android");


       /* Commands to get the package name and appActivity
        C:\Users\Dhivya Balaji>adb shell
        130|shell@jfltevzw:/ $ dumpsys window windows | grep -E 'mCurrentFocus'*/

        capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
// This package name of your app (you can get it from apk info app)
        capabilities.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
//Create RemoteWebDriver instance and connect to the Appium server
        //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public  void Test1(){
        System.out.println("testing...");
    }

}