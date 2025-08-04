package ReusableFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverInfo;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browserInIt {

	public static Properties prop;
	public WebDriver driver;
	public String browser;
	public String URL;
	
	public WebDriver setBrowser() {
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\resource\\basicload.properties";

		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
			browser = prop.getProperty("browser");
			URL = prop.getProperty("url");			

		} catch (IOException e) {
			
			System.out.println("File not Loading");

		}

		finally {
			
		}

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			break;

		}
		
		return driver;

	}

}
