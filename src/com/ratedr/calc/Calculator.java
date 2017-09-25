package com.ratedr.calc;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Calculator {

	public AndroidDriver<MobileElement> androidDriver;
	public DesiredCapabilities caps = new DesiredCapabilities();
	String output;
	String userDir = System.getProperty("user.dir");

	@BeforeClass
	public void setUpConfiguration() throws MalformedURLException {

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		caps.setCapability("app", userDir + "\\Calculator.apk");
		caps.setCapability("app-package", "com.tricolorcat.calculator");
		caps.setCapability("app-activity",
				"com.tricolorcat.calculator.MainActivity");

		// Add your device name from adb devices
		caps.setCapability("deviceName", "4a299b2");
		caps.setCapability("platformName", "ANDROID");

		androidDriver = new AndroidDriver<MobileElement>(url, caps);
		androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() {
		androidDriver.quit();
	}

	@Test
	public void addition() throws InterruptedException {

		MobileElement Num6 = androidDriver.findElement(By
				.id("com.tricolorcat.calculator:id/six"));
		MobileElement Num5 = androidDriver.findElement(By
				.id("com.tricolorcat.calculator:id/five"));
		MobileElement plus = androidDriver.findElement(By
				.id("com.tricolorcat.calculator:id/plus"));
		MobileElement equal = androidDriver.findElement(By
				.id("com.tricolorcat.calculator:id/equal"));

		Num6.click();
		System.out.println("Click on : 6");
		Thread.sleep(1000);
		plus.click();
		System.out.println("Click on : Plus");
		Thread.sleep(1000);
		Num5.click();
		System.out.println("Click on : 5");
		Thread.sleep(1000);
		equal.click();
		System.out.println("Click on : Equal");
		Thread.sleep(1000);

		output = androidDriver.findElement(
				By.id("com.tricolorcat.calculator:id/display")).getText();

		System.out.println("Result : " + output);

		assert output.equals("11") : "Wrong Calculation, Actual Output : "
				+ output + "Expected : 11";

	}

	@Test
	public void substraction() throws InterruptedException {

		MobileElement Num9 = androidDriver.findElement(By
				.id("com.tricolorcat.calculator:id/nine"));
		MobileElement Num3 = androidDriver.findElement(By
				.id("com.tricolorcat.calculator:id/three"));
		MobileElement minus = androidDriver.findElement(By
				.id("com.tricolorcat.calculator:id/minus"));
		MobileElement equal = androidDriver.findElement(By
				.id("com.tricolorcat.calculator:id/equal"));

		Num9.click();
		System.out.println("Click on : 9");
		Thread.sleep(1000);
		minus.click();
		System.out.println("Click on : Minus");
		Thread.sleep(1000);
		Num3.click();
		System.out.println("Click on : 3");
		Thread.sleep(1000);
		equal.click();
		System.out.println("Click on : Equal");
		Thread.sleep(1000);

		output = androidDriver.findElement(
				By.id("com.tricolorcat.calculator:id/display")).getText();

		System.out.println("Result : " + output);

		assert output.equals("6") : "Wrong Calculation, Actual Output : "
				+ output + "Expected : 6";

	}

	@Test
	public void multiplication() throws InterruptedException {

		MobileElement Num4 = androidDriver.findElement(By
				.id("com.tricolorcat.calculator:id/four"));
		MobileElement Num7 = androidDriver.findElement(By
				.id("com.tricolorcat.calculator:id/seven"));
		MobileElement multiply = androidDriver.findElement(By
				.id("com.tricolorcat.calculator:id/times"));
		MobileElement equal = androidDriver.findElement(By
				.id("com.tricolorcat.calculator:id/equal"));

		Num4.click();
		System.out.println("Click on : 4");
		Thread.sleep(1000);
		multiply.click();
		System.out.println("Click on : Multiply");
		Thread.sleep(1000);
		Num7.click();
		System.out.println("Click on : 7");
		Thread.sleep(1000);
		equal.click();
		System.out.println("Click on : Equal");
		Thread.sleep(1000);

		output = androidDriver.findElement(
				By.id("com.tricolorcat.calculator:id/display")).getText();

		System.out.println("Result : " + output);

		assert output.equals("28") : "Wrong Calculation, Actual Output : "
				+ output + "Expected : 28";

	}

	@Test
	public void division() throws InterruptedException {

		MobileElement Num8 = androidDriver.findElement(By
				.id("com.tricolorcat.calculator:id/eight"));
		MobileElement Num2 = androidDriver.findElement(By
				.id("com.tricolorcat.calculator:id/two"));
		MobileElement divide = androidDriver.findElement(By
				.id("com.tricolorcat.calculator:id/divide"));
		MobileElement equal = androidDriver.findElement(By
				.id("com.tricolorcat.calculator:id/equal"));

		Num8.click();
		System.out.println("Click on : 8");
		Thread.sleep(1000);
		divide.click();
		System.out.println("Click on : Device");
		Thread.sleep(1000);
		Num2.click();
		System.out.println("Click on : 2");
		Thread.sleep(1000);
		equal.click();
		System.out.println("Click on : Equal");
		Thread.sleep(1000);

		output = androidDriver.findElement(
				By.id("com.tricolorcat.calculator:id/display")).getText();

		System.out.println("Result : " + output);

		assert output.equals("4") : "Wrong Calculation, Actual Output : "
				+ output + "Expected : 4";

	}

}
