package ReusableFunctions;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListeners implements ITestListener
{
	
	ExtentReports extent=ExtentReportManager.getReport();
	public static ExtentTest test ;
	@Override
	public void onTestStart(ITestResult result) {
	
	test= extent.createTest(result.getMethod().getMethodName());
			
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
		extent.flush();

		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Failed");
		extent.flush();

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}
	

}
