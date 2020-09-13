package com.log4j2.latest.logger;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.report.ExtentTestManager;
import com.report.Log;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class SeleniumLog4j {

protected static  WebDriver driver;
	
//private static final Logger log = LogManager.getLogger(LoggerTest2.class);
static  ExtentTest test;
static  ExtentTest childtest;
	public static void main(String[] args) throws Throwable {
		

		test = ExtentTestManager.startTest("Smoke Test");// start
		test.assignCategory("Smoke Test");
		childtest=test.createNode("Login Function");
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();//upcasting
		//Log.info("Browser opened");
		childtest.log(Status.PASS, "Browser opened");
		driver.manage().window().maximize();//maximum or full size
		driver.manage().deleteAllCookies();
		driver.get(BaseConfig.getconfig("URL"));
		//Log.info("Send URL");
		childtest.log(Status.PASS, "Send URL");
		//LoginPage login =new LoginPage(driver);
		LoginPage login = new LoginPage(driver);
		//Log.info("Home page title:: "+driver.getTitle());
		childtest.log(Status.PASS, "Home page title:: "+driver.getTitle());
		//new Highlighter().getcolor(driver, login.getLogin());
		login.getLogin().click();// click

		//Log.info("Current URL ="+driver.getCurrentUrl());
		childtest.log(Status.PASS, "Current URL ="+driver.getCurrentUrl());
		//Log.info("Login page title :: "+driver.getTitle());
		childtest.log(Status.PASS, "Login page title :: "+driver.getTitle());
		Wait.getExplicitWaitClicable(driver, login.getEmail());
		
		Highlighter.getcolor(driver, login.getEmail(), "yellow");
		login.getEmail().sendKeys(BaseConfig.getconfig("email"));
		
		
		
		Highlighter.getcolor(driver, login.getPass(),"black");
		login.getPass().sendKeys(BaseConfig.getconfig("pass"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		login.getSubmit().click();
		
		if(login.getLogOut().size()>0) {
			
			//Log.pass("Login success");
			Log.screenShot(driver, "Login Success");
			childtest.log(Status.PASS, "Login Success");
		}else {
			//Log.fail("Log in Failed");
			//TakeAppScreenShot.captureScreenShot(driver, "Login success");
			//Log.screenShot(driver, "Login Failed");
			String path = TakeAppScreenShot.captureScreenShot(driver, "Login Failed");
				childtest.info("Login Failed",
						MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			childtest.log(Status.FAIL, "Login Failed");
			
		
		ExtentTestManager.endTest();
	}
	}
}