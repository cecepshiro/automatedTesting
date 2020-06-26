package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() {
		try {
			//Device Configuration
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Kuri_Kame");
			cap.setCapability(MobileCapabilityType.UDID, "11bb51f7");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			cap.setCapability(MobileCapabilityType.NO_RESET, true);
			cap.setCapability(MobileCapabilityType.FULL_RESET, false);
			
			//App Configuration
			cap.setCapability("appPackage", "com.dsi.sulselbaragent.lakupandai");
			cap.setCapability("appActivity", "com.dsi.sulselbaragent.lakupandai.others.SplashScreen");
			
			//Driver Configuration
			URL url  = new URL("http://0.0.0.0:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, cap);
//			driver = new AndroidDriver<MobileElement>(url, cap);
//			driver = new IOSDriver<MobileElement>(url, cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			
		}catch(Exception e) {
			System.out.println("Cause is : " + e.getCause());
			System.out.println("Message is : " + e.getMessage());
			e.printStackTrace();
			
		}
	}
	
	@Test
	public void sampleTest() {
		System.out.println("I am inside a sample test!!!!!!");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
