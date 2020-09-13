package com.log4j2.latest.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class SeleniumLog4jTesting {
	
	 private  final static Logger logger = LogManager.getLogger(SeleniumLog4jTesting.class);
	
	@Test
	public void getLogin() {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();//upcasting
		
	
		driver.manage().window().maximize();//maximum or full size
		driver.manage().deleteAllCookies();
		driver.get(BaseConfig.getconfig("URL"));
		
		//LoginPage login =new LoginPage(driver);
		LoginPage login = new LoginPage(driver);
		//System.out.println(driver.getTitle());
		logger.info(driver.getTitle());
		//new Highlighter().getcolor(driver, login.getLogin());
		login.getLogin().click();// click
		logger.info(driver.getCurrentUrl());
		logger.info(driver.getTitle());

		Wait.getExplicitWaitClicable(driver, login.getEmail());
		
		Highlighter.getcolor(driver, login.getEmail(), "yellow");
		login.getEmail().sendKeys(BaseConfig.getconfig("email"));
		
		
		
		Highlighter.getcolor(driver, login.getPass(),"black");
		login.getPass().sendKeys(BaseConfig.getconfig("pass"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		login.getSubmit().click();
		TakeAppScreenShot.captureScreenShot(driver, "Login success");
		logger.info(driver.getTitle());
		
	}

}
