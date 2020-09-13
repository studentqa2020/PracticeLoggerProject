package com.page.object.model;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	//WebElement = driver.findElement()
	//List<WebElement> =driver.findElements()		

	@FindBy(xpath = "(//*[@title='Dresses'])[2]")
	private WebElement dresses;

	@FindBy(xpath = "//*[@class='left-block']")// dress =5
	private List<WebElement> dressesCount;

	@FindBy(xpath = "//*[@class='right-block']//*[@class='product-name']")//name=5
	private List<WebElement> allDressName;

	@FindBy(xpath = "// *[@class='right-block']//*[@class='price product-price']")//price=5
	private List<WebElement> allDressPrice;
	
	@FindBy(xpath = "//*[@id='quantity_wanted_p']/input")
	private WebElement quantityinputbox;
	
	@FindBy(xpath = "//*[@id='group_1']")
	private WebElement dressSizeDropDown;
	
	@FindBy(xpath = "//*[@id='add_to_cart']")
	private WebElement addtoCartBtn;
	
	@FindBy(xpath = "//*[@title='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	@FindBy(xpath = "//*[@name='processAddress']")
	private WebElement addressProceedToCheckOut;
	
	
	@FindBy(xpath = "//*[@name='processCarrier']")
	private WebElement shippingProceedToCheckOut;
	@FindBy(xpath = "(//*[@title='Proceed to checkout'])[2]")
	private WebElement summaryProceedToCheckOut;

	@FindBy(xpath = "//*[@type='checkbox']")
	private WebElement checkBox;
	
	@FindBy(xpath = "//*[@class='payment_module']")
	private List<WebElement> paymentOptions;
	
	@FindBy(xpath = "//*[@class='button btn btn-default button-medium']")
	private List<WebElement> orderConfirmedBtn;
	
	
	@FindBy(xpath = "//*[@class='box']")
	private WebElement orderSummary;
	
	public WebElement getaddressProceedToCheckOut() {
		return addressProceedToCheckOut;
	}
	
	public WebElement getshippingProceedToCheckOut() {
		return shippingProceedToCheckOut;
	}
	public WebElement getorderSummary() {
		return orderSummary;
	}
	
	public List<WebElement> getorderConfirmedBtn() {
		return orderConfirmedBtn;
	}
	public List<WebElement> getpaymentOptions() {
		return paymentOptions;
	}
	
	public WebElement getcheckBox() {
		return checkBox;
	}
	
	
	public WebElement getsummaryProceedToCheckOut() {
		return summaryProceedToCheckOut;
	}
	
	public WebElement getproceedToCheckOut() {
		return proceedToCheckOut;
	}
	public WebElement getaddtoCartBtn() {
		return addtoCartBtn;
	}
	
	public WebElement getdressSizeDropDown() {
		return dressSizeDropDown;
	}
	
	public WebElement getquantityinputbox() {
		return quantityinputbox;
	}
	
	public WebElement getdressesbtn() {
		return dresses;
	}

	public List<WebElement> getdressesCount() {
		return dressesCount;
	}

	public List<WebElement> getallDressName() {
		return allDressName;
	}

	public List<WebElement> getallDressPrice() {
		return allDressPrice;
	}
}
