package webSiteUseCases;

import java.io.FileOutputStream;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ReusableFunctions.*;

public class useCases extends browserInIt {

	PageAttribute page;
	CommonFunction util;

	@BeforeMethod
	public void set_Values() {

		driver = setBrowser();
		page = new PageAttribute(driver);
		util = new CommonFunction(driver, page);

	}

	@Test
	public void Test_Case_001_User_Registration() {

		driver.get(URL);
		Assert.assertEquals(driver.getTitle(), PageAttribute.homePageTitle);
		page.HomePageSignupButton.click();
		Assert.assertEquals(page.logingPageSignupText.getText(), "New User Signup!");
		String username = CommonFunction.getRanmdomname();
		page.Signupname.sendKeys(username);
		String email=CommonFunction.getRanmdomemail();
		page.Signupemail.sendKeys(email);
		page.SignupButton.click();
		Assert.assertEquals(page.signupRegistrationText.getText(), "ENTER ACCOUNT INFORMATION");
		page.registerationuserprefix.click();
		String password=CommonFunction.getRanmdomname() + "123";
		page.registerationuserpassword.sendKeys(password);
		CommonFunction.selectvaluebytext(page.registerationuserDOB, "8");
		CommonFunction.selectvaluebytext(page.registerationuserMOB, "May");
		CommonFunction.selectvaluebytext(page.registerationuserYOB, "1992");
		page.registerationusernewsletteracceptance.click();
		page.registerationuserfirstname.sendKeys("Max");
		page.registerationuserlastname.sendKeys("test");
		page.registerationusercompany.sendKeys("FBI");
		page.registerationuseraddress.sendKeys("house no 3308 ");
		page.registerationusercountry.sendKeys("Indai");
		page.registerationuserstate.sendKeys("Delhi");
		page.registerationusercity.sendKeys("Delhi");
		page.registerationuserzipcode.sendKeys("45634");
		page.registerationusermobilenumber.sendKeys("7564536409");
		page.registerationusercreateaccountbttn.click();
		Assert.assertEquals(page.registerationuseraccountcrttxt.getText(), "ACCOUNT CREATED!");
		page.registerationusercntbtn.click();
		Assert.assertEquals(page.registerationusernameconf.getText(), username);
		/*
		 * page.registerationuserdltaccbtn.click();
		 * Assert.assertEquals(page.registerationuseraccdeltext.getText(),
		 * "ACCOUNT DELETED!"); page.registerationusercntbtn.click();
		 */
		try {
		 FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\resource\\basicload.properties");
		    prop.setProperty("username", username);
			prop.setProperty("email", email);
			prop.setProperty("password", password);
		    prop.store(fos, "Updated Runtime Credentials");
		    
		}
		catch (Exception e) {
			System.out.println("data not saved in File");
			
		}
		
		

	}

	@Test (dependsOnMethods="Test_Case_001_User_Registration")
	public void Test_Case_002_User_Login_Correct_Email() {

		driver.get(URL);
		String email = prop.getProperty("email");
		String password = prop.getProperty("password");
		String username=prop.getProperty("username");
		util.login(email,password);
		Assert.assertEquals(page.registerationusernameconf.getText(),username);
		/*
		 * page.registerationuserdltaccbtn.click();
		 * Assert.assertEquals(page.registerationuseraccdeltext.getText(),
		 * "ACCOUNT DELETED!"); page.registerationusercntbtn.click();
		 */
		
	}
	

	@Test
	public void  Test_case_003_Login_User_with_incorrect_email_and_password(){
		driver.get(URL);
		util.login("maddy@gmail.com", "password");
		Assert.assertEquals(page.wrongEmailPass.getText(),"Your email or password is incorrect!");
		
		
	}
	
	
	@Test(dependsOnMethods="Test_Case_001_User_Registration")
	public void  Test_case_004_Logout_User(){
		driver.get(URL);
		String email = prop.getProperty("email");
		String password = prop.getProperty("password");
		String username=prop.getProperty("username");
		util.login(email, password);
		Assert.assertEquals(page.registerationusernameconf.getText(),username);

		
		
	}
	
	@AfterMethod
	public void close() {
		
		driver.close();
		driver.quit();
	}
	
	
	
	

	
	

}
