package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides Impliementaion to ItestListners Interface
 * @author Kavya V
 */
public class ListenersimplementaionUtility implements ITestListener{
  ExtentReports report;
  ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		//Capturing Method name
		String Methodname = result.getMethod().getMethodName();
		System.out.println(Methodname+"--@test Start--");
		
		//create test in Extent Reports
		test= report.createTest(Methodname);
	
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//Capturing Method name
		String Methodname = result.getMethod().getMethodName();
		System.out.println(Methodname+"@testPass---------");
		
		
		
	//Captur the exception
				System.out.println(result.getThrowable());
	//log the test Status as pass In Extent Reports
				test.log(Status.PASS, Methodname+"TestPass");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//Capturing Method name
		String Methodname = result.getMethod().getMethodName();
		System.out.println(Methodname+"--@test Failure--");
		
		//log the test Status As PAss in Extent Reports
		test.log(Status.FAIL, Methodname+"Test fail");
		
		//Captur the exception
		System.out.println(result.getThrowable());
		//log the Exception in ectent Reports
		test.log(Status.WARNING, result.getThrowable());
		
	//capture the screenshot
	SeleniumUtility s = new SeleniumUtility();
	JavaUtility j= new JavaUtility();
	//Configure Screenshot name
	String Screenshotname = Methodname+"-"+j.getSystemDate();
	try {
		String path = s.captureScreenShot(BaseClass.sdriver,Screenshotname);
	
	//Attach screenshot to Extent report
		test.addScreenCaptureFromPath(path,Screenshotname);
	
	} catch (IOException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//Capturing Method name
		String Methodname = result.getMethod().getMethodName();
		System.out.println("--------Test  Skip---------");
		//log the test status as skip in ectent Reports
		test.log(Status.SKIP, Methodname+"tset Skip");
		
		//Captur the exception
		System.out.println(result.getThrowable());
		
		//log the exception in extent reports
		test.log(Status.WARNING, result.getThrowable());
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//Capturing Method name
				String Methodname = result.getMethod().getMethodName();
		System.out.println("---------@test failed within success parameter---------");
		//Captur the exception
				System.out.println(result.getThrowable());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		//Capturing Method name
				String Methodname = result.getMethod().getMethodName();
		System.out.println("---------Test Failed with Timout---------");
		//Captur the exception
				System.out.println(result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("---------Start on  test Exection---------");
	
	//basic Configuration of Extent Reports
	
	ExtentSparkReporter esr= new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
	esr.config().setDocumentTitle("Swag labs Exection");
	esr.config().setTheme(Theme.DARK);
	esr.config().setReportName("Swag labs Automation Framework exection");
	
	//configure extent Reports
	report= new ExtentReports();
	report.attachReporter(esr);
	report.setSystemInfo("Base Patform", "Windows");
	report.setSystemInfo("Base Browser", "Microsoft edge");
	report.setSystemInfo("Base env", "Test env");
	report.setSystemInfo("Reporter Name", "Kavya");
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("--------- Start on Falure of test Exection---------");
	report.flush();
	}
	
	

}
