package ReusableFunctions;

import java.util.Properties;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CommonFunction {
	WebDriver driver;
	PageAttribute page;
	Properties prop;
	public CommonFunction(WebDriver driver,PageAttribute page){
		this.driver=driver;
		this.page=page;
		this.prop=browserInIt.prop;
	}
	
	public void login(String email, String password) {
		
		Assert.assertEquals(driver.getTitle(), PageAttribute.homePageTitle);
		page.HomePageSignupButton.click();
		Assert.assertEquals(page.logingPageSignupText.getText(),"New User Signup!");
		page.Loginemail.sendKeys(email);
		page.LoginPassword.sendKeys(password);
		page.LoginButton.click();

	}	
	
	public static String getRanmdomname() {
		
		return "Auto"+UUID.randomUUID().toString().substring(0, 4);
	}
	
	public static String getRanmdomemail() {
		
		return "Auto"+UUID.randomUUID().toString().substring(0, 4)+"@gmail.com";
	}
	
	public static void selectvaluebytext(WebElement element, String value) {
		new Select(element).selectByVisibleText(value);
		
	}
	

}
