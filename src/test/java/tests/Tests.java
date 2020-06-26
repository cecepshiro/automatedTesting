package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

public class Tests extends BaseClass{

	@Test
	public void testLogin() {
		//TestScript
		MobileElement tmp_inputPass= driver.findElement(By.id("com.dsi.sulselbaragent.lakupandai:id/ePassword"));
		tmp_inputPass.sendKeys("Adminadmin1?");
		MobileElement tmp_login = driver.findElement(By.id("com.dsi.sulselbaragent.lakupandai:id/btnLogin"));		
		tmp_login.click();
		System.out.println("Testscript Login Success....");
	}
}
