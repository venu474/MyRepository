package com.hrms.descap;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Sample_GridClass {
	@Test
	public void gridTest(String browserType) throws Exception {
		
		DesiredCapabilities cap= null;
		if(browserType.equals("chrome")) {
			cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}else if(browserType.equals("firefox")) {
			cap=DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
		}else {
			cap=DesiredCapabilities.internetExplorer();
			cap.setBrowserName("iexplore");
			cap.setPlatform(Platform.WINDOWS);
		}
		URL hubUrl= null;
		try {
			hubUrl=new URL("http://localhost:4444/wd/hub");
		} catch (MalformedURLException mUrl) {
			mUrl.printStackTrace();
		}
		RemoteWebDriver rwd= new RemoteWebDriver(hubUrl, cap);
		rwd.navigate().to("http://127.0.0.1/orangehrm-2.6/login.php");//any website
		Thread.sleep(3000);
		System.out.println(rwd.getTitle());
		System.out.println("Application opened");
		rwd.findElement(By.name("txtUserName")).sendKeys("admin");
		rwd.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin");
		rwd.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		System.out.println("Login completed");
		rwd.findElement(By.linkText("Logout")).click();
		System.out.println("Logout completed");
		rwd.close();
	}
	
}
