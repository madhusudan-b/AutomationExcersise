package ReusableFunctions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports getReport() {
		
		if(extent== null) {
			
			String path=System.getProperty("user.dir")+"/reports/index.html";
			ExtentSparkReporter reporter= new ExtentSparkReporter(path); 
			reporter.config().setReportName("Automation Report");
			reporter.config().setDocumentTitle("Detailed Automation Report");
			reporter.config().setTheme(Theme.STANDARD);
			
			extent =new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("SDET","Madhusudan" );
			
			
		}
		
		return extent;
		
	}

}
