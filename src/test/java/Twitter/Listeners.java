//package Twitter;
//
//import java.io.IOException;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//
//import common.ExtentReporterNG;
//import common.base;
//
//public class Listeners extends base implements ITestListener {
//	ExtentTest test;
//	ExtentReports extent = ExtentReporterNG.getReportObject();
//	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
//
//	public void onTestStart(ITestResult result) {
//		// TODO Auto-generated method stub
//		test = extent.createTest(result.getMethod().getMethodName());
//		extentTest.set(test);
//
//	}
//
//	public void onTestSuccess(ITestResult result) {
//		// TODO Auto-generated method stub
//		extentTest.get().log(Status.PASS, "Test Passed");
//	}
//
//	public void onTestFailure(ITestResult result) {
//		// TODO Auto-generated method stub
//		// Screenshot
//		extentTest.get().fail(result.getThrowable());
//		WebDriver driver = null;
//		String testMethodName = result.getMethod().getMethodName();
//
//		try {
//			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
//					.get(result.getInstance());
//		} catch (Exception e) {
//
//		}
//		try {
//			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver),
//					result.getMethod().getMethodName());
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public void onTestSkipped(ITestResult result) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public void onStart(ITestContext context) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public void onFinish(ITestContext context) {
//		// TODO Auto-generated method stub
//		extent.flush();
//	}
//
//}

package Twitter;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import common.base;

public class Listeners implements ITestListener {
	base b = new base();

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		// hey i am done
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		//
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// screenshot

		try {
			b.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}
