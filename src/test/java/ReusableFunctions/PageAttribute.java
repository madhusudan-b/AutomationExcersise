package ReusableFunctions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAttribute {
	public static String homePageTitle = "Automation Exercise";
	public static String username;
	public static String password;
	
	public Properties prop;

	public PageAttribute(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.prop =browserInIt.prop;
		
	}
	
	// Home Page Attribute
	@FindBy(xpath="//a[@href='/login']")
	public WebElement HomePageSignupButton;

	// Login Page Attribute

	@FindBy(xpath = "//input[@data-qa='signup-name']")
	public WebElement Signupname;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	public WebElement Signupemail;

	@FindBy(xpath = "//button[@data-qa='signup-button']")
	public WebElement SignupButton;
	
	@FindBy(xpath = "//div[@class='login-form']/h2")
	public WebElement signupRegistrationText;
	
	@FindBy(xpath="//h2[text()='New User Signup!']")
	public WebElement logingPageSignupText;
	
	@FindBy(xpath="//input[@value='Mr']")
	public WebElement registerationuserprefix;
	
	@FindBy(id="password")
	public WebElement registerationuserpassword;
	
	@FindBy(id="days")
	public WebElement registerationuserDOB;
	
	@FindBy(id="months")
	public WebElement registerationuserMOB;
	
	@FindBy(id="years")
	public WebElement registerationuserYOB;
	
	@FindBy(id="newsletter")
	public WebElement registerationusernewsletteracceptance;
	
	
	@FindBy(xpath="//input[@data-qa='first_name']")
	public WebElement registerationuserfirstname;
	
	@FindBy(xpath="//input[@data-qa='last_name']")
	public WebElement registerationuserlastname;
	
	@FindBy(xpath="//input[@data-qa='company']")
	public WebElement registerationusercompany;
	
	@FindBy(xpath="//input[@data-qa='address']")
	public WebElement registerationuseraddress;
	
	@FindBy(xpath="//select[@data-qa='country']")
	public WebElement registerationusercountry;
	
	@FindBy(xpath="//input[@data-qa='state']")
	public WebElement registerationuserstate;
	
	@FindBy(xpath="//input[@data-qa='city']")
	public WebElement registerationusercity;
	
	@FindBy(xpath="//input[@data-qa='zipcode']")
	public WebElement registerationuserzipcode;
	
	@FindBy(xpath="//input[@data-qa='mobile_number']")
	public WebElement registerationusermobilenumber;
	
	@FindBy(xpath="//button[@data-qa='create-account']")
	public WebElement registerationusercreateaccountbttn;
	
	@FindBy(xpath="//h2[@data-qa='account-created']")
	public WebElement registerationuseraccountcrttxt;
	
	@FindBy(xpath="//a[@data-qa='continue-button']")
	public WebElement registerationusercntbtn;
	
	@FindBy(xpath="//a[text()=' Logged in as ']/b")
	public WebElement registerationusernameconf;
	
	@FindBy(xpath="//a[text()=' Delete Account']")
	public WebElement registerationuserdltaccbtn;
	
	@FindBy(xpath="//h2[@data-qa='account-deleted']")
	public WebElement registerationuseraccdeltext;
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	public WebElement Loginemail;
	
	@FindBy(xpath="//input[@data-qa='login-password']")
	public WebElement LoginPassword;
	
	@FindBy(xpath="//button[@data-qa='login-button']")
	public WebElement LoginButton;
	
	@FindBy(xpath="//p[text()='Your email or password is incorrect!']")
	public WebElement wrongEmailPass;
	
	@FindBy(xpath="//a[@href='/logout']")
	public WebElement logoutbtn;
	

}
